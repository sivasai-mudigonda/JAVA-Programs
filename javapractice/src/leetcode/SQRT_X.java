package leetcode;

/**
 * @author u230107
 *
 *         Leet Code Ques - 69- Sqrt(x) https://leetcode.com/problems/sqrtx/
 *
 *         Compute and return the square root of x, where x is guaranteed to be
 *         a non-negative integer. Since the return type is an integer, the
 *         decimal digits are truncated and only the integer part of the result
 *         is returned. Example 1: Input: 4 Output: 2 Example 2: Input: 8
 *         Output: 2 Explanation: The square root of 8 is 2.82842..., and since
 *         the decimal part is truncated, 2 is returned.
 *
 *
 *         Time Complexity = O(log N) Space Complecity =O(1)
 */
public class SQRT_X {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(mySqrt(4)); // Expected output = 2
		System.out.println(mySqrt(8)); // Expected output = 2
	}

//Square root of n will lie in the range [1, n].
//So we need to search for x in a sorted array such that x/mid >=mid equals given number.
	private static int mySqrt(int x) {
		if (x == 0 || x == 1) {
			return x;
		}
		int left = 0, right = x;
		int mid = 0, res = 0;
		while (left <= right) {
			mid = left + (right - left) / 2;
			if (x / mid >= mid) {
				left = mid + 1;
				res = mid;
			} else {
				right = mid - 1;
			}
		}
		return res;
	}
}