/**
 * 
 */
package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author SIVA SAI
 *
 *Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

Your algorithm should run in O(n) complexity.

Example:

Input: [100, 4, 200, 1, 3, 2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 *
 *
 *Refer https://www.youtube.com/watch?v=1t-082mMScY
 *
 *Time Complexity = O(N)
 *Space Complexity = o(1)
 */
public class LongestConsecutiveSequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums= {100, 4, 200, 1, 3, 2};
		int result=longestConsecutive(nums);
		System.out.println("Result = " +result); // Expected output=4
	}
	
	private static int longestConsecutive(int[] nums) {
        if(nums==null || nums.length<1) {
        	return 0;
        }
        Set<Integer> values = new HashSet<>(); 
        for(int i: nums) {
        	values.add(i);
        }
		
        int max=0;
        for(int i: values) {
        	if(values.contains(i-1) ) { 
        		continue;// Skip Subset. eg: map={1,2,3} and i=2. As i=1 is present in map, We can skip for 2.
        	}
        	
        	int length=0;
        	while(values.contains(i++) ){ // Post Increment operator--> gets incremented after checking contains condition.
        		length++;
        	}
        	max= Math.max(max, length);
        }
        return max;
    }
}
