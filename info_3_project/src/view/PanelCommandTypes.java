package view;
import javax.swing.JList;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

import model.CommandType;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.ControlModel;
@SuppressWarnings("serial")
public class PanelCommandTypes extends JPanel {
	private JList<CommandType> commandTypeList = new JList<CommandType>();
	private JButton bAdd = new JButton("Add");
	ControlModel cM;
	private CommandType selectedCT = null;
	private JFrame cUI = null;
	
	public PanelCommandTypes(ControlModel cM, ControlUI cui) {
		this.cM = cM;
		cUI = cui;
		commandTypeList.setListData(cM.getCommandTypes());
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setView();
		this.setController();
		this.setVisible(true);
	}
	private void setView() {
		//adds graphical components to the panel itself
		this.add(commandTypeList);
		this.add(bAdd);
	}
	
	private void setController() {
		//ButtonListener and ListListener
		bAdd.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent anEvent) 
			{
				if(selectedCT == null)
				{
					System.out.println("Kein CommandType ausgewählt");
				}
				else
				{
					cM.getCommandList().add(selectedCT.createInstance());
					System.out.println("Hier sind wir");
				}
			}
		});
		
		
		
		
		commandTypeList.addListSelectionListener( new ListSelectionListener(){
			public void valueChanged(ListSelectionEvent e)
			{
				//If cell is selected 
				if (!e.getValueIsAdjusting()) 
			          selectedCT = commandTypeList.getSelectedValue();
			}
		});
	}

}
