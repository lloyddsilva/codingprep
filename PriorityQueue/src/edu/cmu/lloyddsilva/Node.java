package edu.cmu.lloyddsilva;

public class Node {
	Object data;
	long timestamp;
	Node next;
	
	public Node(Object data, long timestamp) {
		this.data = data;
		this.timestamp = timestamp;
	}
	
}
