package leetcode;

import java.util.Arrays;

/**
 * @author u230107
 *
 *         LeetCode Ques - 37 {Sudoku Solver}
 *         https://leetcode.com/problems/sudoku-solver/
 *
 *         Write a program to solve a Sudoku puzzle by filling the empty cells.
 *
 *         A sudoku solution must satisfy all of the following rules: Each of
 *         the digits 1-9 must occur exactly once in each row. Each of the
 *         digits 1-9 must occur exactly once in each column. Each of the the
 *         digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of
 *         the grid. Empty cells are indicated by the character '.'.
 *
 *         [ [5, 3, ., ., 7, ., ., ., .], [6, ., ., 1, 9, 5, ., ., .], [., 9, 8,
 *         ., ., ., ., 6, .], [8, ., ., ., 6, ., ., ., 3], [4, ., ., 8, ., 3, .,
 *         ., 1], [7, ., ., ., 2, ., ., ., 6], [., 6, ., ., ., ., 2, 8, .], [.,
 *         ., ., 4, 1, 9, ., ., 5], [., ., ., ., 8, ., ., 7, 9] ] 
 *         A sudoku puzzle...
 * 
 *         [ [5, 3, 4, 6, 7, 8, 9, 1, 2], [6, 7, 2, 1, 9, 5, 3, 4, 8], [1, 9, 8,
 *         3, 4, 2, 5, 6, 7], [8, 5, 9, 7, 6, 1, 4, 2, 3], [4, 2, 6, 8, 5, 3, 7,
 *         9, 1], [7, 1, 3, 9, 2, 4, 8, 5, 6], [9, 6, 1, 5, 3, 7, 2, 8, 4], [2,
 *         8, 7, 4, 1, 9, 6, 3, 5], [3, 4, 5, 2, 8, 6, 1, 7, 9] ] ...and its
 *         solution numbers marked in red.
 *
 *         Note: The given board contain only digits 1-9and the character '.'.
 *         You may assume that the given Sudoku puzzle will have a single unique
 *         solution. The given board size is always 9x9.
 *
 *         Time Complexity = O(9^S) where S represents Empty spaces in the
 *         board. Space Complexity = O(1) , No extra space
 */
public class SudokuSolver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		char[][] board = { 
							{ '5', '3', '.', '.', '7', '.', '.', '.', '.' },
							{ '6', '.', '.', '1', '9', '5', '.', '.', '.' }, 
							{ '.', '9', '8', '.', '.', '.', '.', '6', '.' },
							{ '8', '.', '.', '.', '6', '.', '.', '.', '3' }, 
							{ '4', '.', '.', '8', '.', '3', '.', '.', '1' },
							{ '7', '.', '.', '.', '2', '.', '.', '.', '6' }, 
							{ '.', '6', '.', '.', '.', '.', '2', '8', '.' },
							{ '.', '.', '.', '4', '1', '9', '.', '.', '5' }, 
							{ '.', '.', '.', '.', '8', '.', '.', '7', '9' } 
						};
		SudokuSolver obj = new SudokuSolver();
		System.out.println(Arrays.deepToString(board));
		obj.solveSudoku(board);
		System.out.println(Arrays.deepToString(board));
	}

	public void solveSudoku(char[][] board) {
		if (board == null || board.length == 0) {
			return;
		}
		solveSudokuHelper(board);
	}

	/**
	 *
	 * @param board
	 *
	 *              DFS + BackTracking
	 */
	private boolean solveSudokuHelper(char[][] board) {
		for (int row = 0; row < 9; row++) {
			for (int col = 0; col < 9; col++) {
				if (board[row][col] != '.') {
					continue;
				}
				for (char k = '1'; k <= '9'; k++) {
					if (isValid(board, row, col, k)) {
						board[row][col] = k;
						// Recursive call
						if (solveSudokuHelper(board)) {
							return true; // Correct combination of numbers is placed in all cells.
						}
						// BackTrack current cell value, As the current combination of numbers is incorrect.
						board[row][col] = '.';
					}
				}
				// All 1 to 9 numbers are already present in the current row/column/square.
				// As there is no number to place, return as false, which will initiate backtracking{board[i][j] = '.';}
				return false;
			}
		}
		return true; // return true if all cells are already filled
	}

	private boolean isValid(char[][] board, int row, int col, char ch) {
		for (int i = 0; i < 9; i++) {
			if (board[row][i] == ch) {
				return false;
			}
			if (board[i][col] == ch) {
				return false;
			}

			// We have 9 squares.
			if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == ch) {
				return false;
			}
		}
		return true;
	}
}
