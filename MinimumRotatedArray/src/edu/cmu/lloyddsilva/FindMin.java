package edu.cmu.lloyddsilva;

/*
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 */

public class FindMin {
	public static void main(String[] args) {
		int[] input = new int[] {4, 5, 6, 7, 0, 1, 2};
		System.out.println(findMin(input));
	}
	
	public static int findMin(int[] nums) {
		int min = nums[0];
		for(int i=1; i<nums.length; i++) {
			if (nums[i] < min) {
				min = nums[i];
				break;
			}
		}
		
		return min;
	}
}
