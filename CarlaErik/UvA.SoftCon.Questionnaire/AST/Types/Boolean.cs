﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.AST.Model.Statements;

namespace UvA.SoftCon.Questionnaire.AST.Types
{
    public class Boolean : Value<bool>
    {
        public Boolean(bool value)
            : base(DataType.Boolean, value) { }

        public override string ToString()
        {
            return Value.ToString();
        }
    }
}