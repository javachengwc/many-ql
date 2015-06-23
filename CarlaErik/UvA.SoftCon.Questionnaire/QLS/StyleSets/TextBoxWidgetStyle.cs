﻿namespace UvA.SoftCon.Questionnaire.QLS.StyleSets
{
    public class TextBoxWidgetStyle : WidgetStyle
    {
        public static TextBoxWidgetStyle Default
        {
            get
            {
                return new TextBoxWidgetStyle();
            }
        }

        public override object CreateWidgetControl(IWidgetFactory factory)
        {
            return factory.CreateTextBoxWidget();
        }
    }
}
