/**
 * 
 */
package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author SIVA SAI
 *
 *LeetCode 163. Missing Ranges
 *
 *Given a sorted integer array nums, where the range of elements are in the inclusive range [lower, upper], return its missing ranges.

Example:

Input: nums = [0, 1, 3, 50, 75], lower = 0 and upper = 99,
Output: ["2", "4->49", "51->74", "76->99"]

*Time Complexity = O(N)
*Space Complexity =O(1) 
*
*
*Refer "https://www.youtube.com/watch?v=Hxu8cQ4Nb2E" And 
*https://github.com/jzysheep/LeetCode/blob/master/163.%20Missing%20Ranges.cpp
*
 */
public class MissingRanges {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums= {0, 1, 3, 50, 75};
		int lower=0;
		int upper=99;
		List<String> missingRanges = findMissingRanges(nums,lower,upper);
		missingRanges.forEach(System.out::println); // Expected output =  ["2", "4->49", "51->74", "76->99"]
	}
	
	private static List<String> findMissingRanges(int[] nums, int lower, int upper) {
		List<String> missingRanges = new ArrayList<>();
		for(int i=0;i<nums.length;i++) {
			if(nums[i]==Integer.MIN_VALUE) {
				lower=nums[i]+1;
				continue;
			}
			
			if(lower < nums[i]-1) {
				missingRanges.add(lower +" - "+ (nums[i]-1));
			} else if(lower==nums[i]-1) {
				missingRanges.add(String.valueOf(lower));
			}
			
			if(nums[i] == Integer.MAX_VALUE) {
				return missingRanges;
			}
			
			lower=nums[i]+1;
		}
		
		// If upper is not part of array.
		if(lower < upper) {
			missingRanges.add(lower +" - "+ upper);
		} else if(lower==upper ){
			missingRanges.add(String.valueOf(lower));
		}
		return missingRanges;
	}
}
