package edu.cmu.lloyddsilva.sort;

public class BubbleSort implements ISort {

	@Override
	public void sort(int[] input) {
		int size = input.length;
		for(int i=0; i<size-1; i++) {
			for(int j=0; j<size-1-i; j++) {
				if (input[j+1]<input[j]) {
					int temp = input[j+1];
					input[j+1] = input[j];
					input[j] = temp;
				}
			}
		}
	}

}
