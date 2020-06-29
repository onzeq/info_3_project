package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

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
	private JTable tCommands = new JTable();
	ControlUI controlUI = null;
	ControlModel controlModel = null;
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
		tCommands.setModel(tableCommandModel);		
		tCommands.getSelectionModel().addListSelectionListener(this);
		this.setView();
		this.setController();
		this.setVisible(true);
		
	}
	
	private void setView()
	{
		this.setLayout(new BorderLayout());
		JPanel usePanel = new JPanel();
		this.add(new JScrollPane(tCommands), BorderLayout.CENTER);
		usePanel.add(bRemove);
		usePanel.add(bUp);
		usePanel.add(bDown);
		usePanel.add(JRover);
		usePanel.add(bStart);
		usePanel.add(bStop);
		this.add(usePanel, BorderLayout.SOUTH);
		
		
	}
	
	private void setController()
	{
		
		
		bRemove.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent anEvent) 
			{
				controlModel.getCommandList().remove(tCommands.getSelectedRow());
				tableCommandModel.fireTableDataChanged();
				
			}
		});
		bUp.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent anEvent) 
			{
				controlModel.getCommandList().moveUp(tCommands.getSelectedRow());
				tableCommandModel.fireTableDataChanged();
			}
		});
		bDown.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent anEvent) 
			{
				controlModel.getCommandList().moveDown(tCommands.getSelectedRow());
				tableCommandModel.fireTableDataChanged();
			}
		});
		bStart.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent anEvent) 
			{
				controlModel.start();
			}
		});
		bStop.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent anEvent) 
			{
				controlModel.stop();
			}
		});
		
		
		
		
	}
	
	
	
	/**
	 * 
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
		if(arg0.getValueIsAdjusting() != true)
		{
			System.out.println(tCommands.getSelectedRow());
		}
	}
}
