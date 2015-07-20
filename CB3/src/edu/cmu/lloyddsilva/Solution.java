package edu.cmu.lloyddsilva;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int d = in.nextInt();
		
		int[] input = new int[n];
		
		//get input
		for(int i=0; i<n; i++) {
			input[i] = in.nextInt();
		}
		
		//sort input O(nlogn)
		Arrays.sort(input);
		
		//Create HashSet O(n)
		HashSet<Integer> set = new HashSet<Integer>();
		for(int x=0; x<input.length; x++) {
			set.add(input[x]);
		}
		
		int counter = 0 ;
		//iterate once and see if input + delta exists, O(n)
		for(int j=0; j<input.length;j++) {
			if(set.contains(input[j] + d)) {
				counter++;
			}
		}
		
		System.out.println(counter);
	}
}
