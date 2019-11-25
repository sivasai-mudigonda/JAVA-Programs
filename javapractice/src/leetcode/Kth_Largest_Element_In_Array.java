/**
 * 
 */
package leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

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
 * Solution for method-3:
 * Video Explanation:
 * https://backtobackswe.com/videos/kth-largest-element
 * To Understand QuickSort, Refer 
 * https://backtobackswe.com/videos/quicksort
 * 
 * Time Complexity =O(NLOGN) sorting{method-1} 
 * Time Complexity =O(NLOGK) priority queue{method-2}
 * Time Complexity =O(N) Partitioning by Quick-Select {method-3}
 * Space Complexity =o(1) - constant space for method-1
 * Space Complexity =o(K) - k number of elements stored in priority queue{Min Heap}
 * Space Complexity =o(1) - Constant space
 * 
 */
public class Kth_Largest_Element_In_Array {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Kth_Largest_Element_In_Array obj = new Kth_Largest_Element_In_Array();
		
		int k=2;
		final int nums[] = {1, 5, 1, 1, 6, 4};
		System.out.println("2nd largest element in array(Partioning) = "+obj.findKthLargest_Partitioning(nums,k));  // Expected Output =5
		System.out.println("2nd largest element in array(Min-Heap) = "+obj.findKthLargest_MinHeap(nums,k));  // Expected Output =5
		System.out.println("2nd largest element in array(Sort) = "+obj.findKthLargest_Sort(nums,k));  // Expected Output =5
		
