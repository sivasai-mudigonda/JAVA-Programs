/**
 * 
 */
package leetcode;

/**
 * @author SivaM
 * 
 * LeetCode Ques - 190 {Reverse Bits}
 * https://leetcode.com/problems/reverse-bits/
 * 
 * Reverse bits of a given 32 bits unsigned integer.
 * 
    Example 1:
    
    Input: 00000010100101000001111010011100
    Output: 00111001011110000010100101000000
    Explanation: The input binary string 00000010100101000001111010011100 represents the unsigned integer 43261596, 
    so return 964176192 which its binary representation is 00111001011110000010100101000000.
    
    Example 2:
    Input: 11111111111111111111111111111101
    Output: 10111111111111111111111111111111
    Explanation: The input binary string 11111111111111111111111111111101 represents the unsigned integer 4294967293, 
    so return 3221225471 which its binary representation is 10101111110010110010011101101001.
 *
 * Note
 * Note that in some languages such as Java, there is no unsigned integer type. 
 * In this case, both input and output will be given as signed integer type and should not affect your implementation, 
 * as the internal binary representation of the integer is the same whether it is signed or unsigned.
 * In Java, the compiler represents the signed integers using 2's complement notation. 
 * Therefore, in Example 2 above the input represents the signed integer -3 and the output represents the signed integer -1073741825.
 * 
 * Follow up:
 * If this function is called many times, how would you optimize it?
 * 
 * For solution, refer
 * https://medium.com/@monisha.mary.mathew/reverse-bits-b936bee153a0
 * 
 * Time Complexity = O(32){Constant Time = O(1)}
 * Space Complexity = o(1)
 */
public class ReverseBits {

    /**
     * @param args
     */
    public static void main(String[] args) {
	ReverseBits obj = new ReverseBits();
	
	int n = 0B00000010100101000001111010011100; // b or B represents Binary number
	System.out.println("Original Number = " +Integer.toBinaryString(n));
	int reverse = obj.reverseBits(n);
	System.out.println("Reverse  Number = " +Integer.toBinaryString(reverse));
	// Expected Output = 00111001011110000010100101000000
	
	n = 0b11111111111111111111111111111101;
	System.out.println("Original Number = " +Integer.toBinaryString(n));
	reverse = obj.reverseBits(n);
	System.out.println("Reverse  Number = " +Integer.toBinaryString(reverse));
	// Expected Output = 10111111111111111111111111111111
    }
    
    /**
     * 
     * @param n {Binary Number is the input}
     * @return reverse {Reverse of a binary Number is the output}
     * 
     * eg: 
     *     Input: n = 1010, decimal value = 10
     *     while{
     *     rightMostBit = 0 {Extract rightmost bit from n}
     *     n = 0101 {Right Shift}
     *     reverse = 0000 {Left Shift}
     *     reverse = 0000 {Insert rightMostBit}
     *     **********************
     *     rightMostBit = 1 {Extract rightmost bit from n}
     *     n= 0010 {Right Shift}
     *     reverse=0000 {Left Shift}
     *     reverse= 0001 {Insert rightMostBit}
     *     ***********************
     *      rightMostBit = 0 {Extract rightmost bit from n}
     *      n=0001 {Right Shift}
     *      reverse=0010 {Left Shift}
     *      reverse = 0000 {Insert rightMostBit}
     *      **********************
     *      reightMostBit=1 {Extract rightmost bit from n}
     *      n=0000{Right Shift}
     *      reverse=0100 {Left Shift}
     *      reverse = 0101 {Insert rightMostBit}
     *      }
     *      output = 0101, decimal value = 5
     *     
     */
    public int reverseBits(int n) {
	int reverse=0;
        int bitcount=0;
        int rightMostBit=0;
        while(bitcount<32){
            rightMostBit = n & 1; // Extract Right most bit in original number
            n = n >> 1; // Right shift original number by one for next iteration
            reverse = reverse << 1; // Left shift reverse number one to insert bit.
            reverse = reverse | rightMostBit; // insert rightMostBit in reverse number
            bitcount++;
        }
	return reverse;
    }
}
