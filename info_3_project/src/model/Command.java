package model;

/**
 * 
 * @author jakob
 * @version 1.0.
 * @
 */
public abstract class Command {
	
	private String name;
	
	
	//In Aufgabe Rueckgabewert int, ist aber Konstruktor?!
	/**
	 * 
	 * @param name Name wird der Instanzvariable uebergeben
	 */
	public Command(String name){
		this.name = name;
	};
}


