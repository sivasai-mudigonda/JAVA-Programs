/**
 * 
 */
package leetcode;

import java.util.Arrays;

/**
 * @author SivaM
 * 
 * LeetCode Ques - 130 {Surrounded Regions}
 * https://leetcode.com/problems/surrounded-regions/
 *
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 * 
	Example:
	
	X X X X
	X O O X
	X X O X
	X O X X
	After running your function, the board should be:
	
	X X X X
	X X X X
	X X X X
	X O X X
	Explanation:
	
	Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the board are not flipped to 'X'. Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'. Two cells are connected if they are adjacent cells connected horizontally or vertically.
 *
 * Time complexity:  O(ROWS*COLS)
 * Space complexity: o(ROWS*COLS)
 *
 */
public class SurroundedRegions {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		char[][] board = {
							{'X', 'X', 'X', 'X'},
							{'X', 'O', 'O', 'X'},
							{'X', 'X', 'O', 'X'},
							{'X', 'O', 'X', 'X'}
						 };
		SurroundedRegions obj = new SurroundedRegions();
		Arrays.stream(board).forEach(num->{
			System.out.println(Arrays.toString(num));
		});
		System.out.println("*******************");
		//System.out.println(Arrays.deepToString(board));
		obj.solve(board);
		Arrays.stream(board).forEach(num->{
			System.out.println(Arrays.toString(num));
		});
		/**
		 * Expected Result:
		 * X X X X
		 * X X X X
		 * X X X X
		 * X O X X
		 */
	}
	
	private void solve(char[][] board) {
	     if(board==null || board.length==0) {
	    	 return;
	     }
	     int rows = board.length;
	     int cols = board[0].length;
	     
	     // Change letter o in first and last row to "*"
	     for(int i=0;i<cols;i++) {
	    	 if(board[0][i] =='O') {
	    		 dfs(board,0,i);
	    	 }
	    	 if(board[rows-1][i]=='O') {
	    	  	dfs(board,rows-1,i);
	    	 }
	     }
	     
	  // Change letter o in first and last col to "*"
	     for(int j=0;j<rows;j++) {
	    	 if(board[j][0] =='O') {
	    		 dfs(board,j,0);
	    	 }
	    	 if(board[j][cols-1] =='O') {
	    		 dfs(board,j,cols-1);
	    	 }
	     }
	     
	     for(int row=0;row<rows;row++) {
	    	 for(int col=0;col<cols;col++) {
	    		 if(board[row][col]=='O') {
	    			 board[row][col]='X';
	    		 }
	    		 if(board[row][col]=='*'){
	    			 board[row][col]='O'; // BackTrack change from * to o in first and last, rows and cols
	    		 }
	    	 }
	     }
	}
	
	private void dfs(char[][] board, int rows,int cols) {
		if(board==null 
				|| rows>board.length-1 || cols>board[0].length-1 
				|| rows<0 || cols<0 || board[rows][cols]!='O') {
			return;
		}
		board[rows][cols] = '*';
		dfs(board,rows+1,cols);
		dfs(board,rows-1,cols);
		dfs(board,rows,cols+1);
		dfs(board,rows,cols-1);
	}

}
