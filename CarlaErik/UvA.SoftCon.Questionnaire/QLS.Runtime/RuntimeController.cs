﻿using System;
using System.Collections.Generic;
using UvA.SoftCon.Questionnaire.Common.Validation;
using UvA.SoftCon.Questionnaire.QL.AST.Model;
using UvA.SoftCon.Questionnaire.QLS.AST.Model;
using UvA.SoftCon.Questionnaire.QLS.Runtime.Evaluation;
using UvA.SoftCon.Questionnaire.QLS.Runtime.Validation;

namespace UvA.SoftCon.Questionnaire.QLS.Runtime
{
    public class RuntimeController
    {
        public ValidationReport Validate(StyleSheet styleSheet, QuestionForm form)
        {
            if (styleSheet == null) { throw new ArgumentNullException("styleSheet"); }
            if (form == null) { throw new ArgumentNullException("form"); }

            var validators = new List<ASTChecker> 
            {
                new QuestionReferencingChecker(form.GetAllQuestions()),
                new StyleAttributeChecker(),
                new WidgetTypeChecker(form.GetAllQuestions())
            };

            var report = new ValidationReport();

            foreach (var validator in validators)
            {
                validator.Validate(styleSheet, report);
            }

            return report;
        }

        public QuestionStyleCollection GetQuestionStyles(StyleSheet styleSheet, QuestionForm form)
        {
            if (styleSheet == null) { throw new ArgumentNullException("styleSheet"); }
            if (form == null) { throw new ArgumentNullException("form"); }

            var styleEvaluator = new QuestionStyleEvaluator();

            return styleEvaluator.GetQuestionStyles(styleSheet, form.GetAllQuestions());
        }
    }
}
