package org.fugazi.qls.ast.segment;

import org.fugazi.qls.ast.AbstractASTQLSNode;
import org.fugazi.qls.ast.IQLSASTVisitor;
import org.fugazi.qls.ast.style.DefaultStyleDeclaration;

import java.util.List;

public abstract class Segment extends AbstractASTQLSNode {
    protected final String name;
    protected final List<Section> sections;
    protected final List<DefaultStyleDeclaration> defaultStyles;

    public Segment(int _lineNum, List<Section> _sections, List<DefaultStyleDeclaration> _defaultStyles, String _name) {
        super(_lineNum);
        this.sections = _sections;
        this.defaultStyles = _defaultStyles;
        this.name = _name;
    }
    public Segment(List<Section> _sections, List<DefaultStyleDeclaration> _defaultStyles, String _name) {
        this.sections = _sections;
        this.defaultStyles = _defaultStyles;
        this.name = _name;
    }

    public String getName() {
        return this.name;
    }

    public abstract <T> T accept(IQLSASTVisitor<T> visitor);
}
