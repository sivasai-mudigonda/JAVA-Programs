/**
 * 
 */
package leetcode;

/**
 *
 * @author u230107
 *
 *         Leet-Code - 33 Ques:
 *         https://leetcode.com/problems/search-in-rotated-sorted-array/
 *
 *         Suppose a sorted array is rotated at some pivot unknown to you
 *         beforehand. (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2). You are
 *         given a target value to search. If found in the array return its
 *         index, otherwise return -1. You may assume no duplicate exists in the
 *         array. Your runtime complexity must be in the order of O(logn)
 *
 *         For solution, Refer
 *         https://www.programcreek.com/2014/06/leetcode-search-in-rotated-sorted-array-java/
 */
public class SearchRotatedSortedArray {

	public static void main(String[] args) {
		int[] nums = { 7, 8, 1, 2, 3, 4, 5, 6 };
		System.out.println(search(nums, 5)); // Expected output = 5
		System.out.println(search(nums, -8)); // Expected output = -1
		System.out.println(search( new int[]{4,5,6,7,0,1,2},0));
	}

	private static int search(int[] nums, int target) {
		return binarySearch(nums, target, 0, nums.length - 1);
	}

	private static int binarySearch(int[] nums, int target, int left, int right) {
		if (left > right) {
			return -1;
		}
		int mid = left + (right - left) / 2;
		if (nums[mid] == target) {
			return mid;
		}
		if (nums[left] <= nums[mid]) {
			if (target >= nums[left] && target < nums[mid]) {
				return binarySearch(nums, target, left, mid - 1);
			} else {
				return binarySearch(nums, target, mid + 1, right);
			}
		} else {
			if (target <= nums[right] && target > nums[mid]) {
				return binarySearch(nums, target, mid + 1, right);
			} else {
				return binarySearch(nums, target, left, mid - 1);
			}
		}
	}
}
