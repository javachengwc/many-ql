﻿using AST;
using AST.Nodes.FormObjects;
using AST.VisitorInterfaces;
using Notifications;
using System.Collections.Generic;
using System.Linq;
using TypeChecking.Notifications.Warnings;

namespace TypeChecking.Checkers
{
    public class LabelChecker : IFormObjectVisitor<IEnumerable<Label>>
    {
        public INotificationManager AnalyzeAndReport(IList<FormObject> body)
        {
            List<Label> labels = new List<Label>();

            foreach (FormObject formObject in body)
            {
                labels.AddRange(formObject.Accept(this));
            }
         
            return GetDuplicateLabelWarnings(labels);
        }

        private INotificationManager GetDuplicateLabelWarnings(List<Label> labels)
        {
            NotificationManager notificationManager = new NotificationManager();
            Dictionary<string, List<Label>> labelsByName = GetLabelsByName(labels);

            foreach(string name in labelsByName.Keys.Where(k => labelsByName[k].Count > 1))
            {
                notificationManager.AddNotification(new DuplicateLabel(name, labelsByName[name].Select(l => l.position)));
            }

            return notificationManager;
        }

        private Dictionary<string, List<Label>> GetLabelsByName(IEnumerable<Label> labels)
        {
            var labelsByName = new Dictionary<string, List<Label>>();

            foreach (Label label in labels)
            {
                if(!labelsByName.ContainsKey(label.ToString()))
                {
                    labelsByName[label.ToString()] = new List<Label>();
                } 
                labelsByName[label.ToString()].Add(label);
            }
            return labelsByName;

        }

        public IEnumerable<Label> Visit(Conditional conditional)
        {
            return conditional.GetBody().SelectMany(x => x.Accept(this));
        }

        public IEnumerable<Label> Visit(Question question)
        {
            return new List<Label> { question.Label };
        }
    }
}
