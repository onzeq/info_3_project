package view;

import javax.swing.JPanel;

import model.Command;

public abstract class PanelCommandConfig extends JPanel {
	protected Command command;
	
	public abstract void update(Command c);
}
