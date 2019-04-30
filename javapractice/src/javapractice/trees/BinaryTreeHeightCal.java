/**
* 
*/
package trees;

/**
 * @author u230107
 *
 *         Write a Program to Find the Maximum Depth or Height of a Tree? Refer
 *         https://www.geeksforgeeks.org/write-a-c-program-to-find-the-maximum-depth-or-height-of-a-tree/
 *
 */
public class BinaryTreeHeightCal {

	/**
	 * @param args
	 */
	Node root;

	public static void main(String[] args) {
		BinaryTreeHeightCal tree = new BinaryTreeHeightCal();

		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);

		System.out.println("Height of tree is : " + tree.calBTHeight(tree.root)); // Expected result =3
	}

	private static int calBTHeight(Node node) {
		if (node == null) {
			return 0;
		}
		int lHeight = calBTHeight(node.left);
		int rHeight = calBTHeight(node.right);

		if (lHeight > rHeight) {
			return lHeight + 1;
		} else {
			return rHeight + 1;
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
