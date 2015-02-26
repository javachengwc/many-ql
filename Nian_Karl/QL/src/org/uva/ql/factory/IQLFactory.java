package org.uva.ql.factory;

import org.antlr.v4.runtime.atn.SemanticContext.Operator;
import org.uva.ql.antlr.QLParser.QuestionComputeContext;
import org.uva.ql.antlr.QLParser.QuestionNormalContext;
import org.uva.ql.ast.statement.QuestionCompute;
import org.uva.ql.ast.statement.QuestionNormal;
import org.uva.ql.ast.type.QuestionType;

public interface IQLFactory {
	
	public QuestionNormal getQuestionNormal(QuestionNormalContext ctx);
	public QuestionCompute getQuestionCompute(QuestionComputeContext ctx);
	public QuestionType getQuestionType (String s);
	public boolean stringToBoolean(String s);
	public Operator getOperator(String s);	
}