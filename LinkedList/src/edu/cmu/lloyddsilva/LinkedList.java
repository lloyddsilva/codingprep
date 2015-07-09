package edu.cmu.lloyddsilva;

public class LinkedList<T> {
	private Node<T> head;
	private int count;
	
	public LinkedList() {
		head = null;
		count = 0;
	}
	
	public void addHead(T data) {
		Node<T> current = new Node<T>(data);
		current.setNext(head);
		head = current;
		count++;
	}
	
	public int getCount() {
		return count;
	}
	
	public void removeHead() {
		head = head.getNext();
		count--;
	}
	
	public Node<T> find(T data) {
		Node<T> current = head;
		while(current!= null) {
			if(current.getData() == data) {
				return current;
			} 
			current = current.getNext();
		}
		return null;
	}
	
	public String toString() {
		StringBuffer output = new StringBuffer();
		output.append("{");
		
		Node<T> current = head;
		while(current!= null) {
			output.append("[" + current.toString() + "]");
			current = current.getNext();
		}
		
		output.append("}");
		return output.toString();
	}

}
