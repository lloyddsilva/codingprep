package edu.cmu.lloyddsilva;

import java.util.ArrayList;

public class LCA {
	public static void main(String[] args) {
		TreeNode a = new TreeNode(6);
		TreeNode al = new TreeNode(2);
		TreeNode ar = new TreeNode(8);
		TreeNode all = new TreeNode(0);
		TreeNode alr = new TreeNode(4);
		TreeNode alrl = new TreeNode(3);
		TreeNode alrr = new TreeNode(5);
		TreeNode arl = new TreeNode(7);
		TreeNode arr = new TreeNode(9);
		
		a.left = al;
		a.right = ar;
		al.left = all;
		al.right = alr;
		alr.left = alrl;
		alr.right = alrr;
		ar.left = arl;
		ar.right = arr;
		
		System.out.println(lowestCommonAncestor(a, al, ar).val);
	}
	
	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		ArrayList<TreeNode> pathP = pathToNode(root, p);
		ArrayList<TreeNode> pathQ = pathToNode(root, q);
		
		int pos=0;
		for(int i=0; i<pathP.size() && i<pathQ.size(); i++) {
			if(pathP.get(i).val != pathQ.get(i).val) {
				break;
			}
			pos++;
		}
		
		return pathP.get(pos-1);
		
	}
	
	public static ArrayList<TreeNode> pathToNode(TreeNode root, TreeNode x) {
		ArrayList<TreeNode> path = new ArrayList<TreeNode>();
		TreeNode current = root;
		
		while(current!= null && current.val != x.val ) {
			if(current.val > x.val) {
				path.add(current);
				current = current.left;
			} else {
				path.add(current);
				current = current.right;
			}
		}
		
		path.add(x);
		
		return path;
	}
}
