/**
 * 
 */
package leetcode;

/**
 * @author u230107
 *
 *         LeetCode Ques - 104 {Maximum Depth of Binary Tree}
 *         https://leetcode.com/problems/maximum-depth-of-binary-tree/
 *
 *         Given a binary tree, find its maximum depth. The maximum depth is the
 *         number of nodes along the longest path from the root node down to the
 *         farthest leaf node. Note:A leaf is a node with no children For
 *         example: Given binary tree [3,9,20,null,null,15,7], 3 / \ 9 20 / \ 15
 *         7 return its depth = 3.
 *
 *         Solution: This code recursively calls the maxDepth first to get the
 *         first “farthest” node from the very top root and gradually add 1 to
 *         the overall result every time the tracking “goes up” one level in the
 *         tree. By doing so, the depth value of the tree is obtained.
 *
 *         Time Complexity = O(N) - Recursion solutions in trees run for each
 *         node hence the time complexity will be O(n) Space Complexity = o(N)
 *         -Recursion for each node will make the total space 2*n{space cost
 *         incurred on the stack size because of recursion calls} i.e. o(n)
 */
public class MaxDepthBinaryTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		System.out.println("Max Depth of Binary Tree = " + maxDepth(root)); // Expected Output = 3
	}

	private static int maxDepth(TreeNode root) {
		return root != null ? 1 + Math.max(maxDepth(root.left), maxDepth(root.right)) : 0;
	}

	private static class TreeNode {
		int val;
		TreeNode left, right;

		TreeNode(int val) {
			this.val = val;
		}
	}
}
