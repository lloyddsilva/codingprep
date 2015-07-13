package edu.cmu.lloyddsilva;

public class MaxProfit {
	public static void main(String[] args) {
		int[] input = new int[]{20, 5, 15, 4, 6, 10};
		System.out.println(maxProfit(input));
	}
	
	public static int maxProfit(int[] prices) {
		int maxDiff = 0;
		int minIndex = 0;
		
		for(int i=0; i< prices.length; i++) {
			if (prices[i]<prices[minIndex]) {
				minIndex = i;
			}
				
			int diff = prices[i] - prices[minIndex];
			
			if (diff > maxDiff) {
				maxDiff = diff;
				
			}
		}
		
		return maxDiff;
	}

}
