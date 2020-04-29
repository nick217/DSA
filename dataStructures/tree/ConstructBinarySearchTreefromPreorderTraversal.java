package tree;

/*
* Link: https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
* Return the root node of a binary search tree that matches the given preorder traversal.
  (Recall that a binary search tree is a binary tree where for every node, any descendant
  of node.left has a value < node.val, and any descendant of node.right has a value > node.val.
  Also recall that a preorder traversal displays the value of the node first, then traverses node.left,
  then traverses node.right.)

Example 1:

Input: [8,5,1,7,10,12]
Output: [8,5,10,1,7,null,12]
*/
public class ConstructBinarySearchTreefromPreorderTraversal {

  // Time Complexity: O(nlogn)
  public TreeNode bstFromPreorderNlogN(int[] preorder) {
    TreeNode root = new TreeNode(preorder[0]);
    for (int i = 1; i < preorder.length; i++) {
      insertIntoBST(root, preorder[i]);
    }
    return root;
  }

  public void insertIntoBST(TreeNode root, int ele) {

    if (root.val > ele) {
      if (root.left == null) {
        TreeNode node = new TreeNode(ele);
        root.left = node;
      } else {
        insertIntoBST(root.left, ele);
      }
    } else {
      if (root.right == null) {
        TreeNode node = new TreeNode(ele);
        root.right = node;
      } else {
        insertIntoBST(root.right, ele);
      }
    }
  }

  int i = 0;

  // Time Complexity: O(n)
  public TreeNode bstFromPreorderN(int[] preorder) {

    return insertIntoBST(preorder, Integer.MAX_VALUE);
  }

  public TreeNode insertIntoBST(int[] preorder, int max) {
    if (i >= preorder.length || preorder[i] > max) return null;
    TreeNode node = new TreeNode(preorder[i++]);
    node.left = insertIntoBST(preorder, node.val);
    node.right = insertIntoBST(preorder, max);
    return node;
  }
}
