/**
 * 
 */
package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author SIVA SAI
 *
 * Refer https://www.geeksforgeeks.org/selection-sort/
 * Video Link = https://www.youtube.com/watch?v=g-PGLbMth_g
 *
 * Time Complexity= O(n^2)
 * Space Complexity = o(1)
 */
public class SelectionSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Integer> li = new ArrayList<Integer>();
		li.add(4);
		li.add(10);
		li.add(3);
		li.add(5);
		li.add(1);
		li.add(5);
		Integer[] arr= new Integer[li.size()];
		arr=li.toArray(arr);
		System.out.println("Before Sort = "+Arrays.toString(arr));
		sort(arr);
		System.out.println("After Sort = "+Arrays.toString(arr));
	}
	
	private static void sort(Integer arr[]) 
    { 
       for(int i=0;i<arr.length-1;i++) {
    	   int min=i;
    	   for(int j=i+1;j<arr.length;j++) {
    		   if(arr[min] > arr[j]) {
    			   min=j;
    		   }
    	   }
    	   // Swap i with min.
    	   if(arr[min]!=arr[i]) { // This if condition is to make sort stable. Refer https://www.youtube.com/watch?v=ClG4xjwQ0BM
    		   int temp= arr[min];
    		   arr[min]=arr[i];
    		   arr[i]=temp;
    	   }
       }
    } 

}
