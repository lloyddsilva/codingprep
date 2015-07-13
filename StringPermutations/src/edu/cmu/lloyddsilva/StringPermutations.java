package edu.cmu.lloyddsilva;

import java.util.HashSet;
import java.util.Set;

public class StringPermutations {
	public static void main(String[] args) {
		String input = "ab";
		System.out.println(getPermutations(input));
	}
	
	public static Set<String> getPermutations(String input) {
		Set<String> output = new HashSet<String>();
		
		if(input.length() == 0) {
			return output;
		}
		
		if(input.length() > 1) {
			char firstChar = input.charAt(0);
			String suffix = input.substring(1);
			Set<String> temp = getPermutations(suffix);
			
			for(String x : temp) {
				for(int i=0; i<=x.length(); i++) {
					output.add(x.substring(0,i) + firstChar + x.substring(i));
				}
			}
			
		} else {
			output.add(input);
		}
		
		return output;
	}
}
