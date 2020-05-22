package model;
import hsrt.mec.controldeveloper.core.com.command.ICommand;

/**
 * 
 * @author jakob
 * @version 1.0.
 * @
 */
public abstract class Command implements ICommand{
	
	private String name;
	
	
	//In Aufgabe Rueckgabewert int, ist aber Konstruktor?!
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


