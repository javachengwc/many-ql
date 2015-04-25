package org.nlamah.QL.Model.Error.Parsing;

import org.nlamah.QL.Model.Error.Abstract.ParsingError;

public class ContextSensitivityError extends ParsingError 
{
	private int startIndex;
	private int stopIndex;

	public ContextSensitivityError(int startIndex, int stopIndex) 
	{
		super();
		
		this.startIndex = startIndex;
		this.stopIndex = stopIndex;
	}

	@Override
	public String description() 
	{
		return "ContextSensitivityError: StartIndex:" + startIndex + ", StopIndex:" + stopIndex;
	}	
}