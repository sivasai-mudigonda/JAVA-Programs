package leetcode;
/**
*
*/

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author u230107
 *
 *         LeetCode Ques - 101 {Symmetric Tree}
 *         https://leetcode.com/problems/symmetric-tree/
 *
 *         Given a binary tree, check whether it is a mirror of itself (ie,
 *         symmetric around its center). For example, this binary tree
 *         [1,2,2,3,4,4,3] is symmetric: 1 / \ 2 2 / \ / \ 3 4 4 3 But the
 *         following [1,2,2,null,3,null,3] is not: 1 / \ 2 2 \ \ 3 3 Note: Bonus
 *         points if you could solve it both recursively and iteratively.
 *
 *         Solution: For symmetric attribute, we need to check 1.> left’s left
 *         subtree is the same with right’s right subtree, 2.> left’s right
 *         subtree is the same with right’s left subtree
 *
 *         Dynamic Programming: Time Complexity = O(N) Space Complexity =o(n)
 *
 *         Recursion: Time Complexity = O(N^2) Space Complexity =o(1)
 */
public class SymmetricTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.right.right = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right.left = new TreeNode(4);
		System.out.println("Is Symmetric Tree = " + isSymmetric_DP(root)); // Expected Output = true
		System.out.println("Is Symmetric Tree = " + isSymmetric(root)); // Expected Output = true

		root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(2);
		root.left.right = new TreeNode(3);
		root.right.right = new TreeNode(3);
		System.out.println("Is Symmetric Tree = " + isSymmetric_DP(root)); // Expected Output = false
		System.out.println("Is Symmetric Tree = " + isSymmetric(root)); // Expected Output = false
	}

// Dynamic Programming
	private static boolean isSymmetric_DP(TreeNode root) {
		if (root == null) {
			return true;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		queue.offer(root);

		while (!queue.isEmpty()) {
			TreeNode left = queue.poll();
			TreeNode right = queue.poll();

			if (left == null && right == null) {
				continue;
			}
			if (left == null || right == null) {
				return false;
			}
			if (left.val == right.val) {
				queue.offer(left.left);
				queue.offer(right.right);
				queue.offer(left.right);
				queue.offer(right.left);
			} else {
				return false;
			}
		}
		return queue.isEmpty();
	}

// Recursive
	private static boolean isSymmetric(TreeNode root) {
		return isSame(root, root);
	}

	private static boolean isSame(TreeNode left, TreeNode right) {
		if (left == null && right == null) {
			return true;
		}
		if (left != null && right != null) {
			return left.val == right.val && isSame(left.left, right.right) && isSame(left.right, right.left);
		}
		return false;
	}

	static class TreeNode {
		int val;
		TreeNode left, right;

		TreeNode(int data) {
			this.val = data;
		}
	}

}