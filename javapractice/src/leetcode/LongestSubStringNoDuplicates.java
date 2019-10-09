package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author u230107
 *
 */
public class LongestSubStringNoDuplicates {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(longestSubStringNoDup("aabbzxcvccabcc"));
	}

	private static int longestSubStringNoDup(String str) {
		Set<Character> set = new HashSet<>();
		int i = 0, j = 0;
		int count = 0;
		int globalCnt = 0;
		while (j < str.length()) {
			char cj = str.charAt(j);
			if (!set.contains(cj)) {
				j++;
				set.add(cj);
				count++;
			} else {
				char ci = str.charAt(i);
				i++;
				set.remove(ci);
				if (globalCnt < count) {
					globalCnt = count;
				}
				count = 0;
			}
		}
		return Math.max(globalCnt,count);
	}

}
