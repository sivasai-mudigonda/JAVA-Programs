/**
 * 
 */
package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author u230107 LeetCode Ques-46 {Permutation}
 *         https://leetcode.com/problems/permutations/
 *
 *         Given a collection of distinct numbers, return all possible
 *         permutations.
 *
 *         For example, [1,2,3] have the following permutations: [ [1,2,3],
 *         [1,3,2], [2,1,3], [2,3,1], [3,1,2], [3,2,1] ]
 *
 *         Time Complexity = O(|V|+|E|)
 *
 *         Sol :
 *         http://www.learn4master.com/algorithms/leetcode-permutations-java To
 *         understand backtracking, refer
 *         https://medium.com/algorithms-and-leetcode/backtracking-e001561b9f28
 */
public class Permutation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(permute(new int[] { 1, 2, 3 }));
	}

	private static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		search(nums, 0, res);
		return res;
	}

	private static void search(int[] nums, int startPos, List<List<Integer>> res) {
		if (startPos == nums.length - 1) { // Reached valid permutation size, add to res list
			List<Integer> li = new ArrayList<>();
			for (int num : nums) {
				li.add(num);
			}
			res.add(li);
			return;
		}
		for (int i = startPos; i < nums.length; i++) {
			swap(nums, startPos, i); // Swap
			search(nums, startPos + 1, res); // Generate Permutation and make Recursive call

// this is the backtracking step. After this step, the array is restored to the initial state.
			swap(nums, startPos, i);
		}
	}

	private static void swap(int nums[], int a, int b) {
		int temp = nums[a];
		nums[a] = nums[b];
		nums[b] = temp;
	}
}
