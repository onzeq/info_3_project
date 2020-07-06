package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import model.*;

@SuppressWarnings("serial")
public class PanelConfigDirection extends PanelCommandConfig{
	private JTextField tDegree = new JTextField(10);
	private JButton bSave = new JButton("Save");
	private ControlUI controlUI;
	
	public PanelConfigDirection(ControlUI cui, Command d)
	{
		command = d;
		controlUI = cui;
		this.update(d);
		setView();
		setController();
		
	}
	
	private void setView()
	{
		this.setLayout(new BorderLayout());	
		JLabel lDirection = new JLabel("Direction");
		lDirection.setOpaque(true);
		lDirection.setBackground(Color.GRAY);
		lDirection.setForeground(Color.WHITE);
		this.add(lDirection, BorderLayout.NORTH);
		
		
		JPanel degreePanel = new JPanel();
		degreePanel.add(new JLabel("Degree:"));
		degreePanel.add(tDegree);
		this.add(degreePanel, BorderLayout.CENTER);
		this.add(bSave, BorderLayout.SOUTH);
	}
	
	private void setController()
	{
		bSave.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent anEvent) 
			{
				((Direction) command).setDegree(Integer.parseInt(tDegree.getText()));
				controlUI.getTable().updateTable(command);
				controlUI.messageUpdated("Saved successful!");
			}
				
				
		});
	}
	
	public void update(Command c) {
		
		if(c != null) {
			tDegree.setText(Integer.toString((((Direction) c).getDegree()) ));
		}
		
		
	}

}
