package edu.cmu.lloyddsilva;

import java.util.Arrays;

public class TwoSumSorted {
	public static void main(String[] args) {
		int[] input = new int[] {-1, 0, 1,2,3,5,6,7};
		System.out.println(Arrays.toString(twoSum(input, 3)));
		
	}
	
	public static int[] twoSum(int[] input, int sum) {
		for(int i=0; i<input.length; i++) {
			int rem = sum - input[i];
			int pos = binarySearch(input, rem, i+1, input.length);
			if(pos >= 0) {
				return new int[] {i+1, pos+1};
			}
		}
		
		return new int[] {0,0};
	}
	
	public static int binarySearch(int[] input, int key, int start, int end) {
		int left = start; 
		int right = end;
		
		while(left < right) {
			int med = (left + right) / 2;
			if(input[med] == key) { 
				return med;
			} else if(input[med] < key) {
				left = med+1;
			} else {
				right = med;
			}
		}
		
		return -1;
 	}
}
