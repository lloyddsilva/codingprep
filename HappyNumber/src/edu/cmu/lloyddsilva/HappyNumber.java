package edu.cmu.lloyddsilva;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
	public static void main(String[] args) {
		System.out.println(isHappy(19));
	}
	
	public static boolean isHappy(int n) {
		Set<Integer> set = new HashSet<Integer>();
		
		int current = n;
		
		while(current!=1) {
			if(set.contains(current)) {
				return false;
			}
			else {
				set.add(current);
				current = calculateSquaredSum(current);
			}
		}
		
		return true;
		
	}
	
	public static int calculateSquaredSum(int n) {
		int num = 0;
		while(n!=0) {
			num += Math.pow(n%10, 2);
			n = n/10;
		}
		
		return num;
	}
}
