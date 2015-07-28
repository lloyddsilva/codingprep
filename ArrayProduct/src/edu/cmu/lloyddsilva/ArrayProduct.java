package edu.cmu.lloyddsilva;

import java.util.Arrays;

public class ArrayProduct {
	public static void main(String[] args) {
		int[] nums = new int[] {1, 2, 3, 4};
		System.out.println(Arrays.toString(productExceptSelfLeftRight(nums)));
	}
	
	public static int[] productExceptSelf(int[] nums) {
		int[] output = new int[nums.length];
		for(int x=0; x<output.length; x++)
			output[x] = 1;
		
		for(int i=0; i< nums.length; i++) {
			for(int j=0; j<nums.length; j++) {
				if( j!=i) output[i] *= nums[j];
			}
		}
		
		return output;
	}
	
	public static int[] productExceptSelfBest(int[] nums) {
		int n = nums.length;
	    int[] res = new int[n];
	    res[0] = 1;
	    for (int i = 1; i < n; i++) {
	        res[i] = res[i - 1] * nums[i - 1];
	    }
	    int right = 1;
	    for (int i = n - 1; i >= 0; i--) {
	        res[i] *= right;
	        right *= nums[i];
	    }
	    return res;
	}
	
	public static int[] productExceptSelfLeftRight(int[] nums) {
		int len = nums.length;
		int[] output = new int[len];
		int[] left = new int[len];
		int[] right = new int[len];
		
		left[0] = 1; 
		right[len-1] = 1;
		
		for(int i=1; i<len; i++) {
			left[i] = left[i-1] * nums[i-1];
			right[len-1-i] = right[len-i] * nums[len-i];
		}
		
		for(int k=0; k< len; k++) {
			output[k] = left[k] * right[k];
		}
		
		
		return output;
	}
}
