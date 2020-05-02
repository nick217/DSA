package tree;

/*
 * 	Link: https://leetcode.com/problems/binary-tree-maximum-path-sum/
 * 	Given a non-empty binary tree, find the maximum path sum.
 * 	For this problem, a path is defined as any sequence of nodes from some starting node 
 * 	to any node in the tree along the parent-child connections. The path must contain 
 * 	at least one node and does not need to go through the root.
 */
public class BinaryTreeMaximumPathSum {
	int maxSum = Integer.MIN_VALUE;

	public int maxPathSum(TreeNode root) {
		maxPath(root);
		return maxSum;
	}

	public int maxPath(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int leftSum = maxPath(root.left);
		int rightSum = maxPath(root.right);
		int rootSum = root.val + leftSum + rightSum;
		int currMax = Math.max(leftSum, rightSum) + root.val;
		currMax = Math.max(currMax, root.val);
		maxSum = Math.max(maxSum, rootSum);
		maxSum = Math.max(maxSum, currMax);
		return currMax;

	}
}
