/**
 * 
 */
package leetcode;

/**
 * @author u230107
 *
 *         LeetCode Ques - 169 {Majority Element}
 *         https://leetcode.com/problems/majority-element/
 *
 *         Given an array of size n, find the major element in the array. The
 *         majority element is the element in the array that is greater than
 *         ⌊n/2⌋. You may assume that the array is non-empty and the majority
 *         element always exist in the array.
 *
 *         Example 1: Input: [3,2,3] Output: 3
 * 
 *         Example 2: Input: [2,2,1,1,1,2,2] Output: 2
 *
 *         Solution: 
 *         In the question, it was mentioned that "Majority Element"
 *         appears more than n/2 times. That means, if you start counting the
 *         elements of array by 
 *         1.> Increasing count by one when the element has
 *         a match.
 *         AND 
 *         2.> Decreasing count when the element does not match
 *         then, count has to be greater than zero for the majority element. 
 *         We make use of this logic to find "Majority Element" and return it.
 *         
 *         Time Complexity = O(N) - Traverse through all elements in the array
 *         Space Complexity = o(1)
 */
public class MajorityElement {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MajorityElement obj = new MajorityElement();
		int[] nums1 = { 3, 2, 3 };
		System.out.println("Majority Element = " + obj.majorityElement(nums1)); // Majority Element = 3
		int[] nums2 = { 2, 2, 1, 1, 1, 2, 2 };
		System.out.println("Majority Element = " + obj.majorityElement(nums2)); // Majority Element = 2
	}

	/**
	 *
	 * @param nums
	 * @return
	 *
	 *         Majority element in the array is guaranteed
	 */
	public int majorityElement(int[] nums) {
		int majorityElement = nums[0]; // Lets start with an assumption that "majorityElement" is the first elemnt
		int count = 1; // As we assumed Majority Element, count shall be one.
		int index = 1;
		while (index < nums.length) {
			if (count == 0) {
				majorityElement = nums[index];
				count = 1;
				index++;
				continue;
			}
			if (majorityElement == nums[index]) {
				count++;
			} else {
				count--;
			}
			index++;
		}
		return majorityElement;
	}
}
