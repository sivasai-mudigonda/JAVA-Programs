/**
 * 
 */
package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author u230107
 *
 *         Leet Code - 49 {Group Anagrams}
 *         https://leetcode.com/problems/group-anagrams/
 *
 *         Given an array of strings, group anagrams together. Example: Input:
 *         ["eat", "tea", "tan", "ate", "nat", "bat"], Output: [
 *         ["ate","eat","tea"], ["nat","tan"], ["bat"] ]
 *         
 *         Note:
 *         All inputs will be in lowercase.
 *         The order of your output does not matter.
 *
 *         Time Complexity : O(NLogN) - As we are applying sort
 *         Space Complexity : o(N) - To store key{Sorted chars of strs[i]} and value{grouped anagrams with same key} in Map
 */
public class GroupAnagrams {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] strArr = { "eat", "tea", "tan", "ate", "nat", "bat" };
		List<List<String>> res = groupAnagrams(strArr);
		System.out.println(res); // Expected Output = [[eat, tea, ate], [bat], [tan, nat]]
	}

	/*
	 * All anagrams when sorted will look the same. This can easily be leveraged as
	 * a key in a map for anagram lists.
	 */
	private static List<List<String>> groupAnagrams(String[] strs) {
		if (strs == null || strs.length == 0) {
			return new ArrayList<>();
		}
		/*
		 * key is going to be sorted string. value will be list of strings which have
		 * those characters.
		 */
		Map<String, List<String>> map = new HashMap<>();
		for (String str : strs) {
			char[] chArr = str.toCharArray();
			Arrays.sort(chArr); // Sorting given String by converting to character array.
			String key = String.valueOf(chArr);
			if (!map.containsKey(key)) {
				map.put(key, new ArrayList<>());
			}
			map.get(key).add(str); // list.add(string)
		}
		return new ArrayList<>(map.values());
	}
}
