package view;

//Hinzufügen der benötigten Bibliotheken
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;


import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;


import model.Command;
import model.ControlModel;

import model.IControlModelListener;


@SuppressWarnings("serial")
public class ControlUI extends JFrame  implements IControlModelListener{
	//four different panels for different content in commands + default panel if no command is selected
	//private static final PanelCommandConfig[] panelConfigs = new PanelCommandConfig[4];
	
	//attribute for message area in the bottom of the UI 
	private JTextArea messageArea = new JTextArea();
	
	//MenuBar attribute with several items in it
	private JMenuBar menuBar 	= new JMenuBar();
	private JMenu mFile 		= new JMenu("File");
	private JMenuItem mIOpen 	= new JMenuItem("Open");
	private JMenuItem mISave 	= new JMenuItem("Save");
	private JMenuItem mIRover 	= new JMenuItem("Rover");
	private JMenuItem mIExit 	= new JMenuItem("Exit");
	private JMenu mHelp 		= new JMenu("Help");;
	private JMenuItem mIAbout 	= new JMenuItem("About");
	private AboutDialog dAbout 	= new AboutDialog(this);
	
	//deklarieren der benötigten Panels
	private PanelCommandTypes panelCommandTypes 		= null;
	private PanelCommandTable panelCommandTable 		= null;
	private PanelConfigDefault panelConfigDefault		= null;
	private PanelConfigDirection panelConfigDirection	= null;
	private PanelConfigGear panelConfigGear				= null;
	private PanelConfigPause panelConfigPause			= null;
	
	//file that is worked on
	private File workFile = null;
	
	//controlModel Attribut needed for access in Model 
	private ControlModel cM = ControlModel.getModel();
	
	/**
	 * Constructor creates Instances of the panels and sets everything needed to see the GUI window
	 */
	public ControlUI() {
		//Initialisieren der verschiedenen Panels
		panelCommandTypes 		= new PanelCommandTypes(cM, this);
		panelCommandTable 		= new PanelCommandTable(cM, this);
		panelConfigDefault 		= new PanelConfigDefault();
		panelConfigDirection 	= new PanelConfigDirection(this, null);
		panelConfigGear 		= new PanelConfigGear(this, null);
		panelConfigPause 		= new  PanelConfigPause(this,null);
		
		this.setView();
		this.setController();
	}
	
	public PanelCommandTable getTable() {
		return this.panelCommandTable;
	}
	
	/**
	 * integrates all tables panels buttons and menubar in the window
	*/
	private void setView()
	{
		this.setTitle("Informatik 3 Praktikum - Christian und Jakob");
		
		BorderLayout layout = new BorderLayout(5,5);// 5 Pixel  Abstand(gap)
		this.setLayout(layout);
		this.setMinimumSize(new Dimension(1100,500));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		this.add(panelCommandTable, BorderLayout.CENTER);
		panelCommandTypes.setPreferredSize(new Dimension(150,500)); // Boarderlayout will prefferedSize()
		this.add( panelCommandTypes, BorderLayout.WEST );    
	    this.add( messageArea, BorderLayout.SOUTH );  
		this.setDefaultConfig();
		
		dAbout.setVisible(false);
		
		
		setMenubar();
		super.setJMenuBar(menuBar);
		this.setVisible(true);

		messageArea.setEditable(false);
	}
	
	/**
	 * integrates all components of the menubar in the window
	 */
	private void setMenubar()
	{
		mFile.add(mIOpen);
		mFile.add(mISave);
		mFile.add(mIRover);
		mFile.add(mIExit);
		menuBar.add(mFile);
		mHelp.add(mIAbout);
		menuBar.add(mHelp);
	}
	
