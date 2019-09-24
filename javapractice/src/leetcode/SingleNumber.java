/**
 * 
 */
package leetcode;

/**
 * @author SivaM
 * 
 * LeetCode Ques - 136 {Single Number}
 * https://leetcode.com/problems/single-number/
 * 
 * Given a non-empty array of integers, every element appears twice except for one. 
 * Find that single one.
 * Note:
 * Your algorithm should have a linear runtime complexity. 
 * Could you implement it without using extra memory?
 * 
	Example 1:
	
	Input: [2,2,1]
	Output: 1
	Example 2:
	
	Input: [4,1,2,1,2]
	Output: 4
 *
 * Time Complexity = O(N)
 * Space Complexity = o(1)
 */
public class SingleNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SingleNumber obj  = new SingleNumber();
		
		int[] nums1 = {2,2,1};
		System.out.println("Non Repeated Number = " +obj.singleNumber(nums1)); // Expected Output =1
		
		int[] nums2 = {4,1,2,1,2};
		System.out.println("Non Repeated Number = " +obj.singleNumber(nums2)); // Expected Output =4
	}
	
	/**
	 * 
	 * @param nums
	 * @return
	 * 
	 * The XOR operation is an operator that operates as 0 if the values ​​are the same, and as 1 if they are different.
	 * Since every number is repeating twice we can use xor to eliminate the duplicates as n xor n = 0
	 * 
	    INPUT	OUTPUT
		A	B	A XOR B
		0	0	0
		0	1	1
		1	0	1
		1	1	0
	 *
	 */
	private int singleNumber(int[] nums) {
        int x = 0;
        for(int n : nums) {
        	x = x ^ n; // XOR operation 
        }
        return x;
    }
}
