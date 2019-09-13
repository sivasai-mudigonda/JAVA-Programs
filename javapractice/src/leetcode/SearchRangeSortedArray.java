/**
 * 
 */
package leetcode;

import java.util.Arrays;

/**
 * @author u230107
 *
 *         Leet-Code -34 Ques:
 *         https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 *
 *         Given a sorted array of integers, find the starting and ending
 *         position of a given target value. Your algorithm’s runtime complexity
 *         must be in the order of O(log n). If the target is not found in the
 *         array, return [-1, -1].
 *
 *
 *         For example, Given [5, 7, 7, 8, 8, 10] and target value 8, return [3,
 *         4].
 *
 *         For solution, please refer
 *         http://www.learn4master.com/algorithms/binary-search/leetcode-search-for-a-range-java
 *
 */

// First & Last Position of an element in a sorted array.
public class SearchRangeSortedArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(Arrays.toString(searchRange(new int[] { 5, 7, 7, 8, 8, 10 }, 8))); // Expected output = [3,4]
		System.out.println(Arrays.toString(searchRange(new int[] { 5, 7, 7, 8, 8, 10 }, 6))); // Expected output =
																								// [-1,-1]
	}

	private static int[] searchRange(int[] nums, int target) {
		int upper = binarySearch(nums, target, true);
		int lower = binarySearch(nums, target, false);
		return new int[] { lower, upper };
	}

	private static int binarySearch(int[] nums, int target, boolean isUpper) {
		int left = 0;
		int right = nums.length - 1;
		int res = -1;

		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] == target) {
				res = mid;
				if (isUpper) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			} else if (target < nums[mid]) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return res;
	}
}
