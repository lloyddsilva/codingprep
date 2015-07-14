package edu.cmu.lloyddsilva;

/*
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 * You may assume no duplicates in the array.
 */


public class SearchInsertPosition {
	public static void main(String[] args) {
		int[] input = new int[] {1,2,5,6};
		System.out.println(searchInsert(input, 7));
	}
	
	
	public static int searchInsert(int[] nums, int target) {
        int pos = 0;
        
        while(pos < nums.length && target > nums[pos] ) {
        	pos++;
        }
        	
        return pos;
    }

}
