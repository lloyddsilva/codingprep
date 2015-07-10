package edu.cmu.lloyddsilva;

import java.util.LinkedHashMap;
import java.util.Map;

/* 
 * Given an integer, convert it to a roman numeral.
 * Input is guaranteed to be within the range from 1 to 3999.
 */

public class RomanIntegers {
	public String intToRoman(int num) {
		
		final LinkedHashMap<Integer, String> mappings = new LinkedHashMap<Integer, String>();
		mappings.put(1, "I");
		mappings.put(4, "IV");
		mappings.put(5, "V");
		mappings.put(9, "IX");
		mappings.put(10, "X");
		mappings.put(40, "XL");
		mappings.put(50, "L");
		mappings.put(90, "XC");
		mappings.put(100, "C");
		mappings.put(400, "CD");
		mappings.put(500, "D");
		mappings.put(900, "CM");
		mappings.put(1000, "M");
		
		String output = "";
		int input = num;
		while(input > 0) {
			int highestNum = 0;
			for(Map.Entry<Integer, String> level: mappings.entrySet()) {
				if(input >= level.getKey()) {
					highestNum = level.getKey();
				}
			}
			output = output + mappings.get(highestNum);
			input = input - highestNum;
			
		}
		
		return output;
	}
}
