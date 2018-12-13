package javapractice;

import java.util.Arrays;

public class MatrixRotation {
	private static int N = 2;
	public static void main(String[] args) {
		// Test Case 1
		/*
		 * int mat[][] = { {1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}
		 * };
		 */

		// Tese Case 2
		/*
		 * int mat[][] = { {1, 2, 3}, {4, 5, 6}, {7, 8, 9} };
		 */

		// Tese Case 3
		int mat[][] = { 
						{ 1, 2 }, 
						{ 3, 4 } 
					  };

		// displayMatrix(mat);
		System.out.println(Arrays.deepToString(mat));
		rotateMatrix(mat);
		System.out.println("**********************");
		System.out.println(Arrays.deepToString(mat));
	}

	private static void rotateMatrix(int mat[][]) {
		for (int x = 0; x < N / 2; x++) {
			for (int y = x; y < N - 1 - x; y++) {
				// Anti-clockwise 90deg rotation
				/*
				 * int temp=mat[x][y]; mat[x][y]= mat[y][N-1-x];
				 * mat[y][N-1-x]=mat[N-1-x][N-1-y]; mat[N-1-x][N-1-y]=mat[N-1-y][x];
				 * mat[N-1-y][x]=temp;
				 */

				// anti-clockwise 90deg rotation
				int temp1 = mat[x][y];
				mat[x][y] = mat[N - 1 - y][x];
				mat[N - 1 - y][x] = mat[N - 1 - x][N - 1 - y];
				mat[N - 1 - x][N - 1 - y] = mat[y][N - 1 - x];
				mat[y][N - 1 - x] = temp1;
			}
		}
	}
}
