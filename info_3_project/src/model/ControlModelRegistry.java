package model;
import java.util.Vector;//for using the Vector class

public class ControlModelRegistry {

	private Vector<ControlModelListener> registry = new Vector();
	
	//Constructor
	public ControlModelRegistry() {}

	/**
	 * adds a new ControlModelListener to registry
	 */
	public void addControlModelListenerr(ControlModelListener c) {
		
	}
	
	/**
	 * 
	 * Removes a certain CML fro registry
	 * @param CML we want to remove
	 */
	public void removeControlModelListener(ControlModelListener c) {
		
	}
	
	/**
	 * Informs about certain message s Calls for every CML messageUpdated()
	 * @param s Message String
	 */
	public void notifyMessageChange(String s) {
		
	}
	
	/**
	 * Informs about new selected Rover, calls for all CMLs roverUpdated()
	 * @param s 
	 */
	public void notifyRoverChanged() {
		
	}
	
}
