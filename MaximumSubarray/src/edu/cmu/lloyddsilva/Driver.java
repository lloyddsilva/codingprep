package edu.cmu.lloyddsilva;

public class Driver {
	public static void main(String[] args) {
		int[] nums = new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4};
		MaxSubarray max = new MaxSubarray();
		System.out.println(max.maxSubArray(nums));
		
	}

}
