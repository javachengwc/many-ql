package org.nlamah.QLS.Builders;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

import org.antlr.v4.runtime.ANTLRErrorListener;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ParseTree;
import org.nlamah.QBase.Error.AmbiguityError;
import org.nlamah.QBase.Error.AttemptingFullContextError;
import org.nlamah.QBase.Error.ContextSensitivityError;
import org.nlamah.QBase.Error.QBaseError;
import org.nlamah.QBase.Error.QBaseException;
import org.nlamah.QBase.Error.SyntaxError;
import org.nlamah.QBase.Tools.SourceCodeTools;
import org.nlamah.QL.Model.Form.Form;
import org.nlamah.QLS.QLSLexer;
import org.nlamah.QLS.QLSParser;
import org.nlamah.QLS.Model.StylesheetBlock.Stylesheet;
import org.nlamah.QLS.TypeChecker.QLSTypeChecker;

public class QLSInterpreter implements ANTLRErrorListener 
{
	private List<QBaseError> errors;

	public QLSInterpreter()
	{
		errors = new ArrayList<QBaseError>();
	}

	public Stylesheet interprete(String qlsFileName, Form form) throws QBaseException
	{
		String qlsSourceCode;

		qlsSourceCode = SourceCodeTools.sourceCode(qlsFileName);

		ParseTree tree = createParseTreeFromSourceCode(qlsSourceCode);

		if (errors.size() > 0)
		{
			throw new QBaseException(errors);
		}

		RawStylesheetBuilder rawStylesheetBuilder = new RawStylesheetBuilder();
		Stylesheet stylesheet = rawStylesheetBuilder.build(tree);

		errors.addAll(rawStylesheetBuilder.errors());

		if (errors.size() > 0)
		{
			throw new QBaseException(errors);
		}

		QLSTypeChecker qlsTypeChecker = new QLSTypeChecker();

		try 
		{
			qlsTypeChecker.check(form, stylesheet);
		} 
		catch (QBaseException e) 
		{
			throw new QBaseException(qlsTypeChecker.errors());
		}

		new QuestionStyleCombiner(form, stylesheet).build();

		return stylesheet;
	}

	private ParseTree createParseTreeFromSourceCode(String sourceCode)
	{
		ANTLRInputStream input = new ANTLRInputStream(sourceCode);

		QLSLexer lexer = new QLSLexer(input);

		CommonTokenStream tokens = new CommonTokenStream(lexer);

		QLSParser parser = new QLSParser(tokens);

		parser.addErrorListener(this);

		return parser.stylesheet();
	}

	@Override
	public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) 
	{
		errors.add(new SyntaxError(line, charPositionInLine, msg));
	}

	@Override
	public void reportAmbiguity(Parser recognizer, DFA dfa, int startIndex, int stopIndex, boolean exact, BitSet ambigAlts, ATNConfigSet configs) 
	{
		errors.add(new AmbiguityError(startIndex, stopIndex));
	}

	@Override
	public void reportAttemptingFullContext(Parser recognizer, DFA dfa, int startIndex, int stopIndex, BitSet conflictingAlts, ATNConfigSet configs) 
	{
		errors.add(new AttemptingFullContextError(startIndex, stopIndex));
	}

	@Override
	public void reportContextSensitivity(Parser recognizer, DFA dfa, int startIndex, int stopIndex, int prediction, ATNConfigSet configs) 
	{
		errors.add(new ContextSensitivityError(startIndex, stopIndex));
	}
}
