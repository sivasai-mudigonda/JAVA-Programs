/**
* 
*/
package trees;

/**
 * @author u230107 Find the sum of all elements in a binary tree?
 * 
 * Refer https://www.geeksforgeeks.org/sum-nodes-binary-tree/
 * 
 */
public class NodeSumBinaryTree {

	/**
	 * @param args
	 */
	Node root;

	public static void main(String[] args) {
		NodeSumBinaryTree sumBT = new NodeSumBinaryTree();
		sumBT.root = new Node(15);
		sumBT.root.left = new Node(10);
		sumBT.root.left.left = new Node(8);
		sumBT.root.left.right = new Node(12);

		sumBT.root.right = new Node(20);
		sumBT.root.right.left = new Node(16);
		sumBT.root.right.right = new Node(25);

		int sum = sumBT.calSumBT(sumBT.root);
		System.out.println("Sum of Nodes of BT = " + sum); // Expected output = 106
	}

	private int calSumBT(Node root) {
		if (root == null) {
			return 0;
		}
		return root.data + calSumBT(root.left) + calSumBT(root.right);
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
