package leetcode;

import java.util.*;

public class ValidateParenthesis {

	public static void main(String[] args) {
		String str = "<a><b></b></a>";
		String str1 = "></a></b><";
		boolean output = isValid(str);
		boolean output2 = isValid(str1);
		System.out.println(output);
		System.out.println(output2);
	}

	static boolean isValid(String code) {
		if (!code.startsWith("<"))
			return false;
		if (code.length() < 2)
			return false;

		Stack<String> stack = new Stack<>();
		String cur = "";
		for (int i = 0; i < code.length(); i++) {
			cur += code.charAt(i);
			if (cur.startsWith("</")) {
				if (cur.endsWith(">")) {
					String tag = cur.substring(2, cur.length() - 1);
					if (stack.isEmpty() || !stack.peek().equals("<" + tag + ">"))
						return false;
					stack.pop();
					cur = "";
				}
			} else if (cur.startsWith("<")) {
				if (cur.endsWith(">")) {
					stack.push(cur);
					cur = "";
				}
			}
		}
		return stack.isEmpty() && cur.length() == 0;
	}
}
