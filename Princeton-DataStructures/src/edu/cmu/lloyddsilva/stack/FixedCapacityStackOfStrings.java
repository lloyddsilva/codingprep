package edu.cmu.lloyddsilva.stack;

public class FixedCapacityStackOfStrings {
	String[] data;
	int size;
	
	public FixedCapacityStackOfStrings(int capacity) {
		data = new String[capacity];
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public void push(String item) {
		data[size++] = item;
		
	}
	
	public String pop() {
		return data[--size];
	}

}
