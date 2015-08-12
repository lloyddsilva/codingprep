package edu.cmu.lloyddsilva;

import java.util.StringTokenizer;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 *
 Rules:
 - The input delimiter is the comma, ","
 - If that delimiter is contained within an element, then that element must be quoted
 - If quotes are contained in an element, use double inner quotes (escape character)

 Input:
 John,Smith,john.smith@gmail.com,Los Angeles,1
 Jane,Roberts,janer@msn.com,"San Francisco, CA",0
 "Alexandra ""Alex""",Menendez,alex.menendez@gmail.com,Miami,1
 one,two,,four,"five"

 Output:
 John|Smith|john.smith@gmail.com|Los Angeles|1
 Jane|Roberts|janer@msn.com|San Francisco, CA|0
 Alexandra "Alex"|Menendez|alex.menendez@gmail.com|Miami|1
 one|two||four|five
 */

/*

 "Alexandra ""Alex"""
 "Alexandra "Alex"",

 1<text>
 1) two quotes together = 1 quote
 2) if we encounter a comma, then we remove edge quotes 


 """Bob"" ""Tony""", 

 ""Bob" "Tony"",

 "Bob" "Tony"


 */
class Solution {
	public static void main(String[] args) {

		String[] input = new String[5];
		input[0] = "John,Smith,john.smith@gmail.com,Los Angeles,1";
		input[1] = "Jane,Roberts,janer@msn.com,\"San Francisco, CA\",0";
		input[2] = "\"Alexandra \"\"Alex\"\"\",Menendez,alex.menendez@gmail.com,Miami,1";
		input[3] = "one,two,,four,\"five\"";
		input[4] = "\"one\",two,three,four,\"five\"";

		for (int i = 0; i < input.length; i++) {
			System.out.println(parseCsv(input[i]));
		}
	}

	public static String parseCsv(String input) {
		StringTokenizer st = new StringTokenizer(input, "\",", true);

		boolean isInsideQuote = false;
		boolean isDualQuote = false;
		int numQuotes = 0;

		StringBuilder sb = new StringBuilder();
		StringBuilder tempsb = new StringBuilder();

		while (st.hasMoreTokens()) {
			String current = st.nextToken();

			if (!current.equals(",") && !current.equals("\"")) {
				tempsb.append(current);
				isDualQuote = false;

			} else if (current.equals(",")) { // case with comma
				if(numQuotes % 2 == 0)
					isInsideQuote = false;
				
				if (isInsideQuote) {
					tempsb.append(current);
				} else {
					sb.append(trimTrailingQuotes(tempsb.toString()));
					sb.append("|");
					tempsb = new StringBuilder();
					isInsideQuote = false;
					numQuotes = 0;
				}

			} else { // case with a quote
				numQuotes++;
				if (!isInsideQuote) {
					isInsideQuote = true;
				}

				if (!isDualQuote) {
					isDualQuote = true;
					tempsb.append(current);
				} else {
					// don't append the second quote
					isDualQuote = false;

				}
			}
			

		}
		
		if(tempsb.length() > 0) {
			sb.append(trimTrailingQuotes(tempsb.toString()));
		}

		return sb.toString();

	}
	
	public static String trimTrailingQuotes(String input) {
		if(input.length() > 1 && input.charAt(0) == '"') {
			return input.substring(1, input.length()-1);
		} else {
			return input;
		}
			
	}

}

