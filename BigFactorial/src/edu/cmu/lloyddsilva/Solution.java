package edu.cmu.lloyddsilva;

import java.math.BigInteger;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int input = in.nextInt();
        BigInteger output = BigInteger.ONE;
        for(int i=1; i<=input; i++) {
        	output = output.multiply(BigInteger.valueOf(i));
        }
		
        System.out.println(output);
	}
}
