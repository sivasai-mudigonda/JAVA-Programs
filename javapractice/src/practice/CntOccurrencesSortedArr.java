package practice;

/**
 * Given a sorted array arr[] and a number x, write a function that counts the occurrences of x in arr[]? 
 * Expected time complexity is O(Logn)
 * 
 * Eg:
	  Input: arr[] = {1, 1, 2, 2, 2, 2, 3,},   x = 2
	  Output: 4 // x (or 2) occurs 4 times in arr[]
	
	  Input: arr[] = {1, 1, 2, 2, 2, 2, 3,},   x = 3
	  Output: 1 
	
	  Input: arr[] = {1, 1, 2, 2, 2, 2, 3,},   x = 1
	  Output: 2 
	
	  Input: arr[] = {1, 1, 2, 2, 2, 2, 3,},   x = 4
	  Output: -1 // 4 doesn't occur in arr[] 
 * 
 * Refer https://www.geeksforgeeks.org/count-number-of-occurrences-or-frequency-in-a-sorted-array/
 */


// Time complexity =O(LOGN)
public class CntOccurrencesSortedArr {

	public static void main(String[] args) {
		int arr[] = {1, 2, 2, 3, 3, 3, 3}; 
        int x =  3;  
        int c = cntTargetSortedArr(arr, x); 
        System.out.println(x+" occurs "+c+" times"); 
	}
	
	/* if x is present in arr[] then returns  
    the count of occurrences of x,  
    otherwise returns -1. */
	private static int cntTargetSortedArr(int arr[], int target){
		int i=0;
		int j=0;
		// Get First Instance {i}
		i=getFirstInstanceIndex(arr,0,arr.length-1,target);
		if(i==-1) {
			//System.out.println("Element not present in array");
			return -1;
		}
		// Get Last Instance {j}
		j=getLastInstanceIndex(arr,i,arr.length-1,target);
		return j-i+1;
	}
	
	/* if x is present in arr[] then returns the  
    index of FIRST occurrence of x in arr[0..n-1],  
    otherwise returns -1 */
	private static int getFirstInstanceIndex(int[] arr,int low,int high,int target) {
		if(high>=low) {
			int mid=(high+low)/2;
			if(mid==0 || (target>arr[mid-1] && arr[mid]==target) ) {
				return mid;
			} else if(target>arr[mid]) {
				return getFirstInstanceIndex(arr,mid+1,high,target);
			} else {
				return getFirstInstanceIndex(arr,low,mid-1,target);
			}
			
		}
		return -1;
	}
	
	/* if x is present in arr[] then returns the  
    index of LAST occurrence of x in arr[0..n-1],  
    otherwise returns -1 */
	private static int getLastInstanceIndex(int arr[], int low, int high, int target) {
		if(high>=low) {
			int mid=(high+low)/2;
			if(mid==arr.length-1 || ( target<arr[mid+1]&& arr[mid]==target) ){
				return mid;
			} else if(target<arr[mid]) {
				return getLastInstanceIndex(arr,low,mid-1,target);
			} else {
				return getLastInstanceIndex(arr,mid+1,high,target);
			}
		}
		return -1;
	}

}
