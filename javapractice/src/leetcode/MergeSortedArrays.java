package leetcode;

import java.util.Arrays;

/**
 * @author u230107
 *
 *         LeetCode Ques - 88 {Merge Sorted Array}
 *         https://leetcode.com/problems/merge-sorted-array/
 *
 *         Given two sorted integer arrays nums1 and nums2, merge nums2 into
 *         nums1 as one sorted array. Note: The number of elements initialized
 *         in nums1 and nums2 are m and n respectively. You may assume that
 *         nums1 has enough space (size that is greater or equal to m + n) to
 *         hold additional elements from nums2. Example: Input: nums1 =
 *         [1,2,3,0,0,0], m = 3 nums2 = [2,5,6], n = 3 Output: [1,2,2,3,5,6]
 *
 *         Hint: What if you fill the longer array from end instead of start.
 */
public class MergeSortedArrays {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums1 = { 2,0 };
		int[] nums2 = { 1 };
		int m = 1, n = 1;
		merge(nums1, m, nums2, n);
		System.out.println(Arrays.toString(nums1)); // Expected Output = [1,2,2,3,5,6]
	}

	private static void merge(int[] nums1, int m, int[] nums2, int n) {
		if (m == 0 && n == 0) {
			return;
		} else if (m == 0) {
			/* The difference is that Arrays.copyOf does not only copy elements, it also creates a new array. 
			   System.arrayCopy copies into an existing array.
			   So nums1 change which will not be reflected in main method.
			   nums1 = Arrays.copyOf(nums2, n);
			*/
			
			// source,source start,destination, dest start,the number of array elements to be copied
			System.arraycopy(nums2,0,nums1,0,n);
			return;
		}
// Decrementing m and n as index starts from zero.
		m--;
		n--;
		for (int k = nums1.length - 1; k >= 0; k--) {
			if (m >= 0 && n >= 0) {
				if (nums1[m] > nums2[n]) {
					nums1[k] = nums1[m];
					m--;
				} else {
					nums1[k] = nums2[n];
					n--;
				}
			} else if (m >= 0) {
				nums1[k] = nums1[m];
				m--;
			} else if (n >= 0) {
				nums1[k] = nums2[n];
				n--;
			}
		}
	}

}