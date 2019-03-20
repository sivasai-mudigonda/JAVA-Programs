package javapractice;

/**
 * 
 * @author SIVA SAI
 *Refer https://www.geeksforgeeks.org/search-element-sorted-matrix/
 *
 *Time Complexity = O(row*col) + O(N) . i.e., Matrix Iteration Time + Binary Search
 */
public class SearchElementSortedMatrix {

	public static void main(String[] args) {
		int row = 4, col = 5, target = 8; 
        int mat[][] = {{0, 6, 8, 9, 11}, 
                       {20, 22, 28, 29, 31}, 
                       {36, 38, 50, 61, 63}, 
                       {64, 66, 100, 122, 128}}; 
      
        searchSortedMatrix(mat, row, col, target); 
	}
	
	/*
	 * Consider:    | 1  2  3  4| 
		x = 3, mat = | 5  6  7  8|   Middle column:
             | 9 10 11 12|    = {2, 6, 10, 14}
             |13 14 15 16|   perform binary search on them
                             since, x < 6, discard the 
                             last 2 rows as 'a' will 
                             not lie in them(sorted matrix)
			Now, only two rows are left
             		 | 1  2  3  4| 
		x = 3, mat = | 5  6  7  8|   
		Check whether element is present on the middle elements of these
                             rows = {2, 6}
                             x != 2 or 6
If not, consider the four sub-parts
1st half of 1st row = {1}, 2nd half of 1st row = {3, 4}
1st half of 2nd row = {5}, 2nd half of 2nd row = {7, 8}

According the value of 'x' it will be searched in the
2nd half of 1st row = {3, 4} and found at (i, j): (0, 2)   
	 */
	private static void searchSortedMatrix(int[][] arr, int row, int col, int target) {
		if(row==1) {
			// If there is only one row.
			binarySearch(arr,0,0,col-1,target);
		}
		
		int row_low=0;
		int row_high=row-1;
		int col_mid=col/2;
		
		// Search if mid has element. If not filter the search till two rows.
		while((row_low+1) < row_high ){
			int row_mid=(row_low+row_high)/2;
			
			if(arr[row_mid][col_mid]==target) {
				System.out.println("Element found at = " +row_mid +" , "+col_mid);
				return;
			} else if(arr[row_mid][col_mid] < target) {
				row_low=row_mid;
			} else {
				row_high=row_mid;
			}
		}
		
		/** Search element in two rows.
		 * if found in mid of first two rows. {37 to 41}
		 * If not search in halfs{Left and Right} of the two rows
		*/
		if(arr[row_low][col_mid] ==target) {
			System.out.println("Element found at = " +row_low +" , "+col_mid);
			return;
		} else if(arr[row_low+1][col_mid] ==target ){
			System.out.println("Element found at = " +row_high +" , "+col_mid);
			return;
		} else if(target < arr[row_low][col_mid-1]) {
			// Search element on 1st half of 1st row
			binarySearch(arr,row_low,0,col_mid-1,target); // row, left half of col
		} else if(target > arr[row_low][col_mid+1] 
				         && target < arr[row_low][col-1] ){
			// Search element on 2nd half of 1st row
			binarySearch(arr,row_low,col_mid+1,col-1,target);
		} else if(target < arr[row_low+1][col_mid-1] ){
			// Search element on 1st half of 2nd row
			binarySearch(arr,row_low+1,0,col_mid-1,target);
		} else if(target > arr[row_low+1][col_mid+1]
				          && target < arr[row_low+1][col-1]  ){
			// Search element on 2nd half of 2nd row
			binarySearch(arr,row_low+1,col_mid+1,col-1,target);
		}
	}
	
	private static void binarySearch(int[][] arr, int row, int col_low, int col_high,int target ) {
		while(col_low<=col_high) {
			int col_mid= (col_low+col_high)/2;
			
			if(arr[row][col_mid]==target) {
				System.out.println("Element found at = " +row +" , "+col_mid);
				return;
			} else if(arr[row][col_mid] < target ) {
				col_low=col_mid+1;
			} else {
				col_high=col_mid-1;
			}
			System.out.println("Element not found");
		}
	}

}
