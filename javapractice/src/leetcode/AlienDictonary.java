package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* @author u230107
*
* LeetCode Ques - 269 {Alien Dictionary}
* https://leetcode.com/problems/alien-dictionary/
*
*
* There is a new alien language which uses the latin alphabet.
* However, the order among letters are unknown to you.
* You receive a list of non-empty words from the dictionary,
* where words are sorted lexicographically by the rules of this new language.
* Derive the order of letters in this language.
*
	Example 1:
	Given the following words in dictionary,
	[
	"wrt",
	"wrf",
	"er",
	"ett",
	"rftt"
	]
	The correct order is: "wertf".
	
	Example 2:
	Given the following words in dictionary,
	[
	"z",
	"x"
	]
	The correct order is: "zx".
	
	Example 3:
	Given the following words in dictionary,
	[
	"z",
	"x",
	"z"
	]
	The order is invalid, so return "".
*
* Note:
* You may assume all letters are in lowercase.
* You may assume that if a is a prefix of b, then a must appear before b in the given dictionary.
* If the order is invalid, return an empty string.
* There may be multiple valid order of letters, return any one of them is fine.
*
* Solution:
* Topological sort with DFS. The tricky part is: how to construct the node-edge relationship?
* For the same index of two strings: if the word1[index] != word2[index],
* that means c1 is at the leading position than c2 in topological order.
* Use this feature to build the edges.\
* 1. Build graph with Vertices and Edges
* 2. DFS, mark visited. When dfs down to an leaf element, it'll be the last element of the final output. (reverse order)
*
* Time Complexity = O(V+E) - Time to build graph and do Topological sort
* Space Complexity = o(V+E) - Map to store Vertices and Edges
* 
*/

public class AlienDictonary {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AlienDictonary obj = new AlienDictonary();
		String[] words1 = { "wrt", "wrf", "er", "ett", "rftt" };
		System.out.println("Order of letters in Alien Language = " + obj.alienOrder(words1)); // Expected Output =
																								// "wertf"

		String[] words2 = { "z", "x" };
		System.out.println("Order of letters in Alien Language = " + obj.alienOrder(words2)); // Expected Output = "zx"

		String[] words3 = { "z", "x", "z" };
		System.out.println("Order of letters in Alien Language = " + obj.alienOrder(words3)); // Expected Output = ""
	}

	public String alienOrder(String[] words) {
		if (words == null || words.length == 0) {
			return "";
		}
		Map<Character, List<Character>> graph = new HashMap<>();
		Map<Character, Integer> visited = new HashMap<>();
		StringBuilder sb = new StringBuilder();
		// Build Graph
		buildGraph(words, graph, visited);
		// Topological sort check on vertices
		for (Character c : graph.keySet()) {
			if (!topologicalSort(c, graph, visited, sb)) {
				return ""; // eg: "z", "a", "z". It has a cycle
			}
		}
		return sb.toString();
	}

	/**
	 *
	 * Build graph with vertices and edges
	 */
	private void buildGraph(String[] words, Map<Character, List<Character>> graph, Map<Character, Integer> visited) {
		// Adding Vertices
		for (String word : words) {
			for (char c : word.toCharArray()) {
				if (!graph.containsKey(c)) {
					graph.put(c, new ArrayList<>());
					visited.put(c, 0);
				}
			}
		}
		// Adding neighbors/edges
		for (int i = 0; i < words.length - 1; i++) {
			int index = 0;
			String word1 = words[i];
			String word2 = words[i + 1];
			while (index < word1.length() && index < word2.length()) {
				char c1 = word1.charAt(index);
				char c2 = word2.charAt(index);
				if (c1 != c2) {
					List<Character> li = graph.get(c1);
					li.add(c2);
					graph.put(c1, li);
				}
				index++;
			}
		}
	}

	/**
	 *
	 * DFS+Backtracking to find if graph has cycle or not. {topological sort- Used
	 * to check if it has a cycle or not}
	 */
	private boolean topologicalSort(Character c, Map<Character, List<Character>> graph, Map<Character, Integer> visited,
			StringBuilder result) {
		if (visited.get(c) == -1) {
			return false;
		}
		if (visited.get(c) == 1) {
			return true;
		}
		visited.put(c, -1);
		List<Character> neighbours = graph.get(c);
		if (neighbours != null && !neighbours.isEmpty()) {
			for (char ch : neighbours) {
				if (!topologicalSort(ch, graph, visited, result)) {
					return false;
				}
			}
		}
		visited.put(c, 1); // Backtrack
		result.insert(0, c); // Append current character to String Builder
		return true;
	}
}