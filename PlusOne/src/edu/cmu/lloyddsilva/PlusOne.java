package edu.cmu.lloyddsilva;

import java.util.Arrays;

public class PlusOne {
	public static void main(String[] args) {
		int[] digits = new int[] {1,4,2,1};
		System.out.println(Arrays.toString(plusOne(digits)));
		
		digits = new int[] {9,9,9,9};
		System.out.println(Arrays.toString(plusOne(digits)));
	}
	
	public static int[] plusOne(int[] digits) {
		int len = digits.length;
		int[] output = new int[digits.length];
		int carry = 1;
		int sum = 0;
		for(int i=len-1; i>=0; i--) {
			sum = digits[i] + carry;
			carry = sum / 10;
			sum = sum % 10;
			output[i] = sum;
		}
		
		if(carry > 0) {
			int[] newOutput = new int[digits.length + 1];
			newOutput[0] = carry;
			for(int i=0; i<output.length;i++) {
				newOutput[i+1] = output[i];
			}
			output = newOutput;
		}
		
		
		return output;
	}
}
