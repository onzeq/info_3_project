package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import model.Command;
import model.Gear;

@SuppressWarnings("serial")
public class PanelConfigGear extends PanelCommandConfig{

	private JTextField tSpeed = new JTextField(10);
	private JTextField tDuration = new JTextField(10);;
	private JButton bSave = new JButton("Save");
	private ControlUI controlUI;
	
	
	public PanelConfigGear(ControlUI cui,Command g)
	{
		command = g;
		controlUI = cui;
		this.update(g);
		setView();
		setController();
	}
	
	private void setView()
	{
		this.add(new JLabel("Gear"));
		this.add(new JLabel("Speed"));
		this.add(tSpeed);
		this.add(new JLabel("Duration"));
		this.add(tDuration);
		this.add(bSave);
	}
	
	private void setController()
	{
		bSave.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent anEvent) 
			{
				((Gear) command).setSpeed(Integer.parseInt(tSpeed.getText() ));
				((Gear) command).setDuration(Integer.parseInt(tDuration.getText() ));
				controlUI.getTable().updateTable(command);
				controlUI.messageUpdated("Saved successful!");
			}
		});
	}
	
	public void update(Command c) {
		if(c != null) {
			tSpeed.setText(Integer.toString((((Gear) c).getSpeed()) ));
			tDuration.setText(Integer.toString((((Gear) c).getDuration()) ));
		
		
	}
	}
	


}
