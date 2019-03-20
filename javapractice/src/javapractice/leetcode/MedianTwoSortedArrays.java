/**
 * 
 */
package leetcode;

/**
 * @author SIVA SAI
 *
 *Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n))?
 *
 *Refer http://www.goodtecher.com/leetcode-4-median-two-sorted-arrays/
 *Refer https://www.youtube.com/watch?v=oVPIQdHt_T8&index=4&list=PLV8H0QrJHjOmhbwotwt3Sy8qlfzqGhVW-
 *
 *Time Complexity = O (logn)
 */
public class MedianTwoSortedArrays {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		double median;
		// Odd number of Elements
		int[] nums1 = {1, 3};
		int[] nums2 = {2};
		median=findMedianOfTwoSortedArrays(nums1,nums2);//Expected result is 2.0
		System.out.println("Median for Odd Number of Elements is "+median);
		
		// Even number of Elements
		int[] nums3 = {1, 2};
		int[] nums4 = {3, 4};
		median=findMedianOfTwoSortedArrays(nums3,nums4);//Expected result is (2 + 3)/2 = 2.5
		System.out.println("Median for Even Number of Elements is "+median);
	}
	
	public static double findMedianOfTwoSortedArrays(int[] a, int[] b) {
		int totalLength=a.length+b.length;
		
		if(totalLength%2==0) {
			// Even
			return (findKth(a,0,b,0, (totalLength/2))
				  +findKth(a,0,b,0,totalLength/2+1))/2.0;
		} else {
			// Odd
			return findKth(a,0,b,0, (totalLength/2)+1);
		}
	}
	
	public static int findKth(int[] a, int aStart,int[] b, int bStart, int k) {
		if(aStart >= a.length) {
			// If any of the two arrays is empty, then the kth element is the non-empty array’s kth element
			return b[bStart+k-1];
		}
		
		if(bStart >= b.length) {
			// If any of the two arrays is empty, then the kth element is the non-empty array’s kth element
			return a[aStart+k-1]; 
		}
		
		if(k==1) {
			// If k == 1, the kth element is the first element of A or B.
			return Math.min(a[aStart], b[bStart]);
		}
		
		int indexA=aStart+k/2-1; // First half of first array {Idea derived from Binary Search}
		int indexB=bStart+k/2-1; // Second half of first array
		
		int key1=indexA < a.length ? a[indexA]:Integer.MAX_VALUE;
		int key2=indexB < b.length ? b[indexB]:Integer.MAX_VALUE;
		if(key1<key2) {
			// Consider only second half of a array.
			// Send k as k-k/2 as we send only half of array a.
			return findKth(a,aStart+k/2,b,bStart,k-k/2);
		} else {
			// Consider only second half of a array.
			// Send k as k-k/2 as we send only half of array b.
			return findKth(a,aStart,b,bStart+k/2,k-k/2);
		}
	}
}
