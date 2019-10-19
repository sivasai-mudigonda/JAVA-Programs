/**
 * 
 */
package leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author SivaM
 *
 * LeetCode Ques - 215 {Kth Largest Element in an Array}
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 * 
 * Find the kth largest element in an unsorted array. 
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * 
	Example 1:
	Input: [3,2,1,5,6,4] and k = 2
	Output: 5
	
	Example 2:
	Input: [3,2,3,1,2,4,5,5,6] and k = 4
	Output: 4
 *
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ array's length.
 * 
 * Time Complexity =O(NLOGN) -sorting{method-1} or priority queue{method-2}
 * Space Complexity = o(1) - constant space for method-1
 * Space Complexity =O(K) - k number of elements stored in priority queue
 * 
 */
public class Kth_Largest_Element_In_Array {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Kth_Largest_Element_In_Array obj = new Kth_Largest_Element_In_Array();
		
		int k=2;
		int nums[] = {3,2,1,5,6,4};
		System.out.println("2nd largest element in array = "+obj.findKthLargest(nums,k));  // Expected Output =5
		
		k=4;
		int nums1[] = {3,2,3,1,2,4,5,5,6};
		System.out.println("4th largest element in array = "+obj.findKthLargest(nums1,k)); // Expected Output =4
	}
	
	public int findKthLargest(int[] nums, int k) {
		if(nums==null || nums.length==0) {
			return -1;
		}
		Arrays.sort(nums);
		return nums[nums.length-k];
	}
	
	/**
	 * 
	 * @param nums
	 * @param k
	 * @return
	 */
	public int findKthLargest_MinHeap(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
        for(int n: nums) {
        	if(minHeap.size()<k) {
        		minHeap.offer(n);
        	} else if(n>minHeap.peek()){
        		minHeap.poll();
        		minHeap.offer(n);
        	}
        }
        return minHeap.peek(); // Where head is located
    }
}