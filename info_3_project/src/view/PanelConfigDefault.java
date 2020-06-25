package view;

import javax.swing.JLabel;

import model.Command;

public class PanelConfigDefault extends PanelCommandConfig{

	
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
