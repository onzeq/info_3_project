package model;

import hsrt.mec.controldeveloper.core.com.command.IPause;


/**
 *  defines the class for a pause command, i.e. the duraration, how long the mobile device shall be paused.
 * @author jakob
 *
 */
@SuppressWarnings("serial")
public class Pause extends Command implements IPause {
	private int duration; //time in seconds
	
	/**
	 * constructor for pause class
	 * @param name sets name in superclass
	 */
	public Pause(String name) {
		super(name);
	}
	
	/**
	 * 
	 * @param duration sets value for duration attribut
	 */
	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	/**
	 * Returns the duration of the given pause command, how long the mobile device shall be paused.
	 * 
	 * @returns Duration of the given pause command
	 */
	public int getDuration() {
		return this.duration;
	}
	

}
