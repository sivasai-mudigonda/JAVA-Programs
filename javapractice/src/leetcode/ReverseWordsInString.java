package leetcode;

import java.util.Arrays;

/**
 * @author u230107
 *
 *         LeetCode Ques - 186 {Reverse Words in a String II}
 *         https://leetcode.com/problems/reverse-words-in-a-string-ii/
 *
 *         Given an input string, reverse the string word by word. A word is
 *         defined as a sequence of non-space characters. The input string does
 *         not contain leading or trailing spaces and the words are always
 *         separated by a single space.
 *
 *         For example, Given s = “the sky is blue”, return “blue is sky the”.
 *
 *         Could you do it in-place without allocating extra space?
 *
 *         Time Complexity = O(N) Space Complexity =o(1)
 */
public class ReverseWordsInString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ReverseWordsInString obj = new ReverseWordsInString();
		String str = "the sky is blue";
		char[] chArr = str.toCharArray();
		obj.reverseWords(chArr);
		System.out.println("Reversed String = " + Arrays.toString(chArr)); // Expected Result = [b, l, u, e, , i, s, ,
																			// s, k, y, , t, h, e]
	}

	public void reverseWords(char[] s) {
		if (s == null || s.length == 0) {
			return;
		}
		int i = 0, j = 0;
		while (j < s.length) {
			if (s[j] == ' ') {
				reverseString(s, i, j - 1); // Reverse each word in the sentence
				i = j + 1;
			}
			j++;
		}
		reverseString(s, i, s.length - 1); // Reverse last word in the sentence
		reverseString(s, 0, s.length - 1); // Reverse all words{full sentence} in the string eg: "eht yks" will become
											// "sky the"
	}

	public void reverseString(char[] s, int i, int j) {
		while (i < j) {
			char temp = s[i];
			s[i] = s[j];
			s[j] = temp;
			i++;
			j--;
		}
	}
}
