package leetcode;

/**
*
*/
import java.util.Arrays;

/**
 * @author u230107
 *
 *         LeetCode Ques - 189 {Rotate Array}
 *         https://leetcode.com/problems/rotate-array/
 *
 *         Given an array, rotate the array to the right by k steps, where k is
 *         non-negative.
 *
 *         Example 1: Input: [1,2,3,4,5,6,7] and k = 3 Output: [5,6,7,1,2,3,4]
 *         Explanation: rotate 1 steps to the right: [7,1,2,3,4,5,6] rotate 2
 *         steps to the right: [6,7,1,2,3,4,5] rotate 3 steps to the right:
 *         [5,6,7,1,2,3,4]
 * 
 *         Example 2: Input: [-1,-100,3,99] and k = 2 Output: [3,99,-1,-100]
 *         Explanation: rotate 1 steps to the right: [99,-1,-100,3] rotate 2
 *         steps to the right: [3,99,-1,-100]
 *
 *         Note: Try to come up as many solutions as you can, there are at least
 *         3 different ways to solve this problem. Could you do it in-place with
 *         O(1) extra space?
 *
 *         Time Complexity = O(N) Space Complexity =o(1)
 */
public class RotateArray {

    /**
     * @param args
     */
    public static void main(String[] args) {
	RotateArray obj = new RotateArray();
	System.out.println("*******Right Rotation********");
	// Right Rotation
	int arr[] = { 1, 2, 3, 4, 5, 6, 7 };
	int k = 3;
	obj.rotate(arr, k);
	System.out.println("After Right Rotation : " + Arrays.toString(arr)); // Expected Output = 5 6 7 1 2 3 4

	int arr_2[] = { -1, -100, 3, 99 };
	k = 2;
	obj.rotate(arr_2, k);
	System.out.println("After Right Rotation : " + Arrays.toString(arr_2)); // Expected Output = 3 99 -1 -100

	System.out.println("********Left Rotation********");
	// Left Rotation
	int arr_3[] = { 1, 2, 3, 4, 5, 6, 7 };
	k = 3;
	obj.leftRotate(arr_3, k);
	System.out.println("After Left Rotation : " + Arrays.toString(arr_3)); // Expected Output = 4, 5, 6, 7, 1, 2, 3

	int arr_4[] = { -1, -100, 3, 99 };
	k = 2;
	obj.leftRotate(arr_4, k);
	System.out.println("After Left Rotation : " + Arrays.toString(arr_4)); // Expected Output = 3, 99, -1, -100
    }

    /**
     *
     * @param nums
     * @param k
     *
     *             Right Shifting Array
     */
    public void rotate(int[] nums, int k) {
	if (nums == null || nums.length == 0 || k == 0) {
	    return;
	}
	reverseArray(nums, 0, nums.length - 1); // Reverse full Array
	reverseArray(nums, 0, k - 1); // Reverse from start to k-1
	reverseArray(nums, k, nums.length - 1); // Reverse from k to end of array
    }

    /**
     *
     * @param nums
     * @param start
     * @param end
     */
    private void reverseArray(int[] nums, int start, int end) {
	while (start < end) {
	    int temp = nums[start];
	    nums[start] = nums[end];
	    nums[end] = temp;
	    start++;
	    end--;
	}
    }

    /**
     *
     * @param nums
     * @param k
     *
     * Left Rotate
     */
    public void leftRotate(int[] nums, int k) {
	reverseArray(nums, 0, k - 1); // Reverse from start to k-1
	reverseArray(nums, k, nums.length - 1); // Reverse from start to k-1
	reverseArray(nums, 0, nums.length - 1); // Reverse full Array
    }
}