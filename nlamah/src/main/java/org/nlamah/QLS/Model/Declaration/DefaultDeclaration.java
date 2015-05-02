package org.nlamah.QLS.Model.Declaration;

import java.util.List;

import org.nlamah.QBase.QBaseQuestionType;
import org.nlamah.QLS.Interfaces.QLSNodeVisitor;
import org.nlamah.QLS.Model.Abstract.QLSNode;
import org.nlamah.QLS.Model.Abstract.StyleDeclaration;

public class DefaultDeclaration extends QLSNode
{
	private QBaseQuestionType questionType;
	private List<StyleDeclaration> styleDeclarations;
	
	public DefaultDeclaration(QBaseQuestionType questionType, List<StyleDeclaration> styleDeclarations)
	{
		super();
		
		this.questionType = questionType;
		this.styleDeclarations = styleDeclarations;
	}

	@Override
	public QLSNode accept(QLSNodeVisitor visitor) 
	{
		return visitor.visit(this);
	}
	
	@Override
	public String toString()
	{
		//TODO
		return questionType.toString();
	}
	
	@Override 
	public boolean equals(Object object) 
	{
		if (!(object instanceof DefaultDeclaration))
		{
			return false;
		}
		
		DefaultDeclaration value = (DefaultDeclaration) object;
		
		if (this.questionType != value.questionType)
		{
			return false;
		}
		
		if (!this.styleDeclarations.equals(value.styleDeclarations))
		{
			return false;
		}

		return true;
	}
}
