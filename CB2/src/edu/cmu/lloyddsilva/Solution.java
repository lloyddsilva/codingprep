package edu.cmu.lloyddsilva;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int input = in.nextInt();
		
		System.out.println(getInversedNumber(input));
		
	}
	
	public static int getInversedNumber(int N) {
		String binaryInput = Integer.toBinaryString(N);
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<binaryInput.length(); i++) {
			if(binaryInput.charAt(i) == '1') {
				sb.append("0");
			} else {
				sb.append("1");
			}
		}
		
		int output = Integer.parseInt(sb.toString(), 2);
		return output;
	}
}
