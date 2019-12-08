/**
 * 
 */
package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author SivaM
 * 
 * Leet-code Ques - 387 {First Unique Character in a String} {Easy}
 * https://leetcode.com/problems/first-unique-character-in-a-string/
 * 
 * Given a string, find the first non-repeating character in it and return it's index.
 * If it doesn't exist, return -1.
 * 
	Examples:
	s = "leetcode"
	return 0.
	
	s = "loveleetcode",
	return 2.
 *
 * Note: 
 * You may assume the string contain only lowercase letters.
 * 
 * Method-1: {Using indexOf and lastIndexOf}
 * Time Complexity = O(26) = O(1) - Constant Time
 * Space Complexity = o(1) - Constant Space
 * 
 * Method-2: {Using HashMap} 
 * Time Complexity = O(N+N) =O(N) - To loop through String s  
 * Space Complexity = o(N) - Space used Store character and frequencies in HashMap
 * 
 */
public class Find_Unique_Char_In_String {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Find_Unique_Char_In_String obj = new Find_Unique_Char_In_String();
		System.out.println("First Unique Character Index  = "+obj.firstUniqChar("leetcode")); // Expected Result = 0
		System.out.println("First Unique Character Index  = "+obj.firstUniqChar_Map("leetcode")); // Expected Result = 0
		
		System.out.println("**************************");
		System.out.println("First Unique Character Index  = "+obj.firstUniqChar("loveleetcode")); // Expected Result = 2
		System.out.println("First Unique Character Index  = "+obj.firstUniqChar_Map("loveleetcode")); // Expected Result = 2
	}
	
	/**
	 * 
	 * @param s
	 * @return
	 * 
	 * Method-1:
	 * Using indexOf and lastIndexOf
	 * 
	 * indexOf - Gives first index of the character in String
	 * lastIndexOf - Gives last index of the character in String
	 * 
	 */
	public int firstUniqChar(String s) {
		if(s==null || s.length()==0 ){
			return -1; // Unique String not found
		} else if(s.length()==1 ){
			return 0; // Return First Index
		}
		int index = Integer.MAX_VALUE;
		for(char ch='a';ch<='z';ch++ ){
			if(s.indexOf(ch)!=-1 && s.indexOf(ch)==s.lastIndexOf(ch)  ){
				/* eg: In "loveleetcode",  t and v{chronological order} are appearing only once.
				 * t's index is 7
				 * v's index is 2.
				 * As 2<7, Index will be 2.
				 * 
				 */
				index = Math.min(index, s.indexOf(ch));
			}
		}
		return index==Integer.MAX_VALUE?-1:index;
	}
	
	/**
	 * 
	 * @param s
	 * @return
	 * 
	 * Method-2:
	 * Using HashMap
	 * 
	 */
	public int firstUniqChar_Map(String s) {
		if(s==null || s.length()==0 ){
			return -1; // Unique String not found
		} else if(s.length()==1 ){
			return 0; // Return First Index
		}
		Map<Character,Integer> charCntMap = new HashMap<>();
		// Build Map with Key as character and value as its occurrence frequency in String.
		for(char c: s.toCharArray() ){
			charCntMap.compute(c,(k,v)->{
				return v==null?1:v+1;
			});
		}
		// Loop through String and check if a character has no of occurrences in Map as one.
		// If matched return index.
		for(int index=0;index<s.length();index++){
			if(charCntMap.get(s.charAt(index))==1 ){
				return index;
			}
		}
		return -1; // Unique String not found
    }
}
