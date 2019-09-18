package leetcode;

import java.util.*;

/**
 * @author u230107
 *
 *         LeetCode Ques - 78 - {Subsets} https://leetcode.com/problems/subsets/
 *
 *         Given a set of distinct integers, nums, return all possible subsets
 *         (the power set). Note: The solution set must not contain duplicate
 *         subsets. Example: Input: nums = [1,2,3] Output: [ [3], [1], [2],
 *         [1,2,3], [1,3], [2,3], [1,2], [] ]
 *
 *         For Sol, Refer
 *         https://medium.com/@monisha.mary.mathew/subsets-b8ceb68d6d81
 */
public class SubSets {

	/**
	 * @param args
	 *
	 */
	public static void main(String[] args) {
		System.out.println(subsets(new int[] { 1, 2, 3 })); // Expected Output = [[], [1], [2], [1, 2], [3], [1, 3], [2,
															// 3], [1, 2, 3]]
	}

	private static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		result.add(new ArrayList<>());
		for (int n : nums) {
			List<List<Integer>> currList = new ArrayList<>();
			for (List<Integer> li : result) {
				List<Integer> copyLi = new ArrayList<>();
				copyLi.addAll(li);
				copyLi.add(n);
				currList.add(copyLi);
			}
			result.addAll(currList);
		}
		return result;
	}
}
