package ql.ast.visitor.typechecker;

import java.util.List;
import java.util.stream.Collectors;

import ql.TypeEnvironment;
import ql.ast.QLNode;
import ql.ast.Expression;
import ql.ast.expression.Identifier;
import ql.ast.expression.QLType;
import ql.ast.expression.arithmetic.Add;
import ql.ast.expression.arithmetic.Div;
import ql.ast.expression.arithmetic.Mul;
import ql.ast.expression.arithmetic.Neg;
import ql.ast.expression.arithmetic.Pos;
import ql.ast.expression.arithmetic.Sub;
import ql.ast.expression.literal.BooleanLiteral;
import ql.ast.expression.literal.FloatLiteral;
import ql.ast.expression.literal.IntegerLiteral;
import ql.ast.expression.literal.StringLiteral;
import ql.ast.expression.relational.And;
import ql.ast.expression.relational.Eq;
import ql.ast.expression.relational.GEq;
import ql.ast.expression.relational.GT;
import ql.ast.expression.relational.LEq;
import ql.ast.expression.relational.LT;
import ql.ast.expression.relational.NEq;
import ql.ast.expression.relational.Not;
import ql.ast.expression.relational.Or;
import ql.ast.expression.type.QLBoolean;
import ql.ast.expression.type.QLError;
import ql.ast.expression.type.QLFloat;
import ql.ast.expression.type.QLForm;
import ql.ast.expression.type.QLInteger;
import ql.ast.expression.type.QLNumeric;
import ql.ast.expression.type.QLString;
import ql.ast.statement.Block;
import ql.ast.statement.ComputedQuestion;
import ql.ast.statement.Form;
import ql.ast.statement.If;
import ql.ast.statement.IfElse;
import ql.ast.statement.Question;
import ql.ast.visitor.ExpressionVisitor;
import ql.ast.visitor.StatementVisitor;
import ql.error.TypeErrors;

public class TypeChecker implements ExpressionVisitor<QLType>, StatementVisitor<QLType> {
	private static TypeErrors typeErrors;
	private TypeEnvironment register;	
	
	private TypeChecker(TypeEnvironment register) {
		this.register = register;
	}
	
	/**
	 * Entry point, static type checks the supplied tree
	 * @return a boolean indicating pass or fail
	 */
	public static boolean check(QLNode tree, TypeEnvironment register) {
		TypeChecker typeChecker = new TypeChecker(register);
		typeErrors = new TypeErrors();
		
		tree.accept(typeChecker);
		
		typeErrors.outputErrors();
		
		return typeErrors.hasErrors();
	}	
	
	/**
	 * Checks whether the given expression passes the type checker. 
	 * If the types are not compatible with the given compatibleWith type
	 * then an error is added to the errors list.
	 * @param expr
	 * @param compatibleWith The QLType the operands should be compatible with
	 */
	private QLType checkExpression(Expression expr, QLType compatibleWith) {		
		List<QLType> operandTypes = expr.getOperands()
				.stream()
				.map(operand -> operand.accept(this))
				.collect(Collectors.toList());
				
		// Both operands should be compatible with compatibleWith
		if (!isCompatibleWith(operandTypes, compatibleWith)) {
			typeErrors.incompatibleTypes(expr, operandTypes, compatibleWith);
		}
		
		return expr.getType();
	}
	
	/**
	 * Checks whether the operands of an expression are compatible with the
	 * expected QLType.
	 * @param expr
	 * @param compatibleWith
	 */
	public boolean isCompatibleWith(List<QLType> operandTypes, QLType compatibleWith) {		
		return operandTypes
				.stream()
				.map(n -> n.compatibleWith(compatibleWith))
				.allMatch(a -> a);
	}	
	
	/**
	 * OPERATORS 
	 */
	@Override
	public QLType visit(Add addNode) {
		return checkExpression(addNode, new QLNumeric());
	}

	@Override
	public QLType visit(Div divNode) {
		return checkExpression(divNode, new QLNumeric());
	}

	@Override
	public QLType visit(Mul mulNode) {
		return checkExpression(mulNode, new QLNumeric());
	}

	@Override
	public QLType visit(Sub subNode) {
		return checkExpression(subNode, new QLNumeric());
	}
	
	@Override
	public QLType visit(Neg negNode) {
		return checkExpression(negNode, new QLNumeric());
	}
	
	@Override
	public QLType visit(Pos posNode) {
		return checkExpression(posNode, new QLNumeric());
	}
	
	/**
	 * EQUALITY OPERATORS
	 * 
	 * The left operand should be compatible with the right one.
	 * So the compatibleWith value is one of the operands' type
	 */
	
	@Override
	public QLType visit(Eq eqNode) {
		return checkExpression(eqNode, eqNode.getLeft().accept(this));
	}
	
