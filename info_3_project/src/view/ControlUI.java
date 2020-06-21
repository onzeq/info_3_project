package view;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;

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
}
