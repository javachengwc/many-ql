// Generated from E:/development/Steven/src/main/antlr/grammers\QL.g4 by ANTLR 4.5
package parser.antlrGenerated;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link QLParser}.
 */
public interface QLListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link QLParser#form}.
	 * @param ctx the parse tree
	 */
	void enterForm(@NotNull QLParser.FormContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#form}.
	 * @param ctx the parse tree
	 */
	void exitForm(@NotNull QLParser.FormContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(@NotNull QLParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(@NotNull QLParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLParser#if_statement}.
	 * @param ctx the parse tree
	 */
	void enterIf_statement(@NotNull QLParser.If_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#if_statement}.
	 * @param ctx the parse tree
	 */
	void exitIf_statement(@NotNull QLParser.If_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLParser#else_clause}.
	 * @param ctx the parse tree
	 */
	void enterElse_clause(@NotNull QLParser.Else_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#else_clause}.
	 * @param ctx the parse tree
	 */
	void exitElse_clause(@NotNull QLParser.Else_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(@NotNull QLParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(@NotNull QLParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLParser#bool}.
	 * @param ctx the parse tree
	 */
	void enterBool(@NotNull QLParser.BoolContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#bool}.
	 * @param ctx the parse tree
	 */
	void exitBool(@NotNull QLParser.BoolContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLParser#operator}.
	 * @param ctx the parse tree
	 */
	void enterOperator(@NotNull QLParser.OperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#operator}.
	 * @param ctx the parse tree
	 */
	void exitOperator(@NotNull QLParser.OperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLParser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(@NotNull QLParser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(@NotNull QLParser.IdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLParser#question}.
	 * @param ctx the parse tree
	 */
	void enterQuestion(@NotNull QLParser.QuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#question}.
	 * @param ctx the parse tree
	 */
	void exitQuestion(@NotNull QLParser.QuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLParser#question_expression}.
	 * @param ctx the parse tree
	 */
	void enterQuestion_expression(@NotNull QLParser.Question_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#question_expression}.
	 * @param ctx the parse tree
	 */
	void exitQuestion_expression(@NotNull QLParser.Question_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLParser#question_type}.
	 * @param ctx the parse tree
	 */
	void enterQuestion_type(@NotNull QLParser.Question_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#question_type}.
	 * @param ctx the parse tree
	 */
	void exitQuestion_type(@NotNull QLParser.Question_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLParser#question_label}.
	 * @param ctx the parse tree
	 */
	void enterQuestion_label(@NotNull QLParser.Question_labelContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#question_label}.
	 * @param ctx the parse tree
	 */
	void exitQuestion_label(@NotNull QLParser.Question_labelContext ctx);
}