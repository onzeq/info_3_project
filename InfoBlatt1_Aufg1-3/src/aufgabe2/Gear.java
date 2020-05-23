package aufgabe2;
import hsrt.mec.controldeveloper.core.com.command.IGear;
/**
 * defines the class for a gear command
 * @author christian
 * @version 1.0.
 */
@SuppressWarnings("serial")

public class Gear extends Command implements IGear {
	private int speed;
	private int duration;
	
	public void setDuration(int _duration)
	{
		this.duration = _duration;
	}
	
	public Gear(String name) {
		super(name);
	}
	
	public void setSpeed(int _speed)
	{
		if(_speed > 100)
		{
			_speed = 100;
		}
		else if(_speed < -100)
		{
			_speed = -100;
		}
		this.speed = _speed;
	}
	
	public int getSpeed()
	{
		return speed;
	}
	
	public int getDuration()
	{
		return duration;
	}
	
	
	public String getConfig() {
		String config = "Name:  " + this.getName() +" "+  speed + " cm/sec " + duration + " sec";
		return config;
	}
	
}
