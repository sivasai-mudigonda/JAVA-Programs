/**
 * 
 */
package leetcode;

import java.util.Arrays;

/**
 * @author u230107
 * 
 *         Leet Code - 48 {Rotate Image}
 *
 *
 *         You are given an n x n 2D matrix representing an image. Rotate the
 *         image by 90 degrees (clockwise).
 *
 *         Note: You have to rotate the image in-place, which means you have to
 *         modify the input 2D matrix directly. DO NOT allocate another 2D
 *         matrix and do the rotation.
 *
 *         Example 1: Given input matrix = [ [1,2,3], [4,5,6], [7,8,9] ], rotate
 *         the input matrix in-place such that it becomes: [ [7,4,1], [8,5,2],
 *         [9,6,3] ]
 * 
 *         For Sol, check
 *         https://medium.com/@monisha.mary.mathew/rotate-image-fdfffd07250b
 * 
 * 
 */
public class RotateImage {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int matrix[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		rotateImage(matrix);
		System.out.println("**************************");
		int matrix1[][] = { { 5, 1, 9, 11 }, { 2, 4, 8, 10 }, { 13, 3, 6, 7 }, { 15, 14, 12, 16 } };
		rotateImage(matrix1);
	}

	private static void rotateImage(int[][] matrix) {
		int length = matrix.length;
// Reverse Rows
		for (int r = 0; r < length / 2; r++) { // /2 is because we are operating on 2 rows at a time.
			for (int c = 0; c < matrix[0].length; c++) {
				int curr = matrix[r][c];
				matrix[r][c] = matrix[length - r - 1][c]; // When we reverse, col remains same, row changes because we
															// are reversing first with last row and so on
				matrix[length - r - 1][c] = curr;
			}
		}
		System.out.println(Arrays.deepToString(matrix));
		System.out.println("**************************");

// Swap Diagonally {Swapping row with column and column with row}
		for (int r = 0; r < length - 1; r++) {
			for (int c = r + 1; c < matrix[0].length; c++) {
				int curr = matrix[r][c];
				matrix[r][c] = matrix[c][r];
				matrix[c][r] = curr;
			}
		}
		System.out.println(Arrays.deepToString(matrix));
		/**
		 * eg:1 Expected Output: [ [7, 4, 1], [8, 5, 2], [9, 6, 3] ]
		 *
		 * eg:2 Expected Output: [ [15, 13, 2, 5], [14, 3, 4, 1], [12, 6, 8, 9], [16, 7,
		 * 10, 11] ]
		 */
	}

}
