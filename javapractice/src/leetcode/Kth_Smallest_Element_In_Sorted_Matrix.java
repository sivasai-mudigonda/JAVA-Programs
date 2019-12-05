/**
 * 
 */
package leetcode;

/**
 * @author SivaM
 * 
 * Leetcode Ques - 378 {Kth Smallest Element in a Sorted Matrix} {Medium}
 * https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
 * 
 * Given a n x n matrix where each of the rows and columns are sorted in ascending order, 
 * find the kth smallest element in the matrix.
 * 
 * Note that it is the kth smallest element in the sorted order, not the kth distinct element.
 * 
	Example:
	matrix = [
	   [1,  5,  9],
	   [10, 11, 13],
	   [12, 13, 15]
	],
	k = 8,
	return 13.
 * 
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ n2.
 * 
 * Solution:
 * Binary Search with low and high values.
 * For Video explanation, refer https://www.youtube.com/watch?v=kdvGki08MkE
 * 
 * Time Complexity = NLog(X) where Log(X) is for binary search and N is for count method
 * Space Complexity = o(1) - Constant space
 *  
 */
public class Kth_Smallest_Element_In_Sorted_Matrix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Kth_Smallest_Element_In_Sorted_Matrix obj = new Kth_Smallest_Element_In_Sorted_Matrix();
		
		int[][] matrix = {
							{1,  5,  9},
							{10, 11, 13},
							{12, 13, 15}
						 };
		int k=8;
		System.out.println(k +"th smallest element in the matrix = " +obj.kthSmallest(matrix, k)); // Expected output = 13{2,3 location in Matrix}
	}
	
	/**
	 * 
	 * @param matrix
	 * @param k
	 * @return
	 * 
	 * Using Binary Search
	 * 
	 * 
		// low = 1 , high = 15, mid = 8,   <= 8,  2{count}
		// low = 9， high = 15, mid = 12   <=12   6{count}
		    
		// low = 13, high 15, mid = 14,    <= 14, 8{count}
		// low =13, high = 13, mid = 13,   <= 13, 8{count}
		// low = 13, high = 12 -> return 13.
	 * 
	 */
	public int kthSmallest(int[][] matrix, int k) {
		if(matrix==null || matrix.length==0 || matrix[0].length==0 || k<1){
			return -1;
		}
		int m=matrix.length-1;
		int n=matrix[0].length-1;
        int low = matrix[0][0]; // First Element
        int high = matrix[m][n]; // Last element
        while(low<high ){ // Loop will be done when both high and low points to same cell element
        	/**
        	 * low — high may not lie in the matrix they are just numbers in the range.
        	 * So say we arrive at a element which is not in the matrix but which is in right position, then we check in the range low — high .
        	 * Because there exits a number smaller than high which lies in the matrix with correct number of elements less than or equal to it.
        	 * so our search will stop at it.
        	 */
        	int mid = low+(high-low)/2;
        	int count = smaller_Equal_Count(matrix,mid);
        	if(count<k ) {  // need larger target
        		// Search space(kth smallest) will be in b/w mid+1 to high.
        		low = mid+1;
        	} else {
        		// Search space(kth smallest) will be in b/w low to mid.
        		// Count{number of elements smaller than or equal to mid} is greater than k then that means k the element would lie in range low — mid.
        		high = mid;
        	}
        }
        return low; // Can return either low or high as they will have same value at this point.
    }
	
	/**
	 * 
	 * @param matrix
	 * @param target
	 * @return
	 * 
	 * Time Complexity for below method = O(N)
	 * Counts number of  Elements that are smaller or equal to mid{target}
	 * 
	 */
	private int smaller_Equal_Count(int[][] matrix,int target ){
		int m=matrix.length-1;
		int i=0;
		int j=m;
		int count=0;
		while(i<=m && j>=0 ){
			if(matrix[i][j] > target ){
				//item too large, skip
				j--;
			} else {
				count+= j+1; // +1 is because j starts from zero index.
				i++;
			}
			
		}
		return count;
	}
}
