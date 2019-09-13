package leetcode;

/**
 * @author u230107
 *
 *         Leet Code-62 {Unique Paths}
 *         https://leetcode.com/problems/unique-paths/
 *
 *         A robot is located at the top-left corner of a m x n grid (marked
 *         ‘Start’ in the diagram below). The robot can only move either down or
 *         right at any point in time. The robot is trying to reach the
 *         bottom-right corner of the grid (marked ‘Finish’ in the diagram
 *         below). How many possible unique paths are there? Note: m and n will
 *         be at most 100.
 *
 *         Example Example 1:
 * 
 *         Input: n = 1, m = 3 Output: 1 Explanation: Only one path to target
 *         position. Example 2:
 * 
 *         Input: n = 3, m = 3 Output: 6 Explanation: D : Down R : Right 1) DDRR
 *         2) DRDR 3) DRRD 4) RRDD 5) RDRD 6) RDDR
 *
 *         For sol, Refer http://www.goodtecher.com/leetcode-62-unique-paths/ To
 *         understand sol, refer
 *         https://medium.com/@rachit.slt/leetcode-unique-paths-207c0223a136
 *         Time Complexity = O(M * N) Space Complexity = o(M * N)
 */
public class UniquePaths {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Unique Paths =" + uniquePaths(3, 2)); // Expected Result = 3
		System.out.println("Unique Paths =" + uniquePaths(7, 3)); // Expected Result = 28
	}

	private static int uniquePaths(int m, int n) {
		if (m == 0 || n == 0) {
			return 0;
		}

		int[][] numOfPaths = new int[m][n];

// Mark left most bordering row values as 1 as we can traverse only right for those cells
		for (int i = 0; i < m; i++) {
			numOfPaths[i][0] = 1;
		}

// Mark top most bordering row values as 1 as we can traverse only down for those cells
		for (int j = 0; j < n; j++) {
			numOfPaths[0][j] = 1;
		}

// Number of paths reaching a given point is the sum of paths reaching the point above it and the point to the left of it
		for (int r = 1; r < m; r++) {
			for (int c = 1; c < n; c++) {
				numOfPaths[r][c] = numOfPaths[r - 1][c] + numOfPaths[r][c - 1];
			}
		}
		return numOfPaths[m - 1][n - 1]; // Last cell/Target
	}
}