package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Command;

import model.Pause;

@SuppressWarnings("serial")
public class PanelConfigPause extends PanelCommandConfig {

	private JTextField tDuration = new JTextField(10);
	private JButton bSave = new JButton("Save");
	private ControlUI controlUI;
	
	
	public PanelConfigPause(ControlUI cui, Command p)
	{
		command = p;
		controlUI = cui;
		this.update(p);
		setView();
		setController();
		
	}
	
	private void setView()
	{
		this.setLayout(new BorderLayout());
		JLabel lPause = new JLabel("Pause");
		lPause.setOpaque(true);
		lPause.setBackground(Color.GRAY);
		lPause.setForeground(Color.WHITE);
		this.add(lPause, BorderLayout.NORTH);
		
		JPanel durationlabel = new JPanel();
		durationlabel.add(new JLabel("Duration:"));
		durationlabel.add(tDuration);
		
		this.add(durationlabel, BorderLayout.CENTER);
		this.add(bSave, BorderLayout.SOUTH);
	}
	
	private void setController()
	{
		bSave.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent anEvent) 
			{
				((Pause) command).setDuration(Integer.parseInt(tDuration.getText()));
				controlUI.getTable().updateTable(command);
				controlUI.messageUpdated("Saved successful!");
			}
		});
	}
	
	public void update(Command c) {
		if(c != null) {
			tDuration.setText(Integer.toString((((Pause) c).getDuration()) ));
		}
		
		
	}

}
