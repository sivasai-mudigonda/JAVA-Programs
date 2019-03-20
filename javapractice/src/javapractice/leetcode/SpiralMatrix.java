/**
 * 
 */
package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author SIVA SAI
 *
 *Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order?
 *
 *Refer "https://www.youtube.com/watch?v=siKFOI8PNKM"
 *
 *Time Complexity = O(rows*col)
 *Space Complexity = O(1)
 */
public class SpiralMatrix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] matrix= { { 1, 2, 3 },
						  { 4, 5, 6 },
						  { 7, 8, 9 } };
		List<Integer> result = spiralOrder(matrix);
		System.out.println(result.toString()); // Expected Result = [1,2,3,6,9,8,7,4,5]
		
		int[][] matrix2 ={ {1, 2, 3, 4},
						   {5, 6, 7, 8},
						   {9,10,11,12} };
		result = spiralOrder(matrix2);
		System.out.println(result.toString()); // Expected Result = [1,2,3,4,8,12,11,10,9,5,6,7]		
	}
	
	private static List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> resultLi= new ArrayList<>();
		int top=0;
		int bottom=matrix.length-1;
		int left=0;		
		int right=matrix[0].length-1;
		int dir=0;
		while(left<=right && top<=bottom ){
			if(dir==0) { // left to right
				for(int k=left;k<=right;k++) {
					resultLi.add(matrix[top][k]);
				}
				top++;
			} else if(dir==1) { // top to bottom
				for(int k=top;k<=bottom;k++) {
					resultLi.add(matrix[k][right]);
				}
				right--;
			} else if(dir==2) { // right to left
				for(int k=right;k>=left;k--) {
					resultLi.add(matrix[bottom][k]);
				}
				bottom--;
			} else if(dir==3) { // bottom to top
				for(int k=bottom;k>=top;k--) {
					resultLi.add(matrix[k][left]);
				}
				left++;
			}
			dir=(dir+1)%4;
		}
		return resultLi;
    }

}
