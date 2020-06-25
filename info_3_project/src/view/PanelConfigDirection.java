package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import model.*;

public class PanelConfigDirection extends PanelCommandConfig{
	private JTextField tDegree;
	private JButton bSave;
	private ControlUI cUI;
	protected Command command;
	public PanelConfigDirection(ControlUI cui)
	{
		cUI = cui;
	}
	
	private void setView()
	{
		JLabel lDirection = new JLabel("Direction");
		JLabel lDegree = new JLabel("Degree");
		this.add(tDegree);
		this.add(bSave);
	}
	
	private void setController()
	{
		bSave.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent anEvent) 
			{
				String textfield = tDegree.getText();
			}
		});
	}
	
	public void update(Command c) {
		
		Direction direction = (Direction)c;
		direction.setDegree(Integer.parseInt(tDegree.getText()));
		
	}

}
