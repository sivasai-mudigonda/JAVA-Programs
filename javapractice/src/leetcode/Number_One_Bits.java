/**
 * 
 */
package leetcode;

/**
 * @author SivaM
 * 
 * LeetCode Ques - 191 {Number of 1 Bits}
 * https://leetcode.com/problems/number-of-1-bits/
 * 
 * Write a function that takes an unsigned integer and return the number of '1' bits it has (also known as the Hamming weight).
 * 
    Example 1:
    Input: 00000000000000000000000000001011
    Output: 3
    Explanation: The input binary string 00000000000000000000000000001011 has a total of three '1' bits.
    
    Example 2:
    Input: 00000000000000000000000010000000
    Output: 1
    Explanation: The input binary string 00000000000000000000000010000000 has a total of one '1' bit.
    
    Example 3:
    Input: 11111111111111111111111111111101
    Output: 31
    Explanation: The input binary string 11111111111111111111111111111101 has a total of thirty one '1' bits.
 *
 * Note:
 * Note that in some languages such as Java, there is no unsigned integer type.
 * In this case, the input will be given as signed integer type and should not affect your implementation,
 * as the internal binary representation of the integer is the same whether it is signed or unsigned.
 * In Java, the compiler represents the signed integers using 2's complement notation.
 * Therefore, in Example 3 above the input represents the signed integer -3.
 * 
 * Follow up:
 * If this function is called many times, how would you optimize it?
 */
public class Number_One_Bits {

    /**
     * @param args
     */
    public static void main(String[] args) {
	Number_One_Bits obj = new Number_One_Bits();
	
	int n = 0b00000000000000000000000000001011;
	int result = obj.hammingWeight(n);
	System.out.println("Number Of One's = "+result); // Expected Output =3
	
	n = 0b00000000000000000000000010000000;
	result = obj.hammingWeight(n);
	System.out.println("Number Of One's = "+result); // Expected Output =1
	
	n = 0b11111111111111111111111111111101;
	result = obj.hammingWeight(n);
	System.out.println("Number Of One's = "+result); // Expected Output =31
    }
    
    /**
     * 
     * @param n
     * @return
     * 
     * >>> ==> For -ve numbers it calculates two's compliment of a number, 
     * 	       because of it, value will not overflow
     * 
     * For better understanding, refer
     * https://stackoverflow.com/questions/19058859/what-does-mean-in-java
     */
    public int hammingWeight(int n) {
	int rightMostBit=0;
	int count=0;
	while(n!=0) {
	    rightMostBit = n&1; // To get right most bit
	    if(rightMostBit==1) {
		count++;
	    }
	    n = n>>>1; // Unsigned Right Shift Operator
	}
	return count;
    }
}
