package model;

import java.io.File;
import java.util.Vector;
import hsrt.mec.controldeveloper.core.com.IComListener;
import hsrt.mec.controldeveloper.core.com.command.ICommand;
import hsrt.mec.controldeveloper.io.ObjectFileHandler;
import hsrt.mec.controldeveloper.core.com.Rover;

public class ControlModel extends ControlModelRegistry implements IComListener{
	public static int NOROVERSELECTED = -1;
	private static ControlModel cM;
	private CommandType[] cT = new CommandType[3];
	private CommandList cL = new CommandList();
	private Rover selectedRover;
	
	private ControlModel(){}
	public static ControlModel getModel() //singelton verhindert das mehr als 1 object der klasse erzeugt werden kann
	{
		 if (ControlModel.cM == null) 
		 {
			 ControlModel.cM = new ControlModel();
		 }
		 return ControlModel.cM;
	}
	public CommandList getCommandList()
	{
		return cL;
	}
	public CommandType[] getCommandTypes()
	{
		return cT;
	}
	
	
	/**TODO
	 * Frage: Welcher ICommand Vector ?, reicht das so?, was soll passieren ohne return? 
	 * 
	 */
	public void readCommands(File f) //warum wird auf file konsturktor hingewiesen wenn ganzes file und keine pfad übergeben wird?
	{
		Vector<ICommand> vC = new Vector<ICommand>();
		ObjectFileHandler oF = new ObjectFileHandler(f); //Handler to read
		oF.read(vC);
	}
	public void writeCommands(File f)
	{
		Vector<ICommand> vC = new Vector<ICommand>(); //was für ein Vector soll verwendet werden wenn in Objekt keiner angeben
		ObjectFileHandler oF = new ObjectFileHandler(f); //Handler to write
		oF.write(vC); //was soll gemacht werden
	}
	//TODO
	public boolean start()
	{
		return true;
	}
	//TODO
	public boolean stop()
	{
		return true;
	}
	//TODO
	public void setAvailableRover()
	{
		
	}
	//TODO
	public String getSelectedRoverId()
	{
		return "";
	}
	//TODO
	public void commandPerformed(ICommand c, int i)  //c ist ausgeführtes Commando; i ist ComHandler status  
	{
		//was soll hier passieren? bekommt ausgeführten command und status aber was soll er damit anstellen?
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
