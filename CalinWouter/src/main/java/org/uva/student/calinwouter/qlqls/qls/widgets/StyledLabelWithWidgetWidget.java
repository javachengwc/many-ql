package org.uva.student.calinwouter.qlqls.qls.widgets;

import org.uva.student.calinwouter.qlqls.ql.model.StateWrapper;
import org.uva.student.calinwouter.qlqls.ql.gui.widgets.IWidget;
import org.uva.student.calinwouter.qlqls.ql.gui.widgets.LabelWithWidgetWidget;
import org.uva.student.calinwouter.qlqls.qls.model.StylingSettings;

import java.awt.*;

public class StyledLabelWithWidgetWidget extends LabelWithWidgetWidget implements IWidget {

    private final StylingSettings stylingSettings;

    private int getWidgetHeight() {
        Component widgetComponent = getWidgetComponent();
        return widgetComponent.getHeight();
    }

    @Override
    protected void setLabelStylingSettings(Label fieldLabel) {
        fieldLabel.setFont(stylingSettings.createFont());
        fieldLabel.setForeground(stylingSettings.createForegroundColor());
        final Component widgetComponent = getWidgetComponent();
        Integer widgetHeight = getWidgetHeight();
        Dimension newDimension = stylingSettings.createSizeDimension(widgetHeight);
        widgetComponent.setSize(newDimension);
    }

    @Override
    protected void initializeWidget() {
        // Initializing through the super call would ignore the stylingSettings.
        // Thus we initialize stylingSettings before calling initializeWidgets.
    }

    public StyledLabelWithWidgetWidget(String label, String identifier, IWidget widget, StateWrapper stateWrapper, StylingSettings stylingSettings) {
        super(label, identifier, widget, stateWrapper);
        this.stylingSettings = stylingSettings;
        super.initializeWidget();
    }
}
