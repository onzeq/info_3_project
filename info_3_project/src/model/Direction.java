package model;
import hsrt.mec.controldeveloper.core.com.command.*;
/**
 * defines the class for a direction command, i.e. the degree, in which the mobile device shall be turned.
 * @author jakob
 * @version 1.0.
 */
@SuppressWarnings("serial")
public class Direction extends Command implements IDirection {
	
	private int degree; //Wertebereich [-90;90]
	
	/**
	 * 
	 * @param name Name wird der Instanzvariable uebergeben
	 */
	public Direction(String name) {
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
		if(value <90 && value > -90) {
			this.degree = value;
		}
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
	public String getConfig() {
		String config = "Name:  " + this.getName() +" "+  degree + " degree";
		return config;
	}
}
