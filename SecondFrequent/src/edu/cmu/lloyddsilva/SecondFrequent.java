package edu.cmu.lloyddsilva;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class SecondFrequent {
	public static void main(String[] args) {
		int[] nums = new int[] {10, 10, 10, 9, 7, 5, 8, 8};
		System.out.println(secondFrequent(nums));
	}
	
	public static int secondFrequent(int[] nums) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(); 
		
		for(int i=0; i<nums.length; i++) {
			if(map.containsKey(nums[i])) {
				map.put(nums[i], map.get(nums[i]) + 1);
			} else {
				map.put(nums[i], 1);
			}
			
		}
		
		ArrayList<Frequency> list = new ArrayList<Frequency>();
		
		
		for(Map.Entry<Integer,Integer> entry : map.entrySet()) {
			list.add(new Frequency(entry.getKey(), entry.getValue()));
		}
		
		Collections.sort(list, new Comparator<Frequency>() {
			@Override
			public int compare(Frequency f1, Frequency f2) {
				Integer freq1 = f1.freq;
				Integer freq2 = f2.freq;
				 return freq2.compareTo(freq1);
			}
		});
		
		return list.get(1).val;
	}

}
