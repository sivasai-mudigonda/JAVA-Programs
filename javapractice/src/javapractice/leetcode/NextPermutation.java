/**
 * 
 */
package leetcode;

import java.util.Arrays;

/**
 * @author SIVA SAI
 *
 *
 *Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 *If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 *The replacement must be in-place and use only constant extra memory.
 *Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 *
 * Eg:
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 * 
 * Refer "https://www.youtube.com/watch?v=zGQq3HGBTXg"
 * Refer "https://www.youtube.com/watch?v=quAS1iydq7U"
 * Refer "https://www.youtube.com/watch?v=9mdoM2dVid8" // Java code
 *
 * Time Complexity = O(N)
 * Space Complexity = o(1)
 */
public class NextPermutation {

	/**
	 * @param args
	 * 
	 * 
	 */
	public static void main(String[] args) {
		int[] nums= {1,2,3};
		String  result=nextPermutation(nums);
		System.out.println("Next Permutation ="+result); // Expected Output = 1 3 2 
		
		int[] nums2= {9,1,2,4,3,1,0}; 
		result=nextPermutation(nums2);
		System.out.println("Next Permutation ="+result);  // Expected Output = 9 1 3 0 1 2 4
	}
	
	private static String nextPermutation(int[] nums) {
		if(nums==null || nums.length<1) {
			return null;
		}
		// Subtract two because we assume that there are at least one element.
		// Also Array index starts with zero.
		int i=nums.length-2;
		int firstSmall= Integer.MIN_VALUE;
		while(i>=0) {
			if(nums[i] < nums[i+1]) { // Previous number less than next number. eg :9 1 2 4 3 1 0 {firstSmall Ele =2, firstSmall{Index}= 2}
				firstSmall=i;
				break;
			}
			i--;
		}
		
		if(firstSmall==Integer.MIN_VALUE ){
			reverse(nums,0,nums.length-1);
			return Arrays.toString(nums);
		}
		
		int j=nums.length-1;
		int firstLarge= Integer.MAX_VALUE;
		while(j>firstSmall) {
			if(nums[j] > nums[firstSmall]) { // Previous number greater than than Inverse point. eg :9 1 2 4 3 1 0 {firstLargeEle =3 , firstLarge{Index}= 4}
				firstLarge=j;
				break;
			}
			j--;
		}
		reverse(nums,firstSmall,firstLarge); // Swap Inverse point and firstLarge 
		reverse(nums,firstSmall+1,nums.length-1);
		return Arrays.toString(nums);
    }
	
	private static void reverse(int[] nums, int startIndex, int endIndex) {
		while(startIndex<endIndex) {
			int temp= nums[startIndex];
			nums[startIndex]=nums[endIndex];
			nums[endIndex]=temp;
			startIndex++;
			endIndex--;
		}
	}
}
