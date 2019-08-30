package arrays;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

// Time complexity for n*n matrix is O(n)
// Time complexity for m*n matrix is O(m+n)

public class SearchSortedMatrix {

	Integer[][] arr;
	Integer n,r=0, c; // r=row, c=column
	
	private Boolean searchSortedMatrix(Integer n, Integer key) {
		c=n-1; //n is n*n matrix
		return search(key, arr);
	}
	private Boolean search(Integer key, Integer[][] arr) {
		if(arr==null || arr.length==0) {
			return Boolean.FALSE;
		}
		if(key==arr[r][c]) {
			return Boolean.TRUE; // r and c is the location of the element in the matrix
		} else {
			if(key < arr[r][c] ){
				c--;
			} else if(key > arr[r][c] ){
				r++;
			}
			if(r<n && c>=0 ){
				return search(key, arr);
			}
		}
		return Boolean.FALSE;
	}
	
	@Before
	public void initializeArray() {
		n=5;
		Integer[][]   arr1= { {10, 20, 30, 40},
                			  {15, 25, 35, 45},
                			  {27, 29, 37, 48},
                			  {32, 33, 39, 50} };
		arr=arr1;
	}
	
	@Test
	public void testSearchSortedMatrix(){
		assertTrue(searchSortedMatrix(4,29));
	}
	
	@Test
	public void testSearchSortedMatrix2(){
		assertTrue(searchSortedMatrix(4,99));
	}
}
