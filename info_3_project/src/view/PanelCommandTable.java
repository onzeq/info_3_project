package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;

import model.Command;
import model.ControlModel;

@SuppressWarnings("serial")
public class PanelCommandTable extends JPanel implements ListSelectionListener{
	private JButton bRemove = new JButton("Remove");
	private JButton bUp =   new JButton("Up");
	private JButton bDown = new JButton("Down");
	private JButton bStart= new JButton("Start");
	private JButton bStop = new JButton("Stop");
	private JLabel JRover = new JLabel("Rover: ");
	private JTable tCommands = null;
	private ListSelectionModel listSelectionModel;
	ControlUI controlUI = null;
	ControlModel cM = null;
	TableCommandModel tcM = null;
	
	/**
	 * Constructor sets all components needed
	 * @param cm controlmodel needed to have access to model 
	 * @param cui Userinterface so its known in the panel
	 */
	public PanelCommandTable(ControlModel cm, ControlUI cui)
	{
		controlUI = cui;
		cM = cm;
		
		tcM = new TableCommandModel(cM.getCommandList());
		tCommands = new JTable();
		tCommands.setModel(tcM);
		this.setView();
		this.setController();
		this.setVisible(true);
		
		
		
	}
	
	private void setView()
	{
		this.add(bRemove);
		this.add(bUp);
		this.add(bDown);
		this.add(bStart);
		this.add(bStop);
		this.add(JRover);
		this.add(tCommands);
	}
	
	private void setController()
	{
		bRemove.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent anEvent) 
			{
				cM.getCommandList().remove(tCommands.getSelectedRow());
				//update --> configview / tableview
			}
		});
		bUp.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent anEvent) 
			{
				cM.getCommandList().moveUp(tCommands.getSelectedRow());
			}
		});
		bDown.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent anEvent) 
			{
				cM.getCommandList().moveDown(tCommands.getSelectedRow());
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
	
	
	
	/**
	 * 
	 * @param c
	 */
	public void updateTable(Command c)
	{
		
		tcM.fireTableDataChanged();
		//LSM.setSelectionInterval();
	}
	
	
	public void updateSelectedRover()
	{
		JRover.setName("Rover: " + cM.getSelectedRoverId());
	}

	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
