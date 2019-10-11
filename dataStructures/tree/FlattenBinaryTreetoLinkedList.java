package tree;

import java.util.Stack;

/*
 * 	Given a binary tree, flatten it to a linked list in-place.

	For example, given the following tree:

    1
   / \
  2   5
 / \   \
3   4   6
	The flattened tree should look like:

1
 \
  2
   \
    3
     \
      4
       \
        5
         \
          6
 */
public class FlattenBinaryTreetoLinkedList {
	public void flatten(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		if (root == null)
			return;

		TreeNode head = root;
		TreeNode curr = head;
		if (root.right != null)
			stack.push(root.right);
		if (root.left != null)
			stack.push(root.left);

		while (!stack.isEmpty()) {
			root = stack.pop();

			if (root.right != null)
				stack.push(root.right);
			if (root.left != null)
				stack.push(root.left);

			curr.right = root;
			curr.left = null;
			curr = curr.right;

		}
		root = head;
	}
}
