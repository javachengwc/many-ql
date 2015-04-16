package org.nlamah.QL;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.swing.SwingUtilities;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.apache.commons.io.IOUtils;
import org.nlamah.QL.FormModel.ComputedQuestion;
import org.nlamah.QL.FormModel.ConditionalBlock;
import org.nlamah.QL.FormModel.Form;
import org.nlamah.QL.FormModel.FormElement;
import org.nlamah.QL.FormModel.InputQuestion;
import org.nlamah.QL.FormModel.IfThenBlock;
import org.nlamah.QL.FormViewControllers.FormRootViewController;
import org.nlamah.QL.Literal.BooleanLiteral;

public class QLInterpreter implements Runnable
{
	private String fileName;
	
	public QLInterpreter(String fileName)
	{
		this.fileName = fileName;
	}
	
	public static void main( String[] args )
    {
    	String fileName = args.length > 0 ? args[0] : "source.ql";
    	
    	SwingUtilities.invokeLater(new QLInterpreter(fileName));
    }
	
	@Override
	public void run()
	{
		Form form = this.interprete();
		
		((FormRootViewController)form.viewController()).showForm();
	}
	
	private Form interprete()
	{
		String sourceCode = this.getSourceCode();
		
		ParseTree tree = this.createParseTreeFromSourceCode(sourceCode);
		
		//return this.createFormFromParseTree(tree);
		return buildForm(tree);
	}
	
	private String getSourceCode()
    {
		String qlSourceCode = "";
		
		try 
		{
			InputStream fileInputStream = QLInterpreter.class.getResourceAsStream(this.fileName);
			qlSourceCode = IOUtils.toString(fileInputStream, "UTF-8");
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		return qlSourceCode;
    }
    
    private ParseTree createParseTreeFromSourceCode(String sourceCode)
    {
    	ANTLRInputStream input = new ANTLRInputStream(sourceCode);

		QLLexer lexer = new QLLexer(input);
		
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		
		QLParser parser = new QLParser(tokens);
		
    	return parser.form();
    }
    
    private Form buildForm(ParseTree tree)
    {
    	return (Form)tree.accept(new MyQLVisitor());
    }
    
    private Form createFormFromParseTree(ParseTree tree)
    {
 		ArrayList<FormElement> formElements = new ArrayList<FormElement>(10);
		
		FormElement formElement;
		
		for (int i = 0; i < 10; i++)
		{
			if (i % 3 == 0)
			{
				formElement = new InputQuestion(Integer.toString(i + 1) + ".", Integer.toString(i+1) + "th question", "BOOL");	
			}
			else if (i % 3 == 1)
			{
				formElement = new ComputedQuestion(Integer.toString(i+1) + ".", Integer.toString(i+1) + "th question", "Computed", Integer.toString(i * i));
			}
			else
			{
				BooleanLiteral booleanLiteral = new BooleanLiteral("true");
				
				ArrayList<FormElement> dummyQuestions = createConditionalDummyQuestions(i, "if then");
				
				IfThenBlock ifThenBlock = new IfThenBlock(booleanLiteral, dummyQuestions);
				
				ifThenBlock.addRelatedElement(formElements.get(i - 2));
				
				ConditionalBlock conditionalBlock = new ConditionalBlock(ifThenBlock, null, null);
	
				formElements.get(i - 2).addRelatedElement(conditionalBlock);
				
				conditionalBlock.addRelatedElement(formElements.get(i - 2));
				
				formElement = conditionalBlock;
			}
			
			formElements.add(formElement);
		}
 		
 		Form form = new Form("test", formElements);
    	
    	return form;	
    }
		
	private ArrayList<FormElement> createConditionalDummyQuestions(int number, String type)
	{
		ArrayList<FormElement> conditionalQuestions = new ArrayList<FormElement>(3);
		
		for (int i = 0; i < 3; i++)
		{
			conditionalQuestions.add(new InputQuestion(number + "." + i, (i + 1) + "th " + type + " question", "BOOL"));
		}
			
		return conditionalQuestions;
	}
}


