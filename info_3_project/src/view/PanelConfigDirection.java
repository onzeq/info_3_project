package view;
//Importieren der benötigten Bibliotheken
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import model.*;

/**
 * Klasse die das Panel bei Klick auf ein Direction Objekt in der Tabelle aufruft
 * @author jakob
 *
 */
@SuppressWarnings("serial")
public class PanelConfigDirection extends PanelCommandConfig{
	private JTextField tDegree 		= new JTextField(10);
	private JButton bSave 			= new JButton("Save");
	private ControlUI controlUI;
	
	/**
	 * Konstruktor der Command und ControlUi zuweist und,die Ansicht und die Funktionalität ausführt
	 * @param cui
	 * @param d
	 */
	public PanelConfigDirection(ControlUI cui, Command d)
	{
		command = d;
		controlUI = cui;
		this.update(d);
		setView();
		setController();
		
	}
	
	/**
	 * Methode zum setzen der Komponenten im Panel
	 */
	private void setView()
	{
		//Layout anlegen und Farben der Überschrift anpassen
		this.setLayout(new BorderLayout());	
		JLabel lDirection = new JLabel("Direction");
		lDirection.setOpaque(true);
		lDirection.setBackground(Color.GRAY);
		lDirection.setForeground(Color.WHITE);
		this.add(lDirection, BorderLayout.NORTH);
		
		//erzeugen von neuem Panel, dem Label und wert von Degree hinzugefügt wird
		JPanel degreePanel = new JPanel();
		degreePanel.add(new JLabel("Degree:"));
		degreePanel.add(tDegree);
		this.add(degreePanel, BorderLayout.CENTER);
		this.add(bSave, BorderLayout.SOUTH);
	}
	
	/**
	 * Methode die Save Button Listener zuweißt 
	 */
	private void setController()
	{
		//SAve Button Listener zuweisen
		bSave.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent anEvent) 
			{
				//in den Command die Werte der TExtfelder schreiben und updaten
				((Direction) command).setDegree(Integer.parseInt(tDegree.getText()));
				//die table updaten und message verändern
				controlUI.getTable().updateTable(command);
				controlUI.messageUpdated("Saved successful!");
				controlUI.setDefaultConfig();
			}
				
				
		});
	}
	
	/**
	 * Methode die das Textfeld mit dem bisherigen Wert befüllt
	 */
	public void update(Command c) {
		//wenn commmand nicht null ist
		if(c != null) {
			tDegree.setText(Integer.toString((((Direction) c).getDegree()) ));
		}
		
		
	}

}
