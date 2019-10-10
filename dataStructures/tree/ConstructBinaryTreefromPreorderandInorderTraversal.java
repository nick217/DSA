package tree;

import java.util.HashMap;

/*
 * 	Link: https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * 	Given preorder and inorder traversal of a tree, construct the binary tree.

	Note:
	You may assume that duplicates do not exist in the tree.

	For example, given

	preorder = [3,9,20,15,7]
	inorder = [9,3,15,20,7]
	Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7
 */
public class ConstructBinaryTreefromPreorderandInorderTraversal {
	HashMap<Integer, Integer> posMap = new HashMap<>();
	int preIndex = 0;

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder.length == 0) {
			return null;
		}
		populatePosMap(inorder);
		return buildTree(preorder, inorder, 0, preorder.length - 1);
	}

	public TreeNode buildTree(int[] preorder, int[] inorder, int start, int end) {
		if (start > end) {
			return null;
		}
		TreeNode n = new TreeNode(preorder[preIndex++]);
		if (start == end) {
			return n;
		}
		int pos = posMap.get(n.val);
		n.left = buildTree(preorder, inorder, start, pos - 1);
		n.right = buildTree(preorder, inorder, pos + 1, end);

		return n;
	}

	public void populatePosMap(int[] array) {
		for (int i = 0; i < array.length; i++) {
			posMap.put(array[i], i);
		}
	}
}
