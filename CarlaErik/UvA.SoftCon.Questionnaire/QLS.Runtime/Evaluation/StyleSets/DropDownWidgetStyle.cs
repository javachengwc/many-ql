﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace UvA.SoftCon.Questionnaire.QLS.Runtime.Evaluation.StyleSets
{
    public class DropDownWidgetStyle : WidgetStyle
    {
        public string TrueLabel
        {
            get;
            private set;
        }

        public string FalseLabel
        {
            get;
            private set;
        }

        public static DropDownWidgetStyle Default
        {
            get
            {
                return new DropDownWidgetStyle("Yes", "No");
            }
        }

        public DropDownWidgetStyle(string trueLabel, string falseLabel)
        {
            TrueLabel = trueLabel;
            FalseLabel = falseLabel;
        }
    }
}
