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
 *Refer https://www.youtube.com/watch?v=MtQL_ll5KhQ
 *
 *Refer https://www.geeksforgeeks.org/heap-sort/
 *
 *Time Complexity: Time complexity of heapify is O(nLogn). 
 *Time complexity of createAndBuildHeap() is O(n) and overall time complexity of Heap Sort is O(nLogn).
 */
public class HeapSort {

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
	
	private static void sort(Integer arr[]) 
    {
		int n= arr.length;
		// Heapify Process
		for(int i= n/2-1;i>=0;i--) {
			heapify(arr,n,i); // Build heap.
		}
		
		for(int i=n-1;i>=0;i--) {
			// SWAP first and ith element. 
			// This process is called MAX-HEAP
			int temp=arr[i];
			arr[i]= arr[0];
			arr[0]=temp;
			heapify(arr,i,0);
		}
		
    } 
  
    // To heapify a subtree rooted with node i which is 
    // an index in arr[]. n is size of heap 
    private static void heapify(Integer arr[], int n, int i) {
    	int largest=i;
    	int l=2*i+1;
    	int r=2*i+2;
    	
    	if(l<n && arr[l] > arr[largest] ) {
    		largest=l;
    	}
    	
    	if(r<n && arr[r] > arr[largest]) {
    		largest=r;
    	}
    	
    	if(i!=largest) {
    		// Root should be larger than child nodes.
    		int temp= arr[i];
    		arr[i]=arr[largest];
    		arr[largest]= temp;
    		heapify(arr,n,largest);
    	}
    }
}
