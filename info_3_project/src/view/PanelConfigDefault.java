package view;

import java.awt.BorderLayout;

import javax.swing.JLabel;

import model.Command;

@SuppressWarnings("serial")
public class PanelConfigDefault extends PanelCommandConfig{

	private JLabel lMessage = new JLabel("No command selected");
	
	PanelConfigDefault(){
		this.setLayout(new BorderLayout());
		setView();
	}
	
	public void setView() {
		
		this.add(lMessage, BorderLayout.CENTER);
	}
	@Override
	public void update(Command c) {
		if(c == null)
		{
			JLabel lDefault = new JLabel("No Command selected!");
			this.add(lDefault);
		}
		else
		{
			System.out.println("Called Default config with a command!");
		}
		
	}

}
