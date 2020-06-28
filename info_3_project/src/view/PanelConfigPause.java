package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import model.Command;
import model.Direction;
import model.Gear;
import model.Pause;

public class PanelConfigPause extends PanelCommandConfig {

	private JTextField tDuration;
	private JButton bSave;
	private ControlUI controlUI;
	
	public PanelConfigPause(ControlUI cui)
	{
		controlUI = cui;
	}
	
	private void setView()
	{
		JLabel lPause = new JLabel("Pause");
		JLabel lDuration = new JLabel("Duration");
		this.add(tDuration);
		this.add(bSave);
	}
	
	private void setController()
	{
		bSave.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent anEvent) 
			{
				String textfield = tDuration.getText();
			}
		});
	}
	
	public void update(Command c) {
		
		Pause pause = (Pause)c;
		pause.setDuration(Integer.parseInt(tDuration.getText()));
		
	}

}
