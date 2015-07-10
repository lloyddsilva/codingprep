package edu.cmu.lloyddsilva;

public class ReverseList {
	public ListNode reverseList(ListNode head) {
		if(head == null ) {
			return null;
		} else if (head.next == null) {
			return head;
		} else {
			ListNode reversed = reverseList(head.next);
			ListNode current = reversed;
			while(current.next != null) {
				current = current.next;
			}
			
			current.next = head;
			head.next = null;
			
			return reversed;
		}
	}

}
