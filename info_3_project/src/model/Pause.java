package model;

public class Pause extends Command {
	private int duration; //time in seconds
	
	public Pause(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	
	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	

}
