package model;

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
		//What does to call looks like? How does Method know, which case
		
		switch (this.name) {
		case "Direction":
			Direction d = new Direction("Direction");
			return d;
			
			
		case "Gear":
			Gear g = new Gear("Gear");
			return g;
			
		
		case "Pause":
			Pause p = new Pause("Pause");
			return p;
			
		default:
			return null;
			
		}
		
	}
	
	//TODO
	/**
	 * returns name of command 
	 */
	//WHERES THE DIFFERENCE TO getName?
	public String toString() {
		return this.getName();
	}

}
