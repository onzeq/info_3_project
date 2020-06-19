package model;
import java.util.Vector;//for using the Vector class
/**
*	class that is a subject in the observer pattern
* 	@author christian, jakob
*/
public class ControlModelRegistry {

	private Vector<IControlModelListener> registry = new Vector<IControlModelListener>();
	
	//Constructor
	public ControlModelRegistry() {}

	/**
	 * adds a new ControlModelListener to registry
	 */
	public void addControlModelListener(IControlModelListener c) {
		//calls add method for vectors
		registry.add(c);
	}
	
	/**
	 * 
	 * Removes a certain CML fro registry
	 * @param CML we want to remove
	 */
	public void removeControlModelListener(IControlModelListener c) {
		//calls remove method for vectors and removes the transfer parameter c
		registry.remove(c);
	}
	
	/**
	 * Informs about certain message s Calls for every CML messageUpdated()
	 * @param s Message String
	 */
	public void notifyMessageChange(String message) {
		//all Listeners stored in the vector receive a message 
		for(int i = 0; i< registry.size(); i++) {
			
			registry.get(i).messageUpdated(message);
		}
			
	}
	
	/**
	 * Informs about new selected Rover, calls for all CMLs roverUpdated()
	 */
	public void notifyRoverChanged() {
		//all Listeners stored in the vector receive update
		for(int i = 0; i< registry.size(); i++) {
			registry.get(i).roverUpdated();
		}
	}
	
}
