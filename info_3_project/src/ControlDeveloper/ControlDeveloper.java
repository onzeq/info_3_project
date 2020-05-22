package ControlDeveloper;

import model.*;


public class ControlDeveloper {
	//Max Anzahl im Array
	public final int MAXCOMMANDS = 5;
	//Zaehler zum iterieren
	public int counter = 0;
	
	public String ControlDeveloper_Member = "MEMBER Control-Developer"; //nur fuer eine Instanz g�ltig , ver�nderter Wert nur f�r die eine Instanz ver�ndert
	public static String ControlDeveloper_Class = "CLASS Control-Developer"; //Klassenvariable --> statische Variable ver�ndert sich in allen Objekten der Klasse 
	
	//Array zum Speichern von Befehlen
	public Command commands[] = new Command[MAXCOMMANDS];
	
	//Konstruktor
	public ControlDeveloper() {}
	
	/**
	 * Method to test other Methods without creating new command objects every time
	 */
	void createCommands() {
		//1
		Direction d1 = new Direction("--");
		d1.setDegree(50);
		commands[counter++] = d1;
		
		//2
		Gear g1 = new Gear("--");
		g1.setDuration(15);
		g1.setSpeed(70);
		commands[counter++] = g1;
		
		//3
		Pause p1 = new  Pause("--");
		p1.setDuration(10);
		commands[counter++] = p1;
		
		//4
		Direction d2 = new Direction("--");
		d2.setDegree(50);
		commands[counter++] = d2;
		
		//5
		Gear g2 = new Gear("--");
		g2.setDuration(15);
		g2.setSpeed(70);
		commands[counter++] = g2;
		
		
		
		
		
	}
		
	
	
	public void printCommands() {
		for(int i =0; i < counter; i++) {
			System.out.println(commands[i].getConfig());
		}
		
	}
	
	//Main funktion
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ControlDeveloper c1 = new ControlDeveloper();
		System.out.println(c1.ControlDeveloper_Member); //Zugriff ueber Objekt(Instanz)
		System.out.println(ControlDeveloper.ControlDeveloper_Class); //Zugriff ueber Klasse selbst
		
		
				

	}

}
