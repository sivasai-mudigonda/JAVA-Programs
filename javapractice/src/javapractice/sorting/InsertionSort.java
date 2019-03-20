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
 *Refer https://www.geeksforgeeks.org/insertion-sort/
 *Video Link = https://www.youtube.com/watch?v=JU767SDMDvA
 *
 *Time Complexity = O(N^2)
 *Space Complexity =o(1)
 */
public class InsertionSort {

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
		Integer[] arr= new Integer[li.size()];
		arr=li.toArray(arr);
		System.out.println("Before Sort = "+Arrays.toString(arr));
		sort(arr);
		System.out.println("After Sort = "+Arrays.toString(arr));
	}
	
	private static void sort(Integer arr[]) 
    { 
        for(int i=1;i<arr.length;i++) {
        	int key= arr[i];
        	int j=i-1;
        	
        	while(j>=0 && arr[j] > key) {
        		arr[j+1]= arr[j];
        		j=j-1;
        	}
        	if(arr[j+1]!=key) { // This if condition is to make sort stable. Refer https://www.youtube.com/watch?v=ClG4xjwQ0BM
        		arr[j+1]=key;
        	}
        }
    } 

}
