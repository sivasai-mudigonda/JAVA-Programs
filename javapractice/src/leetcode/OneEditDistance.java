package leetcode;

/**
 * @author u230107
 *
 *         LeetCode Ques - 161 {One Edit Distance}
 *         https://leetcode.com/problems/one-edit-distance/
 *
 *         Given two strings S and T, determine if they are both one edit
 *         distance apart.
 *
 *         Example 1: Input: s = "aDb", t = "adb" Output: true Example 2: Input:
 *         s = "ab", t = "ab" Output: false Explanation: s=t ,so they aren't one
 *         edit distance apart Example 3: Input: s = "1203", t = "1213" Output:
 *         true Explanation: We can replace '0' with '1' to get t.
 *
 *         Solution: Let the input strings be s1 and s2 and lengths of input
 *         strings be m and n respectively. 
 *         1) If difference between m an n is
 *         more than 1, return false. 
 *         2) Initialize count of edits as 0. 
 *         3) Start traversing both strings from first character. 
 *         a) If current characters don't match, then 
	 *         (i) Increment count of edits 
	 *         (ii) If count becomes more than 1, return false 
	 *         (iii) If length of one string
	 *         is more, then only possible edit is to remove a character. Therefore,
	 *         move ahead in larger string. 
	 *         (iv) If length is same, then only
	 *         possible edit is to change a character. Therefore, move ahead in both
	 *         strings.
 *         b) Else, move ahead in both strings.
 *
 *         Time Complexity =O(N) 
 *         Space Complexity = o(1)
 */
public class OneEditDistance {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		OneEditDistance obj = new OneEditDistance();
		String s = "aDb", t = "adb";
		System.out.println("Is one edit distance = " + obj.isOneEditDistance(s, t)); // Expected Output = true

		s = "ab";
		t = "ab";
		System.out.println("Is one edit distance = " + obj.isOneEditDistance(s, t)); // Expected Output = false

		s = "1203";
		t = "1213";
		System.out.println("Is one edit distance = " + obj.isOneEditDistance(s, t)); // Expected Output = true
	}

	/**
	 *
	 * @param s
	 * @param t
	 * @return
	 *
	 * Returns true if edit distance between s1 and s2 is one, else false
	 */
	public boolean isOneEditDistance(String s, String t) {
		if (s == null || t == null) {
			return false;
		}
		int sLength = s.length();
		int tLength = t.length();
		// If difference between lengths is more than 1, then strings can't be at one distance
		if (Math.abs(sLength - tLength) > 1) {
			return false;
		}

		int i = 0;
		int j = 0;
		int count = 0;

		while (i < sLength && j < tLength) {
			if (s.charAt(i) == t.charAt(j)) {
				// If characters are same, increment both
				i++;
				j++;
			} else {
				count++; // Increment count of edits{Either add, subtract or replace}
				if (count > 1) {
					return false;
				}
				// If length of one string is more, then only possible edit is to remove a character
				if (sLength > tLength) {
					i++;
				} else if (sLength < tLength) {
					j++;
				} else {
					i++;
					j++;
				}
			}
		}
		// If last character is extra in any string
		if (i < sLength || j < tLength) {
			count++;
		}
		return count == 1;
	}
}