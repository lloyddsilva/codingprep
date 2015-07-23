package edu.cmu.lloyddsilva;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PrioritizedQueue {
	private PriorityQueue<Node> queue;
	
	public PrioritizedQueue(int capacity) {
		queue = new PriorityQueue<Node>(capacity, 
				new Comparator<Node>() {
			public int compare(Node a, Node b) {
				if(a.timestamp > b.timestamp) 
					return 1;
				else if(a.timestamp == b.timestamp)
					return 0;
				else return -1;
			}
		});
	}
	
	public int size() {
		return queue.size();
	}
	
	public boolean add(Node data) {
		return queue.add(data);
	}
	
	
	class Data {
		Object data;
		long timestamp;
		Data next;
		
		public Data(Object data, long timestamp) {
			this.data = data;
			this.timestamp = timestamp;
		}
		
	}
}



