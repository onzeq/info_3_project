package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import model.Command;
import model.ControlModel;

public class PanelCommandTable extends JPanel {
	private JButton bRemove;
	private JButton bUp;
	private JButton bDown;
	private JButton bStart;
	private JButton bStop;
	private JLabel JRover;
	private JTable ICommands;
	private ListSelectionModel LSM;
	
	public PanelCommandTable(ControlModel cM, ControlUI cUI)
	{
		
	}
	
	private void setView()
	{
		this.add(bRemove);
		this.add(bUp);
		this.add(bDown);
		this.add(bStart);
		this.add(bStop);
		this.add(JRover);
		this.add(ICommands);
	}
	
	private void setController()
	{
		bRemove.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent anEvent) 
			{
				//remove a command
			}
		});
		bUp.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent anEvent) 
			{
				//move up a command
			}
		});
		bDown.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent anEvent) 
			{
				//move down a command
			}
		});
		bStart.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent anEvent) 
			{
				//start running
			}
		});
		bStop.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent anEvent) 
			{
				//stop running
			}
		});
		
	}
	
	public void updateTable(Command c)
	{
		//fireTabelDatachanged???
	}
	
	public void updateSelectedRover()
	{
		//JRover Label aktulatiseren
	}
}
