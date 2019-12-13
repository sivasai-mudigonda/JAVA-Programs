/**
 * 
 */
package leetcode;

/**
* @author u230107
*
* Leet-code Ques - 395 {Longest Substring with At Least K Repeating Characters} {Medium}
* https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/
*
* Find the length of the longest substring T of a given string such that every character in T appears no less than k times.
* (consists of lowercase letters only)
*
	Example 1:
	Input:
	s = "aaabb", k = 3
	Output:
	3
	Explanation:
	The longest substring is "aaa", as 'a' is repeated 3 times.
	
	Example 2:
	Input:
	s = "ababbc", k = 2
	Output:
	5
	Explanation:
	The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.
*
* Solution:
* Divide and conquer solution.
* The idea at its core is that for the given segment of substring [l, r], count occurrence of each character.
* If any character occurs less than k time, meaning that character cannot be in the solution.
* Thus we “split” on that character and recurse on both left [l, i – 1], and right [i + 1, r], and return the max of the two.
*
* Two base cases.
* 1.> If the length of the segment is already less than k, it’s impossible to be valid, thus return 0.
* 2.> if every character in the segment occurs no less than k times, the segment is valid, thus return its length.h.
*
* Note:
* The question states that every character in the string needs to appear at least k times,
* therefore every character that is too infrequent cannot be a part of any substring.
*
* Time Complexity = O(26*N) = O(N) - Each char is split at most once
* Space Complexity = o(N) - Call stack
*
*/
public class Longest_Substring_With_AtLeast_K_Repeating_Chars {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Longest_Substring_With_AtLeast_K_Repeating_Chars obj = new Longest_Substring_With_AtLeast_K_Repeating_Chars();

		String s = "aaabb";
		int k = 3;
		System.out.println("Length of the longest substring = " + obj.longestSubstring(s, k)); // Expected Result = 3

		s = "ababbc";
		k = 2;
		System.out.println("Length of the longest substring = " + obj.longestSubstring(s, k)); // Expected Result = 5

		s = "aambbcc";
		k = 2;
		System.out.println("Length of the longest substring = " + obj.longestSubstring(s, k)); // Expected Result = 4
	}

	/**
	 *
	 * @param s
	 * @param k
	 * @return
	 *
	 * Divide & Conquer Approach
	 *
	 */
	public int longestSubstring(String s, int k) {
		if (s == null || s.length() == 0 || s.length() < k || k <= 0) {
			return 0; /* stop searching if substring is already too short */
		} else if (k == 1) {
			return s.length();
		}
		int[] charsSet = new int[26]; // Can also use Map{Char,Count}
		// 1.> Count frequencies of each character.
		for (char c : s.toCharArray()) {
			charsSet[c - 'a']++;
		}
		// 2.> Check if there exists a character in String s whose frequency{count} is less than k.
		boolean flag = true;
		boolean isValid = false; // To check if there is at-least one valid character freq which is >=k in String s.
		for (int charFreq : charsSet) {
			if (charFreq >= k) {
				isValid = true;
			}
			if (charFreq > 0 && charFreq < k) {
				flag = false;
			}
			if (isValid && !flag) {
				break;
			}
		}

		// 3.1> If there is not a single valid char whose freq is >=k in String s, return 0.
		if (!isValid) {
			return 0;
		}
		// 3.2> If all characters are >=k, then s.length() will become the result.
		if (flag == true) {
			return s.length();
		}

		/*
		 * 4.> If there exists a character whose frequency is less than k in String s,
		 * 4.1> Calculate length of String from from left to right-1 by recursively
		 * calling longestSubstring method. right character is excluded because it is <k
		 * and it cannot be part of result. 
		 * 4.2> Move left pointer to right+1{Move to
		 * next character of <k character} for the next iteration
		 */
		int left = 0;
		int right = 0;
		int maxLength = 0;
		// otherwise we use all the infrequent elements as splits
		while (right < s.length()) {
			if (charsSet[s.charAt(right) - 'a'] < k && charsSet[s.charAt(right) - 'a'] > 0 ){ /* we land at index == i where this letter is INVALID, then we need divide and conquer*/
				// substring- Excludes right character. So, bounds will be left to right-1.
				// Split the string and recurse over the left part from start till current
				// and keep the maximum count
				maxLength = Integer.max(maxLength, longestSubstring(s.substring(left, right), k)); /* chopped part */
				left = right + 1; /* later part, basically this loop ensures that the string is CHOPPED into multiple pieces with INVALID letters EXCLUDED */
			}
			right++; // keep incrementing the right pointer.
		}
		// 5.> Check for last leftover window from left to end of the String.
		maxLength = Integer.max(maxLength, longestSubstring(s.substring(left), k)); /* we still have the last part not searched yet */
		return maxLength;
	}
}