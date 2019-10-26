package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author u230107
 *
 *         LeetCode Ques - 291 {Word Pattern II}
 *         https://leetcode.com/accounts/login/?next=/problems/word-pattern-ii/
 *
 *         Given a pattern and a string str, find if str follows the same
 *         pattern. Here follow means a full match, such that there is a
 *         bijection between a letter in pattern and a non-empty substring in
 *         str.
 *
 *         Example 1: Input: pattern = "abab", str = "redblueredblue" Output:
 *         true
 * 
 *         Example 2: Input: pattern = pattern = "aaaa", str = "asdasdasdasd"
 *         Output: true
 * 
 *         Example 3: Input: pattern = "aabb", str = "xyzabcxzyabc" Output:
 *         false
 *
 *         Notes: You may assume both pattern and str contains only lowercase
 *         letters.
 *
 *         Time Complexity = O(N) - To loop through pattern and word Space
 *         Complexity = O(N) - Space required to store pattern and string{As well as substrings} in map and set
 *
 */
public class WordPattern_2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		WordPattern_2 obj = new WordPattern_2();

		String pattern = "abab";
		String str = "redblueredblue";
		System.out.println("Does str follows same pattern = " + obj.wordPatternMatch(pattern, str)); // Expected Output
																										// = true

		pattern = "aaaa";
		str = "asdasdasdasd";
		System.out.println("Does str follows same pattern = " + obj.wordPatternMatch(pattern, str)); // Expected Output
																										// = true

		pattern = "aabb";
		str = "xyzabcxzyabc";
		System.out.println("Does str follows same pattern = " + obj.wordPatternMatch(pattern, str)); // Expected Output
																										// = false
	}

	public boolean wordPatternMatch(String pattern, String str) {
		if (pattern == null || pattern.length() == 0) {
			return false;
		}
		Map<Character, String> map = new HashMap<>();
		Set<String> set = new HashSet<>();
		return wordPatternHelper(0, 0, str, pattern, map, set);
	}

	/**
	 *
	 * @param i -> Pointer for Pattern
	 * @param j -> Pointer for String
	 * @return
	 *
	 *         DFS+Backtracking approach
	 */
	private boolean wordPatternHelper(int i, int j, String str, String pattern, Map<Character, String> map,
			Set<String> set) {
		// i==pattern.length() && j==str.length(), equals comparison is because we are doing i+ and j+1{k} in the loop
		if (i == pattern.length() && j == str.length()) {
			return true;
		}
		if (i >= pattern.length() || j >= str.length()) {
			return false;
		}
		char c = pattern.charAt(i);
		// k<=str.length(), Equals is because k character will be excluded in substring(j,k)
		for (int k = j + 1; k <= str.length(); k++) {
			String subStr = str.substring(j, k);
			if (!map.containsKey(c) && !set.contains(subStr)) {
				// If map does not contain character and set does not contain sub string, add them
				map.put(c, subStr);
				set.add(subStr);
				// check if pattern matches for next character and next letter(j+1) in substring
				if (wordPatternHelper(i + 1, k, str, pattern, map, set)) {
					return true;
				}
				// Back track
				map.remove(c);
				set.remove(subStr);
			} else if (map.containsKey(c) && map.get(c).equals(subStr)) {
				// check if we reached end of string,
				// else repeat checking if pattern matches for next character and next letter(j+1) in substring
				if (wordPatternHelper(i + 1, k, str, pattern, map, set)) {
					return true;
				}
			}
		}
		return false;
	}
}
