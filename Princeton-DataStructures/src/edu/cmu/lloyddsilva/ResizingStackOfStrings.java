package edu.cmu.lloyddsilva;

public class ResizingStackOfStrings {
	String[] data;
	int size;
	
	public ResizingStackOfStrings() {
		data = new String[2];
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public void push(String item) {
		if(size == data.length) resize(2*data.length);
		data[size++] = item;
		
	}
	
	public String pop() {
		if(isEmpty()) 
			return null;
		else {
			String item = data[--size];
			data[size] = null;
			if(size > 0 && size <= data.length/4) 
				resize(data.length/2);
			
			return item;
		}
		
	}
	
	public void resize(int capacity) {
		String[] newData = new String[capacity];
		for(int i=0;i<capacity && i<data.length; i++) {
			newData[i] = data[i];
		}
		data = newData;
	}

}
