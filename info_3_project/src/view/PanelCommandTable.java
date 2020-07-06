package view;
//Importieren der benötigten Bibliotheken
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


import model.Command;
import model.ControlModel;

/**
 * Legt Panel für Table an
 * @author jakob
 *
 */
@SuppressWarnings("serial")
public class PanelCommandTable extends JPanel implements ListSelectionListener{
	//Klassenvariabeln/Komponenten anlegen und zum teil instanzieren
	private JButton bRemove 		= new JButton("Remove");
	private JButton bUp 			= new JButton("Up");
	private JButton bDown 			= new JButton("Down");
	private JButton bStart			= new JButton("Start");
	private JButton bStop 			= new JButton("Stop");
	private JLabel JRover 			= new JLabel("Rover: ");
	private JTable tCommands 		= new JTable();
	ControlUI controlUI 			= null;
	ControlModel controlModel 		= null;
	TableCommandModel tableCommandModel = null;
	
	/**
	 * Constructor sets all components needed
	 * @param cm controlmodel needed to have access to model 
	 * @param cui Userinterface so its known in the panel
	 */
	public PanelCommandTable(ControlModel cm, ControlUI cui)
	{
		controlUI = cui;
		controlModel = cm;
		
		tableCommandModel = new TableCommandModel(controlModel.getCommandList());
		//fügt selbst implemenitertes talbeCommandModel der jtable hinzu, geben Liste ihre Struktur vor
		tCommands.setModel(tableCommandModel);		
		//weist ListSelectionListener der JTable hinzu um auf Auswahl reagieren zu können
		tCommands.getSelectionModel().addListSelectionListener(this);
		this.setView();
		this.setController();
		
	}
	
	private void setView()
	{
		this.setLayout(new BorderLayout());
		this.add(new JScrollPane(tCommands), BorderLayout.CENTER);
		
		JPanel usePanel = new JPanel();
		//Boxlayout, Anordnung Buttons
		usePanel.setLayout(new BoxLayout(usePanel, BoxLayout.X_AXIS));
		usePanel.add(bRemove);
		usePanel.add(Box.createRigidArea(new Dimension(5,0)));
		usePanel.add(bUp);
		usePanel.add(Box.createRigidArea(new Dimension(5,0)));
		usePanel.add(bDown);
		usePanel.add(Box.createRigidArea(new Dimension(35,0)));
		usePanel.add(bStart);
		usePanel.add(Box.createRigidArea(new Dimension(5,0)));
		usePanel.add(bStop);
		usePanel.add(Box.createRigidArea(new Dimension(20,0)));
		usePanel.add(JRover);
		
		this.add(usePanel, BorderLayout.SOUTH);	
	}
	
	private void setController()
	{
		
		//Remove Button
		bRemove.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent anEvent) 
			{
				//nimmt Index von Reihe als Index der Liste, und löscht entsprechendes Element 
				controlModel.getCommandList().remove(tCommands.getSelectedRow());
				//aktualisiert Table
				tableCommandModel.fireTableDataChanged();
				//default config panel wird sichtbar
				controlUI.setDefaultConfig();
				controlUI.messageUpdated("Command Removed successful!");
			}
		});
		//Up Button
		bUp.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent anEvent) 
			{
				//Wenn schon ganz oben, dann Operation nicht möglich
				if(tCommands.getSelectedRow() == controlModel.getCommandList().getSize()-1)
				{
					//default config panel wird sichtbar
					controlUI.setDefaultConfig();
					//Message in der MessageArea
					controlUI.messageUpdated("MoveUp not possible!");
				}
				else
				{
					//nimmt Index von Reihe als Index der Liste, und moved entsprechendes Element 
					controlModel.getCommandList().moveUp(tCommands.getSelectedRow());
					//aktualisiert Table
					tableCommandModel.fireTableDataChanged();
					//default config panel wird sichtbar
					controlUI.setDefaultConfig();
					//Message in der MessageArea
					controlUI.messageUpdated("MovedUp successful!");
				}
			}
		});
		//Down Button
		bDown.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent anEvent) 
			{
				//Wenn schon ganz unten, dann Operation nicht möglich
				if(tCommands.getSelectedRow() == 0)
				{
					controlUI.setDefaultConfig();
					controlUI.messageUpdated("MoveDown not possible!");
				}
				else
				{
					//nimmt Index von Reihe als Index der Liste, und moved entsprechendes Element 
					controlModel.getCommandList().moveDown(tCommands.getSelectedRow());
					tableCommandModel.fireTableDataChanged();
					controlUI.setDefaultConfig();
					controlUI.messageUpdated("MovedDown successful!");
				}
				
			}
		});
		//Start Button
		bStart.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent anEvent) 
			{
				//startet Simulation
				controlModel.start();
				//Benachrichtigt MessageArea
				controlUI.messageUpdated("Simulation started");
			}
		});
		//Stop Button
		bStop.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent anEvent) 
			{
				//Beendet Simulation
				controlModel.stop();
				//Benachrichtigt MessageArea
				controlUI.messageUpdated("Simulation stopped");
			}
		});
		
	}
	
	
	
	/**
	 * Updated den Table, bekommt Command übergeben
	 * @param c
	 */
	public void updateTable(Command c)
	{
		tableCommandModel.fireTableDataChanged();
	}
	
	
	public void updateSelectedRover()
	{
		JRover.setName("Rover: " + controlModel.getSelectedRoverId());
	}

	
	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		//Wenn Zeile nicht verändert wird
		if(arg0.getValueIsAdjusting() != true)
		{
			//happens after moving up or down
			if(tCommands.getSelectedRow() == -1) {
				return;
			}
			//System.out.println(tCommands.getSelectedRow());
			Command selectedCommand = controlModel.getCommandList().getCommand(tCommands.getSelectedRow());
			controlUI.updateConfigView(selectedCommand);
			
		}
	}
}
