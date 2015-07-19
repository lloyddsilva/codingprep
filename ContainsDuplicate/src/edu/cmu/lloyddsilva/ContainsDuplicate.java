package edu.cmu.lloyddsilva;

import java.util.HashSet;

public class ContainsDuplicate {
	public static void main(String[] args) {
		int[] input = new int[]{1,2,3,4,5,6,7,8};
		
		System.out.println(containsDuplicate(input));
		
	}
	
	public static boolean containsDuplicate(int[] nums){
		
		HashSet<Integer> set = new HashSet<Integer> ();
		for(int i=0; i< nums.length; i++) {
			if(set.contains(nums[i])) {
				return true;
			} else {
				set.add(nums[i]);
			}
		}
		
		return false;
	}
}
