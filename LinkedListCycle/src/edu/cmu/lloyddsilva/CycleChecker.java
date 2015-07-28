package edu.cmu.lloyddsilva;

import java.util.HashSet;
import java.util.Set;

public class CycleChecker {

	public static void main(String[] args) {
		
	}
	
	public static boolean hasCycle(ListNode head) {
		boolean hasCycle = false;
		
		ListNode current = head;
		Set<ListNode> vals = new HashSet<ListNode>();
		
		
		while(current != null) {
			if(vals.contains(current)) {
				hasCycle = true;
				return hasCycle;
			} else {
				vals.add(current);
				current = current.next;
			}
		}
		
		return hasCycle;
	}
}
