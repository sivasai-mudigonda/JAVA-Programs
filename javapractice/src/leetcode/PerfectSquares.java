package leetcode;

import java.util.Arrays;

/**
* @author u230107
*
* LeetCode Ques - 279 {Perfect Squares}
* https://leetcode.com/problems/perfect-squares/
*
* Given a positive integer n,
* find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
*
	Example 1:
	Input: n = 12
	Output: 3
	Explanation: 12 = 4 + 4 + 4.
	
	Example 2:
	Input: n = 13
	Output: 2
	Explanation: 13 = 4 + 9
*
* Solution:
* dp[5] = min{
* dp[5 – 2 * 2] + 1 = dp[1] + 1 = (dp[1 – 1 * 1] + 1) + 1 = dp[0] + 1 + 1 = 2,
* dp[5 – 1 * 1] + 1 = dp[3] + 1 = (dp[3 – 1 * 1] + 1) + 1 = dp[1] + 2 = dp[1 – 1*1] + 1 + 2 = dp[0] + 3 = 3
* };
* dp[5] = 2
*
* From this we can find a pattern, that is
* if i==j*j, then
* dp[i]=1;
* else if i>j*j, then
* dp[i] = min{dp[i – j * j] + 1}
*
* Time Complexity = O(N*SQRT(N))
* Space Complexity = o(N)
*
*/
public class PerfectSquares {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PerfectSquares obj = new PerfectSquares();

		int n = 12;
		System.out.println("Least number of perfect square numbers = " + obj.numSquares(n)); // Expected Output = 3
																								// {2^2+2^2+2^2}

		n = 13;
		System.out.println("Least number of perfect square numbers = " + obj.numSquares(n)); // Expected Output = 2
																								// {3^2+2^2}
	}

	/**
	 *
	 * @param n
	 * @return
	 *
	 *         We are memorizing using dp array as we will be encountering same sub
	 *         problem repetitively.
	 */
	public int numSquares(int n) {
		if (n <= 3) {
			return n;
		}
		int[] dp = new int[n + 1]; /// We need to store values from 0 to n, therefore n+1
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 3;
		for (int i = 4; i <= n; i++) {
			for (int j = 1; j <= Math.sqrt(n); j++) { // n cannot have perfect squares more than sqrt(n)
				if (i == j * j) {
					dp[i] = 1; // eg: i=4 and j=2, 2*2 =4, one perfect number is sufficient
				} else if (i > j * j) {
					dp[i] = Math.min(dp[i], dp[i - (j * j)] + 1); // eg: i=5 and j=2, See explanation under "Solution"
																	// at line 26.
				}
			}
		}
		return dp[n]; // final resu;t for n will be stored in dp[n]
	}
}
