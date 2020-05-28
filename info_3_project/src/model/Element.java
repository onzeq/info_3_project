package model;
/**
 * defines the Elements in the linked List
 * @author Christian
 * @version 1.0.
 */

public class Element {
	/**
	 * class variables for a list element
	 */
	private Element next;
	private Element prev;
	private Command element;
	
	/**
	 * constructor, sets command as element 
	 * @param com
	 */
	public Element(Command com) {
		this.element = com;
		this.next = null;
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
	
	/**
	 * set previous Element in the List
	 * @param el
	 * @return
	 */
	public void setPrev(Element el) {
		this.prev = el;
	}
	
	/**
	 * gets previous Command
	 * @return
	 */
	public Element getPrev() {
		return this.prev;
	}
}
