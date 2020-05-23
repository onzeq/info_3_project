package aufgabe2;
import hsrt.mec.controldeveloper.core.com.command.ICommand;
/**
 * defines the class for a command test123
 * @author christian
 * @version 1.0.
 */
@SuppressWarnings("serial")
public abstract class Command implements ICommand
{
	private String name;
	
	public Command(String s) //constructor
	{
		name = s;
	}
	public String getName()
	{
		return this.name;
	}
	public abstract String getConfig();
	
}
