package leetcode;

/**
 * Leet Code Ques- 55 {Jump Game}
 *
 * @author u230107 Given an array of non-negative integers, you are initially
 *         positioned at the first index of the array. Each element in the array
 *         represents your maximum jump length at that position. Determine if
 *         you are able to reach the last index.
 *
 *
 *         Example 1: Input: [2,3,1,1,4] Output: true Explanation: Jump 1 step
 *         from index 0 to 1, then 3 steps to the last index. Example 2: Input:
 *         [3,2,1,0,4] Output: false Explanation: You will always arrive at
 *         index 3 no matter what. Its maximum jump length is 0, which makes it
 *         impossible to reach the last index.
 *
 *
 *         For Sol, refer
 *         https://medium.com/@monisha.mary.mathew/jump-game-cont-cebe395c1ac
 *
 *         Time complexity = O(N) {Linear time complexity} Time complexity =
 *         o(1) {Linear space complexity
 */
public class JumpGame {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int nums[] = { 2, 3, 1, 1, 4 };
		System.out.println("Able to reach the last index = " + canJump(nums)); // Expected output = true

		int nums2[] = { 3, 2, 1, 0, 4 };
		System.out.println("Able to reach the last index = " + canJump(nums2)); // Expected output = false

	}

// Checking if we can get to last index from last but one position.{Reverse Array Traversal}
	private static boolean canJump(int[] nums) {
		if (nums == null || nums.length == 0) {
			return false;
		}
		int dest = nums.length - 1;
		for (int i = nums.length - 2; i >= 0; i--) {
			if (i + nums[i] >= dest) {
				if (i == 0) {
					return true;
				} else {
					dest = i;
				}
			}
		}
		return nums.length == 1; // If there is only one element in the array
	}
}
