package edu.cmu.lloyddsilva;

public class BinarySearchTree {
	private Node root;
	
	public BinarySearchTree () {
		root = null;
	}
	
	public void insert(int data) {
		
	}
	
	public Node find(int data) {
		if (root != null) {
			return root.find(data);
		} else {
			return null;
		}
	}
	
	public void remove(int data) {
		
	}

}
