package org.uva.student.calinwouter.qlqls.qls.abstractions;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.uva.student.calinwouter.qlqls.qls.exceptions.FieldNotFoundException;
import org.uva.student.calinwouter.qlqls.qls.model.IRenderable;

import java.util.HashMap;
import java.util.Map;

/**
 * Form fields are either questions or computed values, always consisting of an identifier and a set of
 * styling arguments.
 */
@Data
@AllArgsConstructor
public abstract class AbstractFormField {
    protected final String ident;
    protected final Map<String, Object> stylingArguments;

    /**
     * Call the applicable renderer on the provided renderer.
     */
    public abstract <T> T applyRenderer(IRenderable<T> iRenderable) throws FieldNotFoundException;

    public AbstractFormField(String ident) {
        this(ident, new HashMap<String, Object>());
    }
}