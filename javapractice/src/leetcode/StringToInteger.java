/**
* 
*/
package leetcode;

/**
 * @author u230107 LeetCode - 8
 *         https://leetcode.com/problems/string-to-integer-atoi/
 * 
 *         Q- Implement atoi to convert a string to an integer?
 * 
 *         Sol: Refer
 *         https://github.com/chubbysingh/coding/blob/master/src/Leetcode/Q008_String_to_Integer.java
 *
 */
public class StringToInteger {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "-234543241";
		System.out.println("String To Integer Value = " + StringToIntUtil(str));
	}

	private static int StringToIntUtil(String str) {
		if (str == null || str.isEmpty()) {
			return 0;
		}
		int index = 0;
		boolean isNeg = false;
		if (str.charAt(0) == '-') {
			isNeg = true;
			index++;
		} else if (str.charAt(1) == '+') {
			index++;
		}

		long result = 0;
		for (int i = index; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (ch >= '0' && ch <= '9') {
				result = result * 10 + (ch - '0');
			} else {
				break;
			}
		}

		if (isNeg) {
			result = 0 - result;
		}
		if (result >= Integer.MAX_VALUE) {
			return Integer.MAX_VALUE;
		} else if (result <= Integer.MIN_VALUE) {
			return Integer.MIN_VALUE;
		}
		return (int) result;
	}
}
