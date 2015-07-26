package edu.cmu.lloyddsilva.stack;

import edu.cmu.lloyddsilva.Node;

public class StackOfStrings {
	private Node head = null;
	
	public boolean isEmpty() {
		return head == null;
	}
	
	public void push(String item) {
		Node newNode = new Node(item); 
		newNode.next = head;
		head = newNode;
	}
	
	public String pop() {
		String item = (head != null) ? head.item : null;
		head = (head != null) ? head.next: null;
		return item;
	}
}
