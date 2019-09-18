package arrays;

import java.util.Arrays;

/*
* Write an algorithm such that if an element in an MxN matrix is 0, its entire row and
* column is set to 0.
* 
* sol:
* 1) Scan the first row and set a variable rowFlag to indicate whether we need to set all 1s in first row or not.
* 2) Scan the first column and set a variable colFlag to indicate whether we need to set all 1s in first column or not.
* 3) Use first row and first column as the auxiliary arrays row[] and col[] respectively, consider the matrix as submatrix starting from second row and second column and apply method 1.
* 4) Finally, using rowFlag and colFlag, update first row and first column if needed.
*/
public class MatrixSetZeros {

	private static int ROWS = 3;
	private static int COLUMS = 4;

	public static void main(String[] args) {
		int mat[][] = { { 0, 1, 1, 0 }, { 1, 1, 0, 1 }, { 1, 1, 1, 1 }, };
		setZerosExtraSpace(mat);
		printMatrix(mat);

		System.out.println("\t" + "******************");
		int mat1[][] = { { 0, 1, 1, 0 }, { 1, 1, 0, 1 }, { 1, 1, 1, 1 }, };
		setZeros(mat1);
		printMatrix(mat1);
	}

	// No Extra space
	private static void setZeros(int[][] matrix) {
		boolean row_flag = false;
		boolean col_flag = false;

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (i == 0 && matrix[i][j] == 0) {
					row_flag = true;
				}
				if (j == 0 && matrix[i][j] == 0) {
					col_flag = true;
				}
				if (matrix[i][j] == 0) {
					matrix[0][j] = 0;
					matrix[i][0] = 0;
				}
			}
		}

		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[0].length; j++) {
				if (matrix[0][j] == 0 || matrix[i][0] == 0) {
					matrix[i][j] = 0;
				}
			}
		}

		if (row_flag == true) {
			for (int i = 0; i < matrix[0].length; i++) {
				matrix[0][i] = 0;
			}
		}

		if (col_flag == true) {
			for (int i = 0; i < matrix.length; i++) {
				matrix[i][0] = 0;
			}
		}
	}

	// Using extra space.
	private static void setZerosExtraSpace(int[][] matrix) {
		int[] rows = new int[ROWS];
		int[] colums = new int[COLUMS];
		Arrays.fill(rows, 1);
		Arrays.fill(colums, 1);

		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLUMS; j++) {
				if (matrix[i][j] == 0) {
					rows[i] = 0;
					colums[j] = 0;

				}
			}
		}

		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLUMS; j++) {
				if (rows[i] == 0 || colums[j] == 0) {
					matrix[i][j] = 0;
				}
			}
		}
	}

	private static void printMatrix(int[][] matrix) {
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLUMS; j++) {
				System.out.print("\t" + matrix[i][j]);
			}
			System.out.println();
		}
	}
}
