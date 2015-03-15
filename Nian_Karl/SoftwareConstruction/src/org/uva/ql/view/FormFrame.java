package org.uva.ql.view;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;

public class FormFrame extends JFrame {

	private final String identifier;
	private static final long serialVersionUID = 1L;
	private int gridCounterY = 0;
	public FormFrame(String identifier) {
		super("QL Form");
		this.identifier = identifier;
		setSize(600, 800);
		setLayout(new GridBagLayout());
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public String getIdentifier() {
		return identifier;
	}
	
	public void addWithConstraints(Component component) {
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.gridx = 1;
		constraints.gridy = gridCounterY;
		add(component,constraints);
		gridCounterY++;
	}
	
}