/**
 * 
 */
package leetcode;

import java.util.Arrays;
import java.util.Random;

/**
 * @author SivaM
 * 
 * LeetCode Ques - 324 {Wiggle Sort II} - Medium
 * https://leetcode.com/problems/wiggle-sort-ii/
 * 
 * Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....
 * 
	Example 1:
	
	Input: nums = [1, 5, 1, 1, 6, 4]
	Output: One possible answer is [1, 4, 1, 5, 1, 6].

	Example 2:
	Input: nums = [1, 3, 2, 2, 3, 1]
	Output: One possible answer is [2, 3, 1, 3, 1, 2].

 * 
 * Note:
 * You may assume all input has valid answer.
 * 
 * Follow Up:
 * Can you do it in O(n) time and/or in-place with O(1) extra space?
 * 
 * Time Complexity =o(N) - Linear Time
 * Space Complexity = o(1) - Constant Time
 * 
 */
public class WiggleSort_2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		WiggleSort_2 obj = new WiggleSort_2();
		
		int[] nums = {1, 5, 1, 1, 6, 4};
		System.out.println("Original Array = " +Arrays.toString(nums));
		obj.wiggleSort(nums);
		System.out.println("Wiggle(Wave) Array = " +Arrays.toString(nums)); // Expected Output = 1, 6, 1, 5, 4, 1
		
		System.out.println("**********************************");
		
		int[] nums1 = {1, 3, 2, 2, 3, 1};
		System.out.println("Original Array = " +Arrays.toString(nums1));
		obj.wiggleSort(nums1);
		System.out.println("Wiggle(Wave) Array = " +Arrays.toString(nums1)); // Expected Output = 2, 3, 1, 3, 2, 1
		
		
		System.out.println("**********************************");
		
		int[] nums2 = {13,6,5,5,4,2};
		System.out.println("Original Array = " +Arrays.toString(nums2));
		obj.wiggleSort(nums2);
		System.out.println("Wiggle(Wave) Array = " +Arrays.toString(nums2)); // Expected Output = 5, 13, 5, 6, 4, 2
	}
	
	public void wiggleSort(int[] nums) {
		if(nums==null || nums.length==0) {
			return;
		}
		int median = findKthLargest(nums, (nums.length+1)/2); // Median = (n+1)/2
		System.out.println("After Quick Sort Until Kth Element  = " +Arrays.toString(nums));
		System.out.println("Median = " +median);
		int i=0;
		int left =0;
		int right = nums.length-1;
		/*
		 * Mapped_idx[Left] denotes the position where the next smaller-than median element  will be inserted.
		 * Mapped_idx[Right] denotes the position where the next larger-than median element  will be inserted.
			Step 1: 
			Original idx: 0    1    2    3    4    5  
			Mapped idx:   1    3    5    0    2    4 
			Array:        13   6    5    5    4    2 
			             Left
			              i
			                                      Right
			 nums[Mapped_idx[i]] = nums[1] = 6 > 5, so it is ok to put 6 in the first odd index 1. We increment i and left.
			 
			Step 2: 
			Original idx: 0    1    2    3    4    5  
			Mapped idx:   1    3    5    0    2    4 
			Array:        13   6    5    5    4    2 
			                  Left
			                   i
			                                      Right
			 nums[3] = 5 = 5, so it is ok to put 6 in the index 3. We increment i.
			 
			Step 3: 
			Original idx: 0    1    2    3    4    5  
			Mapped idx:   1    3    5    0    2    4 
			Array:        13   6    5    5    4    2 
			                  Left
			                        i
			                                     Right
			 nums[5] = 2 < 5, so we want to put it to the last even index 4 (pointed by Right). 
			 So, we swap nums[Mapped_idx[i]] with nums[Mapped_idx[Right]], i.e. nums[5] with nums[4], and decrement Right. 
			 
			Step 4: 
			Original idx: 0    1    2    3    4    5  
			Mapped idx:   1    3    5    0    2    4 
			Array:        13   6    5    5    2    4 
			                  Left
			                        i
			                               Right
			 nums[5] = 4 < 5, so we want to put it to the second last even index 2. So, we swap nums[5] with nums[2], and decrement Right. 
			 
			Step 5: 
			Original idx: 0    1    2    3    4    5  
			Mapped idx:   1    3    5    0    2    4 
			Array:        13   6    4    5    2    5 
			                  Left
			                        i
			                            Right
			 nums[5] = 5 < 5, it is ok to put it there, we increment i.
			 
			Step 6: 
			Original idx: 0    1    2    3    4    5  
			Mapped idx:   1    3    5    0    2    4 
			Array:        13   6    4    5    2    5 
			                  Left
			                             i
			                            Right
			 nums[0] = 13 > 5, so, we want to put it to the next odd index which is 3 (pointed by 'Left'). So, we swap nums[0] with nums[3], and increment 'Left' and 'i'.
			 
			Step Final: 
			Original idx: 0    1    2    3    4    5  
			Mapped idx:   1    3    5    0    2    4 
			Array:        5    6    4    13   2    5 
			                      Left
			                                  i
			                            Right
			i > Right, we get the final wiggle array 5 6 4 13 2 5
		 */
		while(i<=right) {
			// Take one from each partition in the order of middle --> left --> right (as middle < left > right is wiggle order).
			int mappedCurIndex = getWiggleIndex(i,nums.length);
			int wiggleVal = nums[mappedCurIndex];
			if(wiggleVal > median) {
				// Odd Index, Value should be greater than Median
				int mappedLeftIndex = getWiggleIndex(left,nums.length);
				swap(nums,mappedLeftIndex, mappedCurIndex);
				i++;
				left++;
			} else if(wiggleVal < median) {
				// Even Index, Value should be smaller than Median
				int mappedRightIndex = getWiggleIndex(right,nums.length);
				swap(nums,mappedRightIndex, mappedCurIndex);
				right--;
			} else {
				// mappedCurIndex = Median, No swap required
				i++;
			}
			
			System.out.println("Wiggle Swap Array = " +Arrays.toString(nums));
		}
    }
	
	public int findKthLargest(int[] arr, int k) {

		  /*
		    Keep track of the 'left' and 'right' space in which the
		    k'th largest element can possibly be, we will use these bounds
		    to know what section to actually partition around a choosen pivot
		  */
		  int n = arr.length;
		  int left = 0;
		  int right = n - 1;

		  // A Random object we will use later repeatedly to choose random pivots
		  Random rand = new Random(0);

		  // While the bounds stay valid continue doing directed partitioning
		  while (left <= right) {
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
		    int choosenPivotIndex = rand.nextInt(right - left + 1) + left; // Pick a random pivot. Bounds are [left, right].

		    /*
		      Execute the actual partitioning and get back the final positition
		      of the pivot we choose after partitioning is over
		    */
		    int finalIndexOfChoosenPivot = partition(arr, left, right, choosenPivotIndex);

		    // What does the 'finalIndexOfChoosenPivot' tell us?
		    if (finalIndexOfChoosenPivot == n - k) {

		      /*
		        Found. The pivot is index on index n - k. This is literally its final position if
		        the array we were given had been sorted. See how we saved work? We don't
		        need to sort the whole array
		      */
		      return arr[finalIndexOfChoosenPivot];

		    } else if (finalIndexOfChoosenPivot > n - k) {

		      /*
		        k'th largest must be in the left partition. We "overshot" and need to go left
		        (and we do this by narrowing the right bound)
		      */
		      right = finalIndexOfChoosenPivot - 1;

		    } else {

		      /*
		        finalIndexOfChoosenPivot < n - k
		        k'th largest must be in the right partition. We "undershot" and need to go right
		        (and we do this by narrowing the left bound)
		      */
		      left = finalIndexOfChoosenPivot + 1;

		    }

		  }

		  return -1; // this will never be reached, necessary to compile
		}

		/*
		  So this subroutine is exactly what we do in QuickSort...partition around the value
		  that the 'pivotIndex' holds
		  The result is a "sandwich" at the end.
		  [ items < than the pivot ... pivotItem ... items > than the pivot]
		*/
		private int partition(int[] arr, int left, int right, int pivotIndex) {

		  // Grab the value at the pivot index we passed in
		  int pivotValue = arr[pivotIndex];

		  /*
		    Remember how partitioning works? We need to keep track of where
		    we last placed an item in the section of items "less than the
		    pivot"
		    
		    We keep track of the tail index of this section. We will
		    need this later
		  */
		  int lesserItemsTailIndex = left;

		  /*
		    Move the item at the 'pivotIndex' OUT OF THE WAY. We are about to
		    bulldoze through the partitioning space and we don't want it in
		    the way
		  */
		  swap(arr, pivotIndex, right);

		  /*
		    Iterate from the left bound to 1 index right before the right bound
		    (where the choosen pivot value is now sitting in saftey)
		  */
		  for (int i = left; i < right; i++) {

		    /*
		      If this item is less than the 'pivotValue' then we need to move
		      this item to the section of items "less than the pivot"
		      'lesserItemsTailIndex' keeps track of where we need to swap into
		      next...after doing the swap we advance it...you see how this is
		      coming together?
		    */
		    if (arr[i] < pivotValue) {
		      swap(arr, i, lesserItemsTailIndex);
		      lesserItemsTailIndex++;
		    }
		  }

		  /*
		    Ok...partitioning is done. Swap the pivot item BACK into the space we just
		    partitioned at the 'lesserItemsTailIndex'...that's where the pivot item
		    belongs
		    In the middle of the "sandwich".
		  */
		  swap(arr, right, lesserItemsTailIndex);
		  
		  /*
		    Return the index of where we just put the pivot so that the caller knows its
		    final resting place (so that the caller can make the decisions it needs)
		  */
		  return lesserItemsTailIndex;
		}
	
	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	
	/**
	 * 
	 * @param index
	 * @param numsLen
	 * @return
	 * 
	 * DNF = DUTCH NATIONAL FLAG
	 * 
	 * Eg:
	 * DNF order: [9,8,7,6, 5, 4,3,2,1]
	 * DNF Index: [0,1,2,3, 4, 5,6,7,8]
	 * 
	 * Wiggle order: [5, 9, 4, 8, 3, 7, 2, 6, 1]
	 * Wiggle Index: [0, 1, 2, 3, 4, 5, 6, 7, 8]
	 * 
	 * Index Mapping:
	 * ---------------
	 * DNF --> Wiggle (value)
	 * -----------------------
	 * 0 --> 1 (9)
	 * 1 --> 3 (8)
	 * 2 --> 5 (7)
	 * 3 --> 7 (6)
	 * 4 --> 0 (5)
	 * 5 --> 2 (4)
	 * 6 --> 4 (3)
	 * 7 --> 6 (2)
	 * 8 --> 8 (1)
	 * that is DNF(i) = WIGGLE((1+2*i)%n), Divide by n so that it does not cross boundaries
	 * 
	 * numsLen | 1 => 
	 * If number is even, wiggleIndex will be recurring. To avoid this situation, we add +1 to numLen.
	 * 
	 * 
	 */
	private int getWiggleIndex(int index, int numsLen) {
		int wiggleIndex = ((2*index)+1)%(numsLen | 1);
		return wiggleIndex;
	}
}
