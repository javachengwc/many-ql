﻿using System;
using UvA.SoftCon.Questionnaire.Common.AST.Model;

namespace UvA.SoftCon.Questionnaire.Common.Validation
{
    /// <summary>
    /// Represents a validation message.
    /// </summary>
    public class Message
    {
        public Severity Severity
        {
            get;
            private set;
        }

        public TextPosition Position
        {
            get;
            private set;
        }

        public string Text
        {
            get;
            private set;
        }

        public Message(Severity severity, TextPosition position, string text)
        {
            Severity = severity;
            Position = position;
            Text = text;
        }

        public override string ToString()
        {
            return String.Format("{0,-5} - {1} {2}", StringEnum.GetStringValue(Severity), Text, Position);
        }
    }
}
