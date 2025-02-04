package nl.uva.bromance.QL.ast.nodes;


import nl.uva.bromance.QL.ast.QLNode;
import nl.uva.bromance.QL.ast.QLNodeVisitorInterface;
import nl.uva.bromance.QL.expressions.unary.Primitive;
import nl.uva.bromance.QL.typechecking.SymbolTable;
import nl.uva.bromance.QL.typechecking.exceptions.DuplicateIdentifierException;
import nl.uva.bromance.QL.typechecking.exceptions.TypeCheckingError;

import java.util.List;

public class Question extends QLNode {

    private String identifier;
    private Primitive type;
    private String text;

    public Question(String identifier, int ln) {
        super(ln);
        this.identifier = identifier;
    }

    public String getIdentifier(){
        return identifier;
    }

    public void setType(Primitive type){
        this.type = type;
    }

    public void setText(String text){
        this.text = text;
    }

    public String getText(){
        return this.text;
    }

    public void accept(QLNodeVisitorInterface visitor) {
        visitor.visit(this);
        for (QLNode child : this.getChildren()) {
            child.accept(visitor);
        }
    }

    public Primitive typeCheck(SymbolTable s, List<TypeCheckingError> exceptions){
        return type;
    }

    //TODO: Don't know if this should also apply to questions of the same type.
    private void compareTypes(Primitive lookup, List<TypeCheckingError> exceptions){
        if(lookup != this.type)
        {
            exceptions.add(new DuplicateIdentifierException("You have a duplicate question definition with a different type on line: " + this.getLineNumber()));
        }
    }

    public void addToSymbolTable(SymbolTable s, List<TypeCheckingError> exceptions) {
        Primitive lookup = s.lookup(identifier);
        if(lookup == null){
            s.add(identifier, type, this);
        }
        else{
            compareTypes(lookup, exceptions);
        }
    }
}
