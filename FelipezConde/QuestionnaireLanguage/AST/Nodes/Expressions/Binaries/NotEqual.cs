﻿using AST.Nodes.Interfaces;

namespace AST.Nodes.Expressions.Binaries
{
    public class NotEqual : Binary
    {
        public NotEqual(Expression left, Expression right, PositionInText position)
            : base(left, right, position)
        { }

        public override T Accept<T>(VisitorInterfaces.IExpressionVisitor<T> visitor)
        {
            return visitor.Visit(this);
        }

        public override string ToString()
        {
            return "!=";
        }
    }
}