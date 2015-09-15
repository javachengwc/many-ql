package nl.uva.bromance.QL.ast;

import nl.uva.bromance.QL.ast.nodes.*;
import nl.uva.bromance.QL.controlstructures.Else;
import nl.uva.bromance.QL.controlstructures.ElseIf;
import nl.uva.bromance.QL.controlstructures.If;
import nl.uva.bromance.QL.expressions.Evaluable;
import nl.uva.bromance.QL.expressions.binary.BinaryExpression;
import nl.uva.bromance.QL.expressions.binary.arithmetic.*;
import nl.uva.bromance.QL.expressions.binary.logicalexpressions.*;
import nl.uva.bromance.QL.expressions.primitives.BooleanPrimitive;
import nl.uva.bromance.QL.expressions.primitives.NumberPrimitive;
import nl.uva.bromance.QL.expressions.primitives.StringPrimitive;
import nl.uva.bromance.QL.expressions.unary.Primitive;
import nl.uva.bromance.QL.expressions.unary.Variable;
import nl.uva.bromance.grammar.QL.QLBaseListener;
import nl.uva.bromance.grammar.QL.QLParser;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class QLParseTreeListener extends QLBaseListener {


    private Stack<QLNode> nodeStack = new Stack<>();
    private Stack<String> identifiersStack = new Stack<>();
    private Stack<Evaluable> expressions = new Stack<>();
    private Map<String, Primitive> identifiers = new HashMap<>();

    // Here to differentiate on where to add labelText
    private boolean isQuestion;

    private AST<QLNode> ast = null;

    public AST<QLNode> getAST() {
        return ast;
    }

    public Map<String, Primitive> getIdentifierMap(){
        return this.identifiers;
    }
    
    public Stack<Evaluable> getExpressions() {
        return expressions;
    }

    @Override
    public void enterQuestionnaire(QLParser.QuestionnaireContext ctx) {
        String identifier = ctx.identifier.getText().replace("\"", "");
        Questionnaire questionnaire = new Questionnaire(identifier, ctx.start.getLine());
        nodeStack.push(questionnaire);
    }

    @Override
    public void exitQuestionnaire(QLParser.QuestionnaireContext ctx) {
        ast = new AST(nodeStack.pop(), identifiers);
        getExpressions();
    }

    @Override
    public void enterForm(QLParser.FormContext ctx) {
        String identifier = removeQuotations(ctx.identifier.getText());
        Form form = new Form(identifier, ctx.start.getLine());
        nodeStack.push(form);
    }

    @Override
    public void exitForm(QLParser.FormContext ctx) {
        Form f = (Form) nodeStack.pop();
        nodeStack.peek().addChild(f);
    }

    @Override
    public void enterQuestion(QLParser.QuestionContext ctx) {
        String identifier =
                removeQuotations(ctx.identifier.getText());
        identifiersStack.push(identifier);
        Question question = new Question(identifier, ctx.start.getLine());
        nodeStack.push(question);
        isQuestion = true;
    }

    @Override
    public void exitQuestion(QLParser.QuestionContext ctx) {
        Question q = (Question) nodeStack.pop();
        q.setType(identifiers.get(q.getIdentifier()));
        nodeStack.peek().addChild(q);
        isQuestion = false;
    }

    @Override
    public void enterCalculation(QLParser.CalculationContext ctx) {
        Calculation calc = new Calculation(ctx.start.getLine());
        nodeStack.push(calc);
    }

    @Override
    public void exitCalculation(QLParser.CalculationContext ctx) {
        Calculation calc = (Calculation) nodeStack.pop();
        nodeStack.peek().addChild(calc);
    }

    @Override
    public void enterLabel(QLParser.LabelContext ctx) {
        Label label = new Label(ctx.start.getLine(), removeQuotations(ctx.identifier.getText()));
        nodeStack.push(label);
    }

    @Override
    public void exitLabel(QLParser.LabelContext ctx) {
        Label label = (Label) nodeStack.pop();
        nodeStack.peek().addChild(label);
    }

    @Override
    public void enterTextLabel(QLParser.TextLabelContext ctx) {
        if (isQuestion) {
            Question q = (Question) nodeStack.peek();
            q.setText(removeQuotations(ctx.identifier.getText()));
        }
    }

    @Override
    public void exitTextLabel(QLParser.TextLabelContext ctx) {
    }

    @Override
    public void enterInput(QLParser.InputContext ctx) {

    }

    @Override
    public void exitInput(QLParser.InputContext ctx) {
        Input input = new Input(ctx.start.getLine(), expressions.pop());
        nodeStack.peek().addChild(input);
    }

    @Override
    public void enterIfSequence(QLParser.IfSequenceContext ctx) {

    }

    @Override
    public void exitIfSequence(QLParser.IfSequenceContext ctx) {

    }

    @Override
    public void enterIfStatement(QLParser.IfStatementContext ctx) {

    }

    @Override
    public void exitIfStatement(QLParser.IfStatementContext ctx) {
        If iff = (If) nodeStack.pop();
        nodeStack.peek().addChild(iff);
    }

    @Override
    public void exitIfCondition(QLParser.IfConditionContext ctx) {
        If iff = new If(ctx.start.getLine(), (LogicalExpression) expressions.pop());
        nodeStack.push(iff);
    }

    @Override
    public void enterElseStatement(QLParser.ElseStatementContext ctx) {
        Else _else = new Else(ctx.start.getLine());
        nodeStack.push(_else);
    }

    @Override
    public void exitElseStatement(QLParser.ElseStatementContext ctx) {
        Else _else = (Else) nodeStack.pop();
        nodeStack.peek().addChild(_else);
    }

    @Override
    public void exitElseIfCondition(QLParser.ElseIfConditionContext ctx) {
        ElseIf eif = new ElseIf(ctx.start.getLine(), (LogicalExpression) expressions.pop());
        nodeStack.push(eif);
    }

    @Override
    public void exitElseIfStatement(QLParser.ElseIfStatementContext ctx) {
        ElseIf eif = (ElseIf) nodeStack.pop();
        nodeStack.peek().addChild(eif);
    }

    @Override
    public void enterQuestionAnswerSimple(QLParser.QuestionAnswerSimpleContext ctx) {
        String identifier = identifiersStack.pop();
        switch (ctx.type.getText()) {
            case "integer":
                identifiers.put(identifier, new NumberPrimitive(null));
                break;
            case "string":
                identifiers.put(identifier, new StringPrimitive(""));
                break;
            case "boolean":
                identifiers.put(identifier, new BooleanPrimitive(false));
                break;
            default:
                break;
        }

    }

    @Override
    public void enterQuestionAnswerCustom(QLParser.QuestionAnswerCustomContext ctx) {
        String identifier = identifiersStack.pop();
        Primitive primitive = new StringPrimitive("");
        identifiers.put(identifier, primitive);
    }

    @Override
    public void exitQuestionAnswerCustom(QLParser.QuestionAnswerCustomContext ctx) {

    }

    @Override
    public void enterQuestionRange(QLParser.QuestionRangeContext ctx) {

    }

    @Override
    public void exitQuestionRange(QLParser.QuestionRangeContext ctx) {

    }

    @Override
    public void enterQuestionRangeFromTo(QLParser.QuestionRangeFromToContext ctx) {

    }

    @Override
    public void exitQuestionRangeFromTo(QLParser.QuestionRangeFromToContext ctx) {

    }

    @Override
    public void enterQuestionRangeBiggerThan(QLParser.QuestionRangeBiggerThanContext ctx) {

    }

    @Override
    public void exitQuestionRangeBiggerThan(QLParser.QuestionRangeBiggerThanContext ctx) {

    }

    @Override
    public void enterQuestionRangeSmallerThan(QLParser.QuestionRangeSmallerThanContext ctx) {

    }

    @Override
    public void exitQuestionRangeSmallerThan(QLParser.QuestionRangeSmallerThanContext ctx) {

    }

    @Override
    public void enterQuestionAllowedTypes(QLParser.QuestionAllowedTypesContext ctx) {

    }

    @Override
    public void exitQuestionAllowedTypes(QLParser.QuestionAllowedTypesContext ctx) {

    }

    @Override
    public void exitVariable(QLParser.VariableContext ctx) {
        String identifier = removeQuotations(ctx.identifier.getText());
        Variable v = new Variable(identifier, ctx.start.getLine());
        expressions.push(v);
    }

    @Override
    public void exitPrimitive(QLParser.PrimitiveContext ctx) {
        switch (ctx.value.getType()) {
            case QLParser.STRING:
                expressions.push(new StringPrimitive(ctx.value.getText().replace("\"", "")));
                break;
            case QLParser.NUMBER:
                expressions.push(new NumberPrimitive(Integer.parseInt(ctx.value.getText())));
                break;
        }
    }

    @Override
    public void enterInteger(QLParser.IntegerContext ctx) {
        expressions.push(new NumberPrimitive(Integer.parseInt(ctx.value.getText())));
    }

    @Override
    public void exitArithmeticExpression(QLParser.ArithmeticExpressionContext ctx) {
        if (ctx.operator != null) {
            Evaluable expression = null;
            Evaluable right = expressions.pop();
            Evaluable left = expressions.pop();

            switch (ctx.operator.getType()) {
                case QLParser.ADDITION:
                    expression = new Addition(left, right);
                    break;
                case QLParser.SUBTRACTION:
                    expression = new Subtraction(left, right);
                    break;
                case QLParser.MULTIPLICATION:
                    expression = new Multiplication(left, right);
                    break;
                case QLParser.DIVISION:
                    expression = new Division(left, right);
                    break;
                case QLParser.EQUALTO:
                    expression = new EqualTo(left, right);
                    break;
                case QLParser.NOTEQUALTO:
                    expression = new NotEqualTo(left, right);
                    break;
            }
            this.expressions.push(expression);
        }
    }

    @Override
    public void exitLogicalExpression(QLParser.LogicalExpressionContext ctx) {
        if (ctx.operator != null) {
            BinaryExpression expression = null;
            Evaluable right = expressions.pop();
            Evaluable left = expressions.pop();

            switch (ctx.operator.getType()) {
                case QLParser.AND:
                    expression = new And(left, right);
                    break;
                case QLParser.OR:
                    expression = new Or(left, right);
                    break;
                case QLParser.BIGGERTHANOREQUAL:
                    expression = new BiggerThanOrEqual(left, right);
                    break;
                case QLParser.BIGGERTHAN:
                    expression = new BiggerThan(left, right);
                    break;
                case QLParser.SMALLERTHANOREQUAL:
                    expression = new SmallerThanOrEqual(left, right);
                    break;
                case QLParser.SMALLERTHAN:
                    expression = new SmallerThan(left, right);
                    break;
                case QLParser.EQUALTO:
                    expression = new EqualTo(left, right);
                    break;
                case QLParser.NOTEQUALTO:
                    expression = new NotEqualTo(left, right);
                    break;
            }
            this.expressions.push(expression);
        }
    }

    private String removeQuotations(String string) {
        return string.replace("\"", "");
    }
}
