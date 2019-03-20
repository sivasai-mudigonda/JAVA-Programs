/**
 * 
 */
package leetcode;

/**
 * @author SIVA SAI
 *
 *Leet Code Ques: 162
 *
 *A peak element is an element that is greater than its neighbors.

Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that nums[-1] = nums[n] = -∞.

Example 1:

Input: nums = [1,2,3,1]
Output: 2
Explanation: 3 is a peak element and your function should return the index number 2.
Example 2:

Input: nums = [1,2,1,3,5,6,4]
Output: 1 or 5 
Explanation: Your function can return either index number 1 where the peak element is 2, 
             or index number 5 where the peak element is 6.
 *
 *
 *Time Complexity = O(Log n)
 *Space Complexity = o(1)
 *
 *Refer https://www.youtube.com/watch?v=CFgUQUL7j_c
 */
public class FindPeakElement {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int nums[]= {1,2,3,1};
		int peakIndex = findPeakElement(nums); // Expected Output = 2
		System.out.println("peakIndex = " +peakIndex);
		
		int nums1[]= {1,2,1,3,5,6,4};
		peakIndex = findPeakElement(nums1); // Expected Output = 1 or 5
		System.out.println("peakIndex = " +peakIndex);
	}
	
	
	
	// O(Log N)
	private static int findPeakElement(int[] nums) {
		int left=0;
		int right= nums.length;
		
		while(left < right){
			int mid= left + (right-left) /2; // {x+y)/2 == x+(y-x)/2}
			if(nums[mid] < nums[mid+1]) {
				left= mid+1;
			} else {
				right= mid;
			}
		}
		return left;
	}
}