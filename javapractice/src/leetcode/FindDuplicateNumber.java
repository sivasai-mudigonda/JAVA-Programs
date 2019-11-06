package leetcode;

/**
* @author u230107
*
* LeetCode Ques - 287 {Find the Duplicate Number}
* https://leetcode.com/problems/find-the-duplicate-number/
*
* Given an array nums containing n + 1 integers where each integer is between 1 and n(inclusive),
* prove that at least one duplicate number must exist.
* Assume that there is only one duplicate number, find the duplicate one.
*
	Example 1:
	Input: [1,3,4,2,2]
	Output: 2
	
	Example 2:
	Input: [3,1,3,4,2]
	Output: 3
*
* Note:
* You must not modify the array (assume the array is read only).
* You must use only constant, O(1) extra space.
* Your runtime complexity should be less than O(n2).
* There is only one duplicate number in the array, but it could be repeated more than once.
*
* Solution-1:
* Runner Technique:
* This solution considers the given array as a sort of linked list.
* (This is possible because of the constraint that each integer is between 1 and n).
* Let’s analyze the example [1, 2, 3, 4, 2]:
* Example with [1, 2, 3, 4, 2]
* With this representation, we can simply say that a duplicate exists when a cycle does exist.
* Moreover, the duplicate is the entry point of the cycle (in this case, the second element).
* If we take inspiration from Floyd’s cycle-finding algorithm, we can derive the following algorithm:
* Initiate two pointers slow and fast
* For each step, slow is moving one step at a time with slow = a[slow],
* whereas fast is moving two steps at a time with fast = a[a[fast]]
* When slow == fast, we are in a cycle
* Is the algorithm completed? Not yet.
* The entry point of this cycle will be the duplicate.
* We have to reset slow and move both pointers step by step until they are equals again.
* A possible implementation in Java:
* This solution is O(n) time and O(1) space and does not require to mutate the input list.
*
* Solution-2:
* Marker Technique:
* There is something interesting to mention.Each value has its own corresponding index in the array.
* The solution is to consider array as a sort of linked list. Any index is pointing to the value of that index.
* Example with [2, 3, 3, 1]
* We iterate over each element and mark its corresponding index by setting its sign to minus.
* If we already marked it as negative, it means its index is a duplicate.
* Let’s see a concrete step by step example:
* Input: [2, 3, 3, 1]
* Index 0:
Absolute value = 2
Put a minus sign to a[2] => [2, 3, -3, 1]
* Index 1:
Absolute value = 3
Put a minus sign to a[3] => [2, 3, -3, -1]
* Index 2:
Absolute value = 3
As a[3] is already negative, it means 3 is a duplicate
* This solution is O(n) time and O(1) space. Yet, it requires to mutate the input list.
*
* Time Complexity = O(N)
* Space Complexity =o(1)
*
*/
public class FindDuplicateNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FindDuplicateNumber obj = new FindDuplicateNumber();

		int[] nums1 = { 1, 3, 4, 2, 2 };
		System.out.println("Duplicate Number = " + obj.findDuplicate_FloydCycle(nums1)); // Expected Output = 2
		System.out.println("Duplicate Number = " + obj.findDuplicate_UsingMarker(nums1)); // Expected Output = 2

		int[] nums2 = { 3, 1, 3, 4, 2 };
		System.out.println("Duplicate Number = " + obj.findDuplicate_FloydCycle(nums2)); // Expected Output = 3
		System.out.println("Duplicate Number = " + obj.findDuplicate_UsingMarker(nums2)); // Expected Output = 3
	}

	/**
	 *
	 * @param nums
	 * @return
	 *
	 *         See explanation under solution-1.
	 */
	public int findDuplicate_FloydCycle(int[] nums) {
		if (nums == null || nums.length == 0) {
			return -1;
		}
		int slow = 0;
		int fast = 0;
		boolean isDupExists = false;

		while (true) {
			slow = nums[slow];
			fast = nums[nums[fast]];
			if (slow == fast) {
				isDupExists = true;
				break;
			}
		}

		slow = 0;
		while (slow != fast) {
			slow = nums[slow];
			fast = nums[fast];
		}
		return isDupExists ? slow : -1;
	}

	/**
	 *
	 * @param nums
	 * @return
	 *
	 *         See explanation under solution-2.
	 */
	public int findDuplicate_UsingMarker(int[] nums) {
		if (nums == null || nums.length == 0) {
			return -1;
		}
		for (int i = 0; i < nums.length; i++) {
			int index = Math.abs(nums[i]) - 1; // As Index cannot be -ve, We are applying Math.abs
			if (nums[index] < 0) {
				return index + 1;
			} else {
				nums[index] = 0 - nums[index];
				//nums[index]*=-1;
			}
		}
		return -1;
	}
}