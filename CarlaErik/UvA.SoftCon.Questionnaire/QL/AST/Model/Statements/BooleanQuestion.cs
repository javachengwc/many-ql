﻿using UvA.SoftCon.Questionnaire.Common.AST.Model;
using UvA.SoftCon.Questionnaire.QL.AST.Model.Expressions;

namespace UvA.SoftCon.Questionnaire.QL.AST.Model.Statements
{
    public class BooleanQuestion : Question
    {
        internal BooleanQuestion(Identifier id, string label, Expression expression, TextPosition position)
            : base(DataType.Boolean, id, label, expression, position) { }

        public override T Accept<T>(IQuestionFormVisitor<T> visitor)
        {
            return visitor.Visit(this);
        }
    }
}
