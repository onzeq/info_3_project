package view;
//Importieren der benötigten Bibliotheken
import java.awt.BorderLayout;

import javax.swing.JLabel;

import model.Command;

/**
 * Klasse für das Config Standard Panel welches erscheint wenn kein Command ausgewählt ist, Panel verfügt über keine Funkionalität, 
 * sondern nur zur Darstellung
 * @author jakob
 *
 */
@SuppressWarnings("serial")
public class PanelConfigDefault extends PanelCommandConfig{

	//Nachricht die das Panel enthält
	private JLabel lMessage = new JLabel("No command selected");
	
	/**
	 * Konstruktor setzt Layout und Ansicht des Panels
	 */
	PanelConfigDefault(){
		this.setLayout(new BorderLayout());
		setView();
	}
	
	/**
	 * konfiguriert die Ansicht des Panels
	 */
	public void setView() {
		
		//Message wird im Panel oben angezeigt
		this.add(lMessage, BorderLayout.NORTH);
		//Mittig ausgerichtet
		lMessage.setHorizontalAlignment(JLabel.CENTER);
	}
	
	@Override
	public void update(Command c) {
		//wenn update ohne Command aufgerufen wird
		if(c == null)
		{
			JLabel lDefault = new JLabel("No Command selected!");
			this.add(lDefault);
		}
		else
		{
			System.out.println("Called Default config with a command!");
		}
		
	}

}
