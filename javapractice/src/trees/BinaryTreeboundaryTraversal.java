package trees;

/**
 * 
 * Given a binary tree, print boundary nodes of the binary tree Anti-Clockwise
 * starting from the root? Refer
 * https://www.geeksforgeeks.org/boundary-traversal-of-binary-tree/
 * 
 */

// Print Binary Tree Boundary in Anti Clock Wise Direction.
public class BinaryTreeboundaryTraversal {

	Node root;

	// Driver program to test above functions
	public static void main(String args[]) {
		BinaryTreeboundaryTraversal tree = new BinaryTreeboundaryTraversal();
		tree.root = new Node(20);
		tree.root.left = new Node(8);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(12);
		tree.root.left.right.left = new Node(10);
		tree.root.left.right.right = new Node(14);
		tree.root.right = new Node(22);
		tree.root.right.right = new Node(25);
		tree.printBoundary(tree.root);
	}

	private void printBoundary(Node root) {
		if (root != null) {
			System.out.print(root.data + " ");
			printLeftTree(root.left);
			printLeaf(root.left);
			printLeaf(root.right);
			printRightTree(root.right);
		}
	}

	private void printLeftTree(Node node) {
		if (node != null) {
			if (node.left != null) {
				System.out.print(node.data + " ");
				printLeftTree(node.left);
			} else if (node.right != null) {
				System.out.print(node.data + " ");
				printLeftTree(node.right);
			}
			// Do not do anything if it is a leaf.
		}
	}

	private void printRightTree(Node node) {
		if (node != null) {
			if (node.right != null) {
				printRightTree(node.right);
				System.out.print(node.data + " ");
			} else if (node.left != null) {
				printRightTree(node.left);
				System.out.print(node.data + " ");
			}
		}
		// Do not do anything if it is a leaf.
	}

	private void printLeaf(Node node) {
		if (node != null) {
			printLeaf(node.left);
			if (node.right == null && node.left == null) {
				System.out.print(node.data + " ");
			}
			printLeaf(node.right);
		}
	}

	private static class Node {
		int data;
		Node left, right;

		Node(int data) {
			this.data = data;
			left = right = null;
		}
	}
}
