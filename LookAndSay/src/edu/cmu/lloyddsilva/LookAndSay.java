package edu.cmu.lloyddsilva;

public class LookAndSay {
	public static void main(String[] args) {
		String num = "1";
		
		for(int i=1; i<=10; i++) {
			System.out.println(num);
			num = lookAndSay(num);
		}
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
}
