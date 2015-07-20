package edu.cmu.lloyddsilva;

import java.util.Scanner;

public class FizzBuzz {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int num = in.nextInt();
		
		if(num % 15 == 0) {
			System.out.println("FizzBuzz");
		} else if (num % 5 == 0) {
			System.out.println("Buzz");
		} else if (num % 3 == 0) {
			System.out.println("Fizz");
		} else {
			System.out.println(num);
		}
	}
}
