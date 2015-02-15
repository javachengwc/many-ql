﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.AST.Expressions.Boolean;

namespace UvA.SoftCon.Questionnaire.AST.Literals
{
    /// <summary>
    /// Represents a static immutable boolean value.
    /// </summary>
    public class BooleanLiteral : IBooleanExpression
    {
        public bool Value {
            get;
            private set;
        }

        public BooleanLiteral(bool value)
        {
            Value = value;
        }

        public bool Evaluate()
        {
            return Value;
        }
    }
}