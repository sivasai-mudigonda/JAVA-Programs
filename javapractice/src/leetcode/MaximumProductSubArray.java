package leetcode;

/**
 * @author u230107
 *
 *         LeetCode Ques - 152 {Maximum Product Subarray}
 *         https://leetcode.com/problems/maximum-product-subarray/
 *
 *         Given an integer array nums, find the contiguous subarray within an
 *         array (containing at least one number) which has the largest product.
 *
 *         Example 1: Input: [2,3,-2,4] Output: 6 Explanation: [2,3] has the
 *         largest product 6.
 * 
 *         Example 2: Input: [-2,0,-1] Output: 0 Explanation: The result cannot
 *         be 2, because [-2,-1] is not a subarray.
 *
 *         For Solution, Refer below links
 *         https://medium.com/@nitishchandra/maximum-product-subarray-a552603b25d
 *         AND
 *
 *         Time Complexity =O(N) - To iterate all elements in the array. -Linear
 *         Time Complexity Space Complexity =o(1) - Constant Space
 *
 */
public class MaximumProductSubArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MaximumProductSubArray obj = new MaximumProductSubArray();
		int nums1[] = { 2, 3, -2, 4 };
		System.out.println("Maximum Product of Sub-Array = " + obj.maxProduct(nums1)); // Expected Output = 6
		int nums2[] = { -2, 0, -1 };
		System.out.println("Maximum Product of Sub-Array = " + obj.maxProduct(nums2)); // Expected Output = 0
		int nums3[] = { 0, -2, -3, 0, 7, -8, -2 };
		System.out.println("Maximum Product of Sub-Array = " + obj.maxProduct(nums3)); // Expected Output = 112
		int nums4[] = { -2, 3, 3, 2 };
		System.out.println("Maximum Product of Sub-Array = " + obj.maxProduct(nums4)); // Expected Output = 18
	}

	public int maxProduct(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int min_so_far = nums[0]; // To Handle -ve numbers in the array.
		int max_so_far = nums[0]; // To Handle +ve numbers in the array.
		int globalMax = nums[0];
		int index = 1;
		while (index < nums.length) {
			int temp = max_so_far; // temp will now have previous max_so_far
			/*
			 * Take the maximum of {max_so_far*nums[index],
			 * min_so_far*nums[index],nums[index]}
			 * 
			 * (nums[i] > 0) {
			 * 		max_ending_here = max_ending_here * arr[i];
			 * 		min_ending_here = min(min_ending_here * arr[i], arr[i]);
			 * }
			 * 
			 * (nums[i] < 0) {
			 *  	int temp = max_ending_here;
			 *  	max_ending_here = max(min_ending_here * arr[i], arr[i]);
			 *  	min_ending_here = temp * arr[i];
			 * }
			 */
			max_so_far = Math.max(max_so_far * nums[index], Math.max(min_so_far * nums[index], nums[index]));
			/*
			 * Take the minimum of {temp*nums[index],min_so_far*nums[index],nums[index]}
			 */
			min_so_far = Math.min(temp * nums[index], Math.min(min_so_far * nums[index], nums[index]));
			if ((max_so_far > globalMax)) {
				globalMax = max_so_far; // But the greater product in globalMax
			}
			index++;
		}
		return globalMax;
	}
}