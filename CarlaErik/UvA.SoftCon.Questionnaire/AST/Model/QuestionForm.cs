﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.AST.Model;
using UvA.SoftCon.Questionnaire.AST.Model.Statements;

namespace UvA.SoftCon.Questionnaire.AST.Model
{
    /// <summary>
    /// Represents the root of a questionnaire AST.
    /// </summary>
    public sealed class QuestionForm : Node
    {
        public ICollection<IStatement> Statements
        {
            get;
            private set;
        }

        public QuestionForm(ICollection<IStatement> statements, TextPosition position)
            : base(position)
        {
            Statements = statements;
        }

        public override void Accept(IASTVisitor visitor)
        {
            visitor.Visit(this);
        }

        public override T Accept<T>(IASTVisitor<T> visitor)
        {
            return visitor.Visit(this);
        }

        public ICollection<Question> GetAllQuestions()
        {
            var questions = new List<Question>();

            foreach (var statement in Statements)
            {
                statement.AppendQuestions(questions);
            }
            return questions;
        }
    }
}
