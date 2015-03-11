package org.uva.student.calinwouter.qlqls.application.gui.widgets.computedvalue;

import org.uva.student.calinwouter.qlqls.application.gui.widgets.IWidget;
import org.uva.student.calinwouter.qlqls.ql.interpreter.impl.headless.ChangedStateEventListener;
import org.uva.student.calinwouter.qlqls.ql.interpreter.impl.headless.HeadlessFormInterpreter;
import org.uva.student.calinwouter.qlqls.qls.model.components.ComputedValue;

import javax.swing.*;
import java.awt.*;

/**
 * This widget is used for displaying the value of a computed value field.
 */
public class LabelWidget implements IWidget {
    private JLabel valueLabel;


    public LabelWidget(final ComputedValue computedValue, final HeadlessFormInterpreter headlessFormInterpreter) {
        valueLabel = new JLabel();
        headlessFormInterpreter.subscribeChangedStateEventListener(new ChangedStateEventListener() {
            @Override
            public void onStateChanged() {
                try {
                    valueLabel.setText(headlessFormInterpreter
                            .getField(computedValue.getIdent()).getValue().toString());
                } catch (NullPointerException e) {
                    valueLabel.setText("-");
                }
            }
        });
    }

    @Override
    public Component getWidgetComponent() {
        return valueLabel;
    }
}