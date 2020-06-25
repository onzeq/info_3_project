package model;
/**
 * Class part of observer pattern
 * @author christian
 *
 * With next sheet:
 * 	link with RoverHandler
 * 	link with ComHanlder
 * 	link with FileHandler
 * 	fill commandperformed
 * -->To now just build the casing of the code
 * 
 */
import java.io.File;
import java.util.Vector;

import hsrt.mec.controldeveloper.core.com.ComHandler;
import hsrt.mec.controldeveloper.core.com.IComListener;
import hsrt.mec.controldeveloper.core.com.command.ICommand;
import hsrt.mec.controldeveloper.io.ObjectFileHandler;
import hsrt.mec.controldeveloper.core.com.Rover;
import hsrt.mec.controldeveloper.core.com.RoverHandler;

public class ControlModel extends ControlModelRegistry implements IComListener{
	
	public final static int NOROVERSELECTED = -1;
	private final String PATH = "";
	private static ControlModel cM;
	private Rover selectedRover;
	private CommandType[] cT = new CommandType[3];
	private CommandList cL = new CommandList();
	
	
	/** 
	 * Consturctor fills Commandtype
	 */
	private ControlModel(){ //Übergabe für Testzwecke
		
		cT[0] = new CommandType(CommandType.DIRECTION);
		cT[1] = new CommandType(CommandType.GEAR);
		cT[2] = new CommandType(CommandType.PAUSE);
			
	}
	
	/**
	 * method to return the ControlModel --> Singelton only allows one Control Model object to exist
	 */
	public static ControlModel getModel() 
	{
		 if (ControlModel.cM == null) 
		 {
			 ControlModel.cM = new ControlModel();
			 return ControlModel.cM;
		 }
		 else {
			 System.out.println("ControlModel already exists");
			 return cM;
		 }	 
	}
	
	/**
	 * return the commandlist
	 */
	public CommandList getCommandList()
	{
		return cL;
	}
	
	/**
	 *return the commandtypes
	 */
	public CommandType[] getCommandTypes()
	{
		return cT;
	}
	
	/**
	 * method to select first free rover
	 */
	public void setSelectedRover()
	{
		//RoverObject just for testing purpose/ no errors 
		
		RoverHandler rH = new RoverHandler();
		Rover[] freeRovers = rH.getFreeRover();
		if(freeRovers != null) //Wenn Liste von freien Rovern nicht leer ist wird erster freier ausgewählt
		{
			selectedRover = freeRovers[0];
		}
	}
	
	/**
	 * return selected RoverId
	 */
	public String getSelectedRoverId()
	{
		return selectedRover.getRoverID();
	}
	
	
	/**
	 * Method to Read/Write a CommandVectorFile --> implement in next excercise
	 */
	public void readCommands(File f) 
	{
		
		Vector<ICommand> vC = new Vector<ICommand>();
		ObjectFileHandler oF = new ObjectFileHandler(f); //Handler to read
		
		oF.read(vC);
		if(vC.isEmpty())
		{
			System.out.println("Error, empty Vector");
		}
		else
		{
			cL.clear();
			int size = vC.size();
			for(int i = 0; i < size ; i++)
			{
				cL.add((Command) vC.get(i));
			}
			System.out.println("Read succesful!");
		}
		
		
	}
	public void writeCommands(File f)
	{
		Vector<ICommand> vC = new Vector<ICommand>(); 
		ObjectFileHandler oF = new ObjectFileHandler(f); //Handler to write
		
		int size = cL.getSize();
		for(int i = 0; i < size; i++)
		{
			vC.add(cL.getCommand(i));
			//System.out.println(vC.elementAt(i-1).getName());
		}
		
		boolean check = oF.write(vC);
		if(check == true)
		{
			System.out.println("Succesfully saved");
		}
		else
		{
			System.out.println("Error while saving");
		}
	}
	
	/**
	 * method to start running the commandList commands
	 */
	public boolean start()
	{
		ComHandler cM = ComHandler.getInstance();
		Vector<ICommand> vC = new Vector<ICommand>();
		int size = cL.getSize();
		for(int i = 0; i < size; i++)
		{
			vC.add(cL.getCommand(i));
		}
		return cM.start(vC, selectedRover);
	}
	/**
	 * method to stop the commandlist commands --> ComHandler gets implemented in next sheet
	 */
	public boolean stop()
	{
		ComHandler cM = ComHandler.getInstance();
		return cM.stop();
	}
	
	
	/**
	 * method commandPerformed gives information about performed Commands --> next sheet
	 */
	public void commandPerformed(ICommand c, int comHandlerState)  //c ist ausgeführtes Commando; i ist ComHandler status  
	{
		switch (comHandlerState) {
		case ComHandler.CONNECTION_ERROR:
			System.out.println("Connection Error");
			break;
		case ComHandler.ROVER_FINISH_ICOMMAND:
			System.out.println("Rover finished Command: " + c.getName());
			break;
		case ComHandler.ROVER_IS_USED:
			System.out.println("Rover is used");
			break;
		case ComHandler.ROVER_NOT_SELECTED:
			System.out.println("Rover not selected");
			break;
		case ComHandler.ROVER_RECEIVE_ICOMMAND:
			System.out.println("Rover Receive Command: "+ c.getName());
			break;
		case ComHandler.ROVER_RUNNING_ICOMMAND:
			System.out.println("Command executed: "+c.getName());
			break;
		case ComHandler.SEND_ICOMMAND:
			System.out.println("Send Command to Rover: "+ c.getName());
			break;
		default:
			break;
		}
	}
	
}
