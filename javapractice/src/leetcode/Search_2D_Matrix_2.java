/**
 * 
 */
package leetcode;

/**
 * @author SivaM
 * 
 * 
 * LeetCode Ques : 240 {Search a 2D Matrix II}
 * https://leetcode.com/problems/search-a-2d-matrix-ii/
 * 
 * Write an efficient algorithm that searches for a value in an m x n matrix. 
 * This matrix has the following properties:
 * Integers in each row are sorted in ascending from left to right.
 * Integers in each column are sorted in ascending from top to bottom.
 * 
	Example:
	Consider the following matrix:
	
	[
	  [1,   4,  7, 11, 15],
	  [2,   5,  8, 12, 19],
	  [3,   6,  9, 16, 22],
	  [10, 13, 14, 17, 24],
	  [18, 21, 23, 26, 30]
	]
	Given target = 5, return true.
	Given target = 20, return false.
 *
 * Solution :
 * The matrix in this case is not entirely sorted. 
 * Which means similar numbers can be in entirely different locations, like 10 and 11, which are on different side of the matrix. 
 * What we want to do is to use the property of the matrix to reach the target. 
 * If we start from the top left, we have two ways to go, go right or go down. 
 * Both of the ways make the number bigger. We can’t determine which way to go based on target. 
 * If we start from the top right, we have two ways to go, go left or go down, if we go left, the number gets smaller, if we go down, the number gets bigger. 
 * By using this property, we can determine which way to go based on the target.
 * 
 * Time Complexity = O(R * C) where R and C are length of Matrix{Row & Column}
 * Space Complexity = o(1)
 * 
 */
public class Search_2D_Matrix_2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Search_2D_Matrix_2 obj = new Search_2D_Matrix_2();
		
		int[][] nums = 
						{
								{1,   4,  7, 11, 15},
								{2,   5,  8, 12, 19},
								{3,   6,  9, 16, 22},
								{10, 13, 14, 17, 24},
								{18, 21, 23, 26, 30}
						};
		int target = 5;
		System.out.println("Is target found : "+obj.searchMatrix(nums,target)); // Expected Result = true
		target = 20;
		System.out.println("Is target found : "+obj.searchMatrix(nums,target)); // Expected Result = false
	}
	
	/**
	 * 
	 * @param matrix
	 * @param target
	 * @return
	 * 
	 * i & j are used to iterare row and col of matrix.
	 */
	public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null || matrix.length==0 ){
        	return false;
        }
        int i=0;
        int j=matrix[0].length-1;
        while(i<matrix.length && j>=0) {
        	if(matrix[i][j]==target ){
        		return true;
        	} else if(matrix[i][j] > target) {
        		// If we start from the top right, we have two ways to go, go left or go down, 
        		// if we go left, the number gets smaller, if we go down, the number gets bigger.
        		j--;
        	} else {
        		// If we start from the top left, we have two ways to go, go right or go down.
        		i++;
        	}
        }
        return false;
    }
}