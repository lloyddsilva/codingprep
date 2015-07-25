package edu.cmu.lloyddsilva;

import java.util.Scanner;

public class DriverStack {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		ResizingStackOfStrings stack = new ResizingStackOfStrings();
		
		while(true) {
			String input = in.nextLine();
			if(input.equals("-")) {
				System.out.println(stack.pop());
			}
			else {
				stack.push(input);
			}
		}
	}
}
