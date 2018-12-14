package javapractice.arrays;

public class ReplaceString {

	public static void main(String[] args) {
		String s = "Hello WOR LD WELCOME ON E";
		String str = replaceString(s);
		System.out.println(str);

		str = replaceStringStringBuilder(s);
		System.out.println(str);
	}

	// Using replaceAll()
	private static String replaceString(String str) {
		if (str == null || str.isEmpty()) {
			return "";
		}
		String output = new String();
		output = str.replaceAll("\\s", "%20");
		return output;
	}

	// Using String Builder
	private static String replaceStringStringBuilder(String str) {
		if (str == null || str.isEmpty()) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		char[] charArr = str.toCharArray();
		for (char c : charArr) {
			if (c == ' ') {
				sb.append("%20");
			} else {
				sb.append(c);
			}
		}

		return sb.toString();
	}

}
