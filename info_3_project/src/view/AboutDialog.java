package view;

//Importieren der benötigten Bibliotheken
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
/**
 * Klasse zur Anzeige des Info Dialogs der GUI,
 * @author jakob
 *
 */
public class AboutDialog extends JDialog {
	//Anlegen der benötigten Objekte für Darstellung
	JTextArea tA = new JTextArea("   Das ist der About-Bereich von Jakob und Christians Programm!");
	JButton bOk = new JButton("Okay");
	
	/**
	 * Konstruktor setzt View und Controller
	 * 
	 */
	public AboutDialog(ControlUI cui)
	{
		setView();
		setController();
	}
	
	/**
	 * Methode zur Darstellungskonfiguration
	 */
	private void setView()
	{
		this.setLayout(new BorderLayout());
		this.setSize(380, 100);
		this.add(tA, BorderLayout.CENTER);
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(bOk);
		this.add(buttonPanel, BorderLayout.SOUTH);
	}
	
	/**
	 * Fügt Button Funktionalität hinzu
	 */
	private void setController()
	{
		bOk.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent anEvent) 
			{
				//Bei Klick Fenster unsichtbar machen(damit erneut aufrufbar)
				setVisible(false);
			}
		});
	}
}
