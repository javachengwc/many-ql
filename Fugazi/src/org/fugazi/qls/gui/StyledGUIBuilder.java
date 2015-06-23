package org.fugazi.qls.gui;

import org.fugazi.ql.ast.form.Form;
import org.fugazi.ql.ast.statement.IfStatement;
import org.fugazi.ql.gui.GUIBuilder;
import org.fugazi.ql.gui.ui_element.ui_questions.UIQuestion;
import org.fugazi.qls.ast.question.QLSQuestion;
import org.fugazi.qls.ast.segment.Page;
import org.fugazi.qls.ast.segment.Section;
import org.fugazi.qls.ast.stylesheet.stylesheet_data.QLSStyleSheetDataStorage;
import org.fugazi.qls.gui.ui_segment.UIPage;
import org.fugazi.qls.gui.ui_segment.UISection;
import org.fugazi.qls.gui.widget.QLSWidgetsFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StyledGUIBuilder extends GUIBuilder {

    private final Map<UISection, List<UIQuestion>> visibleQuestionsPerSection;
    private final Map<UIQuestion, UISection> parentSections;

    private final Map<UIPage, List<UISection>> visibleSectionsPerPage;
    private final Map<UISection, UIPage> parentPages;

    public StyledGUIBuilder(
            Form _form,
            QLSStyleSheetDataStorage _qlsData)
    {
        super(_form, new QLSWidgetsFactory(_qlsData), new QLSUIFormManager(_form.getName()));
        
        this.visibleQuestionsPerSection = new HashMap<>();
        this.parentSections = new HashMap<>();
        this.visibleSectionsPerPage = new HashMap<>();
        this.parentPages = new HashMap<>();
        
        this.prepareForm(_qlsData);
    }

    /**
     * =====================
     * Form updates
     * =====================
     */

    @Override
    protected void updateForm(Map<UIQuestion, List<IfStatement>> _questionsWithConditionState) {
        if (_questionsWithConditionState == null)
            return;

        QLSUIFormManager formManager = (QLSUIFormManager) this.uiFormManager;
        
        for (UIQuestion uiQuestion : _questionsWithConditionState.keySet()) {
            if (this.isQuestionStateTrue(_questionsWithConditionState, uiQuestion)) {
                this.setQuestionVisible(uiQuestion, formManager);
            } else {
                this.unsetQuestionVisible(uiQuestion, formManager);
            }
        }
    }

    /**
     * =====================
     * Element visbility methods
     * =====================
     */

    private void setQuestionVisible(UIQuestion _uiQuestion, QLSUIFormManager _formManager) {
        UISection uiSection = this.parentSections.get(_uiQuestion);
        UIPage uiPage = this.parentPages.get(uiSection);

        this.addVisibleSectionToPage(uiSection, uiPage, _formManager);
        this.addVisibleQuestionToSection(_uiQuestion, uiSection, _formManager);

        _formManager.addQuestion(_uiQuestion);
    }

    private void unsetQuestionVisible(UIQuestion _uiQuestion, QLSUIFormManager _formManager) {
        UISection parentSection = this.parentSections.get(_uiQuestion);
        this.removeVisibleQuestionFromSection(_uiQuestion, parentSection, _formManager);

        List<UIQuestion> visibleQuestions = this.visibleQuestionsPerSection.get(parentSection);
        if (visibleQuestions != null && visibleQuestions.isEmpty()) {
            UIPage parentPage = this.parentPages.get(parentSection);
            this.removeVisibleSectionFromPage(parentSection, parentPage, _formManager);

            List<UISection> visibleSections = this.visibleSectionsPerPage.get(parentPage);
            if (visibleSections != null && visibleSections.isEmpty()) {
                this.removeVisiblePage(parentPage, _formManager);
            }
        }
    }

    private void addVisibleQuestionToSection(
            UIQuestion _uiQuestion, UISection _section, QLSUIFormManager _formManager) {
        List<UIQuestion> visibleQuestions = this.visibleQuestionsPerSection.get(_section);
        if (visibleQuestions == null) {
            visibleQuestions = new ArrayList<>();
        }
        if (!visibleQuestions.contains(_uiQuestion)) {
            visibleQuestions.add(_uiQuestion);
            this.visibleQuestionsPerSection.put(_section, visibleQuestions);
        }
        _formManager.addSection(_section);
    }

    private void removeVisibleQuestionFromSection(
            UIQuestion _uiQuestion, UISection _section, QLSUIFormManager _formManager) {
        List<UIQuestion> visibleQuestions = this.visibleQuestionsPerSection.get(_section);
        if (visibleQuestions != null && visibleQuestions.contains(_uiQuestion)) {
            visibleQuestions.remove(_uiQuestion);
            this.visibleQuestionsPerSection.put(_section, visibleQuestions);
        }
        _formManager.removeQuestion(_uiQuestion);
    }

    private void addVisibleSectionToPage(
            UISection _section, UIPage _uiPage, QLSUIFormManager _formManager) {
        List<UISection> visibleSections = this.visibleSectionsPerPage.get(_uiPage);
        if (visibleSections == null) {
            visibleSections = new ArrayList<>();
        }
        if (!visibleSections.contains(_section)) {
            visibleSections.add(_section);
            this.visibleSectionsPerPage.put(_uiPage, visibleSections);
        }

        _formManager.addPage(_uiPage);
    }

    private void removeVisibleSectionFromPage(
            UISection _section, UIPage _uiPage, QLSUIFormManager _formManager) {
        List<UISection> visibleSections = this.visibleSectionsPerPage.get(_uiPage);
        if (visibleSections != null && visibleSections.contains(_section)) {
            visibleSections.remove(_section);
            this.visibleSectionsPerPage.put(_uiPage, visibleSections);
        }
        _formManager.removeSection(_section);
    }

    private void removeVisiblePage(UIPage _page, QLSUIFormManager _formManager){
        _formManager.removePage(_page);
    }

    /**
     * =====================
     * Initial form preparation
     * =====================
     */

    private void prepareForm(QLSStyleSheetDataStorage _qlsData) {
        int pageIndex = 0;
        for (Page page : _qlsData.getPages()) {
            List<Section> sections = page.getSections();

            UIPage uiPage = new UIPage(page.getName(), pageIndex, sections.size());
            pageIndex++;

            int sectionIndex = 0;
            for (Section section : sections) {
                List<QLSQuestion> questions = section.getQuestions();

                UISection uiSection = this.prepareSection(uiPage, section.getName(), sectionIndex);
                sectionIndex++;

                for (QLSQuestion question : questions) {
                    this.prepareQuestion(question, uiSection);
                }
            }
        }
    }

    private void prepareQuestion(QLSQuestion _question, UISection _section) {
        UIQuestion uiQuestion = this.getUIQuestionById(
                _question.getIdName(), this.questionsWithConditions
        );
        this.parentSections.put(uiQuestion, _section);
    }

    private UISection prepareSection(UIPage _page, String _name, int _index) {
        UISection uiSection = new UISection(_page, _name, _index);
        this.parentPages.put(uiSection, _page);

        return uiSection;
    }
}