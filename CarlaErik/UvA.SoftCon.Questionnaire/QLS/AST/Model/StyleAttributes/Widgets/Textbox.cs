﻿using UvA.SoftCon.Questionnaire.Common.AST.Model;
using UvA.SoftCon.Questionnaire.QLS.StyleSets;

namespace UvA.SoftCon.Questionnaire.QLS.AST.Model.StyleAttributes.Widgets
{
    public class TextBox : Widget
    {
        internal TextBox(TextPosition position)
            : base(position) { }

        public override T Accept<T>(IStyleSheetVisitor<T> visitor)
        {
            return visitor.VisitTextBox(this);
        }

        public override void OverrideStyle(StyleSet styleSet)
        {
            styleSet.OverrideWidget(new TextBoxWidgetStyle());
        }

        public override bool SupportsDataType(DataType dataType)
        {
            return dataType == DataType.String || dataType == DataType.Integer;
        }
    }
}
