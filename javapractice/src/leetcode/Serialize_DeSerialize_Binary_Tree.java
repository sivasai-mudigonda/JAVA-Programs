package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author u230107
 *
 *         LeetCode Ques - 297 {Serialize and De-serialize Binary Tree}
 *         https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
 *
 *         Serialization is the process of converting a data structure or object
 *         into a sequence of bits so that it can be stored in a file or memory
 *         buffer, or transmitted across a network connection link to be
 *         reconstructed later in the same or another computer environment.
 *
 *         Design an algorithm to serialize and deserialize a binary tree. There
 *         is no restriction on how your serialization/deserialization algorithm
 *         should work. You just need to ensure that a binary tree can be
 *         serialized to a string and this string can be deserialized to the
 *         original tree structure.
 *
 *         Example: For example, you may serialize the following tree
 * 
 *         1 / \ 2 3 / \ 4 5
 * 
 *         as "[1,2,3,null,null,4,5]"
 *
 *         Clarification: The above format is the same, as how LeetCode
 *         serializes a binary tree. You do not necessarily need to follow this
 *         format, so please be creative and come up with different approaches
 *         yourself.
 *
 *         Note: Do not use class member/global/static variables to store
 *         states. Your serialize and deserialize algorithms should be
 *         stateless.
 *
 *         Solution:
 *         https://medium.com/@dimko1/serialize-and-deserialize-binary-tree-e9811ead85ed
 *
 *         Time Complexity = O(N) - To serialize and de-serialize every Node or
 *         every Element in the array Space Complexity = o(N) - To Store every
 *         Node or every Element in the Queue
 *
 */
public class Serialize_DeSerialize_Binary_Tree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Serialize_DeSerialize_Binary_Tree obj = new Serialize_DeSerialize_Binary_Tree();
		String data = "1,2,3,#,#,4,5";
		System.out.println(obj.serialize(obj.deserialize(data))); // Expected Output = 1,2,3,#,#,4,5

		data = "3,9,20,#,#,15,7";
		System.out.println(obj.serialize(obj.deserialize(data))); // Expected Output = 3,9,20,#,#,15,7
	}

	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		if (root == null) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		// Lever Order Traversal - BFS
		while (!queue.isEmpty()) {
			TreeNode temp = queue.poll();
			if (temp != null) {
				sb.append(temp.val + ",");
				queue.offer(temp.left);
				queue.offer(temp.right);
			} else {
				sb.append("#" + ","); // Null node represented by "#"
			}
		}
		sb.deleteCharAt(sb.length() - 1); // To remove last comma which is present at end

		// To remove "#" at the end of String builder
		// That is "1,2,3,#,#,4,5,#,#,#,#" to "1,2,3,#,#,4,5"
		int index = sb.length() - 1;
		while (sb.charAt(index) == '#') {
			sb.deleteCharAt(index);
			sb.deleteCharAt(sb.length() - 1); // To remove comma
			index -= 2;
		}
		return sb.toString();
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		if (data == null || data.length() == 0) {
			return null;
		}
		int index = 0;
		String[] strArr = data.split(",");
		TreeNode root = new TreeNode(Integer.parseInt(strArr[index]));
		index++;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		// Lever Order Traversal - BFS
		while (!queue.isEmpty()) {
			TreeNode temp = queue.poll();
			if (temp == null) {
				continue;
			}
			if (index < strArr.length) {
				if (!strArr[index].equals("#")) {
					// Insert Left Child to Node{Also Queue}
					temp.left = new TreeNode(Integer.parseInt(strArr[index]));
					queue.offer(temp.left);
				} else {
					temp.left = null;
				}
				index++;
			}
			if (index < strArr.length) {
				if (!strArr[index].equals("#")) {
					// Insert Right Child to Node{Also Queue}
					temp.right = new TreeNode(Integer.parseInt(strArr[index]));
					queue.offer(temp.right);
				} else {
					temp.right = null;
				}
				index++;
			}
		}
		return root;
	}

	class TreeNode {
		int val;
		TreeNode left, right;

		TreeNode(int val) {
			this.val = val;
			left = right = null;
		}
	}
}
