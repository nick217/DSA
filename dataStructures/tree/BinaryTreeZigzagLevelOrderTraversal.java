package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/*
 * 	Link: https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 * 	Given a binary tree, return the zigzag level order traversal of its nodes' values. 
 * 	(ie, from left to right, then right to left for the next level and alternate between).

	For example:
	Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
	return its zigzag level order traversal as:
	[
  		[3],
  		[20,9],
  		[15,7]
	]
 */
public class BinaryTreeZigzagLevelOrderTraversal {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> zigZag = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		Queue<TreeNode> queue = new LinkedList<>();
		if (root == null) {
			return zigZag;
		}
		stack.push(root);
		int level = 0;
		while (!stack.isEmpty()) {
			while (!stack.isEmpty()) {
				queue.offer(stack.pop());
			}
			List<Integer> list = new ArrayList<>();
			while (!queue.isEmpty()) {
				TreeNode node = queue.poll();
				if (level % 2 == 0) {
					if (node.left != null)
						stack.push(node.left);
					if (node.right != null)
						stack.push(node.right);
				} else {
					if (node.right != null)
						stack.push(node.right);
					if (node.left != null)
						stack.push(node.left);
				}
				list.add(node.val);
			}
			zigZag.add(list);
			level++;
		}
		return zigZag;
	}
}
