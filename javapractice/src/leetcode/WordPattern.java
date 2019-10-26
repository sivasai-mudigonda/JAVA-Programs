package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author u230107
 *
 *         Given a pattern and a string str, find if str follows the same
 *         pattern. Here follow means a full match, such that there is a
 *         bijection between a letter in patternand a non-empty word in str.
 *
 *         Example 1: Input: pattern = "abba" , str = "dog cat cat dog" Output:
 *         true
 * 
 *         Example 2: Input: pattern = "abba" , str = "dog cat cat fish" Output:
 *         false
 * 
 *         Example 3: Input: pattern = "aaaa" , str = "dog cat cat dog" Output:
 *         false
 * 
 *         Example 4: Input: pattern = "abba" , str = "dog dog dog dog" Output:
 *         false
 *
 *         Notes: You may assume patterncontains only lowercase letters, and
 *         strcontains lowercase letters that may be separated by a single
 *         space.
 *
 *         Time Complexity = O(N) - Loop through pattern Space Complexity = o(N)
 *         - To store values on Map
 *
 */
public class WordPattern {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		WordPattern obj = new WordPattern();

		String pattern = "abba";
		String str = "dog cat cat dog";
		System.out.println("Does str follows same pattern = " + obj.wordPattern(pattern, str)); // Expected Output = true

		pattern = "abba";
		str = "dog cat cat fish";
		System.out.println("Does str follows same pattern = " + obj.wordPattern(pattern, str)); // Expected Output = false

		pattern = "aaaa";
		str = "dog cat cat dog";
		System.out.println("Does str follows same pattern = " + obj.wordPattern(pattern, str)); // Expected Output = false

		pattern = "abba";
		str = "dog dog dog dog";
		System.out.println("Does str follows same pattern = " + obj.wordPattern(pattern, str)); // Expected Output = false
	}

	public boolean wordPattern(String pattern, String str) {
		if (pattern == null || pattern.length() == 0) {
			return false;
		}
		String[] strArr = str.split("\\s"); // Split str by space
		if(strArr.length!=pattern.length() ){
			return false; // Num of chars in pattern should match no of words in str
		}
		Map<Character, String> map = new HashMap<>();
		for (int i = 0; i < pattern.length(); i++) {
			char c = pattern.charAt(i);
			if (map.containsKey(c)) {
				String s = map.get(c);
				if (!s.equals(strArr[i])) {
					return false; // Key (character in pattern) is present and its value{word in str} is not current word in the map
				}
			} else if (map.containsValue(strArr[i])) {
				return false; // Value{Word in str} is mapped with some other key{character in pattern} in the map
			}
			map.put(c, strArr[i]);
		}
		return true;
	}
}
