package model;

/**
 * 
 * @author jakob
 * @version 1.0.
 */
public class Gear extends Command {
	private int speed;
	private int duration;
	
	/**
	 * 
	 * @param name Instanzvariable bekommt String uebergeben
	 */
	public Gear(String name) {
		super(name);
	}
	
	/**
	 * 
	 * @param speed setzt Wert fuer Geschwindigkeit, wenn au�erhalb der Grenzen, dann wird Grenzwert uebergeben
	 */
	public void setSpeed(int speed) {
		
		//innerhalb der Grenzen
		if(speed < 100 && speed > -100 ) {
			this.speed = speed;
		}
		//au�erhalb der Grenzen
		else if(speed > 100) {
			this.speed = 100;
		}
		else if(speed < -100) {
			this.speed = -100;
		}
		
	}
	/**
	 * 
	 * @param duration setzt die Dauer des Befehls
	 */
	public void setDuration(int duration) {
		this.duration = duration;
	}
	

}
