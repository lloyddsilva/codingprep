package edu.cmu.lloyddsilva;

/*
 * Given a string S, you are allowed to convert it to a palindrome by adding characters in front of it. 
 * Find and return the shortest palindrome you can find by performing this transformation.
 */

public class Palindrome {
	public static void main(String[] args) {
		String test = "dcbabcd";
		System.out.println(checkPalindrome(test));
		String input = "aacecaaa";
		System.out.println(shortestPalindrome(input));
	}
	
	public static String shortestPalindrome(String s) {
		int len = s.length();
		//Step 1: Find shortest existing palindrome
		int lastIndex = len; 
		while(lastIndex > 0) {
			if(checkPalindrome(s.substring(0, lastIndex))) {
				break;
			}
			lastIndex--;
		}
		
		//Step 2: Extract extra stuff at end
		String extra = s.substring(lastIndex, len);
		
		//Step 3: Reverse extra stuff and append
		StringBuilder sb = new StringBuilder(extra);
		sb.reverse();
		sb.append(s);
		
		
		return sb.toString();
		
	}

	public static boolean checkPalindrome(String s) {
//		System.out.println(s);
		int length = s.length();
		for(int i=0; i< length/2 ; i++) {
			if(s.charAt(i) != s.charAt(length - i- 1)) {
				return false;
			}
		}
		return true;
	}
}
