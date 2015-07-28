package edu.cmu.lloyddsilva;

import java.util.ArrayList;

public class ClimbingStairs {
	private static ArrayList<Integer> memo = new ArrayList<Integer>();
	
	static {
		memo.add(0);
		memo.add(1);
		memo.add(2);
	}
	
	public static void main(String[] args) {
		for(int i=1; i<=100; i++) {
			
			System.out.println(climbStairsIterative(i));
		}
		
	}
	
	public static int climbStairs(int n) {
		if(n < memo.size()) 
			return memo.get(n);
		else {
			return climbStairs(n-1) + climbStairs(n-2);
		}
		
	}
	
	public static int climbStairsIterative(int n) {
		if(n <= 2 ) return n;
		else {
			ArrayList<Integer> memo = new ArrayList<Integer>();
			memo.add(0);
			memo.add(1);
			memo.add(2);
			
			for(int i=3; i<=n; i++) {
				memo.add(memo.get(i-1) + memo.get(i-2));
			}
			
			return memo.get(n);
		}
		
		
		
	}
}
