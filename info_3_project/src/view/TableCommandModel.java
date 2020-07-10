package view;

import javax.swing.table.AbstractTableModel;

import model.CommandList;
/**
 * AbstractTable Model that Handles the Tabel of Commands
 * @author Christian
 *
 */

@SuppressWarnings("serial")
public class TableCommandModel extends AbstractTableModel{
	//String Array welches die Header Namen darstellt
	static final String[] COLUMNNAMES = {"No.", "Command", "Configuration"};
	//CommandList mit der die Table befüllt wird
	CommandList commandList;
	
	/**
	 * Konstruktor welcher die Liste einbindet
	 * @param commandList
	 */
	public TableCommandModel (CommandList commandList)
	{
		this.commandList = commandList;
	}
	
	@Override
	/**
	 * Methode welche die Breite der Tabelle zurückgibt
	 */
	public int getColumnCount() {
		// Returns 3 because of column no. / name / config
		return COLUMNNAMES.length;
	}

	@Override
	/**
	 * Methode welche die Höhe der Tabelle zurückgibt
	 */
	public int getRowCount() {
		//returns count of Elements in commandList
		return commandList.getSize();
	}

	@Override
	/**
	 * Methode die Object an bestimmer Stelle returned, sodass Tabelle befüllt werden kann
	 */
	public Object getValueAt(int arg0, int arg1) {
			switch (arg1) {
			case 0:
				return arg0 +1; //nummer
			case 1:
				return commandList.getCommand(arg0).getName(); //name
			case 2:
				return commandList.getCommand(arg0).getConfig();//config
			default:
				return "Fehler"; //kein gültiges arg1 übergeben
			}
	}
	

	@Override
	/**
	 * liefert den Namen der Spalte für die Table an pos
	 */
	public String getColumnName(int col)
	{
		return COLUMNNAMES[col];
	}
	
	/**
	 * liefert die Header für die Table als Array
	 * @return
	 */
	public String[] getColumnNames()
	{
		return COLUMNNAMES; 
	}

}
