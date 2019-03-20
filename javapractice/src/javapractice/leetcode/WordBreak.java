/**
 * 
 */
package leetcode;

/**
 * @author SIVA SAI
 *
 */
import java.util.HashSet;
import java.util.Set;

/**
 * Given a string s and a dictionary of words dict, determine if s can be
 * segmented into a space-separated sequence of one or more dictionary words.
 * 
 * For example, given s = "leetcode", dict = ["leet", "code"].
 * 
 * Return true because "leetcode" can be segmented as "leet code".
 *
 *
 * Refer "https://www.techiedelight.com/word-break-problem-using-trie/"
 * 
 * 
 * Time Complexity= O(N) //It is because we break when node is null. Space
 * Complexity = O(N+Sum of Word Length)
 *
 *
 * Hint: Use Trie Data Structure
 */

public class WordBreak {
	public static void main(String[] str) {
		Set<String> dictonary = new HashSet<>();
		dictonary.add("this");
		dictonary.add("th");
		dictonary.add("is");
		dictonary.add("famous");
		dictonary.add("word");
		dictonary.add("break");
		dictonary.add("b");
		dictonary.add("r");
		dictonary.add("e");
		dictonary.add("a");
		dictonary.add("k");
		dictonary.add("br");
		dictonary.add("bre");
		dictonary.add("brea");
		dictonary.add("ak");
		dictonary.add("prob");
		dictonary.add("lem");
		boolean result = wordBreak("wordbreakproblem", dictonary);
		System.out.println("Result = " + result);

		result = wordBreak("leetcode", dictonary);
		System.out.println("Result = " + result);
	}

	private static boolean wordBreak(String s, Set<String> dict) {
		TrieNode head = new TrieNode();
		dict.forEach(str -> {
			insertToTrie(str, head);
		});

		if (wordBreakUtil(head, s)) {
			return true;
		} else {
			return false;
		}
	}

	private static boolean wordBreakUtil(TrieNode head, String str) {
		if (str == null || str.length() < 1 || head == null) {
			return false;
		}
		boolean[] good = new boolean[str.length() + 1];
		good[0] = true; // base condition
		for (int i = 0; i < str.length(); i++) {
			if (good[i]) {
				TrieNode node = head;
				for (int j = i; j < str.length(); j++) {
					if (node == null) {
						break;
					}
					node = node.next[str.charAt(j) - 'a'];
					if (node != null && node.isLeaf) { // If it is leaf node, Mark it as true.
						good[j + 1] = true;
					}
				}
			}
		}
		return good[str.length()];
	}

	private static void insertToTrie(String str, TrieNode head) {
		TrieNode node = head;
		for (int i = 0; i < str.length(); i++) {
			if (node.next[str.charAt(i) - 'a'] == null) {
				node.next[str.charAt(i) - 'a'] = new TrieNode(); // If node does not have character, add it to the node.
			}
			node = node.next[str.charAt(i) - 'a']; // Move node to next
		}
		node.isLeaf = true; // Mark the last character as leaf.
	}

	private static class TrieNode {
		int CHAR_SIZE = 26; // All small letters
		boolean isLeaf; // True if it is a leaf node.
		TrieNode[] next;

		TrieNode() {
			isLeaf = false;
			next = new TrieNode[CHAR_SIZE];
		}
	}
}
