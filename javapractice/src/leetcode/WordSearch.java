package leetcode;

/**
 * @author u230107
 *
 *         LeetCode Ques=79 {Word Search}
 *         https://leetcode.com/problems/word-search/
 *
 *         Given a 2D board and a word, find if the word exists in the grid. The
 *         word can be constructed from letters of sequentially adjacent cell,
 *         where “adjacent” cells are those horizontally or vertically
 *         neighboring. The same letter cell may not be used more than once.
 *         Example: board = [ ['A','B','C','E'], ['S','F','C','S'],
 *         ['A','D','E','E'] ] Given word = "ABCCED", return true. Given word =
 *         "SEE", return false. Given word = "ABCB", return false.
 *
 *         For Sol, refer
 *         https://medium.com/@monisha.mary.mathew/word-search-cont-862ff82cbcfe
 */
public class WordSearch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
		String word = "ABCCED";
		System.out.println("Is word existing in the grid = " + exist(board, word)); // Expected Output = true
		System.out.println("Is word existing in the grid = " + exist(board, "SEE")); // Expected Output = false
		System.out.println("Is word existing in the grid = " + exist(board, "ABCB")); // Expected Output = false
	}

	private static boolean exist(char[][] board, String word) {
		char[] chArr = word.toCharArray();
		for (int r = 0; r < board.length; r++) {
			for (int c = 0; c < board[0].length; c++) {
				if (check(board, chArr, r, c, 0)) {
					return true;
				}
			}
		}
		return false;
	}

// DFS + BackTracking Technique
	private static boolean check(char[][] board, char[] chArr, int row, int col, int currW) {
		if (row < 0 || col < 0 || row >= board.length || col >= board[0].length) {
			return false;
		}
		if (board[row][col] == chArr[currW]) {
			char orginalChar = board[row][col];
//Mark as convered
			board[row][col] = '*';
			if (currW == chArr.length - 1) {
				return true;
			} else {
				if (
//Proceed to check for the rest of the search word
				check(board, chArr, row - 1, col, currW + 1) // Top
						|| check(board, chArr, row + 1, col, currW + 1) // Bottom
						|| check(board, chArr, row, col - 1, currW + 1) // Left
						|| check(board, chArr, row, col + 1, currW + 1) // Right
				) {
					return true;
				}
			}
//Failed to find word
//passing through this matched character.
//Therefore, Unmark
			board[row][col] = orginalChar;
		}
		return false;
	}
}
