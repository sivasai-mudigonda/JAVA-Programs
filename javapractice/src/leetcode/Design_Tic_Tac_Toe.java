package leetcode;

/**
 * 	@author u230107
 *
 *  Leetcode Ques - 348 {Design Tic-Tac-Toe} {Medium}
 *  https://leetcode.com/problems/valid-tic-tac-toe-state/
 *
 *  Design a Tic-tac-toe game that is played between two players on a n x
 *  n grid.
 *
 *  You may assume the following rules: A move is guaranteed to be valid
 *  and is placed on an empty block. Once a winning condition is reached,
 *  no more moves is allowed. A player who succeeds in placing n of their
 *  marks in a horizontal, vertical, or diagonal row wins the game.
 *
 *  Example: Given n = 3, assume that player 1 is "X" and player 2 is "O"
 *  in the board.
 * 
 *  TicTacToe toe = new TicTacToe(3);
 * 
 *  toe.move(0, 0, 1); -> Returns 0 (no one wins)
 * |X| | |
 * | | | |    // Player 1 makes a move at (0, 0).
 * | | | |
 * 
 * toe.move(0, 2, 2); -> Returns 0 (no one wins)
 * |X| |O|
 * | | | |    // Player 2 makes a move at (0, 2).
 * | | | |
 * 
 * toe.move(2, 2, 1); -> Returns 0 (no one wins)
 * |X| |O|
 * | | | |    // Player 1 makes a move at (2, 2).
 * | | |X|
 * 
 * toe.move(1, 1, 2); -> Returns 0 (no one wins)
 * |X| |O|
 * | |O| |    // Player 2 makes a move at (1, 1).
 * | | |X|
 * 
 * toe.move(2, 0, 1); -> Returns 0 (no one wins)
 * |X| |O|
 * | |O| |    // Player 1 makes a move at (2, 0).
 * |X| |X|
 * 
 * toe.move(1, 0, 2); -> Returns 0 (no one wins)
 * |X| |O|
 * |O|O| |    // Player 2 makes a move at (1, 0).
 * |X| |X|
 * 
 * toe.move(2, 1, 1); -> Returns 1 (player 1 wins)
 * |X| |O|
 * |O|O| |    // Player 1 makes a move at (2, 1).
 * |X|X|X|
 *
 *  Follow up: Could you do better than O(n2) per move() operation?
 *
 *  Solution: 1.> Create a one-dimensional array of rows and cols of size
 *  n, as well as the variable diagonal diag and inverse diagonal.
 *
 *  2.> If player 1 puts a child in a certain column of the first row,
 *  then rows [0] increases by 1, If player 2 puts a child in a certain
 *  column of first row, rows [0] decreases by 1.
 *
 *  3.> When rows [0] is equal to n or -n, it means that the children of
 *  the first row are all put by a player, which means player 1 or 2 have
 *  won the game. Return player.
 *
 *  Time Complexity = O(1) - Constant Time, Instead of tracking the
 *  entire grid, we count entries in rows, columns, diagonals, anti
 *  diagonals. Space Complexity = o(N) - Linear space to store elements
 *  in rows and cols arrays.
 *
 */
public class Design_Tic_Tac_Toe {

	public static void main(String[] args) {
		int n = 3;
		Design_Tic_Tac_Toe obj = new Design_Tic_Tac_Toe(n);
		System.out.println("Step Output is " + obj.move(0, 0, 1) + " therefore, no one wins");
		System.out.println("Step Output is " + obj.move(0, 2, 2) + " therefore, no one wins");
		System.out.println("Step Output is " + obj.move(2, 2, 1) + " therefore, no one wins");
		System.out.println("Step Output is " + obj.move(1, 1, 2) + " therefore, no one wins");
		System.out.println("Step Output is " + obj.move(2, 0, 1) + " therefore, no one wins");
		System.out.println("Step Output is " + obj.move(1, 0, 2) + " therefore, no one wins");
		System.out.println("Winner is = player " + obj.move(2, 1, 1)); // Expected Output= 1
	}

	int[] rows;
	int[] cols;
	int diagonal;
	int inverseDiagonal;
	int size;

	/**
	 *
	 * @param boardLen Initialize your data structure here.
	 *
	 */
	public Design_Tic_Tac_Toe(int boardLen) {
		rows = new int[boardLen];
		cols = new int[boardLen];
		size = boardLen;
	}

	/**
	 *
	 * Player {player} makes a move at ({row}, {col}).
	 *
	 * @param row    The row of the board.
	 * @param col    he column of the board.
	 * @param player The player, can be either 1 or 2.
	 * @return The current winning condition, can be either: 0: No one wins. 1:
	 *         Player 1 wins. 2: Player 2 wins.
	 *
	 */
	public int move(int row, int col, int player) {
		// On each move add 1 or -1 to row/col, diagonal and anti diagonal if player is 1 or -1
		int valueToBeAdded = player == 1 ? 1 : -1;
		rows[row] += valueToBeAdded;
		cols[col] += valueToBeAdded;
		if (row == col) {
			// Diagonal
			diagonal += valueToBeAdded;
		}
		if (row + col == size - 1) {
			// -1 = Index starts from zero, whereas array length starts from one. To balance it, we subtract one
			// Inverse-Diagonal
			inverseDiagonal += valueToBeAdded;
		}
		// Return 1 or 2 (player1 or player 2) if the row/col/diagonal/anti diagonal equals size
		if (Math.abs(rows[row]) == size || Math.abs(cols[col]) == size || Math.abs(diagonal) == size
				|| Math.abs(inverseDiagonal) == size) {
			return player; // player 1 or 2 wins
		}
		return 0; // No one wins.
	}
}
