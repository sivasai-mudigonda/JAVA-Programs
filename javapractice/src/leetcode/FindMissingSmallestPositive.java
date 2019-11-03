/**
 * 
 */
package leetcode;

/**
 * @author SivaM
 * 
 * LeetCode - 41 {First Missing Positive}
 * https://leetcode.com/problems/first-missing-positive/
 *
 * Given an unsorted integer array, find the smallest missing positive integer.
 * 
	Example 1:
	Input: [1,2,0]
	Output: 3
	
	Example 2:
	Input: [3,4,-1,1]
	Output: 2
	
	Example 3:
	Input: [7,8,9,11,12]
	Output: 1
 * 
 * Note:
 * Your algorithm should run in O(n) time and uses constant extra space.
 * 
 * Solution:
 * Since the first missing positive number must be between 1 and len(array) + 1 (why?), 
 * we can ignore any negative numbers and numbers bigger than len(array). 
 * The basic idea is to use the indices of the array itself to reorder the elements to where they should be. 
 * We traverse the array and swap elements between 0 and the length of the array to their value’s index. 
 * We stay at each index until we find that index’s value and keep on swapping.
 * By the end of this process, all the first positive numbers should be grouped in order at the beginning of the array. 
 * We don’t care about others. 
 * This only takes O(N) time with zero space complexity, since we swap each element at most once.
 * Then we can iterate through the array and return the index of the first number that doesn’t match.
 * 
 * Time Complexity =O(N)
 * Space Complexity =o(1)
 * 
 */
public class FindMissingSmallestPositive {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FindMissingSmallestPositive obj = new FindMissingSmallestPositive();
		
		int[] nums1 = {1,2,0};
		System.out.println("Missing Number = " +obj.findMissingSmallestPositive(nums1)); // Expected Output=3
		
		int[] nums2 = {3,4,-1,1};
		System.out.println("Missing Number = " +obj.findMissingSmallestPositive(nums2)); // Expected Output=2
		
		int[] nums3 = {7,8,9,11,12};
		System.out.println("Missing Number = " +obj.findMissingSmallestPositive(nums3)); // Expected Output=1
	}
	
	private int findMissingSmallestPositive(int nums[]){
		int i=0;
		while(i<nums.length) {
			if(nums[i]<=0 || nums[i]>nums.length){
				i++; // we can ignore any negative numbers and numbers bigger than len(array).
			} else if(nums[nums[i]-1]!=nums[i] ){ // Bucket Sorting
				/*
				 * The basic idea is to use the indices of the array itself to reorder the elements to where they should be.
				 * We traverse the array and swap elements between 0 and the length of the array to their value’s index.
				 * We stay at each index until we find that index’s value and keep on swapping.
				 * By the end of this process, all the first positive numbers should be grouped in order at the beginning of the array.  
				 */
				swap(nums,i,nums[i]-1);
			} else {
				i++; // if nums[nums[i]-1]==nums[i], +ve number is already in its index place.
			}
		}
		i=0;
		while(i<nums.length && nums[i]==i+1) {
			i++; // If number is present, continue searching by incrementing i
		}
		return i+1;
	}
	
	private static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
