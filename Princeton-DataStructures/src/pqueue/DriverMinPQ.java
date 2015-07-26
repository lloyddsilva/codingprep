package pqueue;

import java.util.PriorityQueue;
import java.util.Scanner;

public class DriverMinPQ {
	public static final int MAX_SIZE = 5;
	
	public static void main(String[] args) {
		
		PriorityQueue<Integer> pqueue = new PriorityQueue<Integer>();

		Scanner in = new Scanner(System.in);
		while(in.hasNext()) {
			int input = in.nextInt();
			pqueue.add(input);
			
			if(pqueue.size() > MAX_SIZE) {
				int test = pqueue.poll();
			}
		}
	}
}
