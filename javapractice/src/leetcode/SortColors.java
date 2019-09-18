/**
 * 
 */
package leetcode;

import java.util.Arrays;

/**
 * Leet Code Ques - 75 {Sort Colors}
 * 
 * @author SivaM
 * Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 * Note: You are not suppose to use the library's sort function for this problem.
 * 
 * 
Example:

Input: [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]

Follow up:
A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
Could you come up with a one-pass algorithm using only constant space?
 *
 * Time complexity: O(N)
 * Space Complexity: o(1)
 *
 */
public class SortColors {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums = new int[]{2,0,2,1,1,0};
		System.out.println(Arrays.toString(nums));
		System.out.println("*******************");
		sortColors(nums);
		System.out.println(Arrays.toString(nums));
	}
	
	private static void sortColors(int[] nums) {
        if(nums==null || nums.length==0) {
        	return;
        }
        int startPt=0;
        int endPt = nums.length-1;
        int cursorPt=0;
        while(cursorPt<=endPt) {
        	if(nums[cursorPt]==2) {
        		swap(nums,cursorPt,endPt);
        		endPt--;
        	} else if(nums[cursorPt]==1) {
        		cursorPt++;
        	} else if(nums[cursorPt]==0){
        		swap(nums,cursorPt,startPt);
        		startPt++;
        		cursorPt++;
        	}
        }
    }
	
	private static void swap(int[] nums, int a, int b) {
		int temp = nums[a];
		nums[a] = nums[b];
		nums[b] = temp;
	}
}