	/**
	 * Fügt Button Funktionalität hinzu
	 */
	private void setController()
	{
		//open Button
		mIOpen.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent anEvent) 
			{
				
				setDefaultConfig();
				//fileChooser öffnet popUp Wnindow zum Auswählen des Files(API)
				JFileChooser fileChooser = new JFileChooser();
				
				//akzeptiert nur .txt Files
				FileNameExtensionFilter filter = new FileNameExtensionFilter(
				        ".txt Documents only", "txt");
				fileChooser.setFileFilter(filter);
				fileChooser.setDialogTitle("Explorer");
				JDialog dFileChooser = new JDialog();
				//Liefert Ergebnis der "Öffnen" - Operation zurück
				int result = fileChooser.showOpenDialog(dFileChooser);
				dFileChooser.setVisible(true);
				
				//Wenn erfolgreich geöffnet wird Liste befüllt
				if (result == JFileChooser.APPROVE_OPTION) {
					workFile = fileChooser.getSelectedFile();
					cM.readCommands(workFile);
					dFileChooser.dispose();
					if(cM.getCommandList().getSize()==0)
					{
						messageUpdated("List from "+ workFile.getPath()+ " is empty!");
					}
					//Wenn nicht erfolgreich Fehlermeldung in Messagearea
					else
					{
						messageUpdated("Opened List from "+ workFile.getPath());
					}
					
					//wenn fenster ohne Auswahl geschlossen wird
				} else if (result == JFileChooser.CANCEL_OPTION) {
					messageUpdated("Cancel Selection");
				    dFileChooser.dispose();
				}
				panelCommandTable.updateTable(null);
			}
		});
		
		//Save Button
		mISave.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent anEvent) 
			{
				//fileChooser öffnet popUp Window Pfad wählen wo gespeichtert werden soll(API)
				setDefaultConfig();
				JFileChooser fileChooser = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter(
				        ".txt Documents only", "txt");
				fileChooser.setFileFilter(filter);
				fileChooser.setDialogTitle("Explorer");
				JDialog dFileChooser = new JDialog();
				
				//Liefert Ergebnis ob Pfad in Ordnung 
				int result = fileChooser.showOpenDialog(dFileChooser);
				dFileChooser.setVisible(true);
				
				//wenn Pfad in Ordnung, schreiben der Liste in Txt datei und speichern in gewähltem Pfad
				if (result == JFileChooser.APPROVE_OPTION) {
					workFile = fileChooser.getSelectedFile();
					cM.writeCommands(workFile);
					dFileChooser.dispose();
					messageUpdated("Saved List in "+ workFile.getPath());
					
					//Wenn nicht erfolgreich, Fehler in Messagearea ausgeben
				} else if (result == JFileChooser.CANCEL_OPTION) {
					messageUpdated("Cancel Selection");
				    dFileChooser.dispose();
				}
				
			}
		});
		//Rover Button
		mIRover.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent anEvent) 
			{
				//selektiert verfügbaren Rover und meldet Ergebnis in MessageArea
				cM.setSelectedRover();
				cM.notifyRoverChanged();
				messageArea.setText("New Rover selected");
			}
		});
		//Exit Button
		mIExit.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent anEvent) 
			{
				//Schließt Fenster bei Druck des Buttons
				dispose();
			}
		});
		//About Button
		mIAbout.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent anEvent) 
			{
				//öffnet Dialogfenster
				dAbout.setVisible(true);
			}
		});
	}

	/**
	 * refreshes the view after changes
	 * @param c command needed to execute nested method updateTable
	 */
	public void updateTableView(Command c)
	{
		//fügt neuen Command in der Liste hinzu
		cM.getCommandList().add(c);
		//refresht die Tabellendarstellung
		panelCommandTable.updateTable(c);
	}
	
	/**
	 * updates the command Config view for the selected command
	 * @param c command needed to select right panel
	 */
	public void updateConfigView(Command c)
	{
		//wählt passenden Command aus und setzt entsprechende Panels
		switch (c.getName()) {
		case "Direction":
			panelConfigDirection.setVisible(false);
			panelConfigDirection = new PanelConfigDirection(this, c);
			panelConfigDirection.setPreferredSize(new Dimension (250,500));
			this.add(panelConfigDirection, BorderLayout.EAST);
			panelConfigDirection.setVisible(true);
			
			panelConfigGear.setVisible(false);
			panelConfigPause.setVisible(false);
			panelConfigDefault.setVisible(false);
			break;
			
		case "Gear":
			panelConfigGear.setVisible(false);
			panelConfigGear = new PanelConfigGear(this, c);

			panelConfigGear.setPreferredSize(new Dimension (250,500));
			this.add(panelConfigGear, BorderLayout.EAST);
			
			panelConfigGear.setVisible(true);
			
			panelConfigDirection.setVisible(false);
			panelConfigPause.setVisible(false);
			panelConfigDefault.setVisible(false);
			break;
			
		case "Pause":
			panelConfigPause.setVisible(false);
			panelConfigPause = new PanelConfigPause(this, c);
			panelConfigPause.setPreferredSize(new Dimension (250,500));
			this.add(panelConfigPause, BorderLayout.EAST);
			
			panelConfigPause.setVisible(true);
			
			panelConfigGear.setVisible(false);
			panelConfigDirection.setVisible(false);
			panelConfigDefault.setVisible(false);
			break;

		default:
			this.setDefaultConfig();
			break;
		}
	}
	
	/**
	 * wird aufgerufen wenn keine Zeile in tabelle ausgewählt, Standarddarstellung von panelConfig wird dargestellt
	 */
	public void setDefaultConfig()
	{
		this.add( panelConfigDefault, BorderLayout.EAST);   

		panelConfigDefault.setPreferredSize(new Dimension (250,500));
		panelConfigDefault.setVisible(true);
		panelConfigGear.setVisible(false);
		panelConfigDirection.setVisible(false);
		panelConfigPause.setVisible(false);
	}
	@Override
	/**
	 * implements method from Interface IControlModelListener and shows the text in the textfield
	 */
	public void messageUpdated(String message) {
		messageArea.setText(message);
		
	}

	@Override
	/**
	 * invoke Method fr update the rover and shows the Information about the rover in the messagepanel
	 */
	public void roverUpdated() {
		panelCommandTable.updateSelectedRover();
		messageArea.setText("Rover updated:" + panelCommandTable.controlModel.getSelectedRoverId());
		
	}
	
	//Hauptprogramm
	public static void main(String[] argv) {
		//GUI wird erzeugt, mit zugrunde liegender Logik des Models
		new ControlUI();
	}
	
}

