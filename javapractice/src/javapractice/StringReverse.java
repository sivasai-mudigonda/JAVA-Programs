package javapractice;

import java.util.Scanner;

public class StringReverse {

	@SuppressWarnings("null")
	public static void main(String[] args) {
		String str="";
		try(Scanner sc= new Scanner(System.in)){
			str = sc.nextLine();
		}
		if (str == null && str.isEmpty()) {
			System.out.println("String is empty");
		}
		char[] revStr = new char[str.length()];
		for (int i = str.length() - 1, j = 0; j < i; i--, j++) {
			revStr[j] = str.charAt(i);
			revStr[i] = str.charAt(j);
		}
		System.out.println("Rev Str=" + new String(revStr));
	}

}
