package edu.cmu.lloyddsilva;

import java.util.Arrays;

import edu.cmu.lloyddsilva.sort.ISort;
import edu.cmu.lloyddsilva.sort.InsertionSort;

public class Driver {
	public static void main(String[] args) {
		int[] input = new int[] {12, 8, 7, 5, 2};

		System.out.println(Arrays.toString(input));

		ISort sorter = new InsertionSort();
		sorter.sort(input);
		
		System.out.println(Arrays.toString(input));
	}
}
