/**
 * 
 */
package sorting;

import java.util.Arrays;

/**
 * @author SIVA SAI
 * Refer https://www.youtube.com/watch?v=SLauY6PpjW4
 * Avg Time Complexity = O(NLOGN)
 * Worst Case Time Complexity = O(N^2)
 * It all depends on how efficiently pivot is selected. 
 */
public class QuickSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr= {2,1,4,21,9,56,56,43};
		System.out.println("before Sort = "+Arrays.toString(arr));
		arr=quickSort(arr,0,arr.length-1);
		System.out.println("after Sort = "+Arrays.toString(arr));
	}
	
	private static int[] quickSort(int arr[],int left, int right) {
		if(left>=right) {
			return arr;
		}
		int pivot=arr[(left+right)/2];
		int index= partition(arr,left,right,pivot);
		quickSort(arr,left, index-1);
		return quickSort(arr,index, right);
	}
	
	private static int partition(int arr[],int left, int right,int pivot) {
		while(left<=right) {
			while(arr[left] < pivot) {
				left++;
			}
			
			while(arr[right] > pivot){
				right--;
			}
			
			if(left<=right) {
				if(left<right) { // This if condition is to make sort stable. Refer https://www.youtube.com/watch?v=ClG4xjwQ0BM
					int temp= arr[left];
					arr[left]= arr[right];
					arr[right]=temp;
				}
				left++;
				right--;
			}
		}
		return left;
	}
}
