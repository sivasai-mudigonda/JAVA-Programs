/**
 * 
 */
package leetcode;

import java.util.Arrays;

/**
 * @author SivaM
 * 
 * Leetcode Ques - 289 {Game of Life}
 * https://leetcode.com/problems/game-of-life/
 * 
 * According to the Wikipedia's article: 
 * "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."
 * Given a board with m by n cells, each cell has an initial state live (1) or dead (0). 
 * Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules 
 * (taken from the above Wikipedia article):
 * Any live cell with fewer than two live neighbors dies, as if caused by under-population.
 * Any live cell with two or three live neighbors lives on to the next generation.
 * Any live cell with more than three live neighbors dies, as if by over-population.
 * Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
 * Write a function to compute the next state (after one update) of the board given its current state. 
 * The next state is created by applying the above rules simultaneously to every cell in the current state, 
 * where births and deaths occur simultaneously.
 * 
	Example:
	Input: 
	[
	  [0,1,0],
	  [0,0,1],
	  [1,1,1],
	  [0,0,0]
	]
	Output: 
	[
	  [0,0,0],
	  [1,0,1],
	  [0,1,1],
	  [0,1,0]
	]
 *
 * Follow up:
 * Could you solve it in-place? 
 * Remember that the board needs to be updated at the same time: 
 * You cannot update some cells first and then use their updated values to update other cells.
 * In this question, we represent the board using a 2D array. 
 * In principle, the board is infinite, 
 * which would cause problems when the active area encroaches the border of the array. 
 * How would you address these problems?
 *
 * Time Complexity = O(M*N) - where M is rows and N is cols of board
 * Space Complexity = o(1) - constant space
 * 
 */
public class GameOfLife {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		GameOfLife obj = new GameOfLife();
		
		int[][] board = 
						{
							{0,1,0},
							{0,0,1},
							{1,1,1},
							{0,0,0}
						};
		obj.gameOfLife(board);
		System.out.println("Next State of Board = " +Arrays.deepToString(board));
		/*
		 * Expected Output = 
		 * [
		 * 	  [0,0,0],
		 * 	  [1,0,1],
		 * 	  [0,1,1],
		 * 	  [0,1,0]
		 * ]
		 */
	}
	
	public void gameOfLife(int[][] board) {
		if(board==null || board.length==0 ){
			return;
		}
        int rowLength = board.length;
        int colLength = board[0].length;
        // Loop through board
        for(int i=0;i<rowLength;i++) {
        	for(int j=0;j<colLength;j++){
        		int liveCnt = getLiveCount(board,i,j);
        		if(board[i][j]==1) {
        			// Any live cell with two or three live neighbors lives on to the next generation.
        			if(liveCnt==2 || liveCnt==3 ){
        				board[i][j] = 3; // Need to live
            		}
        		} else {
        		   //  Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
        			if(liveCnt==3 ){
        				board[i][j] = 2;
        			}
        		}
        	}
        }
        /**
         * board[i][j] values which are not equal to 2 or 3 need to die as per the rules give in the problem.
         * Only board[i][j] values which are 2 or 3 will survive for next generation. 
         */
        for(int i=0;i<rowLength;i++) {
        	for(int j=0;j<colLength;j++){
        		//if  board[i][j]=1, value will be changed to zero.
        		//if  board[i][j]=2, value will be changed to one.
        		//if  board[i][j]=3, value will be changed to one.
        		board[i][j] = board[i][j] >> 1;
        	}
        }
    }
	
	/**
	 * 
	 * @param board
	 * @param rowIndex
	 * @param colIndex
	 * @return
	 * 
	 *  This function counts neighbors which are alive
	 *  Check all 8 neighbors around board[rowIndex][colIndex]. Upper, Lower, Left, Right and diagonals.
	 *  Also you need to keep in mind that while checking your left/right/upper/lower element should not get out of array bound.
	 */
	private int getLiveCount(int[][] board, int rowIndex, int colIndex) {
		int liveCnt=0;
		for(int i=rowIndex-1;i<=rowIndex+1;i++) {
			for(int j=colIndex-1;j<=colIndex+1;j++) {
				if(i>=0 && i<board.length && j>=0 && j<board[0].length && !(i==rowIndex && j==colIndex) ){
					liveCnt+= board[i][j] & 1;
				}
			}
		}
		return liveCnt;
	}
}
