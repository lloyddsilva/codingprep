package edu.cmu.lloyddsilva;

public class Queue {
	private Node first;
	private Node last;
	
	public void enqueue(int item) {
		if(last == null) {
			last = new Node(item);
			first = last;
		} else {
			last.setNext(new Node(item));
			last = last.getNext();
		}
	}
	
	public int dequeue() {
		if(first != null) {
			int output = first.getData();
			first = first.getNext();
			if(first == null) 
				last = null;
			return output;
		}
		return 0;
	}
	
}
