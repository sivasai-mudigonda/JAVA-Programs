/**
 * 
 */
package javapractice;

import java.util.Arrays;

/**
 * @author SIVA SAI
 *
 */

/** Given an array of integers, 
   find the nearest smaller number for every element such that the smaller element is on left side?
 * Eg:
		Input:  arr[] = {1, 6, 4, 10, 2, 5}
		Output:         {_, 1, 1,  4, 1, 2}
		First element ('1') has no element on left side. For 6, 
		there is only one smaller element on left side '1'. 
		For 10, there are three smaller elements on left side (1,
		6 and 4), nearest among the three elements is 4.
		
		Input: arr[] = {1, 3, 0, 2, 5}
		Output:        {_, 1, _, 0, 2}
		
		Time Complexity= O(N)
*/
public class LeftNearSmalNumArr {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int arr[]= {1, 6, 4, 10, 2, 5};
		System.out.println(Arrays.toString(findLeftSmallNum(arr)));
		int arr1[]= {1, 3, 0, 2, 5};
		System.out.println(Arrays.toString(findLeftSmallNum(arr1)));
	}
	
	private static int[] findLeftSmallNum(int[] arr) {
		int[] result= new int[arr.length];
		int prev=arr[0];
		int prevSmall=arr[0];
		result[0]=Integer.MIN_VALUE;
		for(int i=1;i<arr.length;i++ ){
			if(prev<=arr[i] ){
				result[i]=prev;
			} else {
				if(prevSmall<=arr[i]){
					result[i]=prevSmall;
				} else {
					result[i]=Integer.MIN_VALUE;
					prevSmall=arr[i];
				}
			}
			prev=arr[i];
		}		
		return result;
	}
}
