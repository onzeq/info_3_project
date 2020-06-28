package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import model.Command;
import model.Direction;
import model.Gear;

public class PanelConfigGear extends PanelCommandConfig{

	private JTextField tSpeed;
	private JTextField tDuration;
	private JButton bSave;
	private ControlUI controlUI;
	
	public PanelConfigGear(ControlUI cui)
	{
		controlUI = cui;
	}
	
	private void setView()
	{
		JLabel lGear = new JLabel("Gear");
		JLabel lSpeed = new JLabel("Speed");
		this.add(tSpeed);
		JLabel lDuration = new JLabel("Duration");
		this.add(tDuration);
		this.add(bSave);
	}
	
	private void setController()
	{
		bSave.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent anEvent) 
			{
				//???
			}
		});
	}
	
	public void update(Command c) {
		Gear gear = (Gear)c;
		gear.setSpeed(Integer.parseInt(tSpeed.getText()));
		gear.setDuration(Integer.parseInt(tDuration.getText()));
		
		
	}
	


}
