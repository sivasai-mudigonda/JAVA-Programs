/**
 * 
 */
package leetcode;

/**
 * @author u230107
 *
 *         Leet Code - 53 {Maximum Subarray}
 *
 *         Given an integer array nums, find the contiguous subarray (containing
 *         at least one number) which has the largest sum and return its sum.
 *         Example: Input: [-2,1,-3,4,-1,2,1,-5,4], Output: 6 Explanation:
 *         [4,-1,2,1] has the largest sum = 6.
 *
 *         To understand sol, refer
 *         https://medium.com/@monisha.mary.mathew/maximum-subarray-f109ef4100f7
 *         Time complexity = O(N)
 */
public class MaxSumSubArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int nums[] = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		int res = maxSumSubArr(nums);
		System.out.println("Max Sum of Sub-Array = " + res); // Expected output =6
	}

// This problem is solved using kadane's algorithm.
// To understand the algorithm, go through https://medium.com/@bhprtk/maximum-subarray-sum-6190f2d02c9f
	private static int maxSumSubArr(int[] nums) {
		int max_so_far = nums[0];
		int max_end_here = 0;
		int start = 0, end = 0, s = 0;
		for (int i = 0; i < nums.length; i++) {
			max_end_here += nums[i];
			if (max_so_far < max_end_here) {
				max_so_far = max_end_here;
				start = s;
				end = i;
			}
			if (max_end_here < 0) {
				max_end_here = 0;
				s = i + 1;
			}
		}
		System.out.println("start and end position of the sub-array which has highest sum is " + start + " , " + end);
		return max_so_far;
	}
}
