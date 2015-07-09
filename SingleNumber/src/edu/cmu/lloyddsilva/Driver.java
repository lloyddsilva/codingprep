package edu.cmu.lloyddsilva;

public class Driver {
	public static void main(String[] args) {
		int[] input = new int[] {9, 2, 3, 4, 5, 4, 5, 3, 2};
		
		SingleNumberXOR singleNumber = new SingleNumberXOR();
		
		System.out.println(singleNumber.singleNumber(input));
		
	}
}
