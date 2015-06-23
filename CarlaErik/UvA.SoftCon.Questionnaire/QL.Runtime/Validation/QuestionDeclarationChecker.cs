﻿using System.Collections.Generic;
using System.Linq;
using UvA.SoftCon.Questionnaire.Common.Validation;
using UvA.SoftCon.Questionnaire.QL.AST.Model.Expressions;
using UvA.SoftCon.Questionnaire.QL.AST.Model.Statements;

namespace UvA.SoftCon.Questionnaire.QL.Runtime.Validation
{
    /// <summary>
    /// Checks if there are no duplicate questions declared in the same scope
    /// and there are no references to undefined questions.
    /// </summary>
    internal class QuestionDeclarationChecker : ASTChecker
    {
        private readonly ICollection<string> _declaredQuestions = new List<string>();

        internal QuestionDeclarationChecker()
        {
        }

        protected QuestionDeclarationChecker(IEnumerable<string> declaredQuestions, ValidationReport report)
            : this()
        {
            // Call ToList so we get our own instance of the list.
            _declaredQuestions = declaredQuestions.ToList();
            Report = report;
        }

        public override object Visit(BooleanQuestion question)
        {
            return VisitQuestion(question);
        }

        public override object Visit(DateQuestion question)
        {
            return VisitQuestion(question);
        }

        public override object Visit(IntegerQuestion question)
        {
            return VisitQuestion(question);
        }

        public override object Visit(StringQuestion question)
        {
            return VisitQuestion(question);
        }

        public override object Visit(Identifier identifier)
        {
            if (!_declaredQuestions.Contains(identifier.Name))
            {
                Report.AddError(identifier.Position, "Identifier '{0}' does not reference a defined question.", identifier.Name);
            }
            return null;
        }

        public override object Visit(IfStatement ifStatement)
        {
            ifStatement.If.Accept(this);

            var thenVisitor = new QuestionDeclarationChecker(_declaredQuestions, Report);

            foreach (var statement in ifStatement.Then)
            {
                statement.Accept(thenVisitor);
            }

            var elseVisitor = new QuestionDeclarationChecker(_declaredQuestions, Report);

            foreach (var statement in ifStatement.Else)
            {
                statement.Accept(elseVisitor);
            }

            return null;
        }

        private object VisitQuestion(Question question)
        {
            if (!_declaredQuestions.Contains(question.Id.Name))
            {
                _declaredQuestions.Add(question.Id.Name);
            }
            else
            {
                Report.AddError(question.Position, "A question with the name '{0}' is already defined in the same scope.", question.Id.Name);
            }
            return null;
        }
    }
}
