package edu.cmu.lloyddsilva;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		int num = in.nextInt();
		
		for(int i=1; i<=num; i++) {
			if(i % 15 == 0) {
				System.out.println("BooHoo");
			} else if (i % 5 == 0) {
				System.out.println("Hoo");
			} else if (i % 3 == 0) {
				System.out.println("Boo");
			} else {
				System.out.println(i);
			}
		}
		
	}
}
