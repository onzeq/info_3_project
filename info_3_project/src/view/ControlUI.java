package view;

import java.awt.BorderLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;


import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
	private JMenuBar menuBar = new JMenuBar();
	private JMenu mFile = new JMenu("File");
	private JMenuItem mIOpen = new JMenuItem("Open");
	private JMenuItem mISave = new JMenuItem("Save");
	private JMenuItem mIRover = new JMenuItem("Rover");
	private JMenuItem mIExit = new JMenuItem("Exit");
	private JMenu mHelp = new JMenu("Help");;
	private JMenuItem mIAbout = new JMenuItem("About");
	private JLabel lAbout = new JLabel("Das ist der About-Bereich von Jakob und Christians Programm!");
	private JDialog dAbout = new JDialog();
	
	//constants to choose right commandConfigPanel
	public static final int CONFIGDEFAULT 	= 0;
	public static final int CONFIGDIRECTION = 1;
	public static final int CONFIGGEAR 		= 2;
	public static final int CONFIGPAUSE 	= 3;
	
	//all the panels in the UI
	private PanelCommandTypes panelCommandTypes = null;
	private PanelCommandTable panelCommandTable = null;
	private PanelConfigDefault panelConfigDefault= null;
	private PanelConfigDirection panelConfigDirection= null;
	private PanelConfigGear panelConfigGear= null;
	private PanelConfigPause panelConfigPause= null;
	
	//file that is worked on
	private File workFile = null;
	
	//controlModel Attribut needed for access in Model 
	private ControlModel cM = ControlModel.getModel();
	
	/**
	 * Constructor creates Instances of the panels and sets everything needed to see the GUI window
	 */
	public ControlUI() {
		super("Control Developer");
		this.setLayout( new BorderLayout() );
		
		panelCommandTypes = new PanelCommandTypes(cM, this);
		panelCommandTable = new PanelCommandTable(cM, this);
		panelConfigDefault = new PanelConfigDefault();
		panelConfigDirection = new PanelConfigDirection(this, null);
		panelConfigGear = new PanelConfigGear(this, null);
		panelConfigPause = new  PanelConfigPause(this,null);
		this.setMenubar();
		this.setView();
		this.setController();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		super.setJMenuBar(menuBar);
		//no user input in textarea
		messageArea.setEditable(false);
	    
		//this.setSize(arg0, arg1);
		
		//About Dialog unsichtbar machen
		dAbout.setVisible(false);
		dAbout.add(lAbout);
		
	    this.add( panelCommandTypes, BorderLayout.WEST );    
	    this.add( panelCommandTable, BorderLayout.CENTER );    
	    this.add( messageArea, BorderLayout.SOUTH );    
	    this.add( panelConfigDefault, BorderLayout.EAST);    
	    
	    this.pack();
	   
	}
	public PanelCommandTable getTable() {
		return this.panelCommandTable;
	}
	
	/**
	 * integrates all tables panels buttons and menubar in the window
	*/
	private void setView()
	{
		this.add(messageArea);
		this.add(menuBar);
		this.add(panelCommandTypes);
		this.add(panelCommandTable);
		
	}
	
	/**
	 * integrates all compnents of the menubar in the window
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
	
	
	private void setController()
	{
		mIOpen.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent anEvent) 
			{
				
				JFileChooser fileChooser = new JFileChooser();
				
				FileNameExtensionFilter filter = new FileNameExtensionFilter(
				        ".txt Documents only", "txt");
				fileChooser.setFileFilter(filter);
				fileChooser.setDialogTitle("Explorer");
				JDialog dFileChooser = new JDialog();
				int result = fileChooser.showOpenDialog(dFileChooser);
				dFileChooser.setVisible(true);
				
				if (result == JFileChooser.APPROVE_OPTION) {
					workFile = fileChooser.getSelectedFile();
					cM.readCommands(workFile);
					dFileChooser.dispose();
					
				} else if (result == JFileChooser.CANCEL_OPTION) {
				    System.out.println("Cancel was selected");
				    dFileChooser.dispose();
				}
			}
		});
		mISave.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent anEvent) 
			{
				JFileChooser fileChooser = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter(
				        ".txt Documents only", "txt");
				fileChooser.setFileFilter(filter);
				fileChooser.setDialogTitle("Explorer");
				JDialog dFileChooser = new JDialog();
				int result = fileChooser.showOpenDialog(dFileChooser);
				dFileChooser.setVisible(true);
				
				if (result == JFileChooser.APPROVE_OPTION) {
					workFile = fileChooser.getSelectedFile();
					cM.writeCommands(workFile);
					dFileChooser.dispose();
					
				} else if (result == JFileChooser.CANCEL_OPTION) {
				    System.out.println("Cancel was selected");
				    dFileChooser.dispose();
				}
				
			}
		});
		mIRover.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent anEvent) 
			{
				cM.setSelectedRover();
				cM.notifyRoverChanged();
				messageArea.setText("New Rover selected");
			}
		});
		mIExit.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent anEvent) 
			{
				dispose();
			}
		});
		mIAbout.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent anEvent) 
			{
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
		cM.getCommandList().add(c);
		panelCommandTable.updateTable(c);
	}
	
	/**
	 * updates the command Config view for the selected command
	 * @param c command needed to select right panel
	 */
	
	public void updateConfigView(Command c)
	{
		
		switch (c.getName()) {
		case "Direction":
			panelConfigDirection = new PanelConfigDirection(this, c);
			this.add(panelConfigDirection, BorderLayout.EAST);
			panelConfigDirection.setVisible(true);
			
			panelConfigGear.setVisible(false);
			panelConfigPause.setVisible(false);
			panelConfigDefault.setVisible(false);
			break;
			
		case "Gear":
			panelConfigGear = new PanelConfigGear(this, c);
			this.add(panelConfigGear, BorderLayout.EAST);
			
			panelConfigGear.setVisible(true);
			
			panelConfigDirection.setVisible(false);
			panelConfigPause.setVisible(false);
			panelConfigDefault.setVisible(false);
			break;
			
		case "Pause":
			panelConfigPause = new PanelConfigPause(this, c);
			this.add(panelConfigPause, BorderLayout.EAST);
			
			panelConfigPause.setVisible(true);
			
			panelConfigGear.setVisible(false);
			panelConfigDirection.setVisible(false);
			panelConfigDefault.setVisible(false);
			break;

		default:
			this.add(panelConfigDefault, BorderLayout.EAST);
			
			panelConfigDefault.setVisible(true);
			
			panelConfigGear.setVisible(false);
			panelConfigDirection.setVisible(false);
			panelConfigPause.setVisible(false);
			break;
		}
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
	
	public static void main(String[] argv) {
		new ControlUI();
	}
	
}

