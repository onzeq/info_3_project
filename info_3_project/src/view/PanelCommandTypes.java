package view;
import javax.swing.JList;
import javax.swing.JButton;
import model.CommandType;
import javax.swing.JPanel;
import model.ControlModel;
@SuppressWarnings("serial")
public class PanelCommandTypes extends JPanel {
	private JList<CommandType> commandTypeList = new JList<CommandType>();
	private JButton bAdd = new JButton("Add");
	
	ControlModel cM;
	public PanelCommandTypes(ControlModel cM, ControlUI cui) {
		this.cM = cM;
		
	}
	
	private void setView() {
		//adds graphical components to the panel itself
		this.add(bAdd);
		this.add(commandTypeList);
		
	}
	
	private void setController() {
		//ButtonListener and ListListener
		
	}

}