		k=4;
		int nums1[] = {3,2,3,1,2,4,5,5,6};
		System.out.println("4th largest element in array = "+obj.findKthLargest_Partitioning(nums1,k)); // Expected Output =4
		System.out.println("4th largest element in array = "+obj.findKthLargest_MinHeap(nums1,k)); // Expected Output =4
		System.out.println("4th largest element in array = "+obj.findKthLargest_Sort(nums1,k)); // Expected Output =4
	}
	
	/**
	 * 
	 * @param nums
	 * @param k
	 * @return
	 * 
	 * We make the assumption k is between 1 and n (where n is the length of the array)
	 * The 1st largest element is the largest element.
	 * The n'th largest element is the smallest element.
	 * This optimal solution has the same fundamental reasoning that QuickSort uses. (the partitioning subroutine)
	 * 
	 * n-k = Gives us kth element index 
	 * 
	 */
	public int findKthLargest_Partitioning(int[] nums, int k) {
		if(nums==null || nums.length==0) {
			return -1; // Kth index not found
		}
	    /*
	     * Keep track of the 'left' and 'right' space in which the
	     * k'th largest element can possibly be, we will use these bounds
	     * to know what section to actually partition around a choosen pivot
	     * 
	     */
		int n = nums.length;
		int left=0;
		int right = n-1;
		/*
		 *  A Random object we will use later repeatedly to choose random pivots.
		 *  Choosing Pivot as Random will make sure we don't select bad Pivot
		 *  
		 */
		Random random = new Random(0);
		// While the bounds stay valid continue doing directed partitioning
		while(left<=right ){
			/**
			   * nextInt(bounds) 
			   * eg: nextInt(6), will exclude 6, i.e., 0 to 5.
			   * +left => As nextInt excludes last element, We will include it by adding left
			   * eg:
			   * left =1, right =5
			   * 5-1+1 = 5, i.e., 0 to 4 will be included. 5th element in right boundary is excluded. But we need it.
			   * So, Add left, i.e., (5-1+1)+1 =6. i.e., 0 to 5 will be included
			   * 
			   * right-left => to keep within boundaries
			   * +1 => AS we subtracted n-1 in right, we add +1 here to keep in boundary.
			   * 
			   */
			int choosenPivotIndex = random.nextInt(right-left+1)+left; // Pick a random pivot. Bounds are [left, right].
			/*
		      Execute the actual partitioning and get back the final positition
		      of the pivot we choose after partitioning is over
		    */
			int finalIndexOfChoosenPivot = partitioning(nums,choosenPivotIndex,left,right);
			 if(finalIndexOfChoosenPivot > n-k) {
				 /*
				  * k'th largest must be in the left partition. We "overshot" and need to go left
				  * (and we do this by narrowing the right bound)
				  * 
			      */
				right = finalIndexOfChoosenPivot-1;
			 } else if(finalIndexOfChoosenPivot < n-k) {
				 /*
				  * finalIndexOfChoosenPivot < n - k
				  * k'th largest must be in the right partition. We "undershot" and need to go right
				  * (and we do this by narrowing the left bound)
				  * 
			      */
				 left = finalIndexOfChoosenPivot+1;
			 } else if(finalIndexOfChoosenPivot ==n-k) {
				// What does the 'finalIndexOfChoosenPivot' tell us?
				 /*
			        Found. The pivot is index on index n - k. This is literally its final position if
			        the array we were given had been sorted. See how we saved work? We don't
			        need to sort the whole array
			      */
				// System.out.println(Arrays.toString(nums));
				// System.out.println(nums[finalIndexOfChoosenPivot]);
				 return nums[finalIndexOfChoosenPivot];
			 }
		}
		return -1; // this will never be reached, necessary to compile
	}
	
	/**
	 * 
	 * @param nums
	 * @param pivotIndex
	 * @param left
	 * @param right
	 * @return
	 * 
	 * 
	 * So this subroutine is exactly what we do in QuickSort...partition around the value
	 * that the 'pivotIndex' holds
	 * The result is a "sandwich" at the end.
	 * [ items < than the pivot ... pivotItem ... items > than the pivot]
	 * 
	 */
	private int partitioning(int[] nums, int pivotIndex,int left, int right) {
		// Grab the value at the pivot index we passed in
		int pivotVal = nums[pivotIndex];
		 /*
	    	Move the item at the 'pivotIndex' OUT OF THE WAY. We are about to
	    	bulldoze through the partitioning space and we don't want it in
	    	the way
		  */
		swap(nums,pivotIndex,right);
	    /*
	    	Remember how partitioning works? We need to keep track of where
	    	we last placed an item in the section of items "less than the
	    	pivot"
	    
	    	We keep track of the tail index of this section. We will
	    	need this later
	     */
		int lessThan_PivotIndex=left;
		 /*
	    	Iterate from the left bound to 1 index right before the right bound
	    	(where the choosen pivot value is now sitting in saftey)
		 */
		for(int i=left;i<right;i++) {
			/*
		      If this item is less than the 'pivotValue' then we need to move
		      this item to the section of items "less than the pivot"
		      'lesserItemsTailIndex' keeps track of where we need to swap into
		      next...after doing the swap we advance it...you see how this is
		      coming together?
		    */
			if(nums[i] < pivotVal) {
				swap(nums,i,lessThan_PivotIndex);
				lessThan_PivotIndex++;
			}
		}
		/*
	    	Ok...partitioning is done. Swap the pivot item BACK into the space we just
	    	partitioned at the 'lesserItemsTailIndex'...that's where the pivot item
	    	belongs
	    	In the middle of the "sandwich".
		 */
		swap(nums,right,lessThan_PivotIndex);
		/*
	      Return the index of where we just put the pivot so that the caller knows its
	      final resting place (so that the caller can make the decisions it needs)
	    */
		return lessThan_PivotIndex;
	}
	
	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	
	/**
	 * 
	 * @param nums
	 * @param k
	 * @return
	 * 
	 * SORTING APPROACH
	 * 
	 */
	public int findKthLargest_Sort(int[] nums, int k) {
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
	 * 
	 * HEAP APPROACH
	 * 
	 * To find Largest Item, Use MinHeap
	 * To find Smallest Item, Use MaxHeap
	 * 
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