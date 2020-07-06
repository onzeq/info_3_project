package view;
import javax.swing.JList;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;

import model.CommandType;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JViewport;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.ControlModel;
@SuppressWarnings("serial")
public class PanelCommandTypes extends JPanel {
	private JList<CommandType> commandTypeList = new JList<CommandType>();
	private JButton bAdd = new JButton("Add");
	ControlModel controlModel;
	private CommandType selectedCommandType = null;
	private ControlUI controlUI = null;
	
	public PanelCommandTypes(ControlModel cM, ControlUI cui) {
		this.controlModel = cM;
		controlUI = cui;
		commandTypeList.setListData(cM.getCommandTypes());
		
		
		
	
		this.setView();
		this.setController();
		this.setVisible(true);
	}
	private void setView() {
		//adds graphical components to the panel itself
		this.setLayout(new BorderLayout());
		JScrollPane scrollPane = new JScrollPane(commandTypeList);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		this.add(scrollPane, BorderLayout.CENTER);
		this.add(bAdd, BorderLayout.SOUTH);
		JLabel lTypes = new JLabel("Types");
		lTypes.setOpaque(true);
		lTypes.setBackground(Color.GRAY);
		lTypes.setForeground(Color.WHITE);
		this.add(lTypes, BorderLayout.NORTH);
	}
	
	private void setController() {
		//ButtonListener and ListListener
		bAdd.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent anEvent) 
			{
				if(selectedCommandType == null)
				{
					controlUI.messageUpdated("No CommandType Selected");
				}
				else
				{
					controlUI.updateTableView(selectedCommandType.createInstance());
					controlUI.messageUpdated("Added Command "+ selectedCommandType.getName());
				}
			}
		});
		
		
		
		
		commandTypeList.addListSelectionListener( new ListSelectionListener(){
			public void valueChanged(ListSelectionEvent e)
			{
				//If cell is selected 
				if (!e.getValueIsAdjusting()) 
			          selectedCommandType = commandTypeList.getSelectedValue();
			}
		});
	}

}
