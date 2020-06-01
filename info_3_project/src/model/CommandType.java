package model;
import model.Command;
/**
 * Class for three Commandtypes
 * @author jakob
 *
 */
public class CommandType {

	private String name;
	
	//Constructor
	public CommandType(String name) {
		this.name = name;
	}
	
	/**
	 * returns the private Attribute Name
	 * @return private Attribute name
	 */
	public String getName() {
		return this.name;
	}
	
	//TODO
	/**
	 * if called it creates one of the three commandtypes
	 * @return
	 */
	public Command createInstance() {
		Command c = new Command();
		return c;
	}
	
	//TODO
	/**
	 * returns name of command WHERES THE DIFFERENCE TO getName?
	 */
	public String toString() {
		String s = "";
		return s;
	}

}
