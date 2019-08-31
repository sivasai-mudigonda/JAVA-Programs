package leetcode;

/**
 * 
 * @author SivaM
 * 
 * WildCardMatching -LeetCode-44
 * Q: https://leetcode.com/problems/wildcard-matching/
 * Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*'.

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).
The matching should cover the entire input string (not partial).

Note:

s could be empty and contains only lowercase letters a-z.
p could be empty and contains only lowercase letters a-z, and characters like ? or *.
Example 1:

Input:
s = "aa"
p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".
Example 2:

Input:
s = "aa"
p = "*"
Output: true
Explanation: '*' matches any sequence.
Example 3:

Input:
s = "cb"
p = "?a"
Output: false
Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.
Example 4:

Input:
s = "adceb"
p = "*a*b"
Output: true
Explanation: The first '*' matches the empty sequence, while the second '*' matches the substring "dce".
Example 5:

Input:
s = "acdcb"
p = "a*c?b"
Output: false
 * 
 * Refer https://www.youtube.com/watch?v=3ZDZ-N0EPV0
 * Refer https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/WildCardMatching.java
 * 
 * Time Complexity = O(N^2) or O(MN) ., where M is text and N is pattern
 * Space Complexity = o(N^2) --> Two Dimentional boolean Array
 */

public class WildCardMatching {
	
	private static boolean isMatch(String txt, String pattern) {
		char[] txtArr= txt.toCharArray();
		char[] patternArr = pattern.toCharArray();
		
		// To replace patterns like "a**" with "a*"{Single star}
		int newPatternsize=0;
		boolean isFirst=true;
		for(int col=0;col<patternArr.length;col++) {
			if(patternArr[col]=='*') {
				if(isFirst) {
					patternArr[newPatternsize++]= patternArr[col];
					isFirst=false;
				}
			} else{
				patternArr[newPatternsize++]= patternArr[col];
				isFirst=true;
			}
		}
		
		boolean T[][] =  new boolean[txtArr.length+1][newPatternsize+1];
		
		// If pattern is starting with "*" 
		if(newPatternsize>0 && patternArr[0]=='*') {
			T[0][1]=true;
		}
		
		T[0][0]=true;
		
		//Actual Logic
		for(int row=1;row<T.length;row++) { // Row Represents text
			for(int col=1;col<T[0].length;col++) { // Col represents pttern
				if(txtArr[row-1]==patternArr[col-1] || patternArr[col-1]=='?') {
					T[row][col] = T[row-1][col-1];  // Set left diagonal value from above 
				} else if(patternArr[col-1]=='*' ){
					// Check for previous column cell and above row cell values
					T[row][col] = T[row][col-1] | T[row-1][col]; 
				}
			}
		}
		return T[txtArr.length][newPatternsize];
	}
	
	public static void main(String[] str) {
		System.out.println(isMatch("xbylmz", "x**y***z"));
        System.out.println(isMatch("xbylmz", "x?y*z"));		
	}
}