package leetcode;

/**
*
*/
import java.util.Arrays;

/**
* @author u230107
*
* LeetCode Ques - 283 {Move Zeroes}
* https://leetcode.com/problems/move-zeroes/
*
* Given an array nums,
* write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
*
	Example:
	Input: [0,1,0,3,12]
	Output: [1,3,12,0,0]
*
* Note:
* You must do this in-place without making a copy of the array.
* Minimize the total number of operations.
*
* Time Complexity = O(N) - Linear Space- Loop through nums array
* Space Complexity =o(1) - Constant space
*
*/
public class MoveZeros {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MoveZeros obj = new MoveZeros();

		int[] nums = { 0, 1, 0, 3, 12 };
		obj.moveZeroes(nums);
		System.out.println("Transformed nums array = " + Arrays.toString(nums)); // Expected Output = [1,3,12,0,0]
		//Arrays.stream(nums).forEach(System.out::print);
	}

	/**
	 *
	 * @param nums
	 */
	public void moveZeroes(int[] nums) {
		if (nums == null || nums.length == 0) {
			return;
		}
		int nonZeroCounter = 0;
		// Moving all the non-zero values to one side
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				nums[nonZeroCounter] = nums[i];
				nonZeroCounter++;
			}
		}
		// Resetting all the other values on the other side to zero
		for (int i = nonZeroCounter; i < nums.length; i++) {
			nums[i] = 0;
		}
	}
}
