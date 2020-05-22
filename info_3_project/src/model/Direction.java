package model;
import hsrt.mec.controldeveloper.core.com.command.IDirection;
/**
 * 
 * @author jakob
 * @version 1.0.
 */
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
	 * 
	 * @return liefert den Wert des Lenkwinkels zurück
	 */
	public int getDegree() {
		return degree;
	}
	
	/**
	 * 
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

}