	@Override
	public QLType visit(NEq neqNode) {
		return checkExpression(neqNode, neqNode.getLeft().accept(this));
	}
	
	/**
	 * Relational operators
	 */

	@Override
	public QLType visit(GEq geqNode) {
		return checkExpression(geqNode, new QLNumeric());
	}

	@Override
	public QLType visit(GT gtNode) {
		return checkExpression(gtNode, new QLNumeric());
	}

	@Override
	public QLType visit(LEq leqNode) {
		return checkExpression(leqNode, new QLNumeric());
	}

	@Override
	public QLType visit(LT ltNode) {
		return checkExpression(ltNode, new QLNumeric());
	}

	
	@Override
	public QLType visit(And andNode) {
		return checkExpression(andNode, new QLBoolean());	
	}
	
	@Override
	public QLType visit(Or orNode) {
		return checkExpression(orNode, new QLBoolean());
	}

	@Override
	public QLType visit(Not notNode) {
		return checkExpression(notNode, new QLBoolean());
	}
	
	/**
	 * Types
	 */
	
	public QLType visit(QLBoolean booleanNode) { return booleanNode.getType(); }
	public QLType visit(QLFloat floatNode) { return floatNode.getType(); }
	public QLType visit(QLForm formNode) { return formNode.getType(); }   
	public QLType visit(QLNumeric numericNode) { return numericNode.getType(); }
	public QLType visit(QLInteger intNode) { return intNode.getType(); }
	public QLType visit(QLString stringNode) { return stringNode.getType(); }
	public QLType visit(QLError errNode) { return errNode.getType(); }
	
	public QLType visit(BooleanLiteral booleanNode) { return booleanNode.getType(); }	
	public QLType visit(FloatLiteral floatNode) { return floatNode.getType(); }
	public QLType visit(IntegerLiteral intNode) { return intNode.getType(); }
	public QLType visit(StringLiteral stringNode) {	return stringNode.getType(); }
	
	public QLType visit(Identifier identifier) {
		QLType identifierType = register.resolve(identifier);
		
		if(identifierType == null) {
			typeErrors.undefinedVariable(identifier);
			return new QLError();
		}
		
		return identifierType;
	}

	/**
	 * Statements
	 */	
	@Override

	public QLType visit(ComputedQuestion compQuestionNode) {		
		QLType questionType = compQuestionNode.getType();
		QLType expressionType = compQuestionNode.getExpression().accept(this);
		
		if(!questionType.compatibleWith(expressionType)) {
			typeErrors.illegalQuestionAssignment(compQuestionNode, questionType, expressionType);
		}
		
		Identifier questionIdentifier = compQuestionNode.getIdentifier();
		
		if(register.resolve(questionIdentifier) == null) {
			register.store(questionIdentifier, questionType);
		} else {
			typeErrors.doubleDefinedVariable(questionIdentifier);
		}
		
		return questionType;
	}
	
	@Override
	public QLType visit(Form formNode) {
		Identifier formIdentifier = formNode.getIdentifier();
		
		if(register.resolve(formIdentifier) == null) {
			register.store(formNode.getIdentifier(), formNode.getType());
		} else {
			typeErrors.doubleDefinedVariable(formIdentifier);
		}
		
		StatementVisitor.super.visit(formNode);
		
		return formNode.getType();
	}
	
	@Override
	public QLType visit(If ifNode) {		
		// The expression must have a boolean type
		QLType ifType = ifNode.getExpression().accept(this);
		
		if (!ifType.compatibleWith(new QLBoolean())) {
			typeErrors.incompatibleType(ifNode, new QLBoolean(), ifType);
		}		
			
		ifNode.getBlock().accept(this);
		
		return ifType;
	}
	
	@Override
	public QLType visit(IfElse ifElseNode) {
		// The expression must have a boolean type
		QLType ifType = ifElseNode.getExpression().accept(this);
		
		if (!ifType.compatibleWith(new QLBoolean())) {
			typeErrors.incompatibleType(ifElseNode, new QLBoolean(), ifType);
		}		

		
		ifElseNode.getIfBranch().accept(this);
		ifElseNode.getElseBranch().accept(this);
		
		return ifType;
	}

	@Override
	public QLType visit(Question questionNode) {
		Identifier questionIdentifier = questionNode.getIdentifier();
		
		if(register.resolve(questionIdentifier) == null) {
			register.store(questionIdentifier, questionNode.getType());
		} else {
			typeErrors.doubleDefinedVariable(questionIdentifier);
		}
		
		return questionNode.getType();
	}
	
	@Override
	public QLType visit(Block blockNode) {
		increaseScope();
		StatementVisitor.super.visit(blockNode);
		decreaseScope();
		return null;
	}
	
	private void increaseScope() {
		register = new TypeEnvironment(register);
	}
	
	private void decreaseScope() {
		register = register.getParent();
	}
}
