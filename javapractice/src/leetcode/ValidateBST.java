package leetcode;

/**
 * @author u230107
 *
 *         LeetCode Ques - 98 {Validate Binary Search Tree}
 *         https://leetcode.com/problems/validate-binary-search-tree/
 *
 *         Given a binary tree, determine if it is a valid binary search tree
 *         (BST). Assume a BST is defined as follows: The left subtree of a node
 *         contains only nodes with keys less than the node's key. The right
 *         subtree of a node contains only nodes with keys greater than the
 *         node's key. Both the left and right subtrees must also be binary
 *         search trees. Example 1: 2 / \ 1 3 Input: [2,1,3] Output: true
 *         Example 2: 5 / \ 1 4 / \ 3 6 Input: [5,1,4,null,null,3,6] Output:
 *         false Explanation: The root node's value is 5 but its right child's
 *         value
 *
 *         Time Complexity = O(N) Space Complexity = o(1)
 *         
 *         SOL:
 *         Record the minimum and maximum limits for a node, and add the
 *         recursive function to the incoming root, min, max and Every time you
 *         see a node update its underlying constraints
 *
 *         Another approach is 1.> Perform Inorder Traversal 2.> Validate if
 *         they are in sorting order. If they are in sorted order, It is valid
 *         BST
 */
public class ValidateBST {

	/**
	 * @param args
	 */

	public static void main(String[] args) {
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(1);
		root.right = new TreeNode(3);
		System.out.println("Is Valid BST = " + isValidBST(root)); // Expected Output = true

		root = new TreeNode(5);
		root.left = new TreeNode(1);
		root.right = new TreeNode(4);
		root.right.left = new TreeNode(3);
		root.right.right = new TreeNode(6);
		System.out.println("Is Valid BST = " + isValidBST(root)); // Expected Output = false
	}

	private static boolean isValidBST(TreeNode root) {
		return isValidBSTUtil(root, null, null);
	}

	/**
	 *
	 * @param root
	 * @param min
	 * @param max
	 * @return
	 */
	private static boolean isValidBSTUtil(TreeNode root, Integer min, Integer max) {
		if (root == null) {
			return true;
		}
		if (min != null && root.val <= min) { // root.data here is the right node value and max is current node value
			return false;
		}
		if (max != null && root.val >= max) { // root.data here is the left node value and max is current node value
			return false;
		}

		return isValidBSTUtil(root.left, min, root.val) && isValidBSTUtil(root.right, root.val, max);
	}

	static class TreeNode {
		int val;
		TreeNode left, right;

		TreeNode(int key) {
			this.val = key;
			left = null;
			right = null;
		}
	}

}