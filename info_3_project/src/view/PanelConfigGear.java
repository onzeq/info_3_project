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
import model.Gear;
/**
 * Klasse die das Panel bei klick auf einen Gear Command darstellt
 * @author Christian
 *
 */
@SuppressWarnings("serial")
public class PanelConfigGear extends PanelCommandConfig{
	//Klassenvariablen/Komponenten für das Panel deklarieren
	private JTextField tSpeed = 	new JTextField(10);
	private JTextField tDuration = 	new JTextField(10);;
	private JButton bSave = 		new JButton("Save");
	private ControlUI controlUI;
	
	/**
	 * Konstuktor der Command und ControlUi zuweist
	 * anschließend setview und setcontrller aufruft
	 * @param cui
	 * @param g
	 */
	public PanelConfigGear(ControlUI cui,Command g)
	{
		command = g;
		controlUI = cui;
		this.update(g);
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
		JLabel lGear = new JLabel("Gear");
		lGear.setOpaque(true);
		lGear.setBackground(Color.GRAY);
		lGear.setForeground(Color.WHITE);
		this.add(lGear, BorderLayout.NORTH);
		//2 Label anlegen die einmal Speed + textfiled und einmal duration+ textfield darstellen
		JPanel speedlabel = new JPanel();
		speedlabel.add(new JLabel("Speed:    "));
		speedlabel.add(tSpeed);
		JPanel durationlabel = new JPanel();
		durationlabel.add(new JLabel("Duration:"));
		durationlabel.add(tDuration);
		//Diese dann in einem Panel vereinen und in CENTER einsetzen
		JPanel panel = new JPanel();
		panel.add(speedlabel);
		panel.add(durationlabel);
		this.add(panel, BorderLayout.CENTER);
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
				((Gear) command).setSpeed(Integer.parseInt(tSpeed.getText() ));
				((Gear) command).setDuration(Integer.parseInt(tDuration.getText() ));
				//die table updaten und message verändern
				controlUI.getTable().updateTable(command);
				controlUI.messageUpdated("Saved successful!");
			}
		});
	}
	
	/**
	 * Methode die das Textfeld mit dem bisherigen Wert befüllt
	 */
	public void update(Command c) {
		//wenn commmand nicht null ist
		if(c != null) {
			//schreibe den Wert von Speed und Duration in entsprechende Textfelder
			tSpeed.setText(Integer.toString((((Gear) c).getSpeed()) ));
			tDuration.setText(Integer.toString((((Gear) c).getDuration()) ));
		}
	}
}
