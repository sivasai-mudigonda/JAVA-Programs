/**
 * 
 */
package leetcode;

import java.util.Arrays;

/**
 * @author SIVA SAI
 *
 *
 *Given a non-empty array of digits representing a non-negative integer, plus one to the integer.

The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.

You may assume the integer does not contain any leading zero, except the number 0 itself.

Example 1:

Input: [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
Example 2:

Input: [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.
 *
 *
 * Refer https://www.youtube.com/watch?v=_sls9AdBymI
 * 
 * Time Complexity = O(N)
 * Space Complexity = o(N) // worst case
 */
public class PlusOne {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] resultArr;
		
		int[] digits1= {4,3,2,1};
		resultArr=plusOne(digits1);
		System.out.println(Arrays.toString(resultArr)); // Expected Output :  [4,3,2,2]
		
		int[] digits2= {1,2,3};
		resultArr=plusOne(digits2);
		System.out.println(Arrays.toString(resultArr)); // Expected Output: [1,2,4]
	}
	
	private static int[] plusOne(int[] digits) {
        if(digits==null || digits.length<1) {
        	return digits;
        }
        
        for(int i=digits.length-1;i>=0;i--) {
        	if(digits[i]<9) {
        		digits[i]++; // Increment didit plus one and return digits.
        		return digits;
        	}
        	digits[i]=0; // If digit is 9.
        }
        int[] newDigits=new int[digits.length+1];
        newDigits[0]=1; // If all digits are 9's.
        return newDigits;
    }
}
