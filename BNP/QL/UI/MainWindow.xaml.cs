﻿using System;
using System.Diagnostics;
using System.IO;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Input;
using Microsoft.Win32;
using QL.Exceptions;
using QL.UI.Builder;

namespace QL.UI
{
    public partial class MainWindow : Window
    {
        private QLUIBuilder _qlBuilder;

        public MainWindow()
        {
            ApplicationCommands.Close.InputGestures.Add(new KeyGesture(Key.W, ModifierKeys.Control));
            InitializeComponent();
        }

        private void BuildQuestionnaire(string inputData)
        {
            _qlBuilder = new QLUIBuilder(inputData);
            ExceptionTable.ItemsSource = _qlBuilder.QLExceptions;
            _qlBuilder.RegisterGenericAndUIDataHandlers(RebuildQuestionnaire);

            bool buildResult = _qlBuilder.RunAllHandlers();
            Debug.WriteLineIf(!buildResult, "Cannot proceed to build the UI as the handlers have failed");
            
            WidgetsContainer.ItemsSource = _qlBuilder.ElementsToDisplay;
        }

        private void RebuildQuestionnaire()
        {
            _qlBuilder.RunEvaluators();
            _qlBuilder.RunRenderers();
        }

        private void LoadQuestionnaireFile(string inputFilePath)
        {
            if (string.IsNullOrEmpty(inputFilePath) || !File.Exists(inputFilePath))
            {
                InputFileSourceText.Text = "File not loaded";
                return;
            }

            try
            {
                using (FileStream fileStream = File.Open(inputFilePath, FileMode.Open))
                {
                    StreamReader sr = new StreamReader(fileStream);
                    string inputQuestionnaire = sr.ReadToEnd();
                    InputFileSourceText.Text = inputQuestionnaire;
                    BuildQuestionnaire(inputQuestionnaire);
                }
            }
            catch (Exception ex)
            {
                InputFileSourceText.Text = string.Format("An error has occurred whilst reading the input file{0}{1}", Environment.NewLine, ex.Message);
            }
        }

        private void SaveQuestionnaireFile(string outputFilePath)
        {
            try
            {
                File.WriteAllText(outputFilePath, _qlBuilder.DataContext.ExportableRepresentation);
            }
            catch (Exception ex)
            {
                MessageBox.Show("Failed to save file: " + ex.Message, "Save QL questionnaire", MessageBoxButton.OK, MessageBoxImage.Error);
            }
        }

        private void PopulateExampleFileMenu()
        {
            string path = Path.Combine(Environment.CurrentDirectory, "examples");
            if (!Directory.Exists(path)) return;

            string[] files = Directory.GetFiles(path, "*.ql", SearchOption.AllDirectories);

            foreach (string file in files)
            {
                MenuItem menuItem = new MenuItem();
                menuItem.Header = Path.GetFileNameWithoutExtension(file);
                menuItem.Tag = file;
                menuItem.Click += MenuItemOpenExample_Click;

                MenuItemExamples.Items.Add(menuItem);
            }

            if (files.Length <= 0)
            {
                MenuItemExamples.Visibility = Visibility.Hidden;
            }
        }

        #region Menu event handlers
        private void Command_Open(object sender, ExecutedRoutedEventArgs e)
        {
            OpenFileDialog inputFilePicker = new OpenFileDialog
                                             {
                                                 Multiselect = false,
                                                 AddExtension = true,
                                                 CheckFileExists = true,
                                                 Filter = "QL Files|*.ql|All files|*.*",
                                                 InitialDirectory = Environment.CurrentDirectory
                                             };

            if (inputFilePicker.ShowDialog().GetValueOrDefault())
            {
                LoadQuestionnaireFile(inputFilePicker.FileName);
            }
        }

        private void MenuItemOpenExample_Click(object sender, RoutedEventArgs e)
        {
            MenuItem menuItem = sender as MenuItem;
            if (menuItem == null) return;
            LoadQuestionnaireFile(menuItem.Tag.ToString());
        }

        private void Command_SaveAs(object sender, ExecutedRoutedEventArgs e)
        {
            if (_qlBuilder == null || !_qlBuilder.BuilderStateMachine.IsRendered)
            {
                MessageBox.Show("There is nothing to export", "Save", MessageBoxButton.OK, MessageBoxImage.Information);
                return;
            }

            _qlBuilder.RunExporter();
            SaveFileDialog outputFilePicker = new SaveFileDialog
                                              {
                                                  Filter = "QL Questionnaires (json/xml)|*.json;*.xml|All files|*.*",
                                                  InitialDirectory = Environment.CurrentDirectory
                                              };

            if (outputFilePicker.ShowDialog().GetValueOrDefault())
            {
                SaveQuestionnaireFile(outputFilePicker.FileName);
            }
        }

        private void Command_Close(object sender, ExecutedRoutedEventArgs e)
        {
            Environment.Exit(0);
        }
        #endregion

        #region General event handlers
        private void MainWindow_OnLoaded(object sender, RoutedEventArgs e)
        {
            PopulateExampleFileMenu();
        }

        private void ButtonBuild_Click(object sender, RoutedEventArgs e)
        {
            BuildQuestionnaire(InputFileSourceText.Text);
        }

        private void ExceptionTableItem_MouseClick(object sender, MouseButtonEventArgs e)
        {
            ListViewItem item = sender as ListViewItem;
            if (item == null || !item.IsSelected) return;

            QLBaseException error = item.Content as QLBaseException;
            if (error == null) return;

            InputFileSourceText.TextArea.Caret.Line = error.SourceLocation.Line;
            InputFileSourceText.TextArea.Caret.Column = error.SourceLocation.Column.GetValueOrDefault(0);
            InputFileSourceText.ScrollTo(error.SourceLocation.Line, error.SourceLocation.Column.GetValueOrDefault(0));
            InputFileSourceText.Focus();
        }
        #endregion

        #region Dependency properties
        public static readonly DependencyProperty ShowIdentifiersProperty = DependencyProperty.Register("ShowIdentifiers", typeof(bool), typeof(MainWindow), new PropertyMetadata(true));

        public bool ShowIdentifiers
        {
            get { return (bool)GetValue(ShowIdentifiersProperty); }
            set { SetValue(ShowIdentifiersProperty, value); }
        }
        #endregion
    }
}
