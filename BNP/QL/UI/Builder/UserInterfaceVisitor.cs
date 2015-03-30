﻿using System;
using System.Collections.Generic;
using System.Windows;
using QL.AST;
using QL.AST.Nodes;
using QL.AST.Nodes.Branches;
using QL.AST.Nodes.Branches.Operators;
using QL.AST.Nodes.Terminals;
using QL.AST.Nodes.Terminals.Wrappers;
using QL.DataHandlers.Evaluation;
using QL.Exceptions;
using QL.UI.Controls;
using QL.UI.ControlWrappers;
using Expression = QL.AST.Nodes.Branches.Expression;

namespace QL.UI.Builder
{
    public class UserInterfaceVisitor : IVisitor
    {
        private readonly WidgetFactory _widgetFactory;
        private readonly IList<WidgetBase> _elementsToDisplay;
        private bool _parentExpressionDidNotEvaluate = false;
        public ReferenceTables ReferenceTables { get; private set; }
        public IList<QLBaseException> Exceptions { get; private set; }
        
        public UserInterfaceVisitor(ReferenceTables referenceTables, IList<QLBaseException> exceptions, IList<WidgetBase> elementsToDisplay)
        {
            _widgetFactory = new WidgetFactory();
            _elementsToDisplay = elementsToDisplay;
            ReferenceTables = referenceTables;
            Exceptions = exceptions;
        }

        #region Regular element visitors
        public void Visit(Form node)
        {
            node.Block.Accept(this);
        }

        public void Visit(Block node)
        {
            foreach (ElementBase child in node.Children)
            {
                child.Accept(this);
            }
        }
        
        public void Visit(ControlUnit node)
        {
            YesnoWrapper evaluatedResult = (YesnoWrapper)ReferenceTables.GetValueOrNull(node.Expression);
            //if (!evaluatedResult.ToBool()) return; // todo temp disable
            _parentExpressionDidNotEvaluate = !evaluatedResult.ToBool();

            if (node.ConditionTrueBlock != null)
            {
                node.ConditionTrueBlock.Accept(this);
            }

            _parentExpressionDidNotEvaluate = false;
            if (node.ConditionFalseBlock != null)
            {
                node.ConditionFalseBlock.Accept(this);
            }
        }
        
        public void Visit(StatementUnit node)
        {
            ITerminalWrapper evaluatedResult = ReferenceTables.GetValueOrNull(node.Expression);
            WidgetBase unitWrapper = _widgetFactory.GetWidget(node, evaluatedResult);

            unitWrapper.Visibility = _parentExpressionDidNotEvaluate ? Visibility.Hidden : Visibility.Visible; // todo set to collapsed to remove space
            
            _elementsToDisplay.Add(unitWrapper); // todo set identifier/do lookup
        }

        public void Visit(QuestionUnit node)
        {
            WidgetBase unitWrapper = _widgetFactory.GetWidget(node);

            unitWrapper.Visibility = _parentExpressionDidNotEvaluate ? Visibility.Hidden : Visibility.Visible;

            _elementsToDisplay.Add(unitWrapper); // todo idem ditto
        }
        #endregion

        #region Unused Visit method overloads that are irrelevant for the GUI
        public void Visit(Expression node)
        { }

        /// <summary>
        /// This method has a signature with the highest class in the hierarchy and will act as a fallback
        /// </summary>
        public void Visit(ElementBase elementBase)
        {
            throw new NotImplementedException("GUI Visitor did not expect an ElementBase fallback");
        }

        public void Visit(Yesno node)
        {
        }

        public void Visit(Number node)
        {
        }

        public void Visit(Text node)
        {
        }

        public void Visit(Identifier node)
        {
        }

        public void Visit(EqualsOperator node)
        {
        }

        public void Visit(NotEqualsOperator node)
        {
        }

        public void Visit(GreaterThanOperator node)
        {
        }

        public void Visit(GreaterThanEqualToOperator node)
        {
        }

        public void Visit(LessThanOperator node)
        {
        }

        public void Visit(LessThanEqualToOperator node)
        {
        }

        public void Visit(MultiplicationOperator node)
        {
        }

        public void Visit(DivisionOperator node)
        {
        }

        public void Visit(PlusOperator node)
        {
        }

        public void Visit(MinusOperator node)
        {
        }

        public void Visit(AndOperator node)
        {
        }

        public void Visit(OrOperator node)
        {
        }
        #endregion
    }

}
