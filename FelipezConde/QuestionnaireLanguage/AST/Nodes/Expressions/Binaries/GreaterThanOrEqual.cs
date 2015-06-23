﻿
namespace AST.Nodes.Expressions.Binaries
{
    public class GreaterThanOrEqual : Binary
    {
        public GreaterThanOrEqual(Expression left, Expression right, PositionInText position)
            : base(left, right, position)
        { }
        

        public override T Accept<T>(VisitorInterfaces.IExpressionVisitor<T> visitor)
        {
            return visitor.Visit(this);
        }

        public override string ToString()
        {
            return ">=";
        }
    }
}
