package nl.uva.softwcons.eval;

import static helper.TestHelper.DUMMY_LINE_INFO;
import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

import nl.uva.softwcons.ast.expression.binary.arithmetic.Addition;
import nl.uva.softwcons.ast.expression.binary.arithmetic.Division;
import nl.uva.softwcons.ast.expression.binary.arithmetic.Multiplication;
import nl.uva.softwcons.ast.expression.binary.arithmetic.Subtraction;
import nl.uva.softwcons.ast.expression.binary.comparison.GreaterOrEqual;
import nl.uva.softwcons.ast.expression.binary.logical.And;
import nl.uva.softwcons.ast.expression.binary.logical.Or;
import nl.uva.softwcons.ast.expression.identifier.Identifier;
import nl.uva.softwcons.ast.expression.literal.BooleanLiteral;
import nl.uva.softwcons.ast.expression.literal.DecimalLiteral;
import nl.uva.softwcons.ast.expression.literal.IntegerLiteral;
import nl.uva.softwcons.ast.expression.literal.StringLiteral;
import nl.uva.softwcons.ast.expression.unary.logical.Not;
import nl.uva.softwcons.eval.value.BooleanValue;
import nl.uva.softwcons.eval.value.NumberValue;

import org.junit.Test;

public class ExpressionEvaluatorTest {
    private static final IntegerLiteral INT_1 = new IntegerLiteral(1, DUMMY_LINE_INFO);
    private static final IntegerLiteral INT_2 = new IntegerLiteral(2, DUMMY_LINE_INFO);

    private static final DecimalLiteral DEC_1_5 = new DecimalLiteral(1.5, DUMMY_LINE_INFO);
    private static final DecimalLiteral DEC_2_5 = new DecimalLiteral(2.5, DUMMY_LINE_INFO);

    private static final BooleanLiteral TRUE = new BooleanLiteral(true, DUMMY_LINE_INFO);
    private static final BooleanLiteral FALSE = new BooleanLiteral(false, DUMMY_LINE_INFO);

    // TODO add tests for strings
    private static final StringLiteral STR_FOO = new StringLiteral("foo", DUMMY_LINE_INFO);
    private static final StringLiteral STR_BAR = new StringLiteral("bar", DUMMY_LINE_INFO);

    @Test
    public void testIntegerAddition() {
        final Addition exprInt = new Addition(INT_1, INT_2, DUMMY_LINE_INFO);

        assertThat(ExpressionEvaluator.evaluate(exprInt, null)).isExactlyInstanceOf(NumberValue.class);
        assertThat(ExpressionEvaluator.evaluate(exprInt, null).asDecimal()).isEqualTo("3");
    }

    @Test
    public void testDecimalAddition() {
        final Addition exprDec = new Addition(DEC_1_5, DEC_2_5, DUMMY_LINE_INFO);

        assertThat(ExpressionEvaluator.evaluate(exprDec, null)).isExactlyInstanceOf(NumberValue.class);
        assertThat(ExpressionEvaluator.evaluate(exprDec, null).asDecimal()).isEqualTo("4.0");
    }

    @Test
    public void testMixedAddition() {
        final Addition exprMixed = new Addition(DEC_2_5, INT_2, DUMMY_LINE_INFO);

        assertThat(ExpressionEvaluator.evaluate(exprMixed, null)).isExactlyInstanceOf(NumberValue.class);
        assertThat(ExpressionEvaluator.evaluate(exprMixed, null).asDecimal()).isEqualTo("4.5");
    }

    @Test
    public void testVisitSubtraction() {
        Subtraction exprInt = new Subtraction(INT_1, INT_2, DUMMY_LINE_INFO);
        Subtraction exprDec = new Subtraction(DEC_1_5, DEC_2_5, DUMMY_LINE_INFO);
        Subtraction exprMixed = new Subtraction(INT_1, DEC_1_5, DUMMY_LINE_INFO);
        Subtraction exprMixed2 = new Subtraction(DEC_1_5, INT_1, DUMMY_LINE_INFO);

        assertThat(ExpressionEvaluator.evaluate(exprInt, new FormAnswers()).getValue()).isEqualTo(
                BigDecimal.valueOf(-1));
        assertThat(ExpressionEvaluator.evaluate(exprInt, new FormAnswers())).isExactlyInstanceOf(NumberValue.class);

        assertThat(ExpressionEvaluator.evaluate(exprMixed, new FormAnswers()).getValue()).isEqualTo(
                BigDecimal.valueOf(-0.5));
        assertThat(ExpressionEvaluator.evaluate(exprMixed, new FormAnswers())).isExactlyInstanceOf(NumberValue.class);

        assertThat(ExpressionEvaluator.evaluate(exprMixed2, new FormAnswers()).getValue()).isEqualTo(
                BigDecimal.valueOf(0.5));
        assertThat(ExpressionEvaluator.evaluate(exprMixed2, new FormAnswers())).isExactlyInstanceOf(NumberValue.class);

        assertThat(ExpressionEvaluator.evaluate(exprDec, new FormAnswers())).isExactlyInstanceOf(NumberValue.class);
        assertThat(
                ((BigDecimal) ExpressionEvaluator.evaluate(exprDec, new FormAnswers()).getValue())
                        .compareTo(new BigDecimal(-1))).isEqualTo(0);
    }

