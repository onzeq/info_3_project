package view;
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
		
		return commandList.getCommand(arg0);
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
