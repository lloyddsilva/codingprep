package edu.cmu.lloyddsilva;

import java.util.ArrayList;
import java.util.List;

/*
 * Given a binary tree, return the preorder traversal of its nodes' values.
 */

public class BinaryTree {
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> output = new ArrayList<Integer>();
		
		preorder(root, output);
		
		return output;
        
    }
	
	public void preorder(TreeNode root, List<Integer> output) {
		if(root != null) {
			output.add(root.val);
			preorder(root.left, output);
			preorder(root.right, output);
		}
	}
	
}
