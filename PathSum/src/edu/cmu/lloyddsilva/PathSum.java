package edu.cmu.lloyddsilva;

public class PathSum {
	
	public static void main(String[] args) {
		System.out.println(hasPathSum(null, 0));
	}
	
	public static boolean hasPathSum(TreeNode root, int sum) {
		if(root == null) {
			return false;
		} else if(root.left == null && root.right == null) {
			return root.val == sum ? true: false;
		} else if(root.right == null) {
			return hasPathSum(root.left, sum-root.val);
		} else if(root.left == null){
			return hasPathSum(root.right, sum-root.val);
		} else {
			return hasPathSum(root.right, sum-root.val) || hasPathSum(root.left, sum-root.val);
		}
	}

}
