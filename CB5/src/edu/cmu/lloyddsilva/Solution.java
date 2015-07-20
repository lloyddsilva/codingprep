package edu.cmu.lloyddsilva;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		//get input
		Scanner in = new Scanner(System.in);
		
		int N = in.nextInt();
		int[] input = new int[N];
		
		for(int i=0; i<N; i++) {
			input[i] = in.nextInt();
		}
		
		
		//solution
		int zeros_counter = 0;
		int ones_counter = 0;
		
		int total_ones_counter = 0;
		
		int max_zeros = 0;
		int current_zeros = 0;
		
		
		for(int j=0; j< input.length; j++) {
			if(zeros_counter < ones_counter) {
				zeros_counter = 0;
				ones_counter = 0;
			}
			
			if(input[j] == 1) {
				total_ones_counter++;
				ones_counter++;
			} else {
				zeros_counter++;
			}
			
			current_zeros = zeros_counter - ones_counter;
			
			max_zeros = Math.max(max_zeros, current_zeros);
		}	
		
		total_ones_counter += max_zeros;
		System.out.println(total_ones_counter);
		
	}
	
}
