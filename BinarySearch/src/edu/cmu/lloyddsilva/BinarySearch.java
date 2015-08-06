package edu.cmu.lloyddsilva;

public class BinarySearch {
	public static void main(String[] args) {
		int[] input = new int[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
		System.out.println(binarySearch(input, 9));
				
	}
	
	public static int binarySearch(int[] input, int key) {
		return binarySearch(input, key, 0, input.length-1);
	}
	
	public static int binarySearch(int[] input, int key, int start, int end) {
		int left = start; 
		int right = end;
		
		while(left <= right) {
			int med = (left + right) / 2;
			if(input[med] == key) { 
				return med;
			} else if(input[med] < key) {
				left = med+1;
			} else {
				right = med-1;
			}
		}
		
		return -1;
 	}
}