    @Test
    public void testVisitMultiplication() {
        Multiplication exprInt = new Multiplication(INT_1, INT_2, DUMMY_LINE_INFO);

        Multiplication exprDec = new Multiplication(DEC_1_5, DEC_2_5, DUMMY_LINE_INFO);

        assertThat(ExpressionEvaluator.evaluate(exprInt, new FormAnswers()).getValue())
                .isEqualTo(BigDecimal.valueOf(2));
        assertThat(ExpressionEvaluator.evaluate(exprInt, new FormAnswers())).isExactlyInstanceOf(NumberValue.class);

        assertThat(ExpressionEvaluator.evaluate(exprDec, new FormAnswers())).isExactlyInstanceOf(NumberValue.class);
        assertThat(
                ((BigDecimal) ExpressionEvaluator.evaluate(exprDec, new FormAnswers()).getValue())
                        .compareTo(new BigDecimal(1.5 * 2.5))).isEqualTo(0);
    }

    @Test
    public void testVisitDivision() {

        Division exprInt = new Division(INT_1, INT_2, DUMMY_LINE_INFO);
        Division exprDec = new Division(DEC_1_5, DEC_2_5, DUMMY_LINE_INFO);

        assertThat(ExpressionEvaluator.evaluate(exprInt, new FormAnswers())).isExactlyInstanceOf(NumberValue.class);
        assertThat(ExpressionEvaluator.evaluate(exprInt, new FormAnswers()).getValue()).isEqualTo(
                BigDecimal.valueOf(0.5));

        assertThat(ExpressionEvaluator.evaluate(exprDec, new FormAnswers())).isExactlyInstanceOf(NumberValue.class);
        BigDecimal result = new BigDecimal(1.5).divide(new BigDecimal(2.5));
        assertThat(((BigDecimal) ExpressionEvaluator.evaluate(exprDec, new FormAnswers()).getValue()).compareTo(result))
                .isEqualTo(0);

        Division exprMixedFromInt = new Division(new IntegerLiteral(3, DUMMY_LINE_INFO), DEC_1_5, DUMMY_LINE_INFO);
        assertThat(ExpressionEvaluator.evaluate(exprMixedFromInt, new FormAnswers())).isExactlyInstanceOf(
                NumberValue.class);

        BigDecimal result2 = new BigDecimal(3.0).divide(new BigDecimal(1.5));
        assertThat(
                ((BigDecimal) ExpressionEvaluator.evaluate(exprMixedFromInt, new FormAnswers()).getValue())
                        .compareTo(result2)).isEqualTo(0);

    }

    @Test
    public void testVisitGE() {
        GreaterOrEqual exprInt = new GreaterOrEqual(INT_1, INT_2, DUMMY_LINE_INFO);
        GreaterOrEqual exprDec = new GreaterOrEqual(DEC_2_5, DEC_1_5, DUMMY_LINE_INFO);

        GreaterOrEqual exprMixed = new GreaterOrEqual(DEC_2_5, INT_2, DUMMY_LINE_INFO);

        assertThat(ExpressionEvaluator.evaluate(exprInt, new FormAnswers())).isExactlyInstanceOf(BooleanValue.class);
        assertThat(ExpressionEvaluator.evaluate(exprInt, new FormAnswers()).getValue()).isExactlyInstanceOf(
                Boolean.class);
        assertThat(ExpressionEvaluator.evaluate(exprInt, new FormAnswers()).getValue()).isEqualTo(false);

        assertThat(ExpressionEvaluator.evaluate(exprDec, new FormAnswers())).isExactlyInstanceOf(BooleanValue.class);
        assertThat(ExpressionEvaluator.evaluate(exprDec, new FormAnswers()).getValue()).isExactlyInstanceOf(
                Boolean.class);
        assertThat(ExpressionEvaluator.evaluate(exprDec, new FormAnswers()).getValue()).isEqualTo(true);

        assertThat(ExpressionEvaluator.evaluate(exprMixed, new FormAnswers())).isExactlyInstanceOf(BooleanValue.class);
        assertThat(ExpressionEvaluator.evaluate(exprMixed, new FormAnswers()).getValue()).isExactlyInstanceOf(
                Boolean.class);
        assertThat(ExpressionEvaluator.evaluate(exprMixed, new FormAnswers()).getValue()).isEqualTo(true);
    }

