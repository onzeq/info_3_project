package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Command;

import model.Pause;
/**
 * Klasse welches das Panel für die Auswahl der Liste mit Pause darstellt, mit Funktionalitäten
 * @author Christian
 *
 */
@SuppressWarnings("serial")
public class PanelConfigPause extends PanelCommandConfig {
	//Klassenvariablen
	private JTextField tDuration = 	new JTextField(10);
	private JButton bSave = 		new JButton("Save");
	private ControlUI controlUI;
	
	/**
	 * Konstruktor
	 * weißt panel ControlUi und ausgewählten Command zu und setzt View und Controller 
	 * @param cui
	 * @param p
	 */
	public PanelConfigPause(ControlUI cui, Command p)
	{
		command = p;
		controlUI = cui;
		this.update(p);
		setView();
		setController();
		
	}
	
	/**
	 * Methode zum setzen der Komponenten des Panels
	 */
	private void setView()
	{
		//Layout angelegt und Farben angepasst
		this.setLayout(new BorderLayout());
		JLabel lPause = new JLabel("Pause");
		lPause.setOpaque(true);
		lPause.setBackground(Color.GRAY);
		lPause.setForeground(Color.WHITE);
		this.add(lPause, BorderLayout.NORTH);
		//Panel für anordnung von Textfeld und Label in CENTER
		JPanel durationlabel = new JPanel();
		durationlabel.add(new JLabel("Duration:"));
		durationlabel.add(tDuration);
		
		this.add(durationlabel, BorderLayout.CENTER);
		this.add(bSave, BorderLayout.SOUTH);
	}
	
	/**
	 * Methode zum setzten des Controller vom Save Button
	 */
	private void setController()
	{
		//Actionlistener dem Button zuweisen
		bSave.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent anEvent) 
			{
				//Command auf Pause caten und dann die Duration aus dem Textfeld dem Command zuweisen
				((Pause) command).setDuration(Integer.parseInt(tDuration.getText()));
				//Aktualiseren und message updaten
				controlUI.getTable().updateTable(command);
				controlUI.messageUpdated("Saved successful!");
			}
		});
	}
	
	 /**
	  * Methode die bei aufruf Textfield mit Wert des Command befüllt
	  */
	public void update(Command c) {
		//wenn command nicht null dann setzte den Text zu seinem bisherigen Wert
		if(c != null) {
			tDuration.setText(Integer.toString((((Pause) c).getDuration()) ));
		}	
	}

}
