package model;

import java.io.File;
import java.util.Vector;
import hsrt.mec.controldeveloper.core.com.IComListener;
import hsrt.mec.controldeveloper.core.com.command.ICommand;
import hsrt.mec.controldeveloper.io.ObjectFileHandler;
import hsrt.mec.controldeveloper.core.com.Rover;
import hsrt.mec.controldeveloper.core.com.RoverHandler;

public class ControlModel extends ControlModelRegistry implements IComListener{
	public static int NOROVERSELECTED = -1;
	private static ControlModel cM;
	private Rover selectedRover;
	
	
	/** TODO
	 * wo werden CommandType und CommandList gesetzt (Konstruktor)?
	 */
	private CommandType[] cT = new CommandType[3];
	private CommandList cL = new CommandList();
	
	
	/** TODO
	 * was muss in konsturktor nach singelton pattern ist konstruktor leer?!
	 */
	private ControlModel(){}
	
	//Singleton
	public static ControlModel getModel() //singelton verhindert das mehr als 1 object der klasse erzeugt werden kann
	{
		 if (ControlModel.cM == null) 
		 {
			 ControlModel.cM = new ControlModel();
			 return ControlModel.cM;
		 }
		 else {
			 System.out.println("Es gibt schon eine Instanz");
			 return null;
		 }
		 
	}
	
	public CommandList getCommandList()
	{
		return cL;
	}
	
	public CommandType[] getCommandTypes()
	{
		return cT;
	}
	
	public void setAvailableRover()
	{
		RoverHandler rH = new RoverHandler();
		Rover[] freeRovers = rH.getFreeRover();
		if(freeRovers != null) //Wenn Liste von freien Rovern nicht leer ist wird erster freier ausgewählt
		{
			selectedRover = freeRovers[0];
		}
	}
	
	public String getSelectedRoverId()
	{
		return selectedRover.getRoverID();
	}
	
	
	/**TODO
	 * Frage: Welcher ICommand Vector ?, reicht das so?, was soll passieren ohne return? 
	 * warum wird auf file konsturktor hingewiesen wenn ganzes file und keine pfad übergeben wird?
	 * was für ein Vector soll verwendet werden wenn in Objekt keiner angeben
	 * was soll passieren?
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
	
	/**TODO
	 * was für bool soll returned werden
	 * wie/über was starte/stoppe ich ausführung von Commandlist? -> in CommandList ist keine Methode vorhanden
	 */
	public boolean start()
	{
		return true;
	}
	public boolean stop()
	{
		return true;
	}
	
	
	/**TODO
	 * reicht implement um ControlModel als IComLisstener Observer zu machen?
	 * was soll in der Methode passieren?
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
