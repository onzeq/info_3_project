package model;
import hsrt.mec.controldeveloper.core.com.command.IGear;


/**
 * defines the class for a gear command, i.e. the speed and the duraration of the mobile device.
 * @author jakob
 * @version 1.0.
 */
@SuppressWarnings("serial")
public class Gear extends Command implements IGear{
	private int speed;
	private int duration;
	
	/**
	 * Constructor for gear sets name in superclass
	 * @param name Instanzvariable bekommt String uebergeben
	 */
	public Gear(String name) {
		super(name);
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
		
		//innerhalb der Grenzen
		if(speed < 100 && speed > -100 ) {
			this.speed = speed;
		}
		//auﬂerhalb der Grenzen
		else if(speed > 100) {
			this.speed = 100;
		}
		else if(speed < -100) {
			this.speed = -100;
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
	public String getConfig() {
		String config = "Name:  " + this.getName() +" "+  speed + " cm/sec " + duration + " sec";
		return config;
	}
	

}
