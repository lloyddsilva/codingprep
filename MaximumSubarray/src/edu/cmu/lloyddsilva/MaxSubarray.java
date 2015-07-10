package edu.cmu.lloyddsilva;

/*
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 * For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
 * the contiguous subarray [4,−1,2,1] has the largest sum = 6.
 */

public class MaxSubarray {
	public int maxSubArray(int[] nums) {
		int newsum = nums[0];
		int maxsum = nums[0];
		
		for(int i=1; i<nums.length; i++) {
			newsum = Math.max(newsum + nums[i], nums[i]);
			//System.out.println(newsum);
			maxsum = Math.max(maxsum, newsum);
			//System.out.println(maxsum);
		}
		
		return maxsum;
    }

}
