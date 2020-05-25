package model;

public class CommandList {

	private Element root;
	public CommandList() {
		root = new Element(null);
		root.setNext(null);
		root.setPrev(null);
	}
	
	/**
	 * adds a command at the end of the list
	 * @param c 
	 * @return returns the command itself if operation works
	 */
	public Command add(Command c) {
		
		Element current = root;
		Element command = new Element(c);
		
		while(current.getNext() != null) {
			current = current.getNext();
		}
		current.setNext(command);
		
			
		return c;
	}
	
	/**
	 * Method to check the content of the List
	 */
	public void printList() {
		//Root itself is null, start at next element
		Element current = root.getNext();
		//as long as there is one more next element, print its config 
		while(current != null) {
			System.out.println(current.getElement().getConfig());
			//current gets the content of the next element(iterates through)
			current = current.getNext();
			
			
		}
	}
	
	/**
 	* clears the whole linked list --> content no longer accessable
 	*/
	public void clear() {
		//Content no longer accessable --> cleared or Memoery Leaks? Does the garbage collector the rest?
		root.setNext(null);	
	}
	
	
	/**
	 * returns command instance in certain position pos, 
	 * if at least pos - elements in the list, else null
	 * @param pos
	 * @return
	 */
	public Command getCommand(int pos) {
		if(pos <= this.getSize()) //Laufzeit jedesmal Funtkionsaufruf?
		{
			Element temp = root;
			for(int i = 0; i< pos; i++)
			{
				temp = temp.getNext();
			}
			return temp.getElement();
		}
		else
		{
			//test
			return null;
		}
				
	}
	

	/**
	 * returns element instance in Position pos, 
	 * if enough elements in the list, else null
	 * @param pos
	 * @return
	 */
	private Element getElement(int pos) {
		if(pos <= this.getSize()) //Laufzeit jedesmal Funtkionsaufruf?
		{
			Element temp = root;
			for(int i = 0; i< pos; i++)
			{
				temp = temp.getNext();
			}
			return temp;
		}
		else
		{
			return null;
		}
	}

	//TODO
	/**
	 * returns position number of command if its in the list, else -1
	 * @return
	 */
	public int getPos(Command c) { //Muss Methode auch mehrere gleiche Commands finden können?
		
		int size = this.getSize();
		int pos = -1;
		Element temp = root;
		
		for(int i = 0; i < size; i++)
		{
			if(c.equals(temp.getElement()))
			{
				pos = i;
				return pos;
			}
			temp = temp.getNext();
		}
		return pos;
	}

	/**
	 * returns number of elements in the List
	 * @return
	 */
	public int getSize() {
		
		Element temp = root;
		int counter = 0;
		while(temp.getNext() != null)
		{
			counter++;
			temp = temp.getNext();
		}
		return counter;
	}

	//TODO
	/**
	 * moves command in Position pos one up and returns the command itself
	 * @param pos
	 * @return
	 */
	public Command moveUp(int pos) {
		return null;
	}

	//TODO
	/**
	 * moves command in Position pos one down and returns the command itself
	 * @param pos
	 * @return
	 */
	public Command moveDown(int pos) {
		return null;
	}

	//TODO
	/**
	 * Removes command in Position pos and returns it
	 *  if operation is successful
	 * @param pos
	 * @return
	 */
	public Command remove(int pos) {
		return null;
	}


}

	

