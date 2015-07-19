package edu.cmu.lloyddsilva;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        
        int[][] input = new int[n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                input[i][j] = in.nextInt();
            }
        }
        
        int sumFirst = 0;
        int sumSecond = 0;
        for(int x=0; x<n; x++) {
            sumFirst = sumFirst + input[x][x];
            sumSecond = sumSecond + input[x][n-x-1];
        }
        
        System.out.println(Math.abs(sumFirst - sumSecond));
            
        
    }
}
