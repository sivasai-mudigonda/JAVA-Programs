/**
* 
*/
package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author u230107
 *
 *         Leet Code - 15 - 3Sum 
 *         https://leetcode.com/problems/3sum/
 *
 *         Given an array S of n integers, are there elements a, b, c in S such
 *         that a + b + c = 0? Find all unique triplets in the array which gives
 *         the sum of zero.
 *
 *
 *         Note: Elements in a triplet (a,b,c) must be in non-descending order.
 *         (ie, a ≤ b ≤ c) The solution set must not contain duplicate triplets.
 *
 *
 *         For example, given array S = {-1 0 1 2 -1 -4}, A solution set is:
 *         (-1, 0, 1) (-1, -1, 2)
 *
 *
 *         For solution, Refer
 *         https://github.com/chubbysingh/coding/blob/master/src/Leetcode/Q015_3Sum.java
 *
 *         Time Complexity = O(N^2) Space Complexity = o(N)
 */
public class ThreeSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a[] = { -1, 0, 1, 2, -1, -4 };
		List<List<Integer>> res = threeSum(a);
		res.forEach(res1 -> {
			System.out.println(res1);
		});

	}

	public static List<List<Integer>> threeSum(int[] nums) {
		if (nums == null || nums.length == 0) {
			return null;
		}

		List<List<Integer>> result = new ArrayList<>();
		Set<List<Integer>> set = new HashSet<>();
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			int j = i + 1;
			int k = nums.length - 1;
			while (j < k) {
				int sum = nums[i] + nums[j] + nums[k];
				if (sum == 0) {
					set.add(Arrays.asList(nums[i], nums[j], nums[k]));
					j++;
					k--;
				} else if (sum < 0) {
					j++;
				} else {
					k--;
				}
			}
		}
		result.addAll(set);
		return result;
	}
}
