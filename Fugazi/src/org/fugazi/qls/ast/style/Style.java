package org.fugazi.qls.ast.style;

import org.fugazi.ql.ast.AbstractASTNode;
import org.fugazi.qls.ast.style.style_property.StyleProperty;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Style extends AbstractASTNode {

    private final List<StyleProperty> styleProperties;

    public Style() {
        styleProperties = new ArrayList<>();
    }

    public Style(List<StyleProperty> _styleProperties) {
        this.styleProperties = _styleProperties;
    }

    public List<StyleProperty> getStyleProperties() {
        return this.styleProperties;
    }

    public int getWidth(int _default) {
        for (StyleProperty styleProperty : this.styleProperties) {
            if (styleProperty.getName().equals(org.fugazi.qls.ast.style.style_property.Width.PROPERTY_NAME)) {
                return (int) styleProperty.getValue();
            }
        }
        return _default;
    }

    public String getFont(String _default) {
        for (StyleProperty styleProperty : this.styleProperties) {
            if (styleProperty.getName().equals(org.fugazi.qls.ast.style.style_property.Font.PROPERTY_NAME)) {
                return (String) styleProperty.getValue();
            }
        }
        return _default;
    }

    public int getFontSize(int _default) {
        for (StyleProperty styleProperty : this.styleProperties) {
            if (styleProperty.getName().equals(org.fugazi.qls.ast.style.style_property.FontSize.PROPERTY_NAME)) {
                return (int) styleProperty.getValue();
            }
        }
        return _default;
    }

    public Color getColor(int _default) {
        for (StyleProperty styleProperty : this.styleProperties) {
            if (styleProperty.getName().equals(org.fugazi.qls.ast.style.style_property.Color.PROPERTY_NAME)) {
                return new Color((int) styleProperty.getValue());
            }
        }
        return new Color(_default);
    }

    public boolean isUndefined() {
        return false;
    }

    /**
     * Inherits StyleProperties from a base style.
     * @param _baseStyle The base style to be inherited.
     */
    public void inheriteFromStyle(Style _baseStyle) {
        // get base style props.
        for (StyleProperty baseStyleProperty : _baseStyle.styleProperties) {

            // if current style does not contain the base style property,
            // then add it to current style.
            // if exists keep the current property.
            if (!this.styleProperties.contains(baseStyleProperty)) {
                this.styleProperties.add(baseStyleProperty);
            }
        }
    }
}
