/**
* 
*/
package leetcode;

/**
 * @author u230107
 *
 */
public class RemoveDupSortedArr {

	/**
	 * LeetCode-26
	 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
	 * 
	 * Given a sorted array nums, remove the duplicates in-place such that each
	 * element appear only once and return the new length.
	 *
	 * Do not allocate extra space for another array, you must do this by modifying
	 * the input array in-place with O(1) extra memory.
	 *
	 * Example 1: Given nums = [1,1,2],
	 *
	 * Your function should return length = 2, with the first two elements of nums
	 * being 1 and 2 respectively. * It doesn't matter what you leave beyond the
	 * returned length.
	 *
	 * Example 2: Given nums = [0,0,1,1,1,2,2,3,3,4],
	 *
	 * Your function should return length = 5, with the first five elements of nums
	 * being modified to 0, 1, 2, 3, and 4 respectively. It doesn't matter what
	 * values are set beyond the returned length.
	 * 
	 * Time Complexity = O(N) Space complexity =o(1)
	 */
	public RemoveDupSortedArr() {
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int len;

		int[] nums = { 1, 1, 2 };
		len = removeDup(nums); // Expected output = 2
		printArr(nums, len); // Print 1,2

		int[] nums2 = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
		len = removeDup(nums2); // Expected output = 5
		printArr(nums2, len); // Print 0, 1, 2, 3, 4
	}

	// Assuming array as ascending sorted order
	private static int removeDup(int nums[]) {
		int len = 0;
		if (nums == null || nums.length == 0) {
			return len;
		}
		for (int curr : nums) {
			if (len == 0 || curr > nums[len - 1]) {
				nums[len++] = curr;
			}
		}
		return len;
	}

	private static void printArr(int[] nums, int len) {
		for (int i = 0; i < len; i++) {
			System.out.println(nums[i]);
		}
		System.out.println("*********************");
	}
}
