/**
 * 
 */
package leetcode;

import java.util.Arrays;

/**
 * @author u230107
 *
 */
public class DecodeWays {

	/**
	 * @param args
	 *
	 *             LeetCode Ques - 91 {Decode Ways}
	 *             https://leetcode.com/problems/decode-ways/
	 *
	 *             A message containing letters from A-Z is being encoded to numbers
	 *             using the following mapping: 'A' -> 1 'B' -> 2 ... 'Z' -> 26
	 *             Given a non-empty string containing digits, determine the total
	 *             number of ways to decode it.
	 *
	 *             Example 1: Input: “12” Output: 2 Explanation: It could be decoded
	 *             as “AB” (1 2) or “L” (12).
	 * 
	 *             Example 2: Input: “226” Output: 3 Explanation: It could be
	 *             decoded as “BZ” (2 26), “VF” (22 6), or “BBF” (2 2 6).
	 *
	 *             For Sol, Refer https://www.youtube.com/watch?v=YcJTyrG3bZs Time
	 *             Complexity = O(N) Space Complexity = O(N)
	 */
	public static void main(String[] args) {
		System.out.println("Total number of ways to decode = " + numDecodings("12")); // Expected output = 2
		System.out.println("Total number of ways to decode = " + numDecodings("226")); // Expected output = 3
	}

	private static int numDecodings(String s) {
		/*
		 * We will cache the answers to our subproblems
		 */
		int[] prevAnswers = new int[s.length()]; // Memorization
		Arrays.fill(prevAnswers, -1);
		return decodeUtil(s, 0, prevAnswers);
	}

	private static int decodeUtil(String s, int decodePtr, int[] prevAnswers) {
		/*
		 * If our decoding pointer out of bounds then we know that we have exhausted our
		 * ability to decode the string
		 */
		if (decodePtr >= s.length()) {
			return 1;
		}
		/*
		 * If we already know the answer to this subproblem then just return it, don't
		 * waste time calculating it
		 */
		if (prevAnswers[decodePtr] > -1) {
			return prevAnswers[decodePtr];
		}
		int totalWaysFromHere = 0;
		if (decodePtr + 1 <= s.length()) {
			String firstWay = s.substring(decodePtr, decodePtr + 1); // single character decoding
			if (isValid(firstWay)) {
				totalWaysFromHere += decodeUtil(s, decodePtr + 1, prevAnswers);
			}
		}

		if (decodePtr + 2 <= s.length()) {
			String secondWay = s.substring(decodePtr, decodePtr + 2); // 2 character decoding
			if (isValid(secondWay)) {
				/*
				 * If this is a valid decoding then recurse on it since it is ONE valid way to
				 * decode a piece of the string off. If it is INVALID we will not factor this
				 * way of decoing in and the path in the "tree" of recursion is cut short
				 */
				totalWaysFromHere += decodeUtil(s, decodePtr + 2, prevAnswers);
			}

		}
		/*
		 * CACHE THE SUBPROBLEM ANSWER. We will need this later when asked more
		 * subproblems
		 */
		prevAnswers[decodePtr] = totalWaysFromHere;
		return prevAnswers[decodePtr]; // The answer to this subproblem
	}

	/*
	 * Simple helper function to checks if a substring is a valid decoding.
	 */
	private static boolean isValid(String s) {
		if (s.length() == 0 || s.charAt(0) == '0') {
			return false;
		}
		int value = Integer.parseInt(s);
		return (value > 0 && value <= 26);
	}
}