/**
 * 
 */
package javapractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author SIVA SAI
 *
 */

// Refer https://www.youtube.com/watch?v=kekmCQXYwQ0 for explanation.
// Kadane's Algorithm
// TimeComplexity = O(N)
public class MaxSumSubArray_Kadane {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Integer> li= new ArrayList<Integer>();
		li.add(1);
		li.add(-23);
		li.add(4);
		li.add(67);
		li.add(-1);
		li.add(-3);
		Integer arr[] = new Integer[1];
		arr=li.toArray(arr);
		System.out.println("Elements in array = " +Arrays.toString(arr));
		findMaxSumSubArray(arr);
	}
	
	private static void findMaxSumSubArray(Integer[] arr) {
		if(arr.length==0) {
			System.out.println("No elements present in the array");
		}
		int global_sum=arr[0];
		int current_sum=0;
		int start_index=0, end_index=0, search=0;
		for(int i=0; i<arr.length;i++) {
			current_sum+= arr[i];
			if(global_sum < current_sum ){
				global_sum=current_sum;
				start_index=search;
				end_index=i;
			}
			if(current_sum<0) {
				current_sum=0;
				search=i+1;
			}
		}
		System.out.println("Max sum of subArray = " +global_sum);
		System.out.println("Max sum of subArray start index = " +start_index);
		System.out.println("Max sum of subArray end index = " +end_index);
	}

}
