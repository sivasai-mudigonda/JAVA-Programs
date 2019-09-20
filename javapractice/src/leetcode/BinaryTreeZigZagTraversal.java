package leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author u230107
 *
 *         LeetCode Ques - 103 {Binary Tree Zigzag Level Order Traversal}
 *         https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 *
 *         Given a binary tree, return the zigzag level order traversal of its
 *         nodes’ values. (ie, from left to right, then right to left for the
 *         next level and alternate between). For example: Given binary tree
 *         [3,9,20,null,null,15,7], 3 / \ 9 20 / \ 15 7 return its zigzag level
 *         order traversal as: [ [3], [20,9], [15,7] ]
 *
 *         Sol: Similar to level-order traversal, we use queue to lock our
 *         observation of tree at the same level. The size of current queue is
 *         the number of nodes in a level of the tree. We start extracting each
 *         node’s value in a level by popping the nodes in the queue. Especially
 *         in this example, we need to output node’s value in a Zigzag way, so
 *         we use a special flag to identify if our observation in an odd or
 *         even level of the tree.
 *
 *         Time Complexity: O(N) 
 *         Space Complexity: o(N)
 */
public class BinaryTreeZigZagTraversal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.left.left=null;
		root.right.right = new TreeNode(7);
		root.right.right.right=null;
		zigzagLevelOrder(root).stream().forEach(System.out::print); // Expected Output = [[3],[20,9],[15,7]]
	}

	/**
	 *
	 * @param TreeNode root
	 * @return List<List<Integer>>
	 * 
	 * when zigzagFlag==true, add elements from left to right in list,
	 * when zigzagFlag==false, add elements right to left
	 */
	private static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		if (root == null) {
			return new LinkedList<>();
		}
		List<List<Integer>> resultLi = new LinkedList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		boolean zigzagFlag = true;
		while (!queue.isEmpty()) {
			List<Integer> currLi = new LinkedList<>();
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode currNode = queue.poll();
				if (zigzagFlag) {
					currLi.add(currNode.val);
				} else {
					// add - Inserts the specified element at the specified position in this list. 
					// Also shifts the element currently at that position(if any) and any subsequent elements to the right (adds one to their indices).
					currLi.add(0,currNode.val); // insert value in zero index
				}
				// Insert nodes Left to Right
				if (currNode.left != null) {
					queue.add(currNode.left);
				}
				if (currNode.right != null) {
					queue.add(currNode.right);
				}
			}
			zigzagFlag = !zigzagFlag;
			resultLi.add(currLi);
		}
		return resultLi;
	}

	static class TreeNode {
		int val;
		TreeNode left, right;

		TreeNode(int val) {
			this.val = val;
		}
	}
}
