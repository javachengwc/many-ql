﻿using System;

namespace QL.AST.Nodes.Terminals
{
    public class Number : ElementBase, IStaticReturnType
    {

        public int? Value { get; set; }

        public Number()
        {}
        public Number(string unparsedValue)
        {
            Value = Int32.Parse(unparsedValue);
        }

        public Number(string unparsedValue, SourceLocation sourceLocation):this(unparsedValue)
        {
            SourceLocation = sourceLocation;
        }

        public Type GetReturnType()
        {
            return GetType();
        }

        public override string ToString()
        {
            if (!Value.HasValue)
            {
                throw new Exception();
            }
            
            return Value.ToString();
        }
    }
}
