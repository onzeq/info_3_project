package model;

/**
 * Class for three Commandtypes
 * @author jakob
 *
 */
public class CommandType {

	private String name;
	//Static Constants to reduce errors due to name spelling
	
	public static final String DIRECTION = "Direction";
	public static final String GEAR = "Gear";
	public static final String PAUSE = "Pause";
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
	
	
	/**
	 * returns name of command 
	 */
	public String toString() {
		return this.getName();
	}

}
