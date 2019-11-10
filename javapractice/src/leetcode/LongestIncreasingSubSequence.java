/**
 * 
 */
package leetcode;

import java.util.Arrays;

/**
 * @author SivaM
 * 
 * Leetcode Ques - 300 {Longest Increasing Subsequence}
 * https://leetcode.com/problems/longest-increasing-subsequence/
 * 
 * Given an unsorted array of integers, find the length of longest increasing subsequence.
 * 
	Example:
	Input: [10,9,2,5,3,7,101,18]
	Output: 4 
	Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4. 
 * 
 * Note:
 * There may be more than one LIS combination, it is only necessary for you to return the length.
 * Your algorithm should run in O(n2) complexity.
 * Follow up: Could you improve it to O(n log n) time complexity?
 * 
 * Solution:
 * Video Explanation Link : https://www.youtube.com/watch?v=fV-TF4OvZpk
 * 
 * Time Complexity =O(N^2)
 * Space Complexity =o(N)
 * 
 */
public class LongestIncreasingSubSequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LongestIncreasingSubSequence obj = new LongestIncreasingSubSequence();
		
		int nums[] = {10,9,2,5,3,7,101,18};
		System.out.println("Longest increasing sub-sequence = " +obj.lengthOfLIS(nums)); // Expected Output = 4
	}
	
	/**
	 * 
	 * @param nums
	 * @return
	 * 
	 * Dynamic Programming - Solving sub-problem first to obtain solution for actual problem
	 * We are going to apply Dynamic programming to solve this problem.
	 * 
	 * We are also making use of memorization technique {dp array}
	 */
	public int lengthOfLIS(int[] nums) {
        if(nums==null || nums.length==0 ){
        	return 0;
        }
        // By default the best answer is a length of 1
        int longestIncresingSubSequence = 1;
        /*
        Array to store our subproblems, default answer is 1. A single
        item is neither increasing or decreasing, kind of a middle ground.
        Each index records the answer to "what is the longest increasing
        subsequence ending at index i of the original array?"
        */
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        /*
        Test every possible end index of a longest increasing subsequence
        */
        for(int i=1;i<nums.length;i++ ){
        	/*
            We aim to see if we can append the item at nums[i]
            to extend the Longest Increasing Subsequence achieved
            from index 0...j (which is what the cache records)
            We want to solve for maxLength[i] if the value at 'i'
            beats 'j'. If we can we see which is greater between
            these then we have our answer:
            1.) dp[i]: The best answer so far for the LIS from 0...i
            2.) dp[j] + 1: The value of maxLength[j] is the length
            of the LIS from 0...j, we conceptually "append" this{current item} item to
            that LIS by adding 1 to that subproblem answer, yielding a
            potentially new answer for LIS[0..i]
            */
        	for(int j=0;j<i;j++ ){
        		if(nums[i] >nums[j] ){ //  
        			dp[i]	= Math.max(dp[i],dp[j]+1);
        		}
        	}
        	 /*
            We now have an answer for LIS[0...i]. Compete it against the
            best LIS length found so far.
             */
        	longestIncresingSubSequence = Math.max(longestIncresingSubSequence, dp[i]);
        }
        return longestIncresingSubSequence;
    }
	/**
	 * 
	 * O(NlogN) solution, For reference.
	 * In interview if u can write O(n^2) {above} solution, It would be good.
	 * 
	static int CeilIndex(int A[], int l, int r, int key) 
    { 
        while (r - l > 1) { 
            int m = l + (r - l) / 2; 
            if (A[m] >= key) 
                r = m; 
            else
                l = m; 
        } 
  
        return r; 
    } 
  
    static int LongestIncreasingSubsequenceLength(int A[], int size) 
    { 
        // Add boundary case, when array size is one 
  
        int[] tailTable = new int[size]; 
        int len; // always points empty slot 
  
        tailTable[0] = A[0]; 
        len = 1; 
        for (int i = 1; i < size; i++) { 
            if (A[i] < tailTable[0]) 
                // new smallest value 
                tailTable[0] = A[i]; 
  
            else if (A[i] > tailTable[len - 1]) 
                // A[i] wants to extend largest subsequence 
                tailTable[len++] = A[i]; 
  
            else
                // A[i] wants to be current end candidate of an existing 
                // subsequence. It will replace ceil value in tailTable 
                tailTable[CeilIndex(tailTable, -1, len - 1, A[i])] = A[i]; 
        } 
  
        return len; 
    } 
	 */
}
