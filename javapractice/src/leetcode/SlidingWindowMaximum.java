/**
 * 
 */
package leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author SivaM
 *
 * LeetCode Ques - 239 {Sliding Window Maximum}
 * https://leetcode.com/problems/sliding-window-maximum/
 * 
 * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. 
 * You can only see the k numbers in the window. 
 * Each time the sliding window moves right by one position. Return the max sliding window.
 * 
	Example:
	Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
	Output: [3,3,5,5,6,7] 
	
	Explanation: 
	Window position                Max
	---------------               -----
	[1  3  -1] -3  5  3  6  7       3
	 1 [3  -1  -3] 5  3  6  7       3
	 1  3 [-1  -3  5] 3  6  7       5
	 1  3  -1 [-3  5  3] 6  7       5
	 1  3  -1  -3 [5  3  6] 7       6
	 1  3  -1  -3  5 [3  6  7]      7
 *
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ input array's size for non-empty array.
 * 
 * Follow up:
 * Could you solve it in linear time?
 * 
 * Solution:
 * we can just use a Deque{doubly linked list} to solve this problem. 
 * Every time we put a number into the deque, we remove all the smaller ones in the deque, because the new one is larger. 
 * And we can maintain the length of the deque to be less than k. 
 * We throw out any number prior to the window. 
 * So we can always get max number in the front of the deque.
 * 
 * Also refer Deque_Operations.png to view Deque methods.
 *
 * For understanding solution, refer below video links.
 * https://www.youtube.com/watch?v=J6o_Wz-UGvc
 * https://www.youtube.com/watch?v=5VDQxLAlfu0
 * 
 * Time Complexity : O(N) - Loop through nums array
 * Space Complexity : o(K) - To store k elements at any time in the Deque
 */
public class SlidingWindowMaximum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SlidingWindowMaximum obj = new SlidingWindowMaximum();
		
		int k = 3;
		int[] nums = {1,3,-1,-3,5,3,6,7};
		int[] result = obj.maxSlidingWindow(nums, k);
		System.out.println(Arrays.toString(result)); // Expected Output = [3,3,5,5,6,7]
	}
	
	/**
	 * 
	 * @param nums
	 * @param k
	 * @return
	 * 
	 * Deque - Double linked Queue, Which means insertions and deletions will take place from front and rear
	 * 
	 * Note:
	 * If you need add/remove of the both ends of queue, ArrayDeque is significantly better than a linked list.
	 * 
	 */
	public int[] maxSlidingWindow(int[] nums, int k) {
		if(nums==null || nums.length==0 ){
			return new int[0];
		}
		Deque<Integer> deQue = new ArrayDeque<>(); // Deque will store index of nums array
		int[] result = new int[nums.length-k+1];
		// Processing elements up to k-1 in to Dequeue. There will be no result until k-1. so, we are processing them first. 
		for(int i=0;i<k-1;i++) {
			append(deQue,nums,i);
		}
		// Handle from k-1 to nums.length where we get results array{Sliding window results}.
		for(int i=k-1;i<nums.length;i++) {
			append(deQue,nums,i); // Insert in to queue when urrent element is greater than peekLast element of queue
			result[i-k+1] =nums[deQue.peekFirst()]; // Greatest value of the sliding window is stored at the head of the queue in each iteration
			remove(deQue,i,k); // In order to store only k indexes in queue at all times, we remove indexes in queue which are no longer in sliding window range, for the next iteration.
		}
		return result;
    }
	
	/**
	 * 
	 * @param deQue
	 * @param nums
	 * @param index
	 * 
	 * Deque will store index of nums array
	 */
	private void append(Deque<Integer> deQue, int[] nums, int i) {
		if(deQue.isEmpty() ){
			deQue.offerLast(i);
			return;
		}
		// If the current element is greater than peekLast element of queue, remove peekLast index{i} from Deque {Insertion happens when elements are in descending sequence}
		// and finally insert current index
		while(!deQue.isEmpty() && nums[i]>nums[deQue.peekLast()] ){
			deQue.pollLast();
		}
		deQue.offerLast(i);
	}
	
	/**
	 * 
	 * @param deQue
	 * @param i
	 * @param k
	 * 
	 * i-k+1 gives us indexes which have become obsolete, that is, they are no longer in the sliding window range . 
	 * 
	 */
	private void remove(Deque<Integer> deQue, int i, int k) {
		if(!deQue.isEmpty() && (deQue.peekFirst()==i-k+1) ) {
			deQue.pollFirst();
		}
	}
}