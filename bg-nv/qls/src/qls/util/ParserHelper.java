package qls.util;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import ql.ast.AstNode;
import ql.ast.form.Form;
import ql.semantics.errors.Messages;
import qls.ast.AstBuilder;
import qls.ast.Stylesheet;
import qls.gen.QLSLexer;
import qls.gen.QLSParser;

/**
 * Created by bore on 12/03/15.
 */
public class ParserHelper
{
    public static Messages check(String stylesheet, String form)
    {
        Form f = (Form)ql.util.ParserHelper.ParseForm(form);
        Stylesheet s = (Stylesheet)ParseStylesheet(stylesheet);
        return qls.semantics.TypeChecker.check(s, f);
    }

    public static AstNode ParseStylesheet(String file)
    {
        CharStream stream =  ql.util.ParserHelper.createFileStream(file);
        QLSParser parser = createQLSParser(stream);
        QLSParser.StylesheetContext s = parser.stylesheet();
        AstBuilder visitor = new AstBuilder();

        return s.accept(visitor);
    }

    public static AstNode ParsePage(String input)
    {
        CharStream s = ql.util.ParserHelper.createInputStream(input);
        QLSParser parser = createQLSParser(s);
        QLSParser.PageContext c = parser.page();
        qls.ast.AstBuilder visitor = new qls.ast.AstBuilder();

        return c.accept(visitor);
    }

    public static AstNode ParseStatement(String input)
    {
        CharStream s = ql.util.ParserHelper.createInputStream(input);
        QLSParser parser = createQLSParser(s);
        QLSParser.StatementContext c = parser.statement();
        qls.ast.AstBuilder visitor = new qls.ast.AstBuilder();

        return c.accept(visitor);
    }

    public static AstNode ParseStylesheetRule(String input)
    {
        CharStream s = ql.util.ParserHelper.createInputStream(input);
        QLSParser parser = createQLSParser(s);
        QLSParser.StylesheetRuleContext c = parser.stylesheetRule();
        qls.ast.AstBuilder visitor = new qls.ast.AstBuilder();

        return c.accept(visitor);
    }

    public static AstNode ParseWidgetValue(String input)
    {
        CharStream s = ql.util.ParserHelper.createInputStream(input);
        QLSParser parser = createQLSParser(s);
        QLSParser.WidgetValueContext c = parser.widgetValue();
        qls.ast.AstBuilder visitor = new qls.ast.AstBuilder();

        return c.accept(visitor);
    }

    private static QLSParser createQLSParser(CharStream stream)
    {
        QLSLexer lexer = new QLSLexer(stream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        return new QLSParser(tokens);
    }
}
