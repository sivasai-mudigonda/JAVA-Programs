/**
 * 
 */
package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author SIVA SAI
 *
 *
 *Leet Code Ques Num 159 & 340
 *Longest Substring with At Most Two Distinct Characters And
 *Longest Substring with At Most K Distinct Characters
 *
 *
 *Two pointers
 *Time complesity = O(N)
 *Space Complexity = O(N)
 *
 *Explanation:
 *Invariant: A window of at most K distinct characters before the start of each iteration
 *Fix e, move s
 *maxlen = 3
 *eceba   k = 2
 *  s
     e
dic
b : 1
a : 1
* Refer For Code = "https://www.youtube.com/watch?v=RHFrVNmlyA8" 
* And "https://github.com/jzysheep/LeetCode/blob/master/340.%20Longest%20Substring%20with%20At%20Most%20K%20Distinct%20Characters.cpp"
* 
* Refer For explanation:
* "https://www.youtube.com/watch?v=8AQra0p_HmI" And
* "https://github.com/IDeserve/learn/blob/master/LongestSubstringWithMUniqueCharacters.java"
*
*/
 
public class LongestSubStringWithKDistintCharacters {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s="eceba";
		int k=2;
		int maxLength=longestSubString(s,k);
		System.out.println("MAX Length = " +maxLength); // Expected Output = 3
		
		s="arappam";
		maxLength=longestSubString(s,k);
		System.out.println("MAX Length = " +maxLength); // Expected Output = 4
	}
	
	private static int longestSubString(String s, Integer k) {
		int windowStart = 0;
		int maxLength=0;
		if(s==null || s.isEmpty() || k==0) {
			return maxLength;
		}
		int start=0;
		int end=0;
		Map<Character, Integer> dictonary = new HashMap<>();
		while(end<s.length() ) {
			char c= s.charAt(end);
			if(dictonary.containsKey(c) ){
				dictonary.put(c, dictonary.get(c)+1);
			} else {
				dictonary.put(c, 1);
			}
			while(dictonary.size() > k) {
				char startChar= s.charAt(start);
				if(dictonary.get(startChar) >1) {
					dictonary.put(startChar, dictonary.get(startChar)-1);
				} else if(dictonary.get(startChar) ==1){
					dictonary.remove(startChar);
				}
				start++;
			}
			if(end-start+1 >maxLength) {
				windowStart = start;
			}
			maxLength= Math.max(maxLength,end-start+1); // +1 is because end will travel until s.length()-1.
			end++;
		}
		System.out.println("LongestSubStringWithKDistintCharacters = " +s.substring(windowStart, windowStart+maxLength)); // Expected output = ece
		return maxLength;
	}
}
