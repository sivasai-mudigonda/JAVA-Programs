/**
 * 
 */
package leetcode;

import java.util.Arrays;

/**
 * @author SivaM
 *
 * Leetcode Ques - 344 {Reverse String} {EASY}
 * https://leetcode.com/problems/reverse-string/
 * 
 * Write a function that reverses a string. 
 * The input string is given as an array of characters char[].
 * Do not allocate extra space for another array, 
 * you must do this by modifying the input array in-place with O(1) extra memory.
 * You may assume all the characters consist of printable ascii characters.
 * 
	Example 1:
	Input: ["h","e","l","l","o"]
	Output: ["o","l","l","e","h"]
	
	Example 2:
	Input: ["H","a","n","n","a","h"]
	Output: ["h","a","n","n","a","H"]
 *
 * Time Complexity = O(N) - Loop through character array
 * Space Complexity = o(1) - Constant space
 * 
 */
public class ReverseString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ReverseString obj = new ReverseString();
		char[]  charArr1 = {'h','e','l','l','o'};
		System.out.println("Original Array = "+Arrays.toString(charArr1));
		obj.reverseString(charArr1);
		System.out.println("Reversed Array = "+Arrays.toString(charArr1)); // Expected output = [o, l, l, e, h]
		System.out.println("************************");
		char[] charArr2 = {'H','a','n','n','a','h'};
		System.out.println("Original Array = "+Arrays.toString(charArr2));
		obj.reverseString(charArr2);
		System.out.println("Reversed Array = "+Arrays.toString(charArr2)); // Expected output = [h, a, n, n, a, H]
	}
	
	/**
	 * 
	 * @param s
	 * 
	 * Two-Pointer approach+ SWAPPING
	 */
	public void reverseString(char[] s) {
		if(s==null || s.length==0) {
			return;
		}
		int left = 0;
		int right = s.length-1;
		while(left<right) {
			char leftChar = s[left];
			s[left] = s[right];
			s[right] = leftChar;
			left++;
			right--;
		}
	}
}
