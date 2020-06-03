package model;
import java.util.Vector;//for using the Vector class
import java.util.Iterator;//for iterating through the Vector
public class ControlModelRegistry {

	private Vector<ControlModelListener> registry = new Vector();
	
	//Constructor
	public ControlModelRegistry() {}

	/**
	 * adds a new ControlModelListener to registry
	 */
	public void addControlModelListenerr(ControlModelListener c) {
		//calls add method for vectors
		registry.add(c);
	}
	
	/**
	 * 
	 * Removes a certain CML fro registry
	 * @param CML we want to remove
	 */
	public void removeControlModelListener(ControlModelListener c) {
		//calls remove method for vectors and removes the transfer parameter c
		registry.remove(c);
	}
	
	/**
	 * Informs about certain message s Calls for every CML messageUpdated()
	 * @param s Message String
	 */
	public void notifyMessageChange(String s) {
		Iterator a = registry.iterator();
		for(int i = 0; i< registry.size(); i++) {
			
			
		}
			
		
	}
	
	/**
	 * Informs about new selected Rover, calls for all CMLs roverUpdated()
	 * @param s 
	 */
	public void notifyRoverChanged() {
		
	}
	
}
