﻿using System;
using UvA.SoftCon.Questionnaire.Common.AST.Model;
using UvA.SoftCon.Questionnaire.QL.AST.Model.Statements;
using UvA.SoftCon.Questionnaire.QL.Runtime.Evaluation.Types;

namespace UvA.SoftCon.Questionnaire.WinForms.Controls
{
    public partial class RadioWidget : QuestionWidget
    {
        public RadioWidget(Question astQuestion)
            :base(astQuestion)
        {
            InitializeComponent();
            QuestionLabel.Text = Label;
            TrueButton.Enabled = !astQuestion.IsComputed;
            FalseButton.Enabled = !astQuestion.IsComputed;
        }

        public RadioWidget(Question astQuestion, string trueLabel, string falseLabel)
            : this(astQuestion)
        {
            TrueButton.Text = trueLabel;
            FalseButton.Text = falseLabel;
        }

        public override Value GetValue()
        {
            if (TrueButton.Checked)
            {
                return new BooleanValue(true);
            }
            else if (FalseButton.Checked)
            {
                return new BooleanValue(false);
            }
            else
            {
                return new Undefined();
            }
        }

        public override void SetValue(Value value)
        {
            if (!value.IsUndefined)
            {
                if (value.DataType == DataType.Boolean)
                {
                    bool answer = ((BooleanValue)value).Val;

                    TrueButton.Checked = answer;
                    FalseButton.Checked = !answer;
                }
                else
                {
                    throw new ArgumentException("Parameter value must be of datatype 'bool'.");
                }
            }
        }

        private void TrueButton_CheckedChanged(object sender, EventArgs e)
        {
            OnQuestionAnswered(new EventArgs());
        }

        private void FalseButton_CheckedChanged(object sender, EventArgs e)
        {
            OnQuestionAnswered(new EventArgs());
        }
    }
}