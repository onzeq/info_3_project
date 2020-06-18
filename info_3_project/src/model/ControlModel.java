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
	 * Empty constructor
	 */
	private ControlModel(){}
	
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
			 return null;
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
	}
	public void writeCommands(File f)
	{
		Vector<ICommand> vC = new Vector<ICommand>(); 
		ObjectFileHandler oF = new ObjectFileHandler(f); //Handler to write
		oF.write(vC);
	}
	
	/**
	 * method to start running the commandList commands
	 */
	public boolean start()
	{
		ComHandler cM = null;
		Vector<ICommand> vC = new Vector<ICommand>(); 
		return cM.start(vC, selectedRover);
	}
	/**
	 * method to stop the commandlist commands --> ComHandler gets implemented in next sheet
	 */
	public boolean stop()
	{
		ComHandler cM = null;
		return cM.stop();
	}
	
	
	/**
	 * method commandPerformed gives information about performed Commands --> next sheet
	 */
	public void commandPerformed(ICommand c, int comHandlerState)  //c ist ausgeführtes Commando; i ist ComHandler status  
	{
		if(c == null)
		{
			//kein Kommando ausgeführt
		}
		else
		{
			//Kommando c ausgeführt
		}
	}
	
}
