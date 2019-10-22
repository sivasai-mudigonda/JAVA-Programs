/**
 * 
 */
package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author SivaM
 * 
 * LeetCode Ques - 266 {Palindrome Permutation}
 * https://leetcode.com/articles/palindrome-permutation/
 * 
 *  Given a string, determine if a permutation of the string could form a palindrome.
 *  
	Example 1:
	Input: "code"
	Output: false
	
	Example 2:
	Input: "aab"
	Output: true
	
	Example 3:
	Input: "carerac"
	Output: true
 *
 * Time Complexity = O(N) - Loop through str
 * Space Complexity = o(N) - Elements stored in SET
 */
public class PalindromePermutation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PalindromePermutation obj = new PalindromePermutation();
		
		String str="code";
		System.out.println("Can permutation of str form Palindrome = " +obj.canPermutePalindromeSimple(str));
		str="aab";
		System.out.println("Can permutation of str form Palindrome = " +obj.canPermutePalindromeSimple(str));
		str="carerac";
		System.out.println("Can permutation of str form Palindrome = " +obj.canPermutePalindromeSimple(str));
	}
	
	public boolean canPermutePalindromeSimple(String s) {
		if(s==null || s.length()==0 || s.length()==1) {
			return true;
		}
		Set<Character> set = new HashSet<>();
		for(char c : s.toCharArray() ){
			if(set.contains(c) ){
				// If present in set, remove the character
			    set.remove(c); 
			} else {
				// If not present in set, add to set
				set.add(c);
			}
		}
		// If s is even, check if set size is zero
		// If s is odd, check if set size is one.
		return s.length()%2==0?set.size()==0:set.size()==1;
	}
}
