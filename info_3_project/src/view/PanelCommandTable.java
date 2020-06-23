package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

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
	ControlUI cUI = null;
	ControlModel cM = null;
	
	public PanelCommandTable(ControlModel cm, ControlUI cui)
	{
		cUI = cui;
		cM = cm;
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
				cM.getCommandList().remove(ICommands.getSelectedRow());
				//update --> configview / tableview
			}
		});
		bUp.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent anEvent) 
			{
				cM.getCommandList().moveUp(ICommands.getSelectedRow());
			}
		});
		bDown.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent anEvent) 
			{
				cM.getCommandList().moveDown(ICommands.getSelectedRow());
			}
		});
		bStart.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent anEvent) 
			{
				cM.start();
			}
		});
		bStop.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent anEvent) 
			{
				cM.stop();
			}
		});
		
	}
	
	public void updateTable(Command c)
	{
		
	}
	
	public void updateSelectedRover()
	{
		JRover.setName("Rover: " + cM.getSelectedRoverId());
	}
}
