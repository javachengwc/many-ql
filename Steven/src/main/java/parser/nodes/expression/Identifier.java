package parser.nodes.expression;

import parser.Visitor;
import parser.nodes.AbstractNode;

/**
 * Created by Steven Kok on 21/02/2015.
 */
public class Identifier extends Expression {
    private final String identifier;

    public Identifier(String identifier) {
        this.identifier = identifier;
    }

    public String getIdentifier() {
        return identifier;
    }

    @Override
    public AbstractNode accept(Visitor visitor) {
        return visitor.visit(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Identifier that = (Identifier) o;

        if (!identifier.equals(that.identifier)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return identifier.hashCode();
    }

    @Override
    public String toString() {
        return identifier;
    }

    @Override
    public boolean isConditional() {
        return true;
    }
}