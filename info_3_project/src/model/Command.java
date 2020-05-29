package model;
import hsrt.mec.controldeveloper.core.com.command.ICommand;

/**
 * defines the method for naming commands
 * @author jakob
 * @version 1.0.
 * @
 */
@SuppressWarnings("serial")
//Abstract because getConfig is individually implemented for inherited classes 
//--> class has to be abstract so you cant create an instance of a class not fully implemented
public abstract class Command implements ICommand{
	
	//String for command name
	private String name;
	/**
	 * 
	 * @param name Name wird der Instanzvariable uebergeben
	 */
	public Command(String name){
		this.name = name;
	};

	/**
	 * returns private attribute "name"(concrete Command)
	 * @return name of given command
	 */
	public String getName() {
		return this.name;
	}
	public abstract String getConfig(); //getConfig gets implementd in the subclasses because they have different needs and parameters
}


