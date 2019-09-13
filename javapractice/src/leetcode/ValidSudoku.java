/**
 * 
 */
package leetcode;

/**
 * @author u230107
 *
 *         Leet Code Ques-36 https://leetcode.com/problems/valid-sudoku/
 *
 *         Determine if a 9x9 Sudoku board is valid. Only the filled cells need
 *         to be validated according to the following rules:
 * 
 *         Each row must contain the digits 1-9without repetition. Each column
 *         must contain the digits 1-9 without repetition. Each of the 9 3x3
 *         sub-boxes of the grid must contain the digits 1-9 without repetition.
 *
 *         The Sudoku board could be partially filled, where empty cells are
 *         filled with the character '.'.
 * 
 *         Example 1:
 * 
 *         Input: [ ["5","3",".",".","7",".",".",".","."],
 *         ["6",".",".","1","9","5",".",".","."],
 *         [".","9","8",".",".",".",".","6","."],
 *         ["8",".",".",".","6",".",".",".","3"],
 *         ["4",".",".","8",".","3",".",".","1"],
 *         ["7",".",".",".","2",".",".",".","6"],
 *         [".","6",".",".",".",".","2","8","."],
 *         [".",".",".","4","1","9",".",".","5"],
 *         [".",".",".",".","8",".",".","7","9"] ] Output: true Example 2:
 * 
 *         Input: [ ["8","3",".",".","7",".",".",".","."],
 *         ["6",".",".","1","9","5",".",".","."],
 *         [".","9","8",".",".",".",".","6","."],
 *         ["8",".",".",".","6",".",".",".","3"],
 *         ["4",".",".","8",".","3",".",".","1"],
 *         ["7",".",".",".","2",".",".",".","6"],
 *         [".","6",".",".",".",".","2","8","."],
 *         [".",".",".","4","1","9",".",".","5"],
 *         [".",".",".",".","8",".",".","7","9"] ] Output: false Explanation:
 *         Same as Example 1, except with the 5 in the top left corner being
 *         modified to 8. Since there are two 8's in the top left 3x3 sub-box,
 *         it is invalid. Note:
 * 
 *         A Sudoku board (partially filled) could be valid but is not
 *         necessarily solvable. Only the filled cells need to be validated
 *         according to the mentioned rules. The given board contain only digits
 *         1-9and the character '.'. The given board size is always 9x9.
 *
 *
 *         For Solution Refer: Video =
 *         https://www.youtube.com/watch?v=i2YKwM9oCcY Code =
 *         https://github.com/acethecodinginterview/AceTheCodingInterview/blob/master/ValidSudoku/Solution.java
 *
 *         Time Complexity = O(n^2)
 *
 */
public class ValidSudoku {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		char[][] board = { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
				{ '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
				{ '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
				{ '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
				{ '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };
		System.out.println(isValidSudoku(board));

		char[][] board2 = { { '8', '3', '.', '.', '7', '.', '.', '.', '.' },
				{ '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
				{ '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
				{ '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
				{ '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };
		System.out.println(isValidSudoku(board2));
	}

	private static boolean isValidSudoku(char[][] board) {
		short rows[] = new short[9];
		short cols[] = new short[9];
		short squares[] = new short[9];

		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[0].length; col++) {
				if (board[row][col] == '.') {
					continue;
				}

				/*
				 * We are representing digits 1 to 9 by 0's and 1's. 1 means digit is present, 0
				 * means not present. We are left shifting 1 to the location where the digit is
				 * present.
				 *
				 */
				short value = (short) (1 << (board[row][col] - '1'));

				/**
				 * We are checking if the value is already present in the row or col or square
				 * by using & operator.
				 */
				if ((value & rows[row]) > 0) {
					return false;
				}
				if ((value & cols[col]) > 0) {
					return false;
				}
				if ((value & squares[3 * (row / 3) + col / 3]) > 0) { // We have 9 squares. 3*(row/3)+col/3] gives which
																		// square we are in.
					return false;
				}

				/**
				 * We are storing the value in to the arrays by using | operator.
				 */
				rows[row] |= value;
				cols[col] |= value;
				squares[3 * (row / 3) + col / 3] |= value;
			}
		}
		return true;
	}
}