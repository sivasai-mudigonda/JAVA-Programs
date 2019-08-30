package arrays;

public class CStyleReverseString {

	public static void main(String[] args) {
		String str = "SIVA";
		System.out.println(str);
		str = revCStyleStr(str);
		System.out.println(str);
	}

	private static String revCStyleStr(String str) {
		if (str == null || str.isEmpty()) {
			return null;
		}
		char[] revCStyleStr = new char[str.length() + 1];
		// revCStyleStr[0]='\0'; // Insert null char in beginning.
		for (int i = str.length() - 1, j = 0; j < i; i--, j++) {
			revCStyleStr[i + 1] = str.charAt(j);
			revCStyleStr[j + 1] = str.charAt(i);
		}
		return new String(revCStyleStr); // AVIS
	}

}
