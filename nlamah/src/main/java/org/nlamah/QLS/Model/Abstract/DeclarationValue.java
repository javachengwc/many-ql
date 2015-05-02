package org.nlamah.QLS.Model.Abstract;

public abstract class DeclarationValue extends QLSNode 
{
	@Override 
	 public boolean equals(Object object) 
	 {
		 if (this == object)
		 {
			 return true;
		 }
		 
		 if (!(object instanceof DeclarationValue))
		 {
			 return false;
		 }

		 return true;
	 }
}
