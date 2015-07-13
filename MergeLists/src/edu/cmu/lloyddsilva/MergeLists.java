package edu.cmu.lloyddsilva;

public class MergeLists {
	public static void main(String[] args) {
		
	}
	
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if(l1 == null) return l2;
		else if (l2 == null) return l1;
		
		ListNode newHead;
		
		ListNode l1Current = l1;
		ListNode l2Current = l2;
		
		if(l1Current.val < l2Current.val) {
			newHead = l1Current; 
			l1Current = l1Current.next;
		} else {
			newHead = l2Current;
			l2Current = l2Current.next;
		}
		
		ListNode newCurrent = newHead;
		
		while(l1Current != null && l2Current != null) {
			if(l1Current.val < l2Current.val) {
				newCurrent.next = l1Current;
				l1Current = l1Current.next;
				newCurrent = newCurrent.next;
			} else {
				newCurrent.next = l2Current;
				l2Current = l2Current.next;
				newCurrent = newCurrent.next;
			}
		}
		
		if(l1Current != null)  {
			newCurrent.next = l1Current;
		} else {
			newCurrent.next = l2Current;
		}
		
		return newHead;
	}

}
