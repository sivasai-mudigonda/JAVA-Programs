package leetcode;

/**
*
*/

/**
* @author u230107
*
* LeetCode Ques - 268 {Missing Number}
* https://leetcode.com/problems/missing-number/
*
* Given an array containing n distinct numbers taken from 0, 1, 2, ..., n,
* find the one that is missing from the array.
*
	Example 1:
	Input: [3,0,1]
	Output: 2
	
	
	Example 2:
	Input: [9,6,4,2,3,5,7,0,1]
	Output: 8
*
* Note :
* Your algorithm should run in linear runtime complexity.
* Could you implement it using only constant extra space complexity?
*
* Time Complexity = O(N)
* Space Complexity = o(1)
*/
public class MissingNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MissingNumber obj = new MissingNumber();

		int[] arr1 = { 3, 0, 1 };
		System.out.println("Missing Number = " + obj.missingNumber(arr1)); // Expected Output = 2
		System.out.println("Missing Number = " + obj.missingNumber_appr2(arr1)); // Expected Output = 2

		int[] arr2 = { 9, 6, 4, 2, 3, 5, 7, 0, 1 };
		System.out.println("Missing Number = " + obj.missingNumber(arr2)); // Expected Output = 8
		System.out.println("Missing Number = " + obj.missingNumber_appr2(arr2)); // Expected Output = 8
	}

	/**
	 *
	 * @param nums
	 * @return
	 *
	 *         Method-1 -XOR Approach
	 *
	 *         if we XOR-ed all the values and the indices, the cumulative result
	 *         will be zero. But, the actual list at hand has a missing value,
	 *         therefore, the corresponding index will not have a valid match to be
	 *         XOR-ed with. As a result, the cumulative XOR of our input list will
	 *         have all the values XOR-ed to 0, except the one value that is
	 *         missing. That missing value will be our result that needs to be
	 *         returned.
	 *
	 *         If the above explanation is not understood, refer
	 *         https://medium.com/@monisha.mary.mathew/missing-number-45ed9096cf4b
	 */
	public int missingNumber(int[] nums) {
		if (nums == null || nums.length == 0) {
			return -1;
		}
		int result = nums.length;
		for (int i = 0; i < nums.length; i++) {
			result ^= nums[i] ^ i;
		}
		return result;
	}

	/**
	 *
	 * @param nums
	 * @return
	 *
	 *         Approach-2: Sum up all the numbers from 1 to n, then subtract that
	 *         amount with the sum of my arrayWithMissingNumber to get the answer.
	 *
	 *         If we have a series of integers that starts with 1 and increases by 1
	 *         with each number, and we know what the last number n is, the sum of
	 *         the series reduces down to: ∑ =(n^2 + n) / 2
	 *
	 *         Sum of N numbers = n(n+1)/2 {triangular series}
	 */
	public int missingNumber_appr2(int[] nums) {
		if (nums == null || nums.length == 0) {
			return -1;
		}
		int sum = (int) ((Math.pow(nums.length, 2) + nums.length) / 2);
		for (int i = 0; i < nums.length; i++) {
			sum = sum - nums[i];
		}
		return sum;
	}
}