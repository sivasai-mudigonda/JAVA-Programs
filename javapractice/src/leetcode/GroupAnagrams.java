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
 *   Leet-Code - 49 {Group Anagrams} {Medium}
 *   https://leetcode.com/problems/group-anagrams/
 *
 *   Given an array of strings, group anagrams together. Example: Input:
 *   ["eat", "tea", "tan", "ate", "nat", "bat"], Output: [
 *   ["ate","eat","tea"], ["nat","tan"], ["bat"] ]
 *         
 *   Note:
 *   All inputs will be in lowercase.
 *   The order of your output does not matter.
 *
 *   Method-1:
 *   Time Complexity : O(N*K), where N is the length of strs, and K is the maximum length of a string in strs.
 *   Space Complexity : O(N*K), Store elements in result List.
 *
 *   Method-2:
 *   Time Complexity : O(K*NLogN) - As we are applying sort for k number of words
 *   Space Complexity : O(N*K), Store elements in result List.
 *   
 *   Companies:
 *   Oracle
 *   
 */
public class GroupAnagrams {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		GroupAnagrams obj = new GroupAnagrams();
		
		String[] strArr = { "eat", "tea", "tan", "ate", "nat", "bat" };
		List<List<String>> res = obj.groupAnagrams(strArr);
		System.out.println("With Count Approach : " +res); // Expected Output = [[eat, tea, ate], [bat], [tan, nat]]
		res = obj.groupAnagrams_Sort(strArr);
		System.out.println("With Sort Approach : " +res); // Expected Output = [[eat, tea, ate], [bat], [tan, nat]]
		
	}
	
	/**
	 * 
	 * @param strs
	 * @return
	 * 
	 * Method-1: Categorize by Count
	 * 
	 * Two strings are anagrams if and only if their character counts (respective number of occurrences of each character) are the same.
	 * 
	 */
	public List<List<String>> groupAnagrams(String[] strs) {
		if (strs == null || strs.length == 0) {
			return new ArrayList<>();
		}
		Map<String,List<String>> map = new HashMap<>();
		for(String s : strs ){
			String key = getKey(s);
			if(map.containsKey(key) ){
				map.get(key).add(s);
			} else {
				List<String> li = new ArrayList<>();
				li.add(s);
				map.put(key,li);
			}
		}
		List<List<String>> result = new ArrayList<>(map.values()); 
		return result;
	}
	
	/**
	 * 
	 * @return
	 * 
	 * We can transform each string into a character count consisting of 26 non-negative integers. 
	 * We use these counts as the basis for our hash map.
	 * 
	 */
	private String getKey(String s ){
		char[] chArr = s.toCharArray();
		char[] newCharArr = new char[26];
		for(char c: chArr) {
			newCharArr[c-'a']++;
		}
		return new String(newCharArr);
	}
	
	/**
	 * 
	 * @param strs
	 * @return
	 * 
	 * Method-2 : Categorize by Sorted String
	 * 
	 * All anagrams when sorted will look the same. 
	 * This can easily be leveraged as a key in a map for anagram lists.
	 * 
	 */
	public List<List<String>> groupAnagrams_Sort(String[] strs) {
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
		List<List<String>> result = new ArrayList<>(map.values()); 
		return result;
	}
}
