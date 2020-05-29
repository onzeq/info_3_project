package model;
/**
 * adds a command at the end of the list
 * @author Christian
 */
public class CommandList {
	/**
	 * class Variables for that are needed for creating a linked List
	 */
	//root gets no values in our implementation
	//just points to the first element with storage
	private Element root; 
	
	private int size = 0; //Parameter Size because of runtime
	/**
	 * constructor that creates a root element and sets next and prev element null
	 */
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
		Element command = new Element(c); //allocate new element
		
		command.setNext(null);
		//List is empty
		if (root.getNext() == null) {
			command.setPrev(null);
			root.setNext(command);
			this.size++;
			return c;
		}
		//List not empty append at the end
		while(current.getNext() != null) {
			current = current.getNext();
			
		}
		current.setNext(command);
		command.setPrev(current);
		this.size++;
		return c;
	}
	
	/**
	 * Method to check the content of the List
	 * @author jakob
	 */
	//help method for debugging 
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
		size = 0;
	}
	
	
	/**
	 * returns command instance in certain position pos, 
	 * if at least pos - elements in the list, else null
	 * @param pos
	 * @author Christian
	 * @return
	 */
	public Command getCommand(int pos) {
		if(pos <= size) //Checking for valid position 
		{
			return getElement(pos).getElement();
		}
		else
		{
			return null;
		}
				
	}
	

	/**
	 * returns element instance in Position pos, 
	 * if enough elements in the list, else null
	 * @param pos
	 * @author Christian
	 * @return
	 */
	private Element getElement(int pos) {
		if(pos <= size) //is pos in the list?
		{
			//go to pos and return the Element
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

	/**
	 * returns position number of command if its in the list, else -1
	 * @return
	 */
	public int getPos(Command c) {
		//if command isnt in comandlist return -1
		int pos = -1;
		int i = 0;
		Element temp = root;
		 //checking all elements for command c, count position and return it
		do
		{
			if(c.equals(temp.getElement()))
			{
				pos = i;
				return pos;
			}
			temp = temp.getNext();
			i++;
		}while(temp != null);
		
		//reaches if command not in the list
		return pos;
	}

	/**
	 * returns number of elements in the List
	 * @return  private size attribute 
	 */
	public int getSize() {
		//return size param that is counted in all add and remove methods
		return this.size;
	}
	
	/**
	 * moves command in Position pos one up and returns the command itself
	 * @param pos
	 * @return
	 * @Christian
	 */
	public Command moveUp(int pos) {
		//If element already at top or value is negative, operation not possible
		if(pos > size-1 || pos < 0) 
		{
			System.out.println("Operation nicht moeglich");
			return null;
		}
		//operation is possible
		else
		{
			//create elements that are needed
			Element emov = this.getElement(pos);
			Element eprev = emov.getPrev();
			Element enext1 = emov.getNext();
			Element enext2 = enext1.getNext();
			
			//catch error if at the begin of the list
			if(eprev != null) {
				eprev.setNext(enext1);
				enext1.setPrev(eprev);
			}
			else {
				this.root.setNext(enext1);
				enext1.setPrev(this.root);
			}
			//catch error if in the end of the list
			if(enext2 != null)//somewhere in the middle of the list
			{
				emov.setNext(enext2);
				enext2.setPrev(emov);
			}
			//if pos is second last element
			else {
				emov.setNext(null);
			}
			
			enext1.setNext(emov);
			emov.setPrev(enext1);
			
			return emov.getElement();
		}
	}

	/**
	 * moves command in Position pos one down and returns the command itself
	 * @param pos
	 * @Christian
	 */
	public Command moveDown(int pos) {
		//check if out of range or already first element
		if(pos > this.getSize() || pos <= 1) 
		{
			System.out.println("Operation nicht moeglich");
			return null;
		}
		//operation is possible
		else
		{
			Element emov = this.getElement(pos);
			Element eprev1 = emov.getPrev();
			Element eprev2 = eprev1.getPrev();
			Element enext = emov.getNext();
			
			//check: start of the list?
			if(eprev2 != null) {
				eprev2.setNext(emov);
				emov.setPrev(eprev2);
			}
			else //if start of the list, root is needed
			{
				this.root.setNext(emov);
				emov.setPrev(this.root);
			}
			
			
			eprev1.setNext(enext);
			eprev1.setPrev(emov);
			emov.setNext(eprev1);
			
			//return the moved Element
			return emov.getElement();
		}
	}

	/**
	 * Removes command in Position pos and returns it
	 *  if operation is successful
	 * @param pos
	 * @return
	 */
	public Command remove(int pos) {
		//create elements that are needed for the operation
		Element eremove = this.getElement(pos);
		Element eprev;
		Element enext;
		//chec wheter the element exists
		if(eremove != null)
		{
			eprev = eremove.getPrev();
			enext = eremove.getNext();
		}
		else
		{
			eprev = null;
			enext = null;
		}
		//if element is at a unvalid pos return null
		if(size == 0 ||  pos > size || pos <=0 || eremove == null)
		{
			System.out.println("Operation nicht moeglich");
			return null;
		}
		else if(pos == 1 && size == 1 ) // is only 1 element existing?
		{
			this.clear();
			return eremove.getElement();
		}
		else if(pos == 1 && size != 1) // element is at first place --> link root
		{
			root.setNext(enext);
			this.size--;
			return eremove.getElement();
		}
		else if(enext == null) //is element at end of the list
		{
			eprev.setNext(null);
			this.size--;
			return eremove.getElement();
		}		
		else //element is somewhere in the list
		{
			enext.setPrev(eprev);
			eprev.setNext(enext);
			this.size--;
			return eremove.getElement();
		}
		
	}


}

	

