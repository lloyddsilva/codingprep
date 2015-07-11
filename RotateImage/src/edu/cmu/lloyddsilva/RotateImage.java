package edu.cmu.lloyddsilva;

/*
 * You are given an n x n 2D matrix representing an image.
 * Rotate the image by 90 degrees (clockwise).
 */

public class RotateImage {
	public void rotate(int[][] matrix) {
		for(int level=0, len=matrix.length; level<len  ; level++, len--) {
			int end = len - 1;
			
			for(int pos = level; pos < end; pos++) {
				int tail = matrix.length - pos - 1;
				
				int temp = matrix[level][pos];
				
				matrix[level][pos] = matrix[tail][level];
				
				matrix[tail][level] = matrix[end][tail];
				
				matrix[end][tail] = matrix[pos][end];
				
				matrix[pos][end] = temp;
						
						
			}
		}
		
	}
}
