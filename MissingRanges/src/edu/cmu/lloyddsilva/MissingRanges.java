package edu.cmu.lloyddsilva;

import java.util.ArrayList;

public class MissingRanges {
	public static void main(String[] args) {
		int[] input = new int[] {0,1,3,50,75};
		System.out.println(findMissingRanges(input, 0, 99));
	}
	
	public static ArrayList<String> findMissingRanges(int[] vals, int start, int end) {
		ArrayList<String> output = new ArrayList<String> ();
		if(vals.length == 0) {
			output.add("" + start + "->" + end);
			return output;
		}
		
		if(vals[0] > start) {
			output.add(getRange(start, vals[0]-1));
		}
		
		for(int i=1; i<vals.length-1; i++) {
			if(vals[i+1]-vals[i] > 1)
				output.add(getRange(vals[i] + 1, vals[i+1]-1));
		}
		
		if(vals[0] < end) {
			output.add(getRange(vals[vals.length-1] + 1, end));
		}
			
		return output;
	}
	
	public static String getRange(int start, int end) {
		if(start == end) 
			return "" + start;
		else
			return "" + start + "->" + end;		
	}
	
}
