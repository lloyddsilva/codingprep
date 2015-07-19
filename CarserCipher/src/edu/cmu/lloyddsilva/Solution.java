package edu.cmu.lloyddsilva;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int len = in.nextInt();
		in.nextLine();
		String input = in.nextLine();
		int shift = in.nextInt();
		
		System.out.println(caeserCipher(input, shift));
		
	}
	
	public static String caeserCipher(String input, int shift) {
		StringBuilder sb = new StringBuilder();
		shift = shift % 26;
		for(int i=0; i< input.length(); i++) {
			char temp = input.charAt(i);
			if(temp >= 'A' && temp <='Z') {
				sb.append(shiftChar(temp, 'A', shift));
			} else if(temp>='a' && temp <= 'z') {
				sb.append(shiftChar(temp, 'a', shift));
			}
			else {
				sb.append(temp);
			}
		}
		
		return sb.toString();
	}
	
	public static char shiftChar(char input, char base, int shift) {
		char temp = (char) ((input - base + shift) % 26);
		temp = (char) (base + temp);
		return temp;
	}
}
