/**
 * 
 */
package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author u230107
 *
 *         LeetCode Ques-76 {Minimum Window Substring}
 *         https://leetcode.com/problems/minimum-window-substring/
 *
 *         Given a string S and a string T, find the minimum window in S which
 *         will contain all the characters in T in complexity O(n).
 * 
 *         example: Input : S = "ADOBECODEBANC", T = "ABC" Output :"BANC". Note:
 *         1. If there is no such window in S that covers all characters in T,
 *         return the empty string "". 2. If there are multiple such windows,
 *         you are guaranteed that there will always be only one unique minimum
 *         window in S.
 *
 *         For Sol: Refer https://www.youtube.com/watch?v=eS6PZLjoaq8
 *
 *         Time Complexity =O(s+t)- Linear Time Complexity Space Complexity
 *         =o(s+t) - Linear Space Complexity
 *
 */
public class MinWindowSubString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(minWindow("ADOBECODEBANC", "ABC")); // Expected output = BANC
		System.out.println(minWindow("a", "aa")); // Expected output = ""{empty string}
		System.out.println(minWindow("aaaaaaaaaaaabbbbbcdd", "abcdd")); // Expected output = abbbbbcdd
	}

	/**
	 *
	 * @param s
	 * @param t
	 * @return
	 *
	 *         Sliding Window: Use 2 Pointers To Compose A Sliding Window This code
	 *         passes all Leetcode test cases as of Feb. 21 2019 Runtime*: 27 ms,
	 *         faster than 44.99% of Java online submissions for Minimum Window
	 *         Substring. Memory Usage: 35.8 MB, less than 96.11% of Java online
	 *         submissions for Minimum Window Substring.
	 */
	private static String minWindow(String s, String t) {
		String minWindowSubString = "";
		/*
		 * We will keep track of the best window we have seen so far
		 */
		int minWindowLengthSoFar = Integer.MAX_VALUE;
		/*
		 * 2 pointers. Left holds the left index of the window we are inspecting and
		 * right holds the right index. The approach is simple. We keep moving right
		 * (don't touch left) until the window we hold satisfies all required
		 * characters. Then we take note whether the window we see beats the smallest
		 * satisfiable window we have found so far. We then contract the left pointer in
		 * while the window still satisfies all required characters (at every point
		 * continuing to check if we have beaten the smallest window ever seen to this
		 * point) As soon as the window no longer satisfies, go back to expanding the
		 * right pointer. We are finished when the right pointer runs over the array
		 * because we can't keep expanding the window to satisfy at that point.
		 */
		int left = 0, right = 0;
		int charFrequenciesInWindowThatMatch = 0;
		/*
		 * For our window. Map all characters in the window to their occurrence count.
		 * You will see how we use this below.
		 */
		Map<Character, Integer> minWindowMap = new HashMap<>();
// The characters a satisfiable window must cover mapped to their frequency
		Map<Character, Integer> requiredCharMap = buildRequiredCharMap(t);
		/*
		 * 'totalCharFrequenciesToMatch' is the total characters we need to match
		 * frequency for in the window. If I have 1 'a' in my window and I need 2 'a'
		 * chars...then the char frequencies don't match.
		 * 'charFrequenciesInWindowThatMatch' is the count of frequencies that we have
		 * satisfied. When 'totalCharFrequenciesToMatch' ==
		 * 'charFrequenciesInWindowThatMatch' then it can be said that the current
		 * window satisfies that property of having all characters with matching counts
		 * to the string t.
		 */
		int totalCharFrequenciesToMatch = requiredCharMap.size();
		while (right < s.length()) {
			/*
			 * Add the character on the right pointer to the hashtable that maps the
			 * characters seen in the window to their occurrence count
			 */
			char rightChar = s.charAt(right);
			insertCharToMinWindow(rightChar, minWindowMap);
			/*
			 * Is this character part of the requirement?
			 */
			boolean isRightRequiredChar = requiredCharMap.containsKey(rightChar);
			if (isRightRequiredChar) {
				/*
				 * Does the current window frequency match the required frequency?
				 */
				boolean isCharFreqMatch = minWindowMap.get(rightChar).intValue() == requiredCharMap.get(rightChar)
						.intValue();
				if (isCharFreqMatch) {
					/*
					 * If so then we have one more frequency requirement that matches...remember
					 * when: 'totalCharFrequenciesToMatch' == 'charFrequenciesInWindowThatMatch'
					 * then we know that we have a satisfying window
					 */
					charFrequenciesInWindowThatMatch++;
				}
			}
			/*
			 * Does this window satisfy? Ok...if it does try contracting the left pointer
			 * inward until we go over the right pointer.
			 */
			while (charFrequenciesInWindowThatMatch == totalCharFrequenciesToMatch && left <= right) {
				char leftChar = s.charAt(left);
				int windowSize = right - left + 1;
				/*
				 * Have we beat the best satisfiable window seen so far? Ok...if so then update
				 * the tracking variables
				 */
				if (windowSize < minWindowLengthSoFar) {
					minWindowLengthSoFar = windowSize;
					minWindowSubString = s.substring(left, right + 1);
				}
				/*
				 * This character will get contracted out. It won't be in the window anymore
				 * once left moves forward.
				 */
				minWindowMap.put(leftChar, minWindowMap.get(leftChar) - 1);
				/*
				 * Was this character part of the requirement? If so then its frequency changing
				 * matters to us.
				 */
				boolean isLeftRequiredChar = requiredCharMap.containsKey(leftChar);
				if (isLeftRequiredChar) {
					/*
					 * Does the character frequence count not fall below the threshold of
					 * satisfying?
					 */
					boolean isCharFreqMatch = minWindowMap.get(leftChar).intValue() < requiredCharMap.get(leftChar)
							.intValue();
					if (isCharFreqMatch) {
						/*
						 * If so then we have one less character frequency mapping in the window that
						 * matches
						 */
						charFrequenciesInWindowThatMatch--;
					}
				}
				/*
				 * Move the left point forward. We will keep going until the window no longer
				 * satisfies.
				 */
				left++;
			}
			/*
			 * We have moved left as far as it could go. It either led to a window that no
			 * longer satisfied or left passed the right pointer. Either way...advance the
			 * right pointer.
			 */
			right++;
		}

		return minWindowSubString;
	}

	private static Map<Character, Integer> buildRequiredCharMap(String t) {
		Map<Character, Integer> map = new HashMap<>();
		for (char c : t.toCharArray()) {
			int occurrences = map.getOrDefault(c, 0);
			map.put(c, occurrences + 1);
		}
		return map;
	}

	private static void insertCharToMinWindow(char c, Map<Character, Integer> map) {
		int occurrences = map.getOrDefault(c, 0);
		map.put(c, occurrences + 1);
	}
}
