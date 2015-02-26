﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.AST.Model.Statements;
using UvA.SoftCon.Questionnaire.AST.Types;
using UvA.SoftCon.Questionnaire.Utilities;

namespace UvA.SoftCon.Questionnaire.AST.Model.Expressions.Binary
{
    public class BinaryExpression : Node, IExpression
    {
        public override NodeType Type
        {
            get
            {
                return NodeType.BinaryExpression;
            }
        }

        public IExpression Left
        {
            get;
            private set;
        }

        public IExpression Right
        {
            get;
            private set;
        }

        public BinaryExpression(Operation operation, IExpression left, IExpression right, TextPosition position)
            : base(position)
        {
            Left = left;
            Right = right;
        }

        public override void Accept(IASTVisitor visitor)
        {
            visitor.Visit(this);
        }

        public override string ToString()
        {
            return String.Format("{0} {1} {2}", Left.ToString(), StringEnum.GetStringValue(Operation), Right.ToString());
        }

        public abstract DataType? GetType(IDictionary<string, DataType> symbolTable);

        public abstract Value Evaluate(IDictionary<string, Value> environment);
    }
}