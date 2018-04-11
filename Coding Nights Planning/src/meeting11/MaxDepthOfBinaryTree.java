package meeting11;

public class MaxDepthOfBinaryTree {
	
	static int max = 0;
	
	public static void main(String[] args) {
		TreeNode tree = new TreeNode(3);
		tree.left = new TreeNode(9);
		tree.right = new TreeNode(20);
		tree.right.left = new TreeNode(15);
		tree.right.right = new TreeNode(7);
		
		System.out.println("depth of the tree is " + maxDepth(tree));
	}
	
	public static int maxDepth(TreeNode root) {
		maxDepth(root, 1);
		return max;
	}
	
	public static void maxDepth(TreeNode root, int depth) {
		if (root == null) return;
        if (depth > max) max = depth;
        if (root.left != null) maxDepth(root.left, depth + 1);
        if (root.right != null) maxDepth(root.right, depth + 1);
	}
	
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {val = x;}
	}
}
