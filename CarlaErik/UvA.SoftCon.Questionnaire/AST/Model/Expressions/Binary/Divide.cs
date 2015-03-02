﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.AST.Model.Statements;

namespace UvA.SoftCon.Questionnaire.AST.Model.Expressions.Binary
{
    public class Divide : BinaryExpression
    {
        public Divide(Operation operation, IExpression left, IExpression right, TextPosition position)
            : base(operation, left, right, position) {}

        public override void Accept(IASTVisitor visitor)
        {
            visitor.Visit(this);
        }

        public override T Accept<T>(IASTVisitor<T> visitor)
        {
            return visitor.Visit(this);
        }

        public override DataType GetType(IDictionary<string, DataType> symbolTable)
        {
            return DataType.Integer;
        }

        public override bool OperandTypesAreValid(DataType leftType, DataType rightType)
        {
            return (leftType == DataType.Integer && rightType == DataType.Integer);
        }
    }
}
