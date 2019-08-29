package tree;
/*
 * 
 * Given a Binary Tree, print Left view of it. Left view of a Binary Tree is set of nodes visible when tree is visited from Left side. The task is to complete the function leftView(), which accepts root of the tree as argument.

	Left view of following tree is 1 2 4 8.

          1
       /     \
     2        3
   /     \    / \
  4     5   6    7
   \
     8

            

	Input:
	The input contains T, denoting number of testcases. For each testcase there will be two lines. The first line contains number of edges. The second line contains two nodes and a character separated by space. The first node denotes data value, second node denotes where it will be assigned to the previous node which will depend on character 'L' or 'R' i.e. the 2nd node will be assigned as left child to the 1st node if character is 'L' and so on. The first node of second line is root node. The struct or class Node has a data part which stores the data, pointer to left child and pointer to right child. There are multiple test cases. For each test case, the function will be called individually.

	Output:
	The function should print nodes in left view of Binary Tree.

	User Task:
	Since this is a functional problem you don't have to worry about input, you just have to complete the function leftView() that prints the left view. The newline is automatically appended by the driver code.

	Constraints:
	1 <= T <= 100
	1 <= Number of nodes <= 100
	1 <= Data of a node <= 1000

	Example:
	Input:
	2
	2
	1 2 R 1 3 L
	4
	10 20 L 10 30 R 20 40 L 20 60 R

	Output:
	1 3
	10 20 40
 */
class Node {
	int data;
	Node left, right;

	Node(int item) {
		data = item;
		left = right = null;
	}
}

public class LeftViewOfBinaryTree {
	static int maxLevel = 0;

	void leftView(Node root) {
		// Your code here
		maxLevel = 0;
		printLeftView(root, 1);
	}

	void printLeftView(Node root, int level) {
		if (root != null) {
			if (maxLevel < level) {
				System.out.print(root.data + " ");
				maxLevel = level;
			}
			printLeftView(root.left, level + 1);
			printLeftView(root.right, level + 1);
		}
	}
}
