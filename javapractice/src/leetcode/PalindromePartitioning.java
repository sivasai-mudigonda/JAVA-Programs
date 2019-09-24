package leetcode;

import java.util.*;

/**
 * @author u230107
 *
 *         LeetCode Ques - {}
 *         https://leetcode.com/problems/palindrome-partitioning/
 *
 *         Given a string s, partition s such that every substring of the
 *         partition is a palindrome. Return all possible palindrome
 *         partitioning of s.
 *
 *         Example, Input : "aab", Output: [ ["aa","b"], ["a","a","b"] ]
 *
 *         For solution, refer https://www.youtube.com/watch?v=4ykBXGbonlA
 *
 *         Time Complexity = O(N* 2^N) Space Complexity = o(N)
 *
 *         Explanation for 2^n time complexity. imagine a set of n switches,
 *         each of them corresponding to one element of a set. Now, each of the
 *         switches can be turned on or off. Note, how many combinations are
 *         possible: 2^n
 */
public class PalindromePartitioning {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PalindromePartitioning obj = new PalindromePartitioning();
		String str = "aab";
		List<List<String>> res = obj.partition(str);
		System.out.println(res); // Expected Result = [[a, a, b], [aa, b]]
	}

	private List<List<String>> partition(String s) {
		List<List<String>> decompose = new ArrayList<>();
		partition_helper(0, decompose, s, new ArrayList<String>());
		return decompose;
	}

// Recursive + BackTrack + DFS
	private void partition_helper(int start, List<List<String>> decompose, String s, List<String> partial_decompose) {
		/*
		 * If we have decomposed the whole string then reap the 'partialDecomposition',
		 * it is now complete.
		 */
		if (start >= s.length()) {
// If we don't create a new array-list to store "partial_decompose",
// changing of "partial_decompose" will also change values in decompose list.
// that is, current value of "partial_decompose" will be copied in all the elements of decompose list.
			decompose.add(new ArrayList<>(partial_decompose));
			return;
		}
		for (int i = start; i < s.length(); i++) {
			if (isPalidrome(start, i, s)) {
// 1.) Choose - Take the snippet & add it to our decomposition 'path'
				String newStr = s.substring(start, i + 1);
				partial_decompose.add(newStr);

				/*
				 * 2.) Explore - Recurse and advance progress 1 past right bound of the
				 * 'palindromicSnippet' which is 'i + 1'
				 */
				partition_helper(i + 1, decompose, s, partial_decompose);

				/*
				 * 3.) Unchoose - We are done searching, remove the snippet from our 'path'.
				 * Next loop iteration will try another snippet in this stack frame.
				 */
				partial_decompose.remove(partial_decompose.size() - 1);

			}
		}
	}

	/*
	 * Checks if the region from left (inclusive) to right (inclusive) is a
	 * palindromic.
	 */
	private boolean isPalidrome(int left, int right, String s) {
		// System.out.println(s.substring(left, right + 1) + "," + left + "," + right);
		while (left < right) {
			if (s.charAt(left) != s.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}

}
