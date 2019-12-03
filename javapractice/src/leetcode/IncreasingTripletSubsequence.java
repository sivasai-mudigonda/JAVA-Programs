package leetcode;

/**
* @author u230107
*
* Leet code Ques - 334 {Increasing Triplet Subsequence} {Medium}
* https://leetcode.com/problems/increasing-triplet-subsequence/
*
* Given an unsorted array return whether an increasing sub-sequence of length 3 exists or not in the array.
* Formally the function should return true if there exists i, j, k such that arr[i] < arr[j] < arr[k]
* given 0 ≤ i < j < k ≤ n-1
* else return false.
*
* Note: Your algorithm should run in O(n) time complexity and O(1) space complexity.
*
	Example 1:
	Input: [1,2,3,4,5]
	Output: true
	
	Example 2:
	Input: [5,4,3,2,1]
	Output: false
*
* Solution:
* 1.> Define a minimal first element minOne which indicates the minimal element which is the 1st of the triplet.
* 2.> Define a minimal second element minTwo which indicates the minimal element which is the 2nd of the triplet.
* 3.> Iterate from the first element of the array to the last element of the array. For each item
* 3.1> If the number is smaller than minOne, we assign minOne to item because minOne records the minimal first item of the triplet
* 3.1> If the number is greater than minOne and smaller than minTwo, we assign minTwo to item because minTwo records the minimal second item of the triplet
* 3.3> If the number is larger than minTwo, we can say that we found the triplet and then we can return true to say there exists a triplet.
* 4.> If we iterate over the sequence and find nothing satisfied. We return false.
*
* Time Complexity = O(N) - Loop through nums array
* Space COmplexity = o(1) - Constant space
*
*/
public class IncreasingTripletSubsequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		IncreasingTripletSubsequence obj = new IncreasingTripletSubsequence();

		int[] nums1 = { 1, 2, 3, 4, 5 };
		System.out.println("Increasing sub-sequence of length 3 exists = " + obj.increasingTriplet(nums1)); // Expected Output = true

		int[] nums2 = { 5, 4, 3, 2, 1 };
		System.out.println("Increasing sub-sequence of length 3 exists = " + obj.increasingTriplet(nums2)); // Expected Output = false

		int[] nums3 = { 1, 2, 1 };
		System.out.println("Increasing sub-sequence of length 3 exists = " + obj.increasingTriplet(nums3)); // Expected Output = false

		int[] nums4 = { 4, 0, 7, 3, 9 }; // {4,7,9 are in Sub-Sequence}
		System.out.println("Increasing sub-sequence of length 3 exists = " + obj.increasingTriplet(nums4)); // Expected Output = true
	}

	/**
	 *
	 * @param nums
	 * @return
	 * 
	 */
	public boolean increasingTriplet(int[] nums) {
		if (nums == null || nums.length < 3 ){
			return false;
		}
		int minOne = Integer.MAX_VALUE; // Step-1
		int minTwo = Integer.MAX_VALUE; // Step-2
		for (int num : nums) {
			if (num <= minOne) {
				// Step-3.1
				minOne = num;
			} else if (num <= minTwo) {
				// Step-3.2
				minTwo = num;
			} else {
				// Step 3.3
				return true;
			}
		}
		return false; // Step-4
	}
}