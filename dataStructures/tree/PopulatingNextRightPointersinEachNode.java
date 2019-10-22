package tree;

import java.util.ArrayList;
import java.util.List;

/*
 * 	Link: https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
 * 	You are given a perfect binary tree where all leaves are on the same level, 
 * 	and every parent has two children. The binary tree has the following definition:

	struct Node {
  		int val;
  		Node *left;
  		Node *right;
  		Node *next;
	}
	Populate each next pointer to point to its next right node. If there is no next right node, 
	the next pointer should be set to NULL.

	Initially, all next pointers are set to NULL.
 */
class NodeWithNext {
	int val;
	NodeWithNext left;
	NodeWithNext right;
	NodeWithNext next;
	
	NodeWithNext(int x) {
		val = x;
	}
}
public class PopulatingNextRightPointersinEachNode {
	List<NodeWithNext> nodes = new ArrayList<>();
    public NodeWithNext connect(NodeWithNext root) {
        connect(root, 1);
        return root;
    }
    public void connect(NodeWithNext node, int height){
        if(node == null) return;
        if(nodes.size() < height){
            nodes.add(node);
        }
        else{
        	NodeWithNext current = nodes.get(height - 1);
            current.next = node;
            nodes.set(height - 1, node);
        }
        connect(node.left, height + 1);
        connect(node.right, height + 1);
    }
    
    
    //recursively without extra space
    public NodeWithNext connectWithoutExtraSpace(NodeWithNext root) {
        if (root == null) return null;
        helper(root.left, root.right);
        return root;
    }
	// connect helper function
    private void helper(NodeWithNext n1, NodeWithNext n2) {
        if (n1 == null || n2 == null) return;
        if (n1 == n2) return;
        n1.next = n2;
        helper(n1.left, n1.right);
        helper(n1.right, n2.left);
        helper(n2.left, n2.right);
    }
}
