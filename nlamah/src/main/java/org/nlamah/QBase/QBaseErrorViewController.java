package org.nlamah.QBase;

import java.util.ArrayList;

import javax.swing.JFrame;

import org.nlamah.QBase.QBaseError;
import org.nlamah.QL.Helper.QLHelper;

public class QBaseErrorViewController implements Runnable
{
	private final static int FRAME_WIDTH = 900;
	private final static int FRAME_HEIGHT = 600;

	private ArrayList<QBaseWarning> warnings;
	private ArrayList<? extends QBaseError> errors;

	private JFrame frame;
	private QBaseErrorView errorView;

	public QBaseErrorViewController(ArrayList<? extends QBaseError> errors, ArrayList<QBaseWarning> warnings)
	{
		super();

		this.errors = errors;
		this.warnings = warnings;

		loadFrame();
	}

	@Override
	public void run() 
	{
		showErrors();
	}
	
	private void showErrors()
	{
		errorView.fillInErrorString(produceErrorString());
		errorView.fillInWarningString(produceWarningString());

		frame.setVisible(true);
	}

	private void loadFrame()
	{
		frame = new JFrame();

		frame.setTitle("Errors");
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		errorView = new QBaseErrorView();

		frame.setContentPane(errorView);
	}

	private String produceErrorString()
	{
		String errorString = "";
		if (QLHelper.arrayExistsAndHasElements(errors))
		{
			for (QBaseError error : errors)
			{
				errorString += "<p>" + error.description() + "</p>";
			}
		}

		return "<html>" + errorString + "</html>";

	}

	private String produceWarningString()
	{	
		String warningString = "";

		if (QLHelper.arrayExistsAndHasElements(warnings))
		{
			for (QBaseWarning warning : warnings)
			{
				warningString += "<p>" + warning.description() + "</p>";
			}
		}

		return "<html>" + warningString + "</html>";
	}

	
}