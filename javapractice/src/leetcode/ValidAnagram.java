/**
 * 
 */
package leetcode;

/**
 * @author SivaM
 * 
 * LeetCode Ques - 242 {Valid Anagram}
 * https://leetcode.com/problems/valid-anagram/
 * 
 * Given two strings s and t , write a function to determine if t is an anagram of s.
 * 
	Example 1:
	Input: s = "anagram", t = "nagaram"
	Output: true
	
	Example 2:	
	Input: s = "rat", t = "car"
	Output: false
 *
 * Note:
 * You may assume the string contains only lowercase alphabets.
 *
 * Follow up:
 * What if the inputs contain unicode characters? 
 * How would you adapt your solution to such case?
 * 
 * Time Complexity = O(N) - N is the number of characters in the String
 * Space Complexity = o(1)
 * 
 */
public class ValidAnagram {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ValidAnagram obj = new ValidAnagram();
		String s = "anagram", t = "nagaram";
		System.out.println("Is Valid Anagram = " +obj.isAnagram(s,t));
		
		s = "rat";
		t = "car";
		System.out.println("Is Valid Anagram = " +obj.isAnagram(s,t));
	}
	
	/**
	 * 
	 * @param s
	 * @param t
	 * @return
	 * 
	 * Anagram:
	 * A word, phrase, or name formed by rearranging the letters of another, such as cinema, formed from iceman.
	 */
	public boolean isAnagram(String s, String t) {
		if(s==null && t==null ){
			return true;
		} else if(s==null || t==null ){
			return false;
		} else if(s.length() != t.length() ){
			return false;
		} else {
			int[] intArr = new int[26];
			int i=0;
			while(i<s.length() ){
				intArr[s.charAt(i)-'a']++;
				intArr[t.charAt(i)-'a']--;
				i++;
			}
			for(int n : intArr) {
				if(n!=0) {
					return false;
				}
			}
			return true;
		}
	}

}
