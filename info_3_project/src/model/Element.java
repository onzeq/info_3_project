package model;

//import model.*;
public class Element {

	private Element next;
	private Element prev;
	private Command element;
	
	/**
	 * constructor, sets command as element 
	 * @param com
	 */
	public Element(Command com) {
		this.element = com;
	}
	
	/**
	 * returns Element itself
	 * @return
	 */
	public Command getElement() {
		return this.element;
	}
	
	/**
	 * sets next element
	 * @param el
	 */
	public void setNext(Element el) {
		this.next = el;
	}
	
	/**
	 * returns nextElement
	 * @return
	 */
	public Element getNext() {
		return this.next;
	}
	
	
	
	//TODO
	/**
	 * What in should be returned?? number of prev?
	 * @param el
	 * @return
	 */
	public int setPrev(Element el) {
		this.prev = el;
		return 0;
	}
	
	
	/**
	 * gets previous Command
	 * @return
	 */
	public Element getPrev() {
		return this.prev;
	}
	

}
