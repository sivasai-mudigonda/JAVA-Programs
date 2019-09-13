/**
 * 
 */
package leetcode;

/**
 * @author u230107
 *
 *         Leet Code Ques - 38 - Count & Say
 *         https://leetcode.com/problems/count-and-say/
 *
 *         The count-and-say sequence is the sequence of integers beginning as
 *         follows: 1, 11, 21, 1211, 111221, ...
 * 
 *         1 is read off as "one 1" or 11. 11 is read off as "two 1s" or 21. 21
 *         is read off as "one 2, then one 1" or 1211.
 * 
 *         Given an integer n, generate the nth sequence.
 * 
 *         Note: The sequence of integers will be represented as a string.
 *
 *
 *
 *         For solution, please refer
 *         https://www.youtube.com/watch?v=TruT9EsGids
 */
public class CountAndSay {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(countAndSay(1)); // Expected output = 1
		System.out.println(countAndSay(4)); // Expected output = 1211
	}

	private static String countAndSay(int n) {
		// Base cases
		if (n <= 0) {
			return "";
		}

		/**
		 * Find nth term by generating all terms from 2 to n-1. Every term is generated
		 * using previous term.
		 **/

		String str = "1"; // Initialize to previous term
		while (n > 1) {
			StringBuilder tmp = new StringBuilder();
			char prev = str.charAt(0);
			int cnt = 1; // Initialize count of matching chars
			// Process previous term to find the next term.
			for (int j = 1; j < str.length(); j++) {
				// If current character does't match
				char curr = str.charAt(j);
				if (curr != prev) {
					tmp.append(cnt).append(prev); // Append count of str[j-1] to temp
					cnt = 1; // Reset count
					prev = curr;
				} else {
					cnt++; // If matches, then increment count of matching characters.
				}
			}
			tmp.append(cnt).append(prev);
			str = tmp.toString(); // Update str
			n--;
		}
		return str;
	}
}
