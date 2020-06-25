package view;

import javax.swing.JPanel;

import model.Command;

/**
 * 
 * abstract class to four subclasses with slightly different characteristics
 *
 */
@SuppressWarnings("serial")
public abstract class PanelCommandConfig extends JPanel {
	protected Command command;
	
	public abstract void update(Command c);
}
