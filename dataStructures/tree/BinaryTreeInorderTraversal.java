package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * 	Link: https://leetcode.com/problems/binary-tree-inorder-traversal/
 * 	Given a binary tree, return the inorder traversal of its nodes' values.

	Example:

	Input: [1,null,2,3]
   		1
    	 \
     	 2
    	/
   		3

	Output: [1,3,2]
	Follow up: Recursive solution is trivial, could you do it iteratively?
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BinaryTreeInorderTraversal {
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		inorderTraversalIterative(root, list);
		return list;
	}

	public void inorderTraversalIterative(TreeNode root, List<Integer> inOrder) {
		Stack<TreeNode> stack = new Stack<>();
		while (root != null || !stack.isEmpty()) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			TreeNode t = stack.pop();
			inOrder.add(t.val);
			root = t.right;
		}
	}

	public void inorderTraversalRecursive(TreeNode root, List<Integer> inOrder) {
		if (root != null) {
			inorderTraversalRecursive(root.left, inOrder);
			inOrder.add(root.val);
			inorderTraversalRecursive(root.right, inOrder);
		}
	}
}
