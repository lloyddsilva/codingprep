package edu.cmu.lloyddsilva;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
	public static void main(String[] args) {
		int[] input = {1,2,1,2,1,2,2,2};
		System.out.println(majorityElement(input));
		
		
	}
	
	public static int majorityElement(int[] nums) {
		HashMap<Integer, Integer> countTable = new HashMap<Integer, Integer> ();
		
		for(int i=0; i< nums.length; i++) {
			if (countTable.containsKey(nums[i])) {
				countTable.put(nums[i], countTable.get(nums[i]) + 1);
			} else {
				countTable.put(nums[i], 1);
			}
		}
		
		for(Map.Entry<Integer, Integer> values : countTable.entrySet()) {
			if(values.getValue() > nums.length/2) {
				return values.getKey();
			}
		}
		
		return 0;
		
	}
}
