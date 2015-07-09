package edu.cmu.lloyddsilva;

public class Driver {
	public static void main(String[] args) {
		LinkedList<Integer> ll = new LinkedList<Integer>();
		
		ll.addHead(1);
		ll.addHead(2);
		ll.addHead(3);
		ll.addHead(4);
		ll.addHead(5);
		ll.addHead(6);
		ll.addHead(7);
		ll.addHead(8);
		ll.removeHead();
		
		System.out.println(ll.toString());
		
		System.out.println(ll.getCount());
		
		System.out.println(ll.find(7));
		System.out.println(ll.find(8));
	}
	
}
