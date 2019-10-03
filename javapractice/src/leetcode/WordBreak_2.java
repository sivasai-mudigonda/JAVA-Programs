package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author u230107
 *
 *         LeetCode Ques - 140 {Word Break II}
 *         https://leetcode.com/problems/word-break-ii/
 *
 *         Given a non-empty string s and a dictionary wordDict containing a
 *         list of non-empty words, add spaces in s to construct a sentence
 *         where each word is a valid dictionary word. Return all such possible
 *         sentences. Note: The same word in the dictionary may be reused
 *         multiple times in the segmentation. You may assume the dictionary
 *         does not contain duplicate words.
 *
 *         Example 1: Input: 
 *         s = "catsanddog" wordDict = ["cat", "cats", "and",
 *         "sand", "dog"] 
 *         Output: 
 *         [ "cats and dog", "cat sand dog" ] 
 *         
 *         Example 2:
 *         Input: 
 *         s = "pineapplepenapple" wordDict = ["apple", "pen",
 *         "applepen", "pine", "pineapple"] 
 *         Output: 
 *         [ "pine apple pen apple",
 *         "pineapple pen apple", "pine applepen apple" ] 
 *         
 *         Example 3: 
 *         Input: 
 *         s = "catsandog" wordDict = ["cats", "dog", "sand", "and", "cat"] 
 *         Output:
 *         []
 *
 *         For Solution, refer "WordBreak_2_Problem_Analysis.txt" file present
 *         in important docs
 *
 *         Time Complexity = O(n*2^n), n being the number of characters in the
 *         input. Space Complexity = O(n*2^n)
 */
public class WordBreak_2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		WordBreak_2 obj = new WordBreak_2();
		String[] strArr = { "apple", "pen", "applepen", "pine", "pineapple" };
		List<String> wordDict = Arrays.stream(strArr).collect(Collectors.toList());
		String str = "pineapplepenapple";
		List<String> res = obj.wordBreak(str, wordDict);
		res.forEach(System.out::println);
		/*
		 * Expected Output : pine apple pen apple pine applepen apple pineapple pen
		 * apple
		 */

		System.out.println("*********************");
		String[] strArr2 = { "cat", "cats", "and", "sand", "dog" };
		Arrays.stream(strArr2).forEach(wordDict::add);
		str = "catsanddog";
		res = obj.wordBreak(str, wordDict);
		res.forEach(System.out::println);
		/*
		 * Expected Output : cats and dog cat sand dog
		 */

		System.out.println("*********************");
		str = "catsandog";
		res = obj.wordBreak(str, wordDict);
		res.forEach(System.out::println); // Expected Output = []
	}

	private List<String> wordBreak(String s, List<String> wordDict) {
		Map<String, List<String>> map = new HashMap<>();
		Set<String> set = new HashSet<>(wordDict); // For O(1) search time
		return wordBreak_Helper(s, set, map);
	}

	/*
	 * Map is used for memorization of processed strings
	 */
	private List<String> wordBreak_Helper(String s, Set<String> wordSet, Map<String, List<String>> map) {
		if (map.containsKey(s)) {
			return map.get(s);
		}
		List<String> res = new LinkedList<>();
		if (s.length() == 0) {
			res.add(""); // To go to line 51{foreach loop} to add word to list.
			return res;
		}
		for (String word : wordSet) {
			if (s.startsWith(word)) {
				// DFS
				List<String> subList = wordBreak_Helper(s.substring(word.length()), wordSet, map);
				for (String str : subList) {
					res.add(word + (subList.isEmpty() ? "" : " ") + str);
				}
			}
		}
		map.put(s, res);
		return res;
	}
}
