package view;
import java.awt.BorderLayout;

import javax.swing.JScrollPane;
import javax.swing.table.AbstractTableModel;

import model.CommandList;


@SuppressWarnings("serial")
public class TableCommandModel extends AbstractTableModel{
	static final String[] COLUMNNAMES = {"No.", "Command", "Configuration"};
	CommandList commandList;
	
	public TableCommandModel (CommandList commandList)
	{
		this.commandList = commandList;
		
		
	}
	@Override
	public int getColumnCount() {
		// Returns 3 because of column no. / name / config
		return COLUMNNAMES.length;
	}

	@Override
	public int getRowCount() {
		//returns count of Elements in commandList
		return commandList.getSize();
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		//implement for giving back the object in a specific row
		if(commandList.getCommand(arg0).getName()=="Direction")
		{
			switch (arg1) {
			case 0:
				return arg0;
			case 1:
				return commandList.getCommand(arg0).getName();
			case 2:
				return commandList.getCommand(arg0).getConfig();	
			default:
				return "Fehler";
			}
		}
		else if(commandList.getCommand(arg0).getName()=="Gear")
		{
			switch (arg1) {
			case 0:
				return arg0;
			case 1:
				return commandList.getCommand(arg0).getName();
			case 2:
				return commandList.getCommand(arg0).getConfig();	
			default:
				return "Fehler";
			}
		}
		else
		{
			switch (arg1) {
			case 0:
				return arg0;
			case 1:
				return commandList.getCommand(arg0).getName();
			case 2:
				return commandList.getCommand(arg0).getConfig();	
			default:
				return "Fehler";
			}
		}
	}
	

	@Override
	public String getColumnName(int col)
	{
		return COLUMNNAMES[col];
		
		
	}
	
	public String[] getColumnNames()
	{
		return COLUMNNAMES; 
	}

}
