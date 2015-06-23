﻿using UvA.SoftCon.Questionnaire.Common.AST.Model;
using UvA.SoftCon.Questionnaire.QL.AST.Model.Expressions;

namespace UvA.SoftCon.Questionnaire.QL.AST.Model.Statements
{
    public class StringQuestion : Question
    {
        internal StringQuestion(Identifier id, string label, Expression expression, TextPosition position)
            : base(DataType.String, id, label, expression, position) { }

        public override T Accept<T>(IQuestionFormVisitor<T> visitor)
        {
            return visitor.Visit(this);
        }
    }
}
