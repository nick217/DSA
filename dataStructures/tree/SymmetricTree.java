package tree;

/*
 * 	Link: https://leetcode.com/problems/symmetric-tree/
 * 	Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

	For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
 

	But the following [1,2,2,null,3,null,3] is not:

    1
   / \
  2   2
   \   \
   3    3
 

	Note:
	Bonus points if you could solve it both recursively and iteratively.
 */
public class SymmetricTree {
	public boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return true;
		}
		return isSymmetric(root.left, root.right);

	}

	public boolean isSymmetric(TreeNode leftNode, TreeNode rightNode) {
		if (leftNode == null && rightNode == null) {
			return true;
		}
		if (leftNode == null || rightNode == null) {
			return false;
		}
		return ((leftNode.val == rightNode.val) && (isSymmetric(leftNode.left, rightNode.right))
				&& (isSymmetric(leftNode.right, rightNode.left)));
	}
}
