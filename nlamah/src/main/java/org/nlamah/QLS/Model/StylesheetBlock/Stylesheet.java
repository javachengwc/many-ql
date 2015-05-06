package org.nlamah.QLS.Model.StylesheetBlock;

import java.util.List;

import org.nlamah.QLS.Interfaces.QLSNodeVisitor;
import org.nlamah.QLS.Model.Abstract.QLSNode;
import org.nlamah.QLS.Model.Abstract.StylesheetBlock;
import org.nlamah.QLS.Model.Value.IdentifierValue;

public class Stylesheet extends StylesheetBlock 
{
	private List<Page> pages;
	
	public Stylesheet(IdentifierValue identifier, List<Page> pages, List<DefaultBlock> defaultBlocks)
	{
		super(identifier, defaultBlocks);
		
		this.pages = pages;
		
		for (Page page : pages)
		{
			page.setParentNode(this);
		}
	}
	
	public List<Page> pages()
	{
		return pages;
	}
	
	
	@Override
	public QLSNode accept(QLSNodeVisitor visitor) 
	{
		return visitor.visit(this);
	}
	
	@Override 
	public boolean equals(Object object) 
	{
		if (!super.equals(object))
		{
			return false;
		}

		if (!(object instanceof Stylesheet))
		{
			return false;
		}
		
		Stylesheet value = (Stylesheet) object;
		
		if (!(pages.equals(value.pages)))
		{
			return false;
		}

		return true;
	}
}
