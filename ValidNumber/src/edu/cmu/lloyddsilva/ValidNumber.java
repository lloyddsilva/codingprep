package edu.cmu.lloyddsilva;

public class ValidNumber {
	public static void main(String[] args) {
		System.out.println(isNumber(".1"));
		System.out.println(isNumber("46.e3"));
		System.out.println(isNumber("256523.e02"));
		System.out.println(isNumber("+10"));
		System.out.println(isNumber("-9999"));
		System.out.println(isNumber("0 "));
		System.out.println(isNumber(" 0.1"));
		System.out.println(isNumber("2e10"));
		System.out.println(isNumber("3."));
		System.out.println(isNumber(".2e81"));
		

		System.out.println("TRUE ABOVE / FALSE BELOW");

		System.out.println(isNumber(""));
		System.out.println(isNumber("abc"));
		System.out.println(isNumber("1 a"));
		System.out.println(isNumber("e"));
		System.out.println(isNumber("."));
		System.out.println(isNumber("1e."));
		System.out.println(isNumber("1e.66"));
		
	}
	
	public static boolean isNumber(String s) {
		s = s.trim();
		int i=0;
		int len = s.length();
		
		if(len == 0) return false;
		
		boolean signPresent = false;
		boolean preNumber = false;
		boolean betweenNumber = false;
		boolean postNumber = false;
		boolean dotPresent = false;
		boolean ePresent = false;
		
		if(i<len && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
			signPresent = true;
			i++;
		}
		
		while(i<len && Character.isDigit(s.charAt(i))) {
			preNumber = true;
			i++;
		}
		
		if(i>=0 && i<len && s.charAt(i) == '.') {
			dotPresent = true;
			i++;
		}
		
		while(i<len && Character.isDigit(s.charAt(i))) {
			betweenNumber = true;
			i++;
		}
		
		if(i>0 && i<len-1 && s.charAt(i) == 'e') {
			ePresent = true;
			i++;
		}
		
		if(!dotPresent && !ePresent && i>=0 && i<len && s.charAt(i) == '.') {
			dotPresent = true;
			i++;
		}
		
		while(i<len && Character.isDigit(s.charAt(i))) {
			postNumber = true;
			i++;
		}
		
		if(i != len) {
			return false;
		} else if(ePresent) {
			if(dotPresent && (preNumber || betweenNumber) && postNumber)
				return true;
			else if(dotPresent || !preNumber || !postNumber)
				return false;
		} else if(dotPresent) {
			if(!preNumber && !betweenNumber && !postNumber)
				return false;
		} else {
			return true;
		}
		
		return true;
	}
}
