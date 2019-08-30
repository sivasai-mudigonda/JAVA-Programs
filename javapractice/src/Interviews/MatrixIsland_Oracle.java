/**
 * 
 */
package Interviews;

/**
 * @author SIVA SAI
 *
 *LeetCode : 200. Number of Islands
 *https://leetcode.com/problems/number-of-islands/
 *
 *Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. 
 *An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. 
 *You may assume all four edges of the grid are all surrounded by water.
 *
 *Example 1:

Input:
11110
11010
11000
00000

Output: 1

*Example 2:

Input:
11000
11000
00100
00011

Output: 3
 */

// Refer https://www.youtube.com/watch?v=CLvNe-8-6s8
// Time Complexity = O(ROW x COL)
public class MatrixIsland_Oracle {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int M[][]=  new int[][] {
								 {1, 1, 0, 0, 0}, 
            					 {0, 1, 0, 0, 1}, 
                                 {1, 0, 0, 1, 1}, 
                                 {0, 0, 0, 0, 0}, 
                                 {1, 0, 1, 0, 1}
								};
	    System.out.println(calClusterCnt(M));
		
	    /*
		 // Deep Cloning Multi-Dimensional Array
         int N[][]=  new int[5][5];
         for(int k=0;k<M.length;k++) {
        	// N[k]=Arrays.copyOf(M[k], M[k].length); {copyOf internally uses system.arraycopy} 
        	 // OR
        	 // System.arraycopy(M[k], 0, N[k], 0, M[k].length);
         }
         System.out.println(Arrays.deepToString(N));
         System.out.println(calClusterCnt(M));
         System.out.println(Arrays.deepToString(N));
         */
	}
	
	private static int calClusterCnt(int grid[][] ){
		int clusterCnt=0;
		for(int row=0;row<grid.length;row++) {
			for(int col=0;col<grid[row].length;col++) {
				if(grid[row][col] ==1) {
					clusterCnt++;
					dfsOperation(grid,row,col);	
				}
			}
		}
		return clusterCnt;
	}
	
	// Change connected one's to zero's. 
	private static void dfsOperation(int grid[][],int r,int c ) {
		if(r>=0 && c>=0 && r<grid.length && c<grid[r].length) {
			if(grid[r][c] ==1 ){
				grid[r][c]=0; // change one to zero
				dfsOperation(grid,r+1,c);
				dfsOperation(grid,r-1,c);
				dfsOperation(grid,r,c+1);
				dfsOperation(grid,r,c-1);
			}
		}
		//System.out.println(Arrays.deepToString(grid));
	}
		
}
