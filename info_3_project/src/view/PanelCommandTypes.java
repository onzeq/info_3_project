package view;

//Importieren der benötigten Bibliotheken
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.CommandType;
import model.ControlModel;

/**
 * 
 * Klasse zum Darstellen des Types Panel mit gesamter Funktionalität 
 *
 */
@SuppressWarnings("serial")
public class PanelCommandTypes extends JPanel {
	//JList Objekt zum Darstellen der CommandTypes
	private JList<CommandType> commandTypeList = new JList<CommandType>();
	
	ControlModel controlModel;
	private JButton bAdd 					= null;
	private CommandType selectedCommandType = null;
	private ControlUI controlUI 			= null;
	
	/**
	 * 
	 * Konstruktor instanziert nötige Objekte, setzt übergabeparameter zu Klassenattributen und setzt View und Controller des Panels
	 * @param cM ist ControlmodelInstanz die gebraucht wird um Viewl mit Model zu verbinden
	 * @param  cui ist controlUI die für einige public Methoden gekannt werden muss
	 */
	public PanelCommandTypes(ControlModel cM, ControlUI cui) {
		//panel wird das ControlModel übergeben
		this.controlModel = cM;
		bAdd = new JButton("Add");
		controlUI = cui;
		//Fügt der JListe die Commandtypes hinzu
		commandTypeList.setListData(cM.getCommandTypes());
		
		this.setView();
		this.setController();
		this.setVisible(true);
	}
	
	/**
	 * konfiguriert die Ansicht des Panels
	 */
	private void setView() {
		//adds graphical components to the panel itself
		this.setLayout(new BorderLayout());
		
		JScrollPane scrollPane = new JScrollPane(commandTypeList);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); //Setzt scrollbar auch wenn Liste nicht lang genug zum scrollen
		this.add(scrollPane, BorderLayout.CENTER);
		this.add(bAdd, BorderLayout.SOUTH);
		
		//konfiguriert und setzt Labelfarbe und Label Hintergrundfarbe für besseren Kontrast
		JLabel lTypes = new JLabel("Types");
		lTypes.setOpaque(true);
		lTypes.setBackground(Color.GRAY);
		lTypes.setForeground(Color.WHITE);
		this.add(lTypes, BorderLayout.NORTH);
	}
	
	/**
	 * Fügt Button Funktionalität hinzu
	 */
	private void setController() {
		//ButtonListener and ListListener
		//Add Button
		bAdd.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent anEvent) 
			{
				//Wenn in Liste keine Zeile markiert, Fehlermeldung in MessageArea
				if(selectedCommandType == null)
				{
					controlUI.messageUpdated("No CommandType Selected");
				}
				//Wenn Zeile markiert
				else
				{
					//Fügt Commandtype mit leeren Attributen der Liste hinzu und aktualisiert den Table
					controlUI.updateTableView(selectedCommandType.createInstance());
					controlUI.messageUpdated("Added Command "+ selectedCommandType.getName());
				}
			}
		});
		
		
		
		//commandType Liste
		commandTypeList.addListSelectionListener( new ListSelectionListener(){
			public void valueChanged(ListSelectionEvent e)
			{
				//If cell is selected 
				if (!e.getValueIsAdjusting())
					//returnt Zeilenindex
					selectedCommandType = commandTypeList.getSelectedValue();
			}
		});
	}

}
