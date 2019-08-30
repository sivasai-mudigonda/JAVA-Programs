/**
 * 
 */
package leetcode;

import java.util.Stack;

/**
 * @author SIVA SAI
 *
 * This function determines if the braces ('(' and ')') in a string are properly matched.
 * it ignores non-brace characters.
 * Some examples:
 * "()()()()"   -> true
 * "((45+)*a3)" -> true
 * "(((())())"  -> false
 */
public class BalancedParenthesesCheck {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		char exp[] = {'{','(',')','}','[',']'};
		boolean res=isBalParentheses(exp);
		System.out.println("res = "+res);
		
		char exp2[] = {'{','(','}','[',']'};
		res=isBalParentheses(exp2);
		System.out.println("res = "+res);
	}
	
	private static boolean isBalParentheses(char[] arr) {
		if(arr==null ) {
			return false;
		} else {
			if(!(arr[0]=='{') ){
				return false;
			}
		}
		
		Stack<Character> st= new Stack<Character>();
		for(int i=0;i<arr.length;i++) {
			if( arr[i]=='{' || arr[i]=='(' || arr[i]=='[' ) {
				st.push(arr[i]);
			}
			
			if(arr[i]=='}' || arr[i]==')' || arr[i]==']' ){
				if(st.isEmpty() ){
					return false;
				} else {
					char popEle=st.pop();
					if( !( (popEle=='{' && arr[i]=='}') 
							|| (popEle=='(' && arr[i]==')')
							|| (popEle=='[' && arr[i]==']') )){
						return false;
					}
				}
			}
		}
		return st.isEmpty()?true:false;
	}
}
