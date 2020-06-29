package ControlDeveloper;
import model.*;
import view.ControlUI;
import view.PanelCommandTypes;
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
		ControlDeveloper c1 = new ControlDeveloper();
		c1.createCommands();
		c1.printCommands();
		System.out.println("Befüllen der Liste");
		CommandList cl1 = new CommandList();
		for (int i = 0; i < c1.MAXCOMMANDS; i++) {
			cl1.add(c1.commands[i]);
			System.out.println(i);
		}
		System.out.println(cl1.getCommand(0).getConfig());
		cl1.printList();
		
		System.out.println("Nach verschieben");
		
		
		cl1.printList();
		System.out.println("MoveUp");
		cl1.moveUp(0);
		cl1.printList();
		System.out.println("MoveDown");
		cl1.moveDown(1);
		cl1.printList();
		System.out.println("MoveUp");
		cl1.moveUp(0);
		cl1.printList();
		/*ControlDeveloper c1 = new ControlDeveloper();
		c1.createCommands();
		c1.printCommands();
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
		
		File testfile = new File("C:\\Users\\Christian\\Desktop\\objects\\file.txt");
		//Singelton erstellen:
		ControlModel cM = ControlModel.getModel();
		CommandList cL2 = cM.getCommandList();
		for (int i = 0; i < c1.MAXCOMMANDS; i++) {
			cL2.add(c1.commands[i]);
		}
		cM.writeCommands(testfile);
		System.out.println("Cleared the list:");
		cL2.clear();
		int size = cL2.getSize();
		for(int i = 1; i <= size; i++)
		{
			System.out.println(cL2.getCommand(i));
		}
		
		cM.readCommands(testfile);
		System.out.println("Filled the list:");
		size = cL2.getSize();
		for(int i = 1; i <= size; i++)
		{
			System.out.println(cL2.getCommand(i));
		}
		
		
		CommandType cT = new CommandType(CommandType.DIRECTION);
		System.out.println(cT.getName());
		Command Test = cT.createInstance();
		System.out.println(Test);*/
		//ControlModel cM = cM.getModel();
		//ControlUI cUI = new ControlUI();
		//PanelCommandTypes view = new PanelCommandTypes(cM, cUI);
		//view.setView
		
		ControlUI ui = new ControlUI();
		ui.setVisible(true);
	}
	

}
