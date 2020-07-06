package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
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
		this.setLayout(new BorderLayout());
		JLabel lGear = new JLabel("Gear");
		lGear.setOpaque(true);
		lGear.setBackground(Color.GRAY);
		lGear.setForeground(Color.WHITE);
		this.add(lGear, BorderLayout.NORTH);
		JPanel speedlabel = new JPanel();
		speedlabel.add(new JLabel("Speed:    "));
		speedlabel.add(tSpeed);
		
		JPanel durationlabel = new JPanel();
		durationlabel.add(new JLabel("Duration:"));
		durationlabel.add(tDuration);
		
		JPanel panel = new JPanel();
		panel.add(speedlabel);
		panel.add(durationlabel);
		this.add(panel, BorderLayout.CENTER);
		this.add(bSave, BorderLayout.SOUTH);
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
