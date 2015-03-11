package nl.uva.softwcons.ql.ui.widget;

import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.Node;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import nl.uva.softwcons.ql.eval.value.Value;

public class RadioButtonWidget extends Widget {

    private RadioButton yesButton;
    private RadioButton noButton;

    private HBox hbox;
    private ToggleGroup group;
    private Property<Value> valueProperty;

    public RadioButtonWidget(String yesString, String noString) {
        this.valueProperty = new SimpleObjectProperty<Value>();

        yesButton = new RadioButton(yesString);
        noButton = new RadioButton(noString);

        noButton.setSelected(true);

        hbox = new HBox();
        hbox.getChildren().add(yesButton);
        hbox.getChildren().add(noButton);

        group = new ToggleGroup();

        yesButton.setToggleGroup(group);
        noButton.setToggleGroup(group);
    }

    @Override
    public Node getWidget() {
        return hbox;
    }

    @Override
    public void setValue(Value value) {
        if (value.asBoolean()) {
            group.selectToggle(yesButton);
            return;
        }
        group.selectToggle(noButton);
    }

    @Override
    public void setVisible(boolean visible) {
        this.hbox.setVisible(visible);
    }

    @Override
    public Property<Value> getValueProperty() {
        return valueProperty;
    }

}