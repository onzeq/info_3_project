package aufgabe2;
import hsrt.mec.controldeveloper.core.com.command.*;
/**
 * defines the class for a direction command
 * @author christian
 * @version 1.0.
 */
@SuppressWarnings("serial")
public class Direction extends Command implements IDirection {
	
	private int degree;
	
	public Direction(String name) {
		super(name);
	}
	
	public int getDegree() {
		return degree;
	}
	
	public void setDegree(int _degree)
	{
		if(_degree > 90)
		{
			_degree = 90;
		}
		else if(_degree < -90)
		{
			_degree = -90;
		}
		
		degree = _degree;
	}
	
	public String getConfig() { //Creates a config string to be printed laterly
		String config = "Name:  " + this.getName() +" "+  degree + " degree";
		return config;
	}
}
