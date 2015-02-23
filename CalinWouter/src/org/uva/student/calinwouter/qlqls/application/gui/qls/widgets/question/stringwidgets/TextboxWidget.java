package org.uva.student.calinwouter.qlqls.application.gui.qls.widgets.question.stringwidgets;

import org.uva.student.calinwouter.qlqls.application.gui.qls.widgets.IWidget;
import org.uva.student.calinwouter.qlqls.qls.model.Question;

import javax.swing.*;
import java.awt.*;

public class TextboxWidget implements IWidget {
    private Component widget;

    // TODO add intbox specific implementation.
    public TextboxWidget(Question question) {
        this.widget = new JTextField();
    }

    @Override
    public Component getWidget() {
        return widget;
    }
}