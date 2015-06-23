﻿using AST.Nodes;
using Evaluation;
using Evaluation.Values;
using QLGui.ASTVisitors;
using QLGui.FormObjects;
using System.Collections.Generic;
using System.Windows;
using System.Windows.Controls;
using ASTFormObject = AST.Nodes.FormObjects;

namespace QLGui.Controllers
{
    public class SubController
    {
        public SymbolTable SymbolTable { get; private set; }
        private EventUpdateValue EventUpdateValue;

        public SubController(SymbolTable symbolTable, EventUpdateValue UpdateCallbackFunction)
        {
            this.SymbolTable = symbolTable;
            this.EventUpdateValue = UpdateCallbackFunction;
        }

        public StackPanel CreateUIBody(IFormObjectContainer rootNode, StackPanel parent)
        {

            foreach (ASTFormObject.FormObject node in rootNode.GetBody())
            {
                FormObject formObject = node.Accept(new FormObjectVisitor());
                formObject.EventUpdateValue += EventUpdateValue;

                SymbolTable = formObject.RegisterInSymbolTable(SymbolTable);

                parent = formObject.InsertInUIParent(parent);
            }

            return parent;
        }
    }
}
