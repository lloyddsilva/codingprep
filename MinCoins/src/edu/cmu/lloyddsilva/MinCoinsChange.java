package edu.cmu.lloyddsilva;

import java.util.Arrays;


public class MinCoinsChange {
	public static void main(String[] args) {
		int[] denominations = new int[] {3,5,7};
		int sum = 4;
		
		System.out.println(Arrays.toString(numberOfCoins(sum, denominations)));
		
	}
	
	public static int[] numberOfCoins(int sum, int[] denominations) {
		int[] minCoins = new int[sum + 1];
		int[] from = new int[sum+1];
	    for (int s = 1; s <= sum; s++) {
	        minCoins[s] = Integer.MAX_VALUE - 1;
	    }

	    for (int s = 1; s <= sum; s++) {
	        for (int coin : denominations) {
	            if (coin <= s) {
	            	if(minCoins[s-coin] + 1 < minCoins[s]) {
	            		minCoins[s] = minCoins[s-coin] + 1;
	            		from[s] = coin;
	            	}
	            }
	        }
	    }
		
	    // No solutions:
        if (minCoins[sum] == Integer.MAX_VALUE - 1)
            return null;

        // Build answer.
        int[] result = new int[minCoins[sum]];
        int k = sum;
        while (k > 0)
        {
        	result[minCoins[k] - 1] = from[k];
            k = k - from[k];
        }
        
        return result;
		
	}
}
