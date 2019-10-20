/**
 * 
 */
package leetcode;

import java.util.Stack;

/**
 * @author SivaM
 * 
 * LeetCode Ques - 227 {Basic Calculator II}
 * https://leetcode.com/problems/basic-calculator-ii/
 * 
 * Implement a basic calculator to evaluate a simple expression string.
 * The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . 
 * The integer division should truncate toward zero.
 * 
	Example 1:
	Input: "3+2*2"
	Output: 7
	
	Example 2:
	Input: " 3/2 "
	Output: 1
	
	Example 3:
	Input: " 3+5 / 2 "
	Output: 5
 *
 * Note:
 * You may assume that the given expression is always valid.
 * Do not use the eval built-in library function.
 * BODMAS RULE = https://byjus.com/maths/bodmas-rule/
 * 
 * Time Complexity =O(N) - evaluate whole String
 * Space Complexity = O(E)- where e is the elements stored in stack
 *
 */
public class BasicCalculator_2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BasicCalculator_2 obj = new BasicCalculator_2();
		
		String str="3+2*2";
		System.out.println("Computed Result = "+obj.calculate(str)); // Expected Output = 7
		str = " 3/2 ";
		System.out.println("Computed Result = "+obj.calculate(str)); // Expected Output = 1
		str= "3+5 / 2";
		System.out.println("Computed Result = "+obj.calculate(str)); // Expected Output = 5
	}
	
	/**
	 * 
	 * @param s
	 * @return
	 * 
	 * BODMAS RULE:
	 * 
	 * Division and Multiplication has equal weight. They are executed in order of appearance.
	 * Addition and Subtraction has equal weight. They are executed in order of appearance.
	 * Division/Multiplication should happen beforeAddition/Subraction
	 */
	public int calculate(String s) {
        if(s==null || s.isEmpty() ){
        	return -1;
        }
        s= s.trim();
        Stack<Integer> st = new Stack<>();
        int num=0;
        char sign = '+';
        
        for(int i=0;i<s.length();i++) {
        	char ch= s.charAt(i);
        	if(ch ==' ') {
        		continue;
        	}
        	if(Character.isDigit(ch) ){
        		num = num *10 + (ch-'0'); // eg : Ascii 3{23} - Ascii-0{20} =3
        	}
        	if(!Character.isDigit(ch) || i==s.length()-1) {
        		switch(sign) {
        		   case '+':{
        			           st.push(num); // push to stack
        			           break;
        		            }
        		   case '-':{
        			           st.push(-num); // push to stack
        			           break;
        		             }
        		   case '*': {
        			           st.push(st.pop()*num); // Multiply
        			           break;
        		             }
        		   case '/':{
        			           if(num>0) {
        			        	   st.push(st.pop()/num); // Divide
        			           }
        			           break;
        		             }
        		}
        		sign=ch;
     		    num=0;
        	}
        }
        int result=0;
        for(int n : st) { // To do all + and - operations
        	result+=n;
        }
        return result;
    }
}
