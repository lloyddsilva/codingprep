package edu.cmu.lloyddsilva;

public class ValidPalindrome {
	
	public static void main(String[] args) {
		String input = "A man, a plan, a canal: Panama";
		System.out.println(isValidPalindrome(input));
	}
	
	public static boolean isValidPalindrome(String input) {
		boolean isValid = true;
		String cleanInput = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
		int len = cleanInput.length();
		
		for(int i=0; i<len/2; i++) {
			if(cleanInput.charAt(i) != cleanInput.charAt(len-1-i)) {
				return false;
			}
		}
		
		return isValid;
	}

}
