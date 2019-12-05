package leetcode;

/**
* @author u230107
*
* Leet-code Ques - 371 {Sum of Two Integers} {Easy}
* https://leetcode.com/problems/sum-of-two-integers/
*
* The sum of the two integers a and b is calculated without using the operators + and - .
*
	Example 1:
	Enter: a = 1, b = 2
	output: 3
	
	Example 2:
	Enter: a = -2, b = 3
	output: 1
*
* Solution:
* For Video explanation, refer youtube.com/watch?v=qq64FrA2UXQ
* For detail programmatic explanation, refer
* https://github.com/bephrem1/backtobackswe/blob/master/Arrays,%20Primitives,%20Strings/AdditionWithOnlyBitshifting/AdditionWithOnlyBitshifting.java
*
* Time Complexity = O(N) - Loop through until b becomes zero
* Space Complexity = o(1) - Constant space
*
*/
public class Sum_Of_Two_Integers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Sum_Of_Two_Integers obj = new Sum_Of_Two_Integers();

		int a = 1;
		int b = 2;
		System.out.println("sum of " + a + " and " + b + " = " + obj.getSum(a, b)); // Expected Output = 3
		System.out.println("sum of " + a + " and " + b + " = " + obj.getSum_Recursive(a, b)); // Expected Output = 3

		System.out.println("************************");

		a = -2;
		b = 3;
		System.out.println("sum of " + a + " and " + b + " = " + obj.getSum(a, b)); // Expected Output = 1
		System.out.println("sum of " + a + " and " + b + " = " + obj.getSum_Recursive(a, b)); // Expected Output = 1
	}

	/**
	 *
	 * @param a
	 * @param b
	 * @return
	 *
	 * Iterative approach
	 * 
	 * a holds sum b holds carry
	 * 
	 * We used three operators.{Bitwise And, Left Shift and XOR} Below is
	 * the purpose of each operator.
	 * 
	 * & - To take note of what positions will need a carry.
	 * 
	 * << - Carry is not applied where it is discovered. It is applied 1
	 * position to the left of where it was born.{Basic Mathematics} Carry
	 * gets added to Sum in the subsequent next iteration.
	 * 
	 * ^ - This operation does addition. {bit addition}
	 * 
	 */
	public int getSum(int a, int b) {
		// Keep adding until we have no carry left
		while (b != 0) {
			// System.out.println(Integer.toBinaryString(a));
			// System.out.println(Integer.toBinaryString(b));
			int sum = a ^ b;
			int carry = (a & b) << 1;
			// System.out.println("Sum = "+Integer.toBinaryString(sum));
			// System.out.println("Carry = "+Integer.toBinaryString(carry));
			a = sum;
			b = carry;
		}
		return a;
	}

	/**
	 *
	 * @param a
	 * @param b
	 * @return
	 *
	 *  Using Recursion approach
	 *
	 */
	public int getSum_Recursive(int a, int b) {
		if (b == 0) {
			return a;
		}
		int sum = a ^ b;
		int carry = (a & b) << 1;
		return getSum_Recursive(sum, carry);
	}
}
