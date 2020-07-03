package view;

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
		this.add(new JScrollPane(tCommands), BorderLayout.CENTER);
		
		JPanel usePanel = new JPanel();
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
		
		
		bRemove.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent anEvent) 
			{
				controlModel.getCommandList().remove(tCommands.getSelectedRow());
				tableCommandModel.fireTableDataChanged();
				controlUI.setDefaultConfig();
				controlUI.messageUpdated("Command Removed successful!");
			}
		});
		bUp.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent anEvent) 
			{
				if(tCommands.getSelectedRow() == controlModel.getCommandList().getSize()-1)
				{
					controlUI.setDefaultConfig();
					controlUI.messageUpdated("MoveUp not possible!");
				}
				else
				{
					controlModel.getCommandList().moveUp(tCommands.getSelectedRow());
					tableCommandModel.fireTableDataChanged();
					controlUI.setDefaultConfig();
					controlUI.messageUpdated("MovedUp successful!");
				}
			}
		});
		bDown.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent anEvent) 
			{
				if(tCommands.getSelectedRow() == 0)
				{
					controlUI.setDefaultConfig();
					controlUI.messageUpdated("MoveDown not possible!");
				}
				else
				{
					controlModel.getCommandList().moveDown(tCommands.getSelectedRow());
					tableCommandModel.fireTableDataChanged();
					controlUI.setDefaultConfig();
					controlUI.messageUpdated("MovedDown successful!");
				}
				
			}
		});
		bStart.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent anEvent) 
			{
				controlModel.start();
				controlUI.messageUpdated("Simulation started");
			}
		});
		bStop.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent anEvent) 
			{
				controlModel.stop();
				controlUI.messageUpdated("Simulation stopped");
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
			//happens after moving up or down
			if(tCommands.getSelectedRow() == -1) {
				return;
			}
			System.out.println(tCommands.getSelectedRow());
			Command selectedCommand = controlModel.getCommandList().getCommand(tCommands.getSelectedRow());
			controlUI.updateConfigView(selectedCommand);
			
		}
	}
}
