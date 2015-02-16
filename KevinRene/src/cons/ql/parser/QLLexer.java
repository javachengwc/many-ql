package cons.ql.parser;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

import cons.ql.ast.ASTNode;
import cons.ql.ast.expression.literal.QLFloat;
import cons.ql.ast.expression.literal.QLIdent;
import cons.ql.ast.expression.literal.QLInt;
import cons.ql.ast.expression.literal.QLString;

public class QLLexer implements QLTokens {
	private static final Map<String, Integer> KEYWORDS;
	
	static {
		KEYWORDS = new HashMap<String, Integer>();
		KEYWORDS.put("form", FORM);
		KEYWORDS.put("boolean", BOOLEAN);
		KEYWORDS.put("assign", ASSIGN);
		KEYWORDS.put("money", MONEY);
		KEYWORDS.put("if", IF);
		KEYWORDS.put("else", ELSE);
	}
	
	
	private int token;
	private int c = ' ';
	
	private ASTNode yylval;
	private final Reader input;

	public QLLexer(Reader input) {
		this.input = input;
		nextChar();
	}
	
	
	private void nextChar() {
		if (c >= 0) {
			try {
				c = input.read();
			}
			catch (IOException e) {
				c = -1;
			}
		}
		
	}
	
	public int nextToken() {
		boolean inComment = false;
		for (;;) {
			if (inComment) {
				while (c != '*' && c != -1) {
					nextChar();
				}
				if (c == '*') {
					nextChar();
					if (c == '/') {
						nextChar();
						inComment = false;
					}
					continue;
				}
			}
			
			while (c == ' ' || c == '\t' || c == '\n' || c == '\r') {
				nextChar();
			}
			
			
			if (c < 0) {
				return token = ENDINPUT;
			}
			
			switch (c) {
			    case '/': {
			    	nextChar();
			    	if (c == '*') {
			    		inComment = true;
			    		nextChar();
			    		continue;
			    	}
			    	return token = '/'; 
			    }
			    case ':': nextChar(); return token = ':';
			    case '}': nextChar(); return token = '}';
			    case '{': nextChar(); return token = '{';
			    case ')': nextChar(); return token = ')';
			    case '(': nextChar(); return token = '(';
			    case '*': {
			    	nextChar();
			    	if (inComment && c == '/') {
			    		inComment = false;
			    		nextChar();
			    		continue;
			    	}
			    	return token = '*';
			    }
			    case '+': nextChar(); return token = '+';
			    case '-': nextChar(); return token = '-';
			    case '&': {
			    	nextChar(); 
			    	if  (c == '&') {
			    		nextChar();
			    		return token = AND;
			    	}
			    	throw new RuntimeException("Unexpected character: " + (char)c);
			    }
			    case '|': {
			    	nextChar(); 
			    	if  (c == '|') {
			    		nextChar();
			    		return token = OR;
			    	}
			    	throw new RuntimeException("Unexpected character: " + (char)c);
			    }
			    case '!': nextChar(); return token = '!';
			    case '<': {
			    	nextChar();
			    	if (c == '=') {
			    		nextChar();
			    		return token = LEQ;
			    	}
			    	return '<';
			    }
			    case '=': { 
			    	nextChar(); 
			    	if  (c == '=') {
			    		nextChar();
			    		return token = EQ;
			    	}
			    	throw new RuntimeException("Unexpected character: " + (char)c);
			    }
			    case '>': {
			    	nextChar();
			    	if (c == '=') {
			    		nextChar();
			    		return token = GEQ;
			    	}
			    	return token = '>';
			    }
			    case '"': {
			    	StringBuilder sb = new StringBuilder();
			    	// Skip opening quote.
			    	nextChar();
			    	// Build a string from everything between the quotes.
			    	while (c != '"') {
		    			sb.append((char)c);
		    			nextChar();
		    		}
			    	// Skip closing quote.
			    	nextChar();
		    		String string = sb.toString();
					
		    		yylval = new QLString(string);
		    		return token = INITSTRING;
			    }
			    default: {
			    	if (Character.isDigit(c)) {
			    		boolean isFloat = false;
			    		double n = 0; 
			    		int decs = 1;
			    		
			    		do {
			    			if(c == '.') {
			    				isFloat = true;
			    				nextChar();
			    				continue;
			    			}
			    			
			    			if(isFloat) {
			    				n = n + (1.0 / (10 * decs)) * (c - '0');
			    				decs *= 10;
			    			} else {
			    				n = 10 * n + (c - '0');
			    			}
			    			
			    			nextChar(); 
			    		} while (Character.isDigit(c) || (c == '.' && !isFloat));
			    		
			    		yylval = isFloat ? new QLFloat((float)n) : new QLInt((int)n);
			    		
			    		return token = isFloat ? INITFLOAT : INITINT;
			    	}
			    	if (Character.isLetter(c)) {
			    		StringBuilder sb = new StringBuilder();
			    		
			    		do {
			    			sb.append((char)c);
			    			nextChar();
			    		} while (Character.isLetterOrDigit(c));
			    		
			    		String name = sb.toString();
			    		
			    		if (KEYWORDS.containsKey(name)) {
			    			return token = KEYWORDS.get(name);
			    		}
						
			    		yylval = new QLIdent(name);
			    		return token = IDENT;
			    	}
			    	throw new RuntimeException("Unexpected character: " + (char)c);
			    }
			}
		}
	}

	
	public int getToken() {
		return token;
	}

	public ASTNode getSemantic() {
		return yylval;
	}


}
