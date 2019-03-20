/**
 * 
 */
package javapractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author SIVA SAI
 *
 */
public class FindLongestString {

	/**
	 * @param args
	 * 
	 * Find largest word in dictionary by deleting some characters of given string?
	 * 
	 * Refer https://www.geeksforgeeks.org/find-largest-word-dictionary-deleting-characters-given-string/
	 *  
	 * Time Complexity = O(N*K)where N is the length of list 
	 * and K is maximum length of words in the list.
	 * 
	 * Space Complexity =o(1)
	 */
	public static void main(String[] args) {
		String[] arr = {"ale", "apple", "monkey", "plea"}; 
        List<String> dict = new ArrayList<String>(Arrays.asList(arr)); 
        String str = "abpcplea"; 
        findLongestString(dict, str);
	}
	
	private static void findLongestString(List<String> wordsLi, String input) {
		int length=0;
		String resWord="";
		for(String word: wordsLi) {
			if(length<word.length() 
					&&	isSubSequence(word,input)	) {
				length=word.length();
				resWord=word;
			}
		}
		
		System.out.println("Longest String that can be formed with input " +input 
				                 +" is " +resWord +" and its length is "+length);
	}
	
	private static boolean isSubSequence(String word, String input) {
		int wordMatchCnt=0;
		for(int i=0;i<input.length() && wordMatchCnt < word.length() ;i++) {
			if(word.toLowerCase().charAt(wordMatchCnt) == input.charAt(i) ){
				wordMatchCnt++;
			}
		}
		return wordMatchCnt==word.length();
	}

}
