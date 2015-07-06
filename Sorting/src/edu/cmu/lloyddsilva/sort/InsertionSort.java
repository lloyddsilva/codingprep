package edu.cmu.lloyddsilva.sort;

public class InsertionSort implements ISort {

	@Override
	public void sort(int[] input) {
		int size = input.length;
		for(int i=1; i<size; i++) {
			int current = input[i];
			int j=i-1;
			while(j>=0 && input[j]>current) {
				input[j+1] = input[j];
				j--;
			}
			input[j+1] = current;
		}
		
	}
}
