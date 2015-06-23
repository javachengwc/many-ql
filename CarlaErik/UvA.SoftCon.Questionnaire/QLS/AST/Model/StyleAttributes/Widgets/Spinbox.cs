﻿using UvA.SoftCon.Questionnaire.Common.AST.Model;
using UvA.SoftCon.Questionnaire.QLS.StyleSets;

namespace UvA.SoftCon.Questionnaire.QLS.AST.Model.StyleAttributes.Widgets
{
    public class SpinBox : Widget
    {
        internal SpinBox(TextPosition position)
            : base(position) { }

        public override T Accept<T>(IStyleSheetVisitor<T> visitor)
        {
            return visitor.VisitSpinBox(this);
        }

        public override void OverrideStyle(StyleSet styleSet)
        {
            styleSet.OverrideWidget(new SpinBoxWidgetStyle());
        }

        public override bool SupportsDataType(DataType dataType)
        {
            return dataType == DataType.Integer;
        }
    }
}
