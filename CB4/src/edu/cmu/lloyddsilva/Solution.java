package edu.cmu.lloyddsilva;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int _a_cnt = 0,_b_cnt = 0;
		int [][] _a = new int[1001][1001];
		try {
			_a_cnt = sc.nextInt();
			_b_cnt = sc.nextInt();
		}catch (Exception e) {
			 System.out.println("Here: " + e.getMessage()); 
		} 

		for(int i=0; i < _a_cnt; i++) {
			for( int j = 0;j < _b_cnt;j++ ){
				int _a_tmp = 0;
				try {
					_a_tmp = sc.nextInt();
				}catch (Exception e) { }
				_a[i][j] = _a_tmp;
			}			
		}
		System.out.println(numberOfRoutes (_a ,_a_cnt,_b_cnt));
		
		
	}
	
	static int numberOfRoutes(int[][] a, int M, int N) {
		return numberOfRoutes(a, 0, 0, M, N);
		
	}
	
	static int numberOfRoutes(int a[][], int row,int col, int M, int N)
    {   
        if(row==M-1 && col==N-1)
            return a[row][col];
        else if (row==M-1)
            return a[row][col+1];
        else if (col==N-1)
            return a[row+1][col];
        else if(a[row][col]==1) {
        	if(a[row+1][col] == 1 && a[row][col+1] == 1) {
        		return numberOfRoutes(a,row+1,col, M, N) + numberOfRoutes(a,row,col+1, M, N);
        	} else if(a[row+1][col] == 1) {
        		return numberOfRoutes(a,row+1,col, M, N);
        	} else if(a[row][col+1] == 1) {
        		return numberOfRoutes(a,row,col+1, M, N);
        	} else {
        		return 0;
        	}
        }         
        else
            return 0;
    }
	
}
