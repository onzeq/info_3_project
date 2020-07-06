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
	//Command nur in Sub Klase bekannt
	protected Command command;
	
	//abstrakte Methode mit jeweeils unterschiedlicher Implementierung in den Unter Klassen
	public abstract void update(Command c);
}
