package leetcode;

/**
 * @author u230107
 *
 *         LeetCode Ques - {}
 *
 *
 *         The thief has found himself a new place for his thievery again. There
 *         is only one entrance to this area, called the "root." Besides the
 *         root, each house has one and only one parent house. After a tour, the
 *         smart thief realized That "all houses in this place forms a binary
 *         tree". It will automatically contact the police if two
 *         directly-linked houses were broken into on the same night.
 *
 *         Determine the maximum amount of money the thief can rob tonight
 *         without alerting the police.
 *
 *         Example 1:
 * 
 *         3 / \ 2 3 \ \ 3 1 Maximum amount of money the thief can rob = 3 + 3 +
 *         1 = 7.
 * 
 * 
 * 
 *         Example 2:
 * 
 *         3 / \ 4 5 / \ \ 1 3 1 Maximum amount of money the thief can rob = 4 +
 *         5 = 9.
 *
 *         Time Complexity = O(N) - Visit all nodes of binary tree Space
 *         Complexity = o(1) - if we exclude call stack, if included it is O(N)
 *         to store call stack entry for each node
 *
 */
public class HouseRobber_3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HouseRobber_3 obj = new HouseRobber_3();

		TreeNode root = obj.new TreeNode(3);
		root.left = obj.new TreeNode(2);
		root.right = obj.new TreeNode(3);
		root.left.right = obj.new TreeNode(3);
		root.right.right = obj.new TreeNode(1);
		System.out.println("Max amount that can be rob tonight without alerting the police = " + obj.rob(root)); // Expected Output = 7

		root = null;
		root = obj.new TreeNode(3);
		root.left = obj.new TreeNode(4);
		root.right = obj.new TreeNode(5);
		root.left.left = obj.new TreeNode(1);
		root.left.right = obj.new TreeNode(3);
		root.right.right = obj.new TreeNode(1);
		System.out.println("Max amount that can be rob tonight without alerting the police = " + obj.rob(root)); // Expected Output = 9
	}

	/**
	 *
	 * @param root
	 * @return
	 *
	 *         result[0] : Money with robbing the node 
	 *         result[1] : Money without robbing the node
	 *
	 */
	public int rob(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int[] result = robHelper(root);
		return Math.max(result[0], result[1]); 
	}

	private int[] robHelper(TreeNode root) {
		if (root == null) {
			return new int[2]; // To create left and right arrays
		}
		int[] left = robHelper(root.left);
		int[] right = robHelper(root.right);

		int[] curr = new int[2];
		// Rob with root node
		curr[0] = root.val + left[1] + right[1]; // Array Index starts from zero. We will skip zero to avoid adj leafs

		// Rob without root node. This will address robbing cross diagonal leafs.
		curr[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
		return curr;
	}

	class TreeNode {
		int val;
		TreeNode left, right;

		TreeNode(int val) {
			this.val = val;

		}
	}
}