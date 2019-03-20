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
 * Refer https://www.geeksforgeeks.org/bubble-sort/
 *
 * Time Complexity = O(N)
 * Space Complexity = o(1)
 */
public class BubbleSort {

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
		System.out.println("Before SORT "+Arrays.toString(arr));
		sort(arr);
		System.out.println("After SORT " +Arrays.toString(arr));
	}
	
	private static void sort(Integer arr[]) {
		boolean isSwapped=false;
		for(int i=0;i<arr.length;i++ ){
			for(int j=0;j<arr.length-i-1;j++){
				if(arr[j] > arr[j+1]) {
					int temp= arr[j];
					arr[j]= arr[j+1];
					arr[j+1]=temp;
					isSwapped= true;
				}
			}
			if(!isSwapped) {
			  break;	
			}
		}
	}

}
