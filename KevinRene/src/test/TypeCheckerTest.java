package test;

import static org.junit.Assert.*;

import org.junit.Test;

import cons.ql.ast.ASTNode;
import cons.ql.ast.visitor.TypeChecker;
import cons.ql.parser.Parser;

public class TypeCheckerTest {
	@Test
	public void testVisitor() {
		String myForm = 
				"form taxOfficeExample {"
				+ 	"hasSoldHouse : boolean {"
				+ 		"\"Did you sell a house in 2010?\""
				+ 	"}"
				+ 	"if(5 == 5) {"
				+ 		"houseValue : money {"
				+ 			"\"Lol I dont care\""
				+ 		"}"
				+ 	"}"
				+ "}";
		
		ASTNode myTree = Parser.parse(myForm);
		TypeChecker typeChecker = new TypeChecker();
		
		myTree.accept(typeChecker);
	}
}