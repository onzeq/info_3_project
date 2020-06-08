package ControlDeveloper;
import model.*;
import hsrt.mec.controldeveloper.core.com.command.ICommand;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Random;
import java.util.Vector;
import java.io.FileWriter; 
import hsrt.mec.controldeveloper.io.ObjectFileHandler;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ControlDeveloper {
	//Max Anzahl im Array
	public final int MAXCOMMANDS = 5;
	//Zaehler zum iterieren
	public int counter = 0;
	
	public String ControlDeveloper_Member = "MEMBER Control-Developer"; //nur fuer eine Instanz gültig , veränderter Wert nur für die eine Instanz verändert
	public static String ControlDeveloper_Class = "CLASS Control-Developer"; //Klassenvariable --> statische Variable verändert sich in allen Objekten der Klasse 
	
	private static String PATH = "file.obj";
	//Array zum Speichern von Befehlen
	public Command commands[] = new Command[MAXCOMMANDS];

	//Konstruktor
	public ControlDeveloper() {}
	
	/**
	 * Method to test other Methods without creating new command objects every time
	 */
	void createCommands() {
		//sores random number for switch case
		int commandCase = 0;
		int index = 0;
		Random generator = new Random();
		//executes as long as the MAXCOMMANDS is
		for (int i = 0; i < MAXCOMMANDS; i++) {
			//number from 1 to (including) 3
			commandCase = 1+ generator.nextInt(3);
			
			//switch case to choose kind of command
			switch (commandCase) {
			case 1: 
				index = i+1;
				Direction d = new Direction(Integer.toString(index));
				d.setDegree(-90 + generator.nextInt(180));
				commands[i] = d;
				
				break;
			
			case 2: 
				index = i+1;
				Gear g = new Gear(Integer.toString(index));
				
				g.setDuration(1 + generator.nextInt(200));
				g.setSpeed(-100 + generator.nextInt(200));
				commands[i] = g;
				break;
			
			case 3:
				index = i+1;
				Pause p = new Pause(Integer.toString(index));
				p.setDuration(1 + generator.nextInt(200));
				commands[i] = p;
			default:
				break;
			}
			
		}

	}
	
	/**
	 * Looping through the array and printing all configs
	 */
	public void printCommands() {
		for(int i =0; i < MAXCOMMANDS; i++) {
			System.out.println(commands[i].getConfig());
		}
	}
	
	//Main funktion
	public static void main(String[] args) throws IOException {
		//Aufgabe 1:
		ControlDeveloper c1 = new ControlDeveloper();
		System.out.println(c1.ControlDeveloper_Member); //Zugriff ueber Objekt(Instanz)
		System.out.println(ControlDeveloper.ControlDeveloper_Class); //Zugriff ueber Klasse selbst
		
		//Aufgabe 2/3:
		System.out.println("Anzahl commands:" + Integer.toString(c1.MAXCOMMANDS));
		c1.createCommands();
		System.out.println("Ausgabe Commands:");
		c1.printCommands();
		
		
		//Aufgabe 4:
		System.out.println("Befüllen der Liste");
		CommandList cl1 = new CommandList();
		for (int i = 0; i < c1.MAXCOMMANDS; i++) {
			cl1.add(c1.commands[i]);
		}
		
		Vector<ICommand> vectorList = new Vector<ICommand>();
		vectorList.add(cl1.getCommand(1));
		vectorList.add(cl1.getCommand(2));
		vectorList.add(cl1.getCommand(3));
		vectorList.add(cl1.getCommand(4));
		vectorList.add(cl1.getCommand(5));
		System.out.println(vectorList);
		
		File testfile = new File("C:\\Users\\Christian\\Desktop\\objects\\file.obj");
		if(testfile.createNewFile()) 
		{
		    System.out.println("File created: " + testfile.getName());
		    testfile.setWritable(true);
		} 
		else 
		{
		    System.out.println("File already exists.");
		}
		FileOutputStream fileOut = new FileOutputStream(testfile);
	    ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
	    objectOut.writeObject(vectorList);
	    objectOut.close();
	    
		
	}
	

}
