/**
* 
*/
package leetcode;

/**
 * @author u230107
 *
 */
public class LongestCommonPrefix {

	/**
	 * @param args
	 * 
	 *            LeetCode-14- Longest Common Prefix
	 *            https://leetcode.com/problems/longest-common-prefix/
	 * 
	 *            Write a function to find the longest common prefix string amongst
	 *            an array of strings. Longest common prefix for a pair of strings
	 *            S1 and S2 is the longest string S which is the prefix of both S1
	 *            and S2.
	 * 
	 *            As an example, longest common prefix of "abcdefgh" and "abcefgh"
	 *            is "abc". Given the array of strings, you need to find the longest
	 *            S which is the prefix of ALL the strings in the array.
	 * 
	 *            Example: Given the array as: ["abcdefgh","aefghijk","abcefgh"] The
	 *            answer would be “a”.
	 * 
	 *            Time Complexity = O(N^2) Time Complexity = o(N)
	 * 
	 *            Refer https://www.youtube.com/watch?v=Tj0VRPcj8pQ
	 */
	public static void main(String[] args) {
		String[] strArr = { "abcdefgh", "aefghijk", "abcefgh" };
		System.out.println(longestCommonPrefix(strArr)); // Expected output =a
		System.out.println(longestCommonPrefix(new String[] { "aaa", "aab", "aaa" })); // Expected output =aa
	}

	private static String longestCommonPrefix(String[] strArr) {
		String longestCommonPrefix = "";
		if (strArr == null || strArr.length == 0) {
			return longestCommonPrefix;
		}
		longestCommonPrefix = strArr[0];
		int i = 1;
		while (i < strArr.length) {
			String currStr = strArr[i];
			int j = 0;
			while (j < longestCommonPrefix.length() && j < currStr.length()
					&& longestCommonPrefix.charAt(j) == currStr.charAt(j)) {
				j++;
			}
			longestCommonPrefix = longestCommonPrefix.substring(0, j);
			i++;
		}
		return longestCommonPrefix;
	}
}
