package edu.cmu.lloyddsilva;

public class Node {
	private int data;
	private Node leftChild;
	private Node rightChild;
	
	public Node (int data) {
		this.data = data;
	}
	
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public Node getLeftChild() {
		return leftChild;
	}
	public void setLeftChild(Node leftChild) {
		this.leftChild = leftChild;
	}
	public Node getRightChild() {
		return rightChild;
	}
	public void setRightChild(Node rightChild) {
		this.rightChild = rightChild;
	}
	
	public Node find(int data) {
		if(this.data == data) {
			return this;
		} else if (data < this.data && leftChild != null) {
			return leftChild.find(data);
		} else if (rightChild != null) {
			return rightChild.find(data);
		} else {
			return null;
		}
	}
	
	

}
