package tree;

import java.util.ArrayList;
import java.util.List;

/*
 * 	Link: https://leetcode.com/problems/binary-tree-level-order-traversal/
 * 	Given a binary tree, return the level order traversal of its nodes' values. 
 * 	(ie, from left to right, level by level).

	For example:
	Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
	return its level order traversal as:
	[
  		[3],
  		[9,20],
  		[15,7]
	]
 */
public class BinaryTreeLevelOrderTraversal {
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> traversed = new ArrayList<>();
		levelOrderTraversal(root, 1, traversed);
		return traversed;
	}

	public void levelOrderTraversal(TreeNode root, int height, List<List<Integer>> traversed) {
		if (root != null) {
			List<Integer> list;
			if (height > traversed.size()) {
				list = new ArrayList<>();
				traversed.add(list);
			}
			list = traversed.get(height - 1);
			list.add(root.val);
			levelOrderTraversal(root.left, height + 1, traversed);
			levelOrderTraversal(root.right, height + 1, traversed);
		}
	}
}
