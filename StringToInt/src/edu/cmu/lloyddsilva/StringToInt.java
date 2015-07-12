package edu.cmu.lloyddsilva;

public class StringToInt {
	public static void main(String[] args) {
		System.out.println(myAtoi("2234"));
		System.out.println(myAtoi("+2234"));
		System.out.println(myAtoi("-2234"));
		System.out.println(myAtoi("+-2"));
		System.out.println(myAtoi("    010"));
		System.out.println(myAtoi("    +0 123  "));
		System.out.println(myAtoi("-2147483648"));
	}
	
	public static int myAtoi(String str) {
		double result = 0;
		int sign = 1;
		
		//remove any whitespace
		str = str.trim();
		
		//return 0 for blanks
		if(str.isEmpty()) 
			return 0;
				
		//check for sign
		if(str.charAt(0) == '+') {
			sign = 1;
			str = str.substring(1);
		} else if(str.charAt(0) == '-') {
			sign = -1;
			str = str.substring(1);
		}
		
		//return 0 for blanks
		if(str.isEmpty()) 
			return 0;
		
		//test string
		int finalIndex=0;
		while(finalIndex < str.length() && (str.charAt(finalIndex) >= '0' && str.charAt(finalIndex) <= '9')) {
			finalIndex++;
		}
		str = str.substring(0, finalIndex);
		
		//return 0 for blanks
		if(str.isEmpty()) 
			return 0;
		
		//do math to form number char by char
		int pow = str.length() - 1;
		for(int i=0; i<str.length(); i++) {
			result += Character.getNumericValue(str.charAt(i)) * Math.pow(10, pow);
			pow--;
		}
		
		result = result * sign; 
		
		// handle max and min
		if (result > Integer.MAX_VALUE)
			return Integer.MAX_VALUE;
	 
		if (result < Integer.MIN_VALUE)
			return Integer.MIN_VALUE;
		
		return (int) result;
	}
}
