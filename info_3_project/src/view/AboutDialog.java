package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class AboutDialog extends JDialog {
	JTextArea tA = new JTextArea("   Das ist der About-Bereich von Jakob und Christians Programm!");
	JButton bOk = new JButton("Okay");
	public AboutDialog(ControlUI cui)
	{
		setView();
		setController();
	}
	
	private void setView()
	{
		this.setLayout(new BorderLayout());
		this.setSize(380, 100);
		this.add(tA, BorderLayout.CENTER);
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(bOk);
		this.add(buttonPanel, BorderLayout.SOUTH);
	}
	
	private void setController()
	{
		bOk.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent anEvent) 
			{
				dispose();
			}
		});
	}
}
