package leetcode;

/**
* @author u230107
*
* LeetCode Ques - 308 {Range Sum Query 2D - Mutable}
* https://leetcode.com/problems/range-sum-query-2d-immutable/
*
* Given a 2D matrix matrix,
* find the sum of the elements inside the rectangle
* defined by its upper left corner (row1, col1) and lower right corner (row2, col2).
*
[3, 0, 1, 4, 2],
[5, 6, 3, 2, 1],
[1, { 2, 0, 1, 5],
[4, 1, 0, 1, 7],
[1, 0, 3, 0, } 5]
*
* The above rectangle (with flower braces) is defined by (row1, col1) = (2, 1) and (row2, col2) = (4, 3),
* which contains sum = 8
*
	Example:
	Given matrix = [
	[3, 0, 1, 4, 2],
	[5, 6, 3, 2, 1],
	[1, 2, 0, 1, 5],
	[4, 1, 0, 1, 7],
	[1, 0, 3, 0, 5]
	]
	sumRegion(2, 1, 4, 3) -> 8
	sumRegion(1, 1, 2, 2) -> 11
	sumRegion(1, 2, 2, 4) -> 12
*
* Note:
* 1.> You may assume that the matrix does not change.
* 2.> There are many calls to sumRegion function.
* 3.> You may assume that row1 ≤ row2 and col1 ≤ col2
*
* Solution:
* As there are many calls to sumRegion method, we should use extra space to store the intermediate results.{T array}
* {Copy Image from Below Link and store it, It is useful to understand solution}
* https://www.programcreek.com/2014/04/leetcode-range-sum-query-2d-immutable-java/
*
* Video Explanation Link:
* https://www.youtube.com/watch?v=PwDqpOMwg6U
*
* Time Complexity = O(N*M) - where N and M are rows and cols
* Space Complexity = o(N*M) - where N and M are rows and cols
*
*/
public class Range_Sum_Query_2D_Mutable {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Range_Sum_Query_2D_Mutable outerObj = new Range_Sum_Query_2D_Mutable();

		int[][] matrix = { { 3, 0, 1, 4, 2 }, { 5, 6, 3, 2, 1 }, { 1, 2, 0, 1, 5 }, { 4, 1, 0, 1, 7 },
				{ 1, 0, 3, 0, 5 } };
		NumMatrix obj = outerObj.new NumMatrix(matrix);
		System.out.println("Sum of the elements inside the Rectangle = " + obj.sumRegion(2, 1, 4, 3)); // Expected
																										// Result = 8
		System.out.println("Sum of the elements inside the Rectangle = " + obj.sumRegion(1, 1, 2, 2)); // Expected
																										// Result = 11
		System.out.println("Sum of the elements inside the Rectangle = " + obj.sumRegion(1, 2, 2, 4)); // Expected
																										// Result = 12
	}

	class NumMatrix {
		int[][] T; // Stores the sum value from (0,0) to the current cell.

		/**
		 *
		 * @param matrix
		 */
		public NumMatrix(int[][] matrix) {
			if(matrix==null || matrix.length==0){
	            return;
	        }
			T = new int[matrix.length + 1][matrix[0].length + 1]; // +1 is for convenience, it will be useful when we
																	// loop through T array.

			/**
			 * T[i][j-1] - Left element of T[i][j]. It includes T[i-1][j-1] element.
			 * T[i-1][j] - Top element of T[i][j]. It includes T[i-1][j-1] element.
			 * T[i-1][j-1] - As T[i-1][j-1] is added twice, We need to remove it once. We
			 * need to add it only once. matrix[i-1][j-1] - Current element value
			 *
			 */
			for (int i = 1; i < T.length; i++) {
				for (int j = 1; j < T[i].length; j++) {
					T[i][j] = T[i][j - 1] + T[i - 1][j] - T[i - 1][j - 1] + matrix[i - 1][j - 1];
				}
			}
		}

		/**
		 *
		 * @param row1
		 * @param col1
		 * @param row2
		 * @param col2
		 * @return
		 *
		 *         Time Complexity of sumRegion method is O(1) - Constant time
		 */
		public int sumRegion(int row1, int col1, int row2, int col2) {
			// Incrementing row and col to match with T matrix. {T matrix have values starting from i=1 and j=1}
			row1++;
			col1++;
			row2++;
			col2++;

			/*
			 * If we assume rectangle's edges as A{Top Left},B{Top Right},C{Bottom
			 * Left},D{Bottom Right} T[row2][col2] - Sum of total rectangle. {D element}
			 * T[row2][col1-1] - Element before C. It includes T[row1-1][col1-1] element.
			 * T[row1-1][col2] - Element above B. It includes T[row1-1][col1-1] element.
			 * T[row1-1][col1-1] - As T[row1-1][col1-1] is subtracted twice, We need to add
			 * it once. We need to remove it only once.
			 *
			 */
			int sum = T[row2][col2] - T[row2][col1 - 1] - T[row1 - 1][col2] + T[row1 - 1][col1 - 1];
			return sum;
		}
	}
}