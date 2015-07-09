package edu.cmu.lloyddsilva;

import java.util.ArrayList;
import java.util.HashMap;

/*
 * Given an array of integers, every element appears twice except for one. Find that single one.
 */

public class SingleNumber {
	public int singleNumber(int[] nums) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for(int i=0; i<nums.length; i++){
			if(map.containsKey(nums[i])) {
				map.remove(nums[i]);
			} else {
				map.put(nums[i], 0);
			}
		}
		
		ArrayList<Integer> output = new ArrayList<Integer>(map.keySet());
		return output.get(0);
	}
}
