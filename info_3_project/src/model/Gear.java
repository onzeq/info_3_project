package model;
import hsrt.mec.controldeveloper.core.com.command.IGear;


/**
 * defines the class for a gear command, i.e. the speed and the duraration of the mobile device.
 * @author jakob
 * @version 1.0.
 */
@SuppressWarnings("serial")
public class Gear extends Command implements IGear{
	//private attributes to store values of speed and duration
	private static int MINSPEED = -100;
	private static int MAXSPEED = 100;
	private int speed;
	private int duration;
	
	/**
	 * Constructor for gear sets name in superclass
	 * @param name Instanzvariable bekommt String uebergeben
	 */
	public Gear(String name) {
		super(name); //calls constructor of superclass
	}
	
	/**
	 * Method which returns duration for certain gear command
	 * @return returns given duration
	 */
	public int getDuration() {
		return this.duration;
	}
	
	/**
	 * Returns the speed of the given gear command, with which speed the mobile device shall be moved
	 * @return returns given speed
	 */
	public int getSpeed() {
		return this.speed;
	}
	
	/**
	 * sets value for speed in gear command
	 * @param speed setzt Wert fuer Geschwindigkeit, wenn auﬂerhalb der Grenzen, dann wird Grenzwert uebergeben
	 */
	public void setSpeed(int speed) {
		
		//in range
		if(speed < MAXSPEED && speed > MINSPEED ) {
			this.speed = speed;
		}
		//out of range
		else if(speed > MAXSPEED) {
			this.speed = MAXSPEED;
		}
		else if(speed < MINSPEED) {
			this.speed = MINSPEED;
		}
		
	}
	/**
	 * sets duration for gear command
	 * @param duration setzt die Dauer des Befehls
	 */
	
	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	/**
	 * returns String with Configuration Infos
	 */
	//abstract from superclass implemented individally for Direction
	public String getConfig() {
		String config = "Name:  " + this.getName() +" "+  speed + " cm/sec " + duration + " sec";
		return config;
	}
	

}
