package edu.cmu.lloyddsilva;

import java.util.Arrays;
import java.util.HashMap;

// this assumes no duplicates and one solution always exists

public class TwoSum {
	public static void main(String[] args) {
		int[] input = new int[] {-1, 0, 1,2,3,4,5,6,7};
		System.out.println(Arrays.toString(twoSum(input, 8)));
		
	}
	
	public static int[] twoSumBest(int[] numbers, int target) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int[] result = new int[2];
	 
		for (int i = 0; i < numbers.length; i++) {
			if (map.containsKey(numbers[i])) {
				int index = map.get(numbers[i]);
				result[0] = index+1 ;
				result[1] = i+1;
				break;
			} else {
				map.put(target - numbers[i], i);
			}
		}
	 
		return result;
	}
	
	public static int[] twoSum(int[] input, int sum) {
		int[] output = new int[]{0,0};
		
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i=0; i< input.length; i++) {
			map.put(input[i], i);
		}
		
		for(int j=0; j<input.length; j++) {
			int remainder = sum-input[j];
			if(map.containsKey(remainder)) {
				return new int[]{j+1, map.get(remainder) +1};
			}
		}
		
		return output;
	}
}
