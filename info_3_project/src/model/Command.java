package model;
import hsrt.mec.controldeveloper.core.com.command.ICommand;

/**
 * defines the method for naming commands
 * @author jakob
 * @version 1.0.
 * @
 */
@SuppressWarnings("serial")
public abstract class Command implements ICommand{
	
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
}


