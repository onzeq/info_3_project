package aufgabe2;
import hsrt.mec.controldeveloper.core.com.command.IPause;
/**
 * defines the class for a pause command
 * @author christian
 * @version 1.0.
 */
@SuppressWarnings("serial")
public class Pause extends Command implements IPause {
	private int duration;
	
	public Pause(String name) {
		super(name);
	}
	
	public void setDuration(int _duration)
	{
		duration = _duration;
	}
	
	public int getDuration()
	{
		return duration;
	}
	
	public String getConfig() {
		String config = "Name:  " + this.getName() +" "+ duration + " sec";
		return config;
	}
}
