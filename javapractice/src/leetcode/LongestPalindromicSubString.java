/**
 * 
 */
package leetcode;

import java.util.Arrays;

/**
 * @author SIVA SAI
 *
 */
public class LongestPalindromicSubString {

	/**
	 * @param args
	 * 
	 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000?
	 * 
	 * Refer http://www.goodtecher.com/leetcode-5-longest-palindromic-substring/
	 * Refer https://www.youtube.com/watch?v=0xeBqanD5GQ&index=5&list=PLV8H0QrJHjOmhbwotwt3Sy8qlfzqGhVW-
	 * 
	 * Time Complexity = O(n^2)
	 * Space Complexity = o(n^2)
	 */
	public static void main(String[] args) {
		String str="babad";
		String res=longestpalindromicComputation(str);
		System.out.println("palindromic sub sequence = "+res); // Expected Result = aba
		
		str="cbbd";
		res=longestpalindromicComputation(str);
		System.out.println("palindromic sub sequence = "+res); // Expected Result = bb
	}
	
	private static String longestpalindromicComputation(String str) {
		if(str==null || str.length()<2 ) {
			return str;
		}
		
		Boolean[][] isPalindrome= new Boolean[str.length()][str.length()];
		for(int i=0;i<str.length();i++) {
			Arrays.fill(isPalindrome[i], Boolean.FALSE);
		}
		int left=0;
		int right=0;
		
		// In order to get at least one character of a word, j has been to at least one index after i. 
		for(int j=1;j<str.length();j++) {
			for(int i=0;i<j;i++) {
				boolean isInnerPalindromic = isPalindrome[i+1][j-1] || j-i<=2; //  he code j - i <= 2 is checking if the inner word between string.charAt(i) and string.charAt(j) only has one character.﻿
				if(str.charAt(i)==str.charAt(j) && isInnerPalindromic) {
					isPalindrome[i][j]=true;
					if(j-i > right-left) {
						left=i;
						right=j;
					}
				}
			}
		}
		return str.substring(left,right+1);
	}

}
