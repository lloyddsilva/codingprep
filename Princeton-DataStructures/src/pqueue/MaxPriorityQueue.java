package pqueue;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MaxPriorityQueue {
	public static final int MAX_SIZE = 5;
	
	public static void main(String[] args) {
		
		PriorityQueue<Integer> pqueue = new PriorityQueue<Integer>(10, Collections.reverseOrder());

		Scanner in = new Scanner(System.in);
		int counter =0;
		while(in.hasNext() && counter <10) {
			int input = in.nextInt();
			pqueue.add(input);
			
			if(pqueue.size() > MAX_SIZE) {
				int test = pqueue.poll();
			}
			counter++;
		}
		
		System.out.println(pqueue);
	}
}
