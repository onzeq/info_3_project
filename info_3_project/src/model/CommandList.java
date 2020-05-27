package model;

public class CommandList {

	private Element root;
	private int size = 0;
	public CommandList() {
		root = new Element(null);
		root.setNext(null);
		root.setPrev(null);
	}
	
	/**
	 * adds a command at the end of the list
	 * @author jakob
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
	 * @author Christian
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

	/**
	 * returns position number of command if its in the list, else -1
	 * @return
	 */
	public int getPos(Command c) {
		
		int pos = -1;
		int i = 0;
		Element temp = root;
		
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
		
//		Element temp = root;
//		int counter = 0;
//		while(temp.getNext() != null)
//		{
//			counter++;
//			temp = temp.getNext();
//		}
		return this.size;
	}


	

	//github.com/onzeq/info_3_project
	/**
	 * moves command in Position pos one up and returns the command itself
	 * @param pos
	 * @return
	 * @Christian
	 */
	public Command moveUp(int pos) {
		//If element already at top or value is negative, operation not possible
		if(pos > this.getSize() -1 || pos < 0) 
		{
			System.out.println("Operation nicht moeglich");
			return null;
		}
		
		
		else
		{
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
	 * @return
	 * @Christian
	 */
	public Command moveDown(int pos) {
		//check if out of range or already first element
		if(pos > this.getSize() || pos <= 1) 
		{
			return null;
		}
		
		else
		{
			Element emov = this.getElement(pos);
			Element eprev1 = emov.getPrev();
			Element eprev2 = eprev1.getPrev();
			Element enext = emov.getNext();
			
			if(eprev2 != null) {
				eprev2.setNext(emov);
				emov.setPrev(eprev2);
			}
			else
			{
				this.root.setNext(emov);
				emov.setPrev(this.root);
			}
			
			
			eprev1.setNext(enext);
			eprev1.setPrev(emov);
			emov.setNext(eprev1);
			
			
			return emov.getElement();
		}
	}

	//TODO
	/**
	 * Removes command in Position pos and returns it
	 *  if operation is successful
	 * @param pos
	 * @return
	 */
	public Command remove(int pos) {
		Element eremove = this.getElement(pos);
		Element eprev = eremove.getPrev();
		Element enext = eremove.getNext();
		if(size == 0 ||  pos > size || pos <=0 || eremove == null)
		{
			return null;
		}
		else if(pos == 1 && size == 1 )
		{
			this.clear();
			return eremove.getElement();
		}
		else if(pos == 1 && size != 1)
		{
			root.setNext(enext);
			this.size--;
			return eremove.getElement();
		}
		else if(enext == null)
		{
			eprev.setNext(null);
			this.size--;
			return eremove.getElement();
		}		
		else
		{
			enext.setPrev(eprev);
			eprev.setNext(enext);
			this.size--;
			return eremove.getElement();
		}
		
	}


}

	

