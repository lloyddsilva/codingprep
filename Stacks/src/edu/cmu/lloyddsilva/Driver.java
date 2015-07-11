package edu.cmu.lloyddsilva;

public class Driver {
	public static void main(String[] args) {
		ResizingArrayStack stack = new ResizingArrayStack(10);
		for(int i=0; i<20; i++) {
			stack.push(i);
		}
		System.out.println(stack);
	}
}
