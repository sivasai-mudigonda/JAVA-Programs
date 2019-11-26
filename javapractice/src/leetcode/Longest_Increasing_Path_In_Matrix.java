package leetcode;

/**
* @author u230107
*
* LeetCode Ques - 329 {Longest Increasing Path in a Matrix} {Medium}
* https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
*
* Given an integer matrix, find the length of the longest increasing path.
* From each cell, you can either move to four directions: left, right, up or down.
* You may NOT move diagonally or move outside of the boundary
* (ie wrap-around is not allowed).
*
	Example 1:
	Input: nums =
	[
	[ 9 , 9,4],
	[ 6 , 6,8],
	[ 2,1 , 1]
	]
	Output: 4
	Explanation: The longest increasing path is [1, 2, 6, 9] .
	
	Example 2:
	Input: nums =
	[
	[3,4,5],
	[3,2,6],
	[2,2,1]
	]
	Output: 4
	Explanation: The longest increasing path is [3, 4, 5, 6] . Moving diagonally is not allowed.
*
* Solution:
* DFS+Memorization
*
* Time Complexity = O(M*N) - Loop through matrix{M/N} array
* Space Complexity = o(M*N) - Space used for dp array to store length of increasing path for every element present in matrix array
*
*/
public class Longest_Increasing_Path_In_Matrix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Longest_Increasing_Path_In_Matrix obj = new Longest_Increasing_Path_In_Matrix();

		int[][] matrix_1 = { { 9, 9, 4 }, { 6, 6, 8 }, { 2, 1, 1 } };
		System.out.println("Length of longest increasing path = " + obj.longestIncreasingPath(matrix_1)); // Expected Output = 4

		System.out.println("**********************************");

		int[][] matrix_2 = { { 3, 4, 5 }, { 3, 2, 6 }, { 2, 2, 1 } };
		System.out.println("Length of longest increasing path = " + obj.longestIncreasingPath(matrix_2)); // Expected Output = 4
		
		System.out.println("**********************************");
		
		int[][] matrix_3 = {
							 {2147483647,1}
						   };
		System.out.println("Length of longest increasing path = " + obj.longestIncreasingPath(matrix_3)); // Expected Output = 2
	}
	
	/**
	 * 
	 * @param matrix
	 * @return
	 */
	public int longestIncreasingPath(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}
		int max_result = 0;
		// dp[i][j] stores the value of length of longest increasing sequence for sub matrix starting from ith row and jth column.
		int[][] dp = new int[matrix.length][matrix[0].length];
		// Loop through matrix array
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				int length = helper(matrix, i, j, dp,  Integer.MAX_VALUE+1L);
				max_result = Math.max(length, max_result);
			}
		}
		return max_result;
	}

	/**
	 *
	 * @param matrix
	 * @param row
	 * @param col
	 * @param dp
	 * @param prevVal
	 * @return
	 *
	 * DFS+Memorization
	 *
	 */
	private int helper(int[][] matrix, int row, int col, int[][] dp, long prevVal) {
		// Check for boundaries and current value{matrix[]row[col]} is smaller than prevVal or not.
		// If current value is larger than prevVal, then return zero.
		if (row < 0 || col < 0 || row >= matrix.length || col >= matrix[0].length || matrix[row][col] >= prevVal ){
			return 0;
		}

		if (dp[row][col] > 0) {
			// Return if length of increasing path is already present in dp{Already calculated} array
			return dp[row][col];
		} else {
			int currVal = matrix[row][col];
			int tempSum = 0;
			// Check on four sides of current element in the matrix
			tempSum = Math.max(helper(matrix, row - 1, col, dp, currVal), tempSum); // Return max of tempSum and element left to current
			tempSum = Math.max(helper(matrix, row + 1, col, dp, currVal), tempSum); // Return max of tempSum and element right to current
			tempSum = Math.max(helper(matrix, row, col - 1, dp, currVal), tempSum); // Return max of tempSum and element above to current
			tempSum = Math.max(helper(matrix, row, col + 1, dp, currVal), tempSum); // Return max of tempSum and element below to current
			tempSum++; // Increment length of increasing path for current element
			dp[row][col] = tempSum;
			return tempSum;
		}
	}
}