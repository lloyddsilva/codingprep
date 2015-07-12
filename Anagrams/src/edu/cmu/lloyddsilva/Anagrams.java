package edu.cmu.lloyddsilva;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
 * Given an array of strings, return all groups of strings that are anagrams.
 * Note: All inputs will be in lower-case.
 */


public class Anagrams {
	public static void main(String[] args) {
		String[] input = new String[] {"and","dan"};
		System.out.println(anagrams(input));
	}
	
	public static List<String> anagrams(String[] strs) {
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
		
		for(int i=0; i< strs.length; i++) {
			int hash = hashValue(strs[i]);
			if(map.get(hash) == null) {
				ArrayList<Integer> list = new ArrayList<Integer>();
				list.add(i);
				map.put(hash, list);
			} else {
				map.get(hash).add(i);
			}
		}
		
		ArrayList<String> result = new ArrayList<String>();
		for(ArrayList<Integer> vals : map.values()) {
			if(vals.size()>1) {
				for(Integer i:vals) {
					result.add(strs[i]);
				}
			}
		}
		
		return result;
	}
	
	public static int hashValue(String input) {
		int output=1; 
		
		for(int i=0; i<input.length(); i++) {
			output = output * charToPrime(input.charAt(i));
		}
		
		return output;
	}
	
	public static int charToPrime(char letter) {
		switch (letter) {
			case 'a': return 2;
			case 'b': return 3;
			case 'c': return 5;
			case 'd': return 7;
			case 'e': return 11;
			case 'f': return 13;
			case 'g': return 17;
			case 'h': return 19;
			case 'i': return 23;
			case 'j': return 29;
			case 'k': return 31;
			case 'l': return 37;
			case 'm': return 41;
			case 'n': return 43;
			case 'o': return 47;
			case 'p': return 53;
			case 'q': return 59;
			case 'r': return 61;
			case 's': return 67;
			case 't': return 71;
			case 'u': return 73;
			case 'v': return 79;
			case 'w': return 83;
			case 'x': return 89;
			case 'y': return 97;
			case 'z': return 101;
			default: return 1;
		}
		
	}
}