package edu.cmu.lloyddsilva;

import java.util.Arrays;

public class ReverseArray {
	public static void main(String[] args) {
		int[] input = new int[] {6, 5,4,3,2,1};
		System.out.println(Arrays.toString(reverseInts(input)));
	}
	
	public static int[] reverseInts(int[] input) {
		for(int start=0, end=input.length-1; start < end; start++, end--) {
			int temp = input[start];
			input[start] = input[end];
			input[end] = temp;
		}
		return input;
	}
	
	
	public static int sumInts(int[] input) {
		int sum =0;
		
		for(int i=0; i<input.length; i++) {
			sum += input[i];
		}
			
		return sum;
	}
}
