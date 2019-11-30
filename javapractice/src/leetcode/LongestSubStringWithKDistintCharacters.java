/**
 * 
 */
package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author SIVA SAI
 *
 * Leet-Code Ques - 340 {Longest Substring with At Most K Distinct Characters} {HARD}
 * https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/
 * 
 * Given a string, find the length of the longest substring T that contains at most k distinct characters.
 * 
 * "at most" means "maximum" as per English language definition.
 * Opposite of "at most" is "at least" which means "minimum". 
 * 
	Example 1:
	Input: s = "eceba", k = 2
	Output: 3
	Explanation: T is "ece" which its length is 3.
	
	Example 2:
	Input: s = "aa", k = 1
	Output: 2
	Explanation: T is "aa" which its length is 2.
*
* Solution: {Two pointers}
* 1.> if k=0 , no such substring exists as no substring has 0 distinct characters.
* 2.> Use HashMap{frequencies} to keep track of frequency for each character.
* 3.> Inside the while loop, scan each char of the string, increment its frequencies every time.
* 4.> If the current size of distinct characters is larger than k ,we advance start until we have k distinct characters.
* 
* Refer For Code https://www.youtube.com/watch?v=RHFrVNmlyA8
* And 
* https://github.com/jzysheep/LeetCode/blob/master/340.%20Longest%20Substring%20with%20At%20Most%20K%20Distinct%20Characters.cpp
* Also Refer,
* https://www.youtube.com/watch?v=8AQra0p_HmI
* And
* https://github.com/IDeserve/learn/blob/master/LongestSubstringWithMUniqueCharacters.java
* 
* Time Complexity = O(N) - Loop through characters in String
* Space Complexity = o(k) - k characters stored in HashMap{frequencies}
* 
*/
 
public class LongestSubStringWithKDistintCharacters {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LongestSubStringWithKDistintCharacters obj = new LongestSubStringWithKDistintCharacters();
		
		String s="eceba";
		int k=2;
		int maxLength=obj.lengthOfLongestSubstringKDistinct(s,k);
		System.out.println("MAX Length = " +maxLength); // Expected Output = 3
		
		s="arappam";
		maxLength=obj.lengthOfLongestSubstringKDistinct(s,k);
		System.out.println("MAX Length = " +maxLength); // Expected Output = 4
	}
	
	/**
	 * 
	 * @param s
	 * @param k
	 * @return
	 * 
	 * Java-8 Map operations:
	 * compute, computeIfPresent, computeIfAbsent
	 * put, putIfPresent, putIfAbsent
	 * remove, removeAll, removeIf
	 * merge, replace
	 * 
	 */
	public int lengthOfLongestSubstringKDistinct(String s, Integer k) {
		int windowStart = 0;
		int maxLength=0;
		if(s==null || s.isEmpty() || k==0 || k>s.length() ){
			return maxLength;
		}
		int start=0;
		int end=0;
		Map<Character, Integer> frequencies = new HashMap<>();
		while(end<s.length() ) {
			char endChar= s.charAt(end);
			frequencies.compute(endChar,(key,val)->val==null?1:val+1);
			/*
			 * JAVA-7
				if(frequencies.containsKey(endChar) ){
					frequencies.put(endChar, frequencies.get(endChar)+1);
				} else {
					frequencies.put(endChar, 1);
				}
			*/
			while(frequencies.size() > k) {
				char startChar= s.charAt(start);
				frequencies.computeIfPresent(startChar,(key,val)->val==1?null:val-1);
				/*
				 * JAVA-7
					if(frequencies.get(startChar) >1) {
						frequencies.put(startChar, frequencies.get(startChar)-1);
					} else if(frequencies.get(startChar) ==1){
						frequencies.remove(startChar);
					}
				*/
				start++;
			}
			int currWindowDiff = end-start+1; 
			if(currWindowDiff >maxLength) {
				windowStart = start;
			}
			maxLength= Math.max(maxLength,currWindowDiff); // Adding 1 is because array index starts with zero.
			end++;
		}
		System.out.println("LongestSubStringWithKDistintCharacters = " +s.substring(windowStart, windowStart+maxLength)); // Expected output = ece
		return maxLength;
	}
}