    @Test
    public void testVisitAnd() {
        And exprAndFalse = new And(FALSE, TRUE, DUMMY_LINE_INFO);
        And exprAndTrue = new And(TRUE, TRUE, DUMMY_LINE_INFO);
        And exprAndFalse2 = new And(FALSE, FALSE, DUMMY_LINE_INFO);

        assertThat(ExpressionEvaluator.evaluate(exprAndFalse, new FormAnswers())).isExactlyInstanceOf(
                BooleanValue.class);
        assertThat(ExpressionEvaluator.evaluate(exprAndFalse, new FormAnswers()).getValue()).isExactlyInstanceOf(
                Boolean.class);
        assertThat(ExpressionEvaluator.evaluate(exprAndFalse, new FormAnswers()).getValue()).isEqualTo(false);

        assertThat(ExpressionEvaluator.evaluate(exprAndTrue, new FormAnswers()))
                .isExactlyInstanceOf(BooleanValue.class);
        assertThat(ExpressionEvaluator.evaluate(exprAndTrue, new FormAnswers()).getValue()).isExactlyInstanceOf(
                Boolean.class);
        assertThat(ExpressionEvaluator.evaluate(exprAndTrue, new FormAnswers()).getValue()).isEqualTo(true);

        assertThat(ExpressionEvaluator.evaluate(exprAndFalse2, new FormAnswers())).isExactlyInstanceOf(
                BooleanValue.class);
        assertThat(ExpressionEvaluator.evaluate(exprAndFalse2, new FormAnswers()).getValue()).isExactlyInstanceOf(
                Boolean.class);
        assertThat(ExpressionEvaluator.evaluate(exprAndFalse2, new FormAnswers()).getValue()).isEqualTo(false);
    }

    @Test
    public void testVisitOr() {
        Or exprOrTrue = new Or(FALSE, TRUE, DUMMY_LINE_INFO);
        Or exprOrTrue2 = new Or(TRUE, TRUE, DUMMY_LINE_INFO);
        Or exprOrFalse = new Or(FALSE, FALSE, DUMMY_LINE_INFO);

        assertThat(ExpressionEvaluator.evaluate(exprOrTrue, new FormAnswers())).isExactlyInstanceOf(BooleanValue.class);
        assertThat(ExpressionEvaluator.evaluate(exprOrTrue, new FormAnswers()).getValue()).isExactlyInstanceOf(
                Boolean.class);
        assertThat(ExpressionEvaluator.evaluate(exprOrTrue, new FormAnswers()).getValue()).isEqualTo(true);

        assertThat(ExpressionEvaluator.evaluate(exprOrTrue2, new FormAnswers()))
                .isExactlyInstanceOf(BooleanValue.class);
        assertThat(ExpressionEvaluator.evaluate(exprOrTrue2, new FormAnswers()).getValue()).isExactlyInstanceOf(
                Boolean.class);
        assertThat(ExpressionEvaluator.evaluate(exprOrTrue2, new FormAnswers()).getValue()).isEqualTo(true);

        assertThat(ExpressionEvaluator.evaluate(exprOrFalse, new FormAnswers()))
                .isExactlyInstanceOf(BooleanValue.class);
        assertThat(ExpressionEvaluator.evaluate(exprOrFalse, new FormAnswers()).getValue()).isExactlyInstanceOf(
                Boolean.class);
        assertThat(ExpressionEvaluator.evaluate(exprOrFalse, new FormAnswers()).getValue()).isEqualTo(false);
    }

    @Test
    public void testVisitNot() {
        Not exprNotTrue = new Not(FALSE, DUMMY_LINE_INFO);
        Not exprNotFalse = new Not(TRUE, DUMMY_LINE_INFO);

        assertThat(ExpressionEvaluator.evaluate(exprNotTrue, new FormAnswers()))
                .isExactlyInstanceOf(BooleanValue.class);
        assertThat(ExpressionEvaluator.evaluate(exprNotTrue, new FormAnswers()).getValue()).isExactlyInstanceOf(
                Boolean.class);
        assertThat(ExpressionEvaluator.evaluate(exprNotTrue, new FormAnswers()).getValue()).isEqualTo(true);

        assertThat(ExpressionEvaluator.evaluate(exprNotFalse, new FormAnswers())).isExactlyInstanceOf(
                BooleanValue.class);
        assertThat(ExpressionEvaluator.evaluate(exprNotFalse, new FormAnswers()).getValue()).isExactlyInstanceOf(
                Boolean.class);
        assertThat(ExpressionEvaluator.evaluate(exprNotFalse, new FormAnswers()).getValue()).isEqualTo(false);
    }

    @Test
    public void testAnswersValuesStorage() {
        final Identifier id1 = new Identifier("id1", DUMMY_LINE_INFO);
        final Identifier id2 = new Identifier("id2", DUMMY_LINE_INFO);
        final Addition exprWithVariables = new Addition(id1, id2, DUMMY_LINE_INFO);

        final FormAnswers answers = new FormAnswers();
        answers.setValue(id1, new NumberValue(1));
        answers.setValue(id2, new NumberValue(2));

        assertThat(ExpressionEvaluator.evaluate(exprWithVariables, answers)).isExactlyInstanceOf(NumberValue.class);
        assertThat(ExpressionEvaluator.evaluate(exprWithVariables, answers).asDecimal()).isEqualTo("3");
    }
}