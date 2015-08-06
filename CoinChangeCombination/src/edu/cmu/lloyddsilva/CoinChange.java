package edu.cmu.lloyddsilva;

import java.util.Arrays;

public class CoinChange {
	public static void main(String[] args) {
		int[] denominations = new int[] {2, 7, 10};
		int sum = 14;
		
		System.out.println(Arrays.toString(minChange(sum, denominations)));
		
	}
	
	public static int[] minChange(int changeAmount, int[] denom)
    {
        int n = denom.length;
        int[] count = new int[changeAmount + 1];
        int[] from = new int[changeAmount + 1];

        count[0] = 1;
        for (int i = 0 ; i < changeAmount; i++)
            if (count[i] > 0)
                for (int j = 0; j < n; j++)
                {
                    int p = i + denom[j];
                    if (p <= changeAmount)
                    {
                        if (count[p] == 0 || count[p] > count[i] + 1)
                        {
                            count[p] = count[i] + 1;
                            from[p] = j;
                        }
                    }
                }

        // No solutions:
        if (count[changeAmount] == 0)
            return null;

        // Build answer.
        int[] result = new int[count[changeAmount] - 1];
        int k = changeAmount;
        while (k > 0)
        {
            result[count[k] - 2] = denom[from[k]];
            k = k - denom[from[k]];
        }

        return result;
    }
	
}
