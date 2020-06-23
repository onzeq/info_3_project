package view;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import model.ControlModel;

public class ControlUI extends JFrame {
	private static final PanelCommandConfig[] panelConfigs = new PanelCommandConfig[4];
	private JTextArea messageArea;
	private JMenuBar menuBar;
	private JMenu mFile;
	private JMenuItem mIOpen;
	private JMenuItem mISave;
	private JMenuItem mIRover;
	private JMenuItem mIExit;
	private JMenu mHelp;
	private JMenuItem mIAbout;
	public static final int CONFIGDEFAULT = 0;
	public static final int CONFIGDIRECTION = 1;
	public static final int CONFIGGEAR = 2;
	public static final int CONFIGPAUSE = 3;
	
	public PanelCommandTypes pct = null;
	
	//Constructor just for testing 
	public ControlUI( PanelCommandTypes pct) {
		super("Testfenster");
		this.setLayout( new GridLayout( 2, 1) );
		this.pct = pct;
		
		this.add(pct);
		
	}
	public static void main(String[] args) {
		
		ControlModel cM  = ControlModel.getModel();
		
		PanelCommandTypes panel1 = new PanelCommandTypes(cM, null);
		ControlUI GUI = new ControlUI(panel1);
		GUI.setVisible(true);
		
		
	}
}
