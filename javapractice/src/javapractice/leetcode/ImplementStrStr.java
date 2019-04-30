/**
* 
*/
package leetcode;

/**
 * @author u230107
 *
 */
public class ImplementStrStr {

	/**
	 * 
	 * Leet Code - 28 - Implement strStr()
	 * https://leetcode.com/problems/implement-strstr/
	 * 
	 * Implement strStr().
	 *
	 * Return the index of the first occurrence of needle in haystack, or -1 if
	 * needle is not part of haystack.
	 *
	 * Example 1:
	 *
	 * Input: haystack = "hello", needle = "ll" Output: 2 Example 2:
	 *
	 * Input: haystack = "aaaaa", needle = "bba" Output: -1
	 *
	 * Clarification: What should we return when needle is an empty string? This is
	 * a great question to ask during an interview.
	 *
	 * For the purpose of this problem, we will return 0 when needle is an empty
	 * string. This is consistent to C's strstr() and Java's indexOf().
	 * 
	 * Time Complexity = O(M*N), where M is length of String and N is length of
	 * needle. Space Complexity = o(1)
	 *
	 */
	public ImplementStrStr() {
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int startPt = implStrStr("goodtecher", "teah");
		System.out.println(startPt);

		startPt = implStrStr("hello", "ll");
		System.out.println(startPt);

		startPt = implStrStr("aaaaa", "bba");
		System.out.println(startPt);
	}

	private static int implStrStr(String hayStack, String needle) {
		if (hayStack == null || needle == null || hayStack.length() == 0 || needle.length() == 0
				|| (hayStack.length() == needle.length() && needle.equalsIgnoreCase(hayStack))) {
			return 0;
		}
		/*
		 * Iterate hayStack. hayStack.length()-needle.length()+1 --> No need to go
		 * through these last characters eg: hayStack = hello and needle=la After
		 * checking for "hello", there is no point checking for last o as it anyhow does
		 * not match.
		 */
		for (int i = 0; i < hayStack.length() - needle.length() + 1; i++) {
			int indexHayStack = i;
			// Iterate Needle
			for (int j = 0; j < needle.length(); j++) {
				if (hayStack.charAt(indexHayStack) == needle.charAt(j)) {
					if (j == needle.length() - 1) {
						return i; // Return start Index as we reached end of needle.
					}
					indexHayStack++;
				} else {
					break; // Break Inner Loop
				}
			}
		}
		return -1;
	}
}
