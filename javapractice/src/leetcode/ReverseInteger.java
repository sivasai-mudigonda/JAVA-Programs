/**
 * 
 */
package leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * @author SivaM
 * Reverse Integer- Leet Code-7Q
 * https://leetcode.com/problems/reverse-integer/
 * 
 * Given a 32-bit signed integer, reverse digits of an integer.
 * 
 * 
Example 1:

Input: 123
Output: 321
Example 2:

Input: -123
Output: -321
Example 3:

Input: 120
Output: 21
Note:
Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 * 
 * Solution:
 * Refer https://github.com/Blankj/awesome-java-leetcode/blob/master/src/com/blankj/easy/_007/Solution.java
 *
 */
public class ReverseInteger {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	private static int reverseInteger(int x){
		long num = (int) x;
		boolean isNeg=false;
		if(num<0) {
			isNeg = true;
			num = -1 * num;
		}
		
		long result =0;
		while(num !=0 ){
			result = result * 10 + num % 10;
			num =  num/10;
		}
		
		if(isNeg) {
			result = -1 * result;
		}
		if(result > Integer.MAX_VALUE || result < Integer.MIN_VALUE){
			return 0;
		}
		return (int)result;
	}
	
	@Test
	public void test(){
		//System.out.println(reverseInteger(123));
		assertEquals(325, reverseInteger(123));
	}
}
