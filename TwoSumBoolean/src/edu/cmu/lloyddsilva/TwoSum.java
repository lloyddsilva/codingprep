package edu.cmu.lloyddsilva;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	public static void main(String[] args) {
		int[] data = new int[]{1,1,3};
		
		System.out.println(findPossibleSum(data, 10));
		

	}

	public static boolean findPossibleSum(int[] data, int k) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		for(int i=0; i<data.length; i++) {
			if(map.containsKey(data[i])) {
				map.put(data[i], map.get(data[i])+1);
			} else { 
				map.put(data[i], 1);
			}

		}

		for(int j=0; j<data.length; j++) {
			int req = k-data[j];
			if(map.containsKey(req)) {
				if(req!=data[j]) {
					return true;
				} else {
					if(map.get(data[j]) > 1) {
						return true;
					}
				}
			}
		}

		return false;
	}

}
