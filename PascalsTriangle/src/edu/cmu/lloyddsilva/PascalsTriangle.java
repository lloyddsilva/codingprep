package edu.cmu.lloyddsilva;

import java.util.ArrayList;
import java.util.List;


/*
Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]

Time 228 ms
*/
public class PascalsTriangle {
	public static List<List<Integer>> generate(int numRows) {
		List<List<Integer>> output = new ArrayList<List<Integer>>();
		
		if(numRows >= 1) {
			List<Integer> firstRow = new ArrayList<Integer>();
			firstRow.add(1);
			output.add(firstRow);
		}
		
		for(int i=1; i<numRows; i++) {
			List<Integer> prevRow = output.get(i-1);
			List<Integer> currRow = new ArrayList<Integer>();
			
			currRow.add(prevRow.get(0));
			
			for(int j=1; j<i ; j++) {
				currRow.add(prevRow.get(j-1) + prevRow.get(j));
			}
			currRow.add(prevRow.get(i-1));
			output.add(currRow);
		}
		
        return output;
    }
	

	public static void main(String[] args) {
		System.out.println(generate(5));

	}

}
