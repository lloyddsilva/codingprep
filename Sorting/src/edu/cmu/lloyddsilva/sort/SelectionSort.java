package edu.cmu.lloyddsilva.sort;

public class SelectionSort implements ISort {

	@Override
	public void sort(int[] input) {
		int size = input.length;
		
		for(int i=0; i<size-1; i++) {
			int smallestPos = i;
			for(int j=i+1; j<size; j++) {
				if(input[j]<input[smallestPos]) {
					smallestPos = j;
				}
			}
			int temp = input[i];
			input[i] = input[smallestPos];
			input[smallestPos] = temp;
		}
		
	}

}
