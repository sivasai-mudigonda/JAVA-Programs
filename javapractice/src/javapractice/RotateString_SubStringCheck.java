package javapractice;

public class RotateString_SubStringCheck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean res;
		res = isSubString("apple", "leapp");
		System.out.println(res);
		res = isSubString("apple", "ppela");
		System.out.println(res);
	}

	private static boolean isSubString(String str, String rotatedStr) {
		if (str == null || str.isEmpty()) {
			return false;
		}
		String strstr = str + str; // rotated string should be subset of self concatenated string.
		return strstr.contains(rotatedStr);
	}
}
