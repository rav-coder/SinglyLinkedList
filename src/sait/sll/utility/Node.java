package sait.sll.utility;

import java.io.Serializable;
/**
 * 
 * Class Description:
 *
 * @author David, Rafael, Saurav
 * Reference: SLL Demo provided at SAIT, CPRG-251 Lecture
 */
public class Node implements Serializable
{
	private Object element;
	private Node successor;
	
	//Constructs a SLL node with element o and successor n
	public Node(Object o, Node n) {
		this.element = o;
		this.successor = n;
	}
	
	//Constructs the tail
	public Node(Object o) {
		this.element = o;
		this.successor = null;
	}
	//obtains the data within the node
	public Object getElement() {
		return element;
	}
	//sets new data into current node
	public void setElement(Object element) {
		this.element = element;
	}
	//obtains the next node
	public Node getSuccessor() { //getNext
		return successor;
	}
	//sets the next node
	public void setSuccessor(Node successor) { //setNext
		this.successor = successor;
	}
}
