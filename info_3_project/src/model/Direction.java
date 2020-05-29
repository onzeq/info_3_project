package model;
import hsrt.mec.controldeveloper.core.com.command.*;
/**
 * defines the class for a direction command, i.e. the degree, in which the mobile device shall be turned.
 * @author jakob
 * @version 1.0.
 */
@SuppressWarnings("serial")
public class Direction extends Command implements IDirection {
	
	//private attribute for storing the steering degree value
	private int degree;
	
	/**
	 * 
	 * @param name Name wird der Instanzvariable uebergeben
	 */
	public Direction(String name) {
		//sets the name in the superclass, calls constructor of superclass
		super(name);
	}
	
	/**
	 * returns value of steer degree
	 * @return liefert den Wert des Lenkwinkels zurück
	 */
	public int getDegree() {
		return degree;
	}
	
	/**
	 * sets value for steer degree in a cetain range
	 * @param value Wert wird der Instanzvariablen uebergeben, wenn Wert außerhalb der Grenzen, wird Grenzwert uebergeben
	 */
	public void setDegree(int value) {
		//in range
		if(value <90 && value > -90) {
			this.degree = value;
		}
		//out of range
		else if(value < -90) {
			this.degree = -90;
		}
		else if(value > 90) {
			this.degree = 90;
		}
	}

	/**
	 * returns String with Configuration Infos
	 */
	//abstract from superclass implemented individally for Direction
	public String getConfig() {
		String config = "Name:  " + this.getName() +" "+  degree + " degree";
		return config;
	}
}
