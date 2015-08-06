package edu.cmu.lloyddsilva;

import java.io.*;
import java.util.*;



/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

public class Solution {
	public static void main(String[] args) {
		ArrayList<String> listings = new ArrayList<String>(); 
		listings.add("1,28,300.1,San Francisco");
		listings.add("4,5,209.1,San Francisco");
		listings.add("20,7,208.1,San Francisco");
		listings.add("23,8,207.1,San Francisco");
		listings.add("16,10,206.1,Oakland"); 
		listings.add("1,16,205.1,San Francisco");
		listings.add("6,29,204.1,San Francisco");
		listings.add("7,20,203.1,San Francisco");
		listings.add("8,21,202.1,San Francisco");
		listings.add("2,18,201.1,San Francisco");
		listings.add("2,30,200.1,San Francisco");
		listings.add("15,27,109.1,Oakland");
		listings.add("10,13,108.1,Oakland");
		listings.add("11,26,107.1,Oakland");
		listings.add("12,9,106.1,Oakland");
		listings.add("13,1,105.1,Oakland");
		listings.add("22,17,104.1,Oakland");
		listings.add("1,2,103.1,Oakland");
		listings.add("28,24,102.1,Oakland");
		listings.add("18,14,11.1,San Jose");
		listings.add("6,25,10.1,Oakland");
		listings.add("19,15,9.1,San Jose");
		listings.add("3,19,8.1,San Jose");
		listings.add("3,11,7.1,Oakland");
		listings.add("27,12,6.1,Oakland");
		listings.add("1,3,5.1,Oakland");
		listings.add("25,4,4.1,San Jose");
		listings.add("5,6,3.1,San Jose");
		listings.add("29,22,2.1,San Jose");
		listings.add("30,23,1.1,San Jose");


		int len = listings.size(); // 30 
		int count = 0;
		int page_size = 12;
		int pos = 0;


		Queue<String> queue = new LinkedList<String>();

		System.out.println("--Page 1--");
		for(int i=0; i<(len / page_size); i++) {
			count = 0; //-> page_size
			HashSet<Integer> page_hosts = new HashSet<Integer>();

			//Step 0: check if any elements are in the queue; 
			while(!queue.isEmpty() && count < page_size) {
				System.out.println(queue.poll());
				count++;
			}

			//System.out.println("Finished Step 1 for loop :: " + i);


			// Step 1: pull out element at i and print or add to queue
			while(count < page_size) {
				String item = listings.get(pos);
				pos++;
				int host_id = getHostId(item);
				if(page_hosts.contains(host_id)) {
					queue.add(item);

				} else {
					page_hosts.add(host_id);
					System.out.println(item);
					count++;
				}
			}

			//System.out.println("Finished Step 2 for loop :: " + i);
			System.out.println("--Page " + (i+2) + "--");
		}


		//System.out.println("Finished lopp::pos" + pos);


		//Remainder

		while(!queue.isEmpty()) {
			System.out.println(queue.poll());
			count++;
		}

		while(pos < len) {
			System.out.println(listings.get(pos++));
			count++;
		}


		//System.out.println("Completed");

	}


	public static int getHostId(String input) {
		String[] parts = input.split(",");
		return Integer.parseInt(parts[0]);

	}
}





/*


[
"host_id,listing_id,score,city",
"1,28,300.1,San Francisco",
"4,5,209.1,San Francisco",
"20,7,208.1,San Francisco",
"23,8,207.1,San Francisco",
"16,10,206.1,Oakland",
"1,16,205.1,San Francisco",
"6,29,204.1,San Francisco",
"7,20,203.1,San Francisco",
"8,21,202.1,San Francisco",
"2,18,201.1,San Francisco",
"2,30,200.1,San Francisco",
"15,27,109.1,Oakland",
"10,13,108.1,Oakland",
"11,26,107.1,Oakland",
"12,9,106.1,Oakland",
"13,1,105.1,Oakland",
"22,17,104.1,Oakland",
"1,2,103.1,Oakland",
"28,24,102.1,Oakland",
"18,14,11.1,San Jose",
"6,25,10.1,Oakland",
"19,15,9.1,San Jose",
"3,19,8.1,San Jose",
"3,11,7.1,Oakland",
"27,12,6.1,Oakland",
"1,3,5.1,Oakland",
"25,4,4.1,San Jose",
"5,6,3.1,San Jose",
"29,22,2.1,San Jose",
"30,23,1.1,San Jose"
]

 */

// 1. Paginate the input, 12 listing/page
// 2. Keep the score sorted within the page
// 3. Avoid as much as we can the same host showing up in the same page