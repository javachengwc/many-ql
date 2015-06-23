﻿using System;
using UvA.SoftCon.Questionnaire.Common.AST.Building;
using UvA.SoftCon.Questionnaire.QLS.AST.Model.StyleAttributes;
using UvA.SoftCon.Questionnaire.QLS.AST.Model.StyleAttributes.Widgets;
using UvA.SoftCon.Questionnaire.QLS.Grammar;

namespace UvA.SoftCon.Questionnaire.QLS.AST.Building
{
    internal class StyleAttributeBuilder : QLSBaseVisitor<StyleAttribute>
    {
        public override StyleAttribute VisitColor(QLSParser.ColorContext context)
        {
            string rgbValue = context.HEXACOLOR().GetText();

            // Remove any leading '#' character.
            rgbValue = rgbValue.Trim('#');

            return new FontColor(rgbValue, context.GetTextPosition());
        }

        public override StyleAttribute VisitFont(QLSParser.FontContext context)
        {
            string fontName = context.STRING().GetText();

            return new FontName(fontName, context.GetTextPosition());
        }

        public override StyleAttribute VisitFontSize(QLSParser.FontSizeContext context)
        {
            int size = Int32.Parse(context.INT().GetText());

            return new FontSize(size, context.GetTextPosition());
        }

        public override StyleAttribute VisitCalendar(QLSParser.CalendarContext context)
        {
            return new Calendar(context.GetTextPosition());
        }

        public override StyleAttribute VisitCheckBox(QLSParser.CheckBoxContext context)
        {
            return new CheckBox(context.GetTextPosition());
        }

        public override StyleAttribute VisitDropDown(QLSParser.DropDownContext context)
        {
            string trueLabel = context.STRING(0).GetText();
            string falseLabel = context.STRING(1).GetText();

            // Remove the leading and trailing '"' characters from the string literals.
            trueLabel = trueLabel.Trim('"');
            falseLabel = falseLabel.Trim('"');

            return new DropDown(trueLabel, falseLabel, context.GetTextPosition());
        }

        public override StyleAttribute VisitRadioButtons(QLSParser.RadioButtonsContext context)
        {
            string trueLabel = context.STRING(0).GetText();
            string falseLabel = context.STRING(1).GetText();

            // Remove the leading and trailing '"' characters from the string literals.
            trueLabel = trueLabel.Trim('"');
            falseLabel = falseLabel.Trim('"');

            return new RadioButtons(trueLabel, falseLabel, context.GetTextPosition());
        }

        public override StyleAttribute VisitSpinBox(QLSParser.SpinBoxContext context)
        {
            return new SpinBox(context.GetTextPosition());
        }

        public override StyleAttribute VisitTextBox(QLSParser.TextBoxContext context)
        {
            return new TextBox(context.GetTextPosition());
        }
    }
}
