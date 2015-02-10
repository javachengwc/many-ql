package cons.ql.ast.expr.statement;

import cons.ql.ast.ASTNode;

public abstract class Statement implements ASTNode {
	
	/**
	 * Translates the value and the values of its children to a String.
	 * @return The resulting concatenation as a string
	 */
	public abstract String show();
	
	public String toString() {
		return show();
	}

}