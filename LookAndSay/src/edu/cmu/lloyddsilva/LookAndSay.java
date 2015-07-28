package edu.cmu.lloyddsilva;

public class LookAndSay {
	public static void main(String[] args) {
//		String num = "1";
//		
//		for(int i=1; i<=10; i++) {
//			System.out.println(num);
//			num = lookAndSay(num);
//		}
		
		int n = 3;
		System.out.println(countAndSay(n));
	}
	
	public static String lookAndSay(String number) {
		StringBuilder result = new StringBuilder();
		
		char repeat = number.charAt(0);
		number = number.substring(1) + " ";
		int times = 1;
		
		for(char actual: number.toCharArray()) {
			if(actual == repeat) {
				times += 1;
			} else {
				result.append(times + "" + repeat);
				times = 1;
				repeat = actual;
			}
		}
		
		return result.toString();
	}
	
	public static String countAndSay(int n) {
		String output = "" + 1;
		if(n <= 1) {
			return output;
		} else {
			for(int i=2; i<=n; i++) {
				output = countAndSay(output);
			}
		}
		
		return output;
		
	}
	
	public static String countAndSay(String number) {
		StringBuilder result = new StringBuilder();
		
		char repeat = number.charAt(0);
		number = number.substring(1) + " ";
		int times = 1;
		
		for(char actual: number.toCharArray()) {
			if(actual == repeat) {
				times += 1;
			} else {
				result.append(times + "" + repeat);
				times = 1;
				repeat = actual;
			}
		}
		
		return result.toString();
	}
}
