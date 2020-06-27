package view;
import javax.swing.table.AbstractTableModel;

import model.CommandList;
@SuppressWarnings("serial")
public class TableCommandModel extends AbstractTableModel{
	private static final String[] COLUMNNAMES = {"No.", "Command", "Configuration"};
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
	
	public String getColumnName(int col)
	{
		if(col > 2 || col < 0)
		{
			System.out.println("Out of Range!");
			return null;
		}
		else
		{
			return COLUMNNAMES[col];
		}
		
	}
	
	public String[] getColumnNames()
	{
		return COLUMNNAMES; 
	}

}
