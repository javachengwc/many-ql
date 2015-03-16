package ql.errorhandling;

import ql.ast.Expression;
import ql.ast.QLNode;
import ql.ast.QLType;
import ql.ast.Statement;
import ql.ast.visitor.prettyprinter.PrettyPrinter;
import ql.ast.visitor.prettyprinter.printer.WriterCache;

public abstract class Error {
	private QLNode origin;
	private String errorMessage;
	
	public Error(QLNode origin, String errorMessage) {
		this.origin = origin;
		this.errorMessage = errorMessage;
	}
	
	public QLNode getOrigin() {
		return origin;
	}
	
	private String getErrorSourceString() {
		WriterCache writerCache = new WriterCache();
		
		if(origin instanceof Expression) {
			PrettyPrinter.print((Expression) origin, writerCache, "   -> ");
		} else if(origin instanceof Statement) {
			PrettyPrinter.print((Statement) origin, writerCache, "   -> ");
		} else {
			PrettyPrinter.print((QLType) origin, writerCache, "   -> ");
		}
		
		return writerCache.getCachedString();
	}
	
	@Override
	public String toString() {
		return "[" + this.getClass().getSimpleName() + "]: " + errorMessage + "\n"
				+ "-- Error Source Node -- \n" + getErrorSourceString();
	}
}
	