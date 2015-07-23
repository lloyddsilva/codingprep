package edu.cmu.lloyddsilva;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;

public class FibonacciSeries {
	private static ArrayList<BigInteger> fibonacciCache = new ArrayList<BigInteger>();
	
	static {
		fibonacciCache.add(BigInteger.ZERO);
		fibonacciCache.add(BigInteger.ONE);
	}
	
	public static BigInteger getFibonacci(int index) {
		if(index >= fibonacciCache.size()) {
			fibonacciCache.add(index, getFibonacci(index-1).add(getFibonacci(index-2)));
		}
		return fibonacciCache.get(index);
	}
	
	public static BigInteger getFibonacciIterative(int index) {
		BigInteger first = BigInteger.ZERO;
		BigInteger second = BigInteger.ONE;
		for(int i=0; i < index; i++) {
			BigInteger temp = first; 
			first = second;
			second = second.add(temp);
		}
		
		return first;
	}
	
	public static BigInteger getFibonacciRecursive(int index) {
		if(index <= 1) {
			return BigInteger.valueOf(index);
		} else {
			return getFibonacciRecursive(index-1).add(getFibonacciRecursive(index-2));
		}
	}
	
	public static BigInteger[] getFibonacciArray(int index) {
		BigInteger[] fibonacciArray = new BigInteger[index];
		
		for(int i=0; i<index; i++) {
			fibonacciArray[i] = getFibonacci(i);
		}
		
		return fibonacciArray;
	}
	
	public static void main(String[] args) {
		//Generate Fibonacci
		for(int i=0; i<30; i++) {
			System.out.print(getFibonacci(i) + " ");
		}
		
		System.out.println();
		
		//Return Fibonacci as array
		System.out.println(Arrays.toString(getFibonacciArray(10)));
	}
	 
}
