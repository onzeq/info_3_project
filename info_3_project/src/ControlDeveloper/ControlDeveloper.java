package ControlDeveloper;

import model.*;


public class ControlDeveloper {
	//Max Anzahl im Array
	public final int MAXCOMMANDS = 5;
	//Zaehler zum iterieren
	public int counter = 0;
	
	public String ControlDeveloper_Member = "MEMBER Control-Developer"; //nur fuer eine Instanz gültig , veränderter Wert nur für die eine Instanz verändert
	public static String ControlDeveloper_Class = "CLASS Control-Developer"; //Klassenvariable --> statische Variable verändert sich in allen Objekten der Klasse 
	
	//Array zum Speichern von Befehlen
	public Command commands[] = new Command[MAXCOMMANDS];
	
	//Konstruktor
	public ControlDeveloper() {}
	
	void createCommands(int com) {
		if (com ==1) {
			Direction d = new Direction("--");
			d.setDegree(50);
			commands[counter++] = d;
		}
		else if(com ==2) {
			Gear g  = new Gear("--");
			g.setSpeed(60);
			g.setDuration(50);
			commands[counter++] = g;
		}
		else if( com == 3) {
			Pause p = new Pause("--");
			p.setDuration(30);
			commands[counter++] = p;
		}
		
	}
	
	public void printCommands() {
		for(int i =0; i < counter; i++) {
			System.out.println(commands[i]);
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
