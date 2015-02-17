from AST import AST
import ASTNodes
from collections import OrderedDict
from CustomTypes import *

class QuestionTable(OrderedDict):
	def __init__(self, ast):
		super().__init__(self)

		for formStatement in ast.root.statements:
			form = Form(formStatement)

			for statement in formStatement.getChildren():
				self.__addStatement(statement, ExpressionsTuple(), form)

	def __addStatement(self, statement, expressionsTuple, form):
		assert isinstance(statement, ASTNodes.IfStatement) or isinstance(statement, ASTNodes.QuestionStatement)

		if isinstance(statement, ASTNodes.IfStatement):
			childExpressionsTuple = expressionsTuple + (ExpressionFactory.create((statement.expr)),)
			
			for childStatement in statement.getChildren():
				self.__addStatement(childStatement, childExpressionsTuple, form)
		else:
			question = Question(statement, expressionsTuple, form)
			questionList = self.get(question.identifier, QuestionList())
			questionList.append(question)
			self[question.identifier] = questionList

class ExpressionsTuple(tuple):
	def __add__(self, value):
		return ExpressionsTuple(tuple.__add__(self, value))

	def evaluate(self):
		return all(expr.evaluate() for expr in self)

class QuestionList(list):
	def getVisibleQuestion(self):
		for question in self:
			if question.isVisible():
				return question
		return None

class Form(object):
	def __init__(self, formStatementNode):
		assert isinstance(formStatementNode, ASTNodes.FormStatement)

		self.identifier = formStatementNode.identifier

class ExpressionFactory(object):
	@staticmethod
	def create(expressionNode):
		assert isinstance(expressionNode, ASTNodes.Expression)
		
		method = ExpressionFactory._getCreateMethod(expressionNode)
		return method(expressionNode)
		
	@staticmethod
	def _getCreateMethod(expressionNode):
		methodName = '_create' + expressionNode.__class__.__name__
		return getattr(ExpressionFactory, methodName)

	@staticmethod
	def _createBinaryExpression(binaryExpressionNode):
		return BinaryExpression(binaryExpressionNode)

	@staticmethod
	def _createUnaryExpression(unaryExpressionNode):
		return UnaryExpression(unaryExpressionNode)

	@staticmethod
	def _createAtomicExpression(atomicExpressionNode):
		return AtomicExpression(atomicExpressionNode)

class BinaryExpression(object):
	def __init__(self, binaryExpressionNode):
		self.left = ExpressionFactory.create(binaryExpressionNode.left)
		self.op = binaryExpressionNode.op
		self.right = ExpressionFactory.create(binaryExpressionNode.right)

	def evaluate(self):
		left = self.left.evaluate()
		right = self.right.evaluate()
		
		if self.op == '+':
			return left + right
		elif self.op == '>':
			return left > right

class UnaryExpression(object):
	def __init__(self, unaryExpressionNode):
		self.op = unaryExpressionNode.op
		self.right = ExpressionFactory.create(unaryExpressionNode.right)

	def evaluate(self):
		return True

class AtomicExpression(object):
	def __init__(self, atomicExpressionNode):
		self.left = atomicExpressionNode.left

	def evaluate(self):
		return self.left


class Question(object):
	def __init__(self, questionStatementNode, conditionalExpressionsTuple, form):
		assert isinstance(questionStatementNode, ASTNodes.QuestionStatement)
	
		self.identifier = questionStatementNode.identifier	
		self.valueExpression = questionStatementNode.expr
		self.text = questionStatementNode.text
		self.type = questionStatementNode.type

		self.conditionalExpressions = conditionalExpressionsTuple
		self.form = form

	def isVisible(self):
		return self.conditionalExpressions.evaluate()

class Page(object):
	def __init__(self, questionTable, questionIdentifiers):
		self.questionLists = []
		for identifier in questionIdentifiers:
			self.questionLists.append(questionTable[identifier])

	def getVisibleQuestions(self):
		visibleQuestions = []
		
		for questionList in self.questionLists:
			visibleQuestion = questionList.getVisibleQuestion()
			if visibleQuestion:
				visibleQuestions.append(visibleQuestion)

		return visibleQuestions


ast = AST("test_visitor.QL")
qt = QuestionTable(ast)
page = Page(qt, qt.keys())
for q in page.getVisibleQuestions():
	print(q.text)

#for identifier, question in ec.items():
#	print(identifier, question)
	