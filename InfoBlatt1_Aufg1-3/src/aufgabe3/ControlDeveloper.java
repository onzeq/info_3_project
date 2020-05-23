package aufgabe3;
/**
 * Control Developer Class for Exercise 3
 * @author christian
 * @version 1.0.
 */

public class ControlDeveloper {
	
	public final int ANZAHL = 5; //constant value for lenght of object arraya asfdasdf
	public aufgabe2.Command[] commands = new aufgabe2.Command[ANZAHL]; //new Array of commands
	
	public void createCommands() //function for filling the array
	{	
		int counter = 0;
		aufgabe2.Direction d1 = new aufgabe2.Direction("direction1");
		d1.setDegree(-90);
		commands[counter] = d1;
		
		counter++;
		aufgabe2.Gear g1 = new aufgabe2.Gear("gear1");
		g1.setDuration(10);
		g1.setSpeed(100);
		commands[counter] = g1;
		
		counter++;
		aufgabe2.Gear g2 = new aufgabe2.Gear("gear2");
		g2.setDuration(10);
		g2.setSpeed(-100);
		commands[counter] = g2;
		
		counter++;
		aufgabe2.Direction d2 = new aufgabe2.Direction("direction2");
		d2.setDegree(90);
		commands[counter] = d2;
		
		counter++;
		aufgabe2.Pause p1 = new aufgabe2.Pause("pause1");
		p1.setDuration(10);
		commands[counter] = p1;	
	}
	
	public void printCommands() //looping through the array and printing the configs
	{
		for(int i = 0; i<ANZAHL; i++)
		{
			System.out.println(commands[i].getConfig());
		}
	}
	
	public static void main(String[] s) //main function that runs excercise 3
	{
		ControlDeveloper cd = new ControlDeveloper();
		cd.createCommands();
		System.out.println("Gebe die Command-Liste aus:");
		cd.printCommands();
		
	}
}
