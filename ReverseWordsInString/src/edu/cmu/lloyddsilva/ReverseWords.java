package edu.cmu.lloyddsilva;

public class ReverseWords {
	public static void main(String[] args) {
		String input = "the sky is blue";
		System.out.println(reverseWords(input));
	}
	
	public static String reverseWords(String s) {
		String[] parts = s.split("\\s+");
		StringBuilder output = new StringBuilder();
		
		for(int i=parts.length-1; i>=0; i--) {
			output.append(parts[i] + " ");
		}

		return output.toString().trim();
		
	}

}
