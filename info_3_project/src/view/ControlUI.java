package view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import model.Command;
import model.ControlModel;
import model.IControlModelListener;

public class ControlUI extends JFrame  implements IControlModelListener{
	private static final PanelCommandConfig[] panelConfigs = new PanelCommandConfig[4];
	private JTextArea messageArea = new JTextArea();
	private JMenuBar menuBar = new JMenuBar();
	private JMenu mFile = new JMenu();
	private JMenuItem mIOpen = new JMenuItem();
	private JMenuItem mISave = new JMenuItem();
	private JMenuItem mIRover = new JMenuItem();
	private JMenuItem mIExit = new JMenuItem();
	private JMenu mHelp = new JMenu();;
	private JMenuItem mIAbout = new JMenuItem();
	public static final int CONFIGDEFAULT = 0;
	public static final int CONFIGDIRECTION = 1;
	public static final int CONFIGGEAR = 2;
	public static final int CONFIGPAUSE = 3;
	
	private PanelCommandTypes pcTypes = null;
	private PanelCommandTable pcTable = null;
	private PanelConfigDefault pcDefault= null;
	private PanelConfigDirection pcDirection= null;
	private PanelConfigGear pcGear= null;
	private PanelConfigPause pcPause= null;
	private ControlModel cM = ControlModel.getModel();
	
	//Constructor just for testing 
	public ControlUI() {
		pcTypes = new PanelCommandTypes(cM, this);
		pcTable = new PanelCommandTable(cM, this);
		pcDefault = new PanelConfigDefault();
		pcDirection = new PanelConfigDirection(this);
		pcGear = new PanelConfigGear(this);
		pcPause = new PanelConfigPause(this);
		this.setMenubar();
		this.setView();
		this.setController();
		
	}
	
	private void setView()
	{
		this.add(messageArea);
		this.add(menuBar);
		this.add(pcTypes);
		this.add(pcTable);
		this.add(pcDefault);
	}
	
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
		mFile.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent anEvent) 
			{
				
			}
		});
		mIOpen.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent anEvent) 
			{
				
			}
		});
		mISave.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent anEvent) 
			{
				
			}
		});
		mIRover.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent anEvent) 
			{
				
			}
		});
		mIExit.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent anEvent) 
			{
				
			}
		});
		mHelp.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent anEvent) 
			{
				
			}
		});
		mIAbout.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent anEvent) 
			{
				
			}
		});
	}
	
	public void updateTableView(Command c)
	{
		pcTable.updateTable(c);
	}
	
	public void updateConfigView(Command c)
	{
		switch (c.getName()) {
		case "Direction":
			this.add(pcDirection);
			break;
			
		case "Gear":
			this.add(pcGear);
			break;
			
		case "Pause":
			this.add(pcPause);
			break;

		default:
			this.add(pcDefault);
			break;
		}
	}
	
	@Override
	public void messageUpdated(String s) {
		messageArea.setText(s);
		
	}

	@Override
	public void roverUpdated() {
		pcTable.updateSelectedRover();
		messageArea.setText("Rover updated:" + pcTable.cM.getSelectedRoverId());
		
	}
	
	
}
