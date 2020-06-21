package view;
import javax.swing.table.AbstractTableModel;

import model.CommandList;
public class PanelCommandModel extends AbstractTableModel{
	private static String[] columnNames = {"No.", "Command", "Configuration"};
	CommandList cL;
	
	public PanelCommandModel (CommandList commandList)
	{
		cL = commandList;
		
	}
	@Override
	public int getColumnCount() {
		// Returns 3 because of column no. / name / config
		return 3;
	}

	@Override
	public int getRowCount() {
		//returns count of Elements in commandList
		return cL.getSize();
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		//implement for giving back the object in a specific row
		
		return cL.getCommand(arg0);
	}
	
	public String getColumnName(int col)
	{
		return cL.getCommand(col).getName();
	}
	
	public String[] getColumnNames()
	{
		
		return columnNames; 
	}

}
