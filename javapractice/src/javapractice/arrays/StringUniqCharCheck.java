package javapractice.arrays;

import java.util.Arrays;

public class StringUniqCharCheck {

	public static void main(String[] args) {
		boolean res;
		String str;

		str = "RED";
		res = sortApproach(str);
		System.out.println("Is " + str + " Uniqiue= " + res);

		str = "YELLOW";
		res = sortApproach(str);
		System.out.println("Is " + str + " Uniqiue= " + res);

		str = "BLUE";
		res = extraDSApproach(str);
		System.out.println("Is " + str + " Uniqiue= " + res);

		str = "GREEN";
		res = extraDSApproach(str);
		System.out.println("Is " + str + " Uniqiue= " + res);
	}

	// By Sorting {Time Complexity: O(n log n)}
	private static boolean sortApproach(String str) {
		if (str == null || str.isEmpty()) {
			return false;
		}
		char[] chArr = str.toCharArray();
		Arrays.sort(chArr);
		for (int i = 0; i < chArr.length - 1; i++) {
			if (chArr[i] == chArr[i + 1]) {
				return false;
			}
		}
		return true;
	}

	// By using Extra Data structure Time Complexity: O(n)
	// Assuming string is ASCII{256 char set}
	private static boolean extraDSApproach(String str) {
		if (str == null || str.isEmpty()) {
			return false;
		}
		if (str.length() > 256) {
			return false; // IF >256, then ASCII CHARACTERS are repeating
		}
		Boolean[] boolArr = new Boolean[256];
		Arrays.fill(boolArr, false);

		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			int asciiVal = (int) c;
			if (boolArr[asciiVal] == true) {
				return false;
			}
			boolArr[asciiVal] = true;
			;
		}
		return true;
	}

}
