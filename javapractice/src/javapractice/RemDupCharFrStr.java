package javapractice;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class RemDupCharFrStr {

	public static void main(String[] args) {
		String str = "YELLOWYE";
		System.out.println(str);

		String res = strRemDup(str);
		System.out.println(res);

		res = strRemDupUsingSort(str);
		System.out.println(res);

		res = strRemDupIndexOf(str);
		System.out.println(res);
	}

	// Using SORT
	// Time Complexity: O(n log n)
	private static String strRemDupUsingSort(String str) {
		if (str == null || str.isEmpty()) {
			return null;
		}
		StringBuilder sb = new StringBuilder();
		char[] sortStringArr = str.toCharArray();
		Arrays.sort(sortStringArr);
		sb.append(sortStringArr[0]); // Insert first char
		for (int i = 1; i < sortStringArr.length; i++) {
			if (sortStringArr[i] == sortStringArr[i - 1]) {
				continue;
			} else {
				sb.append(sortStringArr[i]);
			}
		}
		return sb.toString();
	}

	// Use Hashing
	// Time Complexity: O(n)
	private static String strRemDup(String str) {
		if (str == null || str.isEmpty()) {
			return null;
		}
		Set<Character> uniqueSet = new LinkedHashSet<>();
		for (char c : str.toCharArray()) {
			uniqueSet.add(c);
		}
		return uniqueSet.toString();
	}

	// Use Index-Of
	private static String strRemDupIndexOf(String str) {
		if (str == null || str.isEmpty()) {
			return null;
		}
		String result = new String();
		for (int i = 0; i < str.length(); i++) {
			// if character is present in str, it returns
			// the index of character, else it returns -1
			if (result.indexOf(str.charAt(i)) < 0) {
				result += str.charAt(i);
			}
		}
		return result;
	}
}
