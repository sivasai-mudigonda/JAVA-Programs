/**
 * 
 */
package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author SivaM
 *
 * LeetCode Ques - 217 {Contains Duplicate}
 * https://leetcode.com/problems/contains-duplicate/
 * 
 * Given an array of integers, find if the array contains any duplicates.
 * Your function should return true if any value appears at least twice in the array, 
 * and it should return false if every element is distinct.
 * 
	Example 1:
	Input: [1,2,3,1]
	Output: true
	
	Example 2:
	Input: [1,2,3,4]
	Output: false
	
	Example 3:
	Input: [1,1,1,3,3,4,3,2,4,2]
	Output: true
 *
 * Time Complexity = O(N)
 * Space Complexity = O(N)
 */
public class ContainsDuplicate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ContainsDuplicate obj = new ContainsDuplicate();
		
		int nums1[] = {1,2,3,1};
		System.out.println("Contains Duplicate = " +obj.containsDuplicate(nums1)); // Expected Output = true
		int nums2[] = {1,2,3,4};
		System.out.println("Contains Duplicate = " +obj.containsDuplicate(nums2)); // Expected Output = false
		int nums3[] = {1,1,1,3,3,4,3,2,4,2};
		System.out.println("Contains Duplicate = " +obj.containsDuplicate(nums3)); // Expected Output = true
	}
	
	/**
	 * 
	 * @param nums
	 * @return
	 */
	public boolean containsDuplicate(int[] nums) {
		Set<Integer> s = new HashSet<>();
		for(int n : nums) {
			if(s.contains(n) ) {
				return true;
			}
			s.add(n);
		}
		return false;
	}
}
