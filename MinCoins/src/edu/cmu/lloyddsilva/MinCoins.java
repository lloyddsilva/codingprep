package edu.cmu.lloyddsilva;


public class MinCoins {
	public static void main(String[] args) {
		int[] denominations = new int[] {2,7,10};
		int sum = 14;
		
		System.out.println(numberOfCoins(sum, denominations));
		
	}
	
	public static int numberOfCoins(int sum, int[] denominations) {
		int[] minCoins = new int[sum + 1];
	    for (int s = 1; s <= sum; s++) {
	        minCoins[s] = Integer.MAX_VALUE - 1;
	    }

	    for (int s = 1; s <= sum; s++) {
	        for (int coin : denominations) {
	            if (s >= coin) {
	                minCoins[s] = Math.min(minCoins[s], minCoins[s - coin] + 1);
	            }
	        }
	    }
	    return minCoins[sum];
		
		
	}
}
