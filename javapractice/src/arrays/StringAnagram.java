package arrays;

import java.util.Arrays;

public class StringAnagram {

	public static void main(String[] args) {
		String str1 = "CINEMA";
		String str2 = "ICEMAN";
		boolean isAnagram = isAnagram(str1, str2);
		System.out.println(str1 + "\t" + str2 + " are Anagrams? " + isAnagram);

		isAnagram = isAnagramCntApproach(str1, str2);
		System.out.println(str1 + "\t" + str2 + " are Anagrams? " + isAnagram);

		str1 = "HELLO";
		str2 = "WORLD";
		isAnagram = isAnagram(str1, str2);
		System.out.println(str1 + "\t" + str2 + " are Anagrams? " + isAnagram);

		isAnagram = isAnagramCntApproach(str1, str2);
		System.out.println(str1 + "\t" + str2 + " are Anagrams? " + isAnagram);
	}

	// SORT Approach
	private static boolean isAnagram(String str1, String str2) {
		if (str1 == null || str1.isEmpty() || str2 == null || str2.isEmpty() || str1.length() != str2.length()) {
			return false;
		}
		char[] chArr1 = str1.toCharArray();
		char[] chArr2 = str2.toCharArray();
		Arrays.sort(chArr1);
		Arrays.sort(chArr2);

		for (int i = 0; i < chArr1.length; i++) {
			if (chArr1[i] == chArr2[i]) {
				continue;
			} else {
				return false;
			}
		}
		return true;
	}

	// COUNT Approach
	private static boolean isAnagramCntApproach(String str1, String str2) {
		if (str1 == null || str1.isEmpty() || str2 == null || str2.isEmpty() || str1.length() != str2.length()) {
			return false;
		}
		char[] chArr1 = str1.toCharArray();
		char[] chArr2 = str2.toCharArray();
		int cnt1[] = new int[256];
		int cnt2[] = new int[256];

		for (int i = 0; i < str1.length(); i++) {
			cnt1[chArr1[i]]++;
			cnt2[chArr2[i]]++;
		}

		for (int i = 0; i < 256; i++) {
			if (cnt1[i] != cnt2[i]) {
				return false;
			}
		}
		return true;
	}
}
