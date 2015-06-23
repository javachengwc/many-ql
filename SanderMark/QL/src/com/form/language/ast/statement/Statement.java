package com.form.language.ast.statement;

import javax.swing.JPanel;

import com.form.language.ast.ASTNode;
import com.form.language.gui.components.FormComponent;
import com.form.language.issue.QLToken;
import com.form.language.memory.Context;

public abstract class Statement extends ASTNode {
    public abstract void createGUIComponent(FormComponent formComponent, JPanel panel, Context context);
    public abstract void initMemory(Context context);
    public abstract boolean checkType(Context context);

    protected Statement(QLToken tokenInfo) {
	super(tokenInfo);
    }
}
