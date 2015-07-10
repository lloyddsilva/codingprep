package edu.cmu.lloyddsilva;

/*
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 */
public class ExcelColumn {
	public int titleToNumber(String s) {
		char[] charArray = s.toCharArray();
		int output = 0 ;
		int index = 0;
		for(int i=charArray.length-1; i>=0; i--) {
			
			int charValue = charArray[i] - 'A' + 1;
			
			output = (int) (output + (charValue * Math.pow(26, index)));
					
			index++;
			
		}
		return output;
	}

}
