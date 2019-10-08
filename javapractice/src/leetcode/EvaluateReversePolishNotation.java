/**
 * 
 */
package leetcode;

import java.util.Stack;

/**
 * @author SivaM
 * 
 * LeetCode Ques - 150 {Evaluate Reverse Polish Notation}
 * https://leetcode.com/problems/evaluate-reverse-polish-notation/
 * 
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
 * Note:
 * Division between two integers should truncate toward zero.
 * The given RPN expression is always valid. 
 * That means the expression would always evaluate to a result and there won't be any divide by zero operation.
 * 
	Example 1:
	Input: ["2", "1", "+", "3", "*"]
	Output: 9
	Explanation: ((2 + 1) * 3) = 9
	
	Example 2:
	Input: ["4", "13", "5", "/", "+"]
	Output: 6
	Explanation: (4 + (13 / 5)) = 6
	
	Example 3:
	Input: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
	Output: 22
	Explanation: 
	  ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
	= ((10 * (6 / (12 * -11))) + 17) + 5
	= ((10 * (6 / -132)) + 17) + 5
	= ((10 * 0) + 17) + 5
	= (0 + 17) + 5
	= 17 + 5
	= 22
 * 
 * 
 * Solution:
 * This problem is a classic stack problem that is expressed in data structure textbook. 
 * We should push any operand into stack and pop two of them out once encountering an operator. 
 * And push back the calculated result.
 * 
 * Time Complexity : O(N) - N denotes length of token
 * Space Complexity : o(M) -  For space complexity, stack should have ability to save all operands in tokens list. 
 * 							  Therefore, it uses O(m) extra space if m denotes to counts of operands in tokens list.
 */
public class EvaluateReversePolishNotation {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EvaluateReversePolishNotation obj = new EvaluateReversePolishNotation();
		String[] strings1 = {"2", "1", "+", "3", "*"};
		System.out.println("Reverse Polish Evaluation : "+obj.evalRPN(strings1)); // Expected Output = 9
		
		String[] strings2 = {"4", "13", "5", "/", "+"};
		System.out.println("Reverse Polish Evaluation : "+obj.evalRPN(strings2)); // Expected Output = 6
		
		String[] strings3 = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
		System.out.println("Reverse Polish Evaluation : "+obj.evalRPN(strings3)); // Expected Output = 22
	}
	
	/**
	 * 
	 * @param tokens
	 * @return
	 * 
	 * Reverse Polish Notation :
	 * Refer, https://en.wikipedia.org/wiki/Reverse_Polish_notation
	 */
	public int evalRPN(String[] tokens) {
		if(tokens==null || tokens.length==0) {
			return 0;
		}
		int i=0;
		Stack<Integer> st = new Stack<>();
		while(i<tokens.length) {
			if(!tokens[i].equals("+")  
					&& !tokens[i].equals("-") 
					&& !tokens[i].equals("*")
					&& !tokens[i].equals("/") ){
				st.push(Integer.parseInt(tokens[i]));
			} else {
				int a = st.pop();
				int b = st.pop();
				int c = 0;
				switch(tokens[i]) {
				case "+":
					     c=b+a;
						 break;
				case "-":
					     c=b-a;
					     break;
				case "*":
					     c=b*a;
					     break;
				case "/":
					     c=b/a;
					     break;
				}
				st.push(new Integer(c));
			}
			i++;
		}
        return st.peek();
    }
}
