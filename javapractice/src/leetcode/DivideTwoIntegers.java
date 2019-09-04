/**
 * 
 */
package leetcode;

/**
 * @author SivaM
 *
 *Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.
 *Return the quotient after dividing dividend by divisor.
 *The integer division should truncate toward zero.

Example 1:

Input: dividend = 10, divisor = 3
Output: 3

Example 2:

Input: dividend = 7, divisor = -3
Output: -2

*
*Note:
*Both dividend and divisor will be 32-bit signed integers.
*The divisor will never be 0.
*Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 231 − 1 when the division result overflows.
*
*
*For solution, Refer https://www.youtube.com/watch?v=htX69j1jf5U
*/
public class DivideTwoIntegers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(divide(10,3)); // Expected Output = 3
		System.out.println(divide(7,-3)); // Expected Output = -2
		System.out.println(divide(-2147483648, -1)); // Expected Output = -1
		System.out.println(divide(2147483647,2));
	}
	
	private static int divide(int dividend, int divisor) {
		if((dividend==-Integer.MIN_VALUE && divisor ==-1) ){
			return Integer.MAX_VALUE;
		}
		int sign = 1;
		if( (dividend< 0 && divisor > 0) || (dividend >0 && divisor <0) ) {
			sign = -1;
		}
		int a,b;
		a = Math.abs( dividend);
        b = Math.abs( divisor);
        
		int result=0;
		while(a-b >= 0){ // Can we take divisor, from what is left of dividend at least once.
			int x=0; // 2^0=1, It means we can take away at least once.
			while(a - (b<<1<<x) >=0) { // checking for the largest one which we can take away from dividend
				x++; // Increment x, as we can take it away.
			}
			result= (result)+(1<<x); // How many times we can double divisor and it will be still be less than what is left of the dividend.
			a = a - (b << x); // Take away dividend, from how many times we have double the divisor 
		}
		return sign * result;
	}
}
