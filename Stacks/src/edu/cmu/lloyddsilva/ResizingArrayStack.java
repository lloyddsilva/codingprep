package edu.cmu.lloyddsilva;

public class ResizingArrayStack {
	private int size;
	private int[] data;
	
	public ResizingArrayStack(int capacity) {
		data = new int[capacity];
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public int size() {
		return size;
	}
	
	private void resize(int capacity) {
		if(capacity > size) {
			int[] temp = new int[capacity];
			for (int i=0; i<size; i++) {
				temp[i] = data[i];
			}
			data = temp;
		}
	}
	
	public void push(int item) {
		if(size == data.length) 
			resize(2*size);
		
		data[size++] = item;
	}
	
	public int pop() {
		if(!isEmpty()) {
			size--;
			return data[size];
		}	
		else
			return -1;
	}
	
	public int peek() {
		if(!isEmpty())
			return data[size-1];
		else
			return -1;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		for(int i=0; i<size; i++) {
			sb.append("{").append(data[i]).append("}");
		}
		sb.append("]");
		return sb.toString();
	}

}
