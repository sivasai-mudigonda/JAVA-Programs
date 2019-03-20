/**
 * 
 */
package javapractice;

/**
 * @author SIVA SAI
 * 
 * Given set A={1,2,3..N}. Find two integers, A and B  (where A<B), from set  
 * such that the value of  is the maximum possible and also less than a given integer, K. 
 * In this case, K represents the bitwise AND operator.
 * 
 * Constraints:
 * k < A.length
 * 
 * Refer https://www.hackerrank.com/challenges/linkedin-practice-bitwise-and/forum
 */
public class BitwiseSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int arrLength=12;
		int k=6;
		bitWiseSum(arrLength,k);
	}
	
	// Time Complexity is O(1)
	private static void bitWiseSum(int arrLength, int k) {
		if(k%2!=0) { // If Odd, return k-1
			System.out.println(k-1);
		} else {
			int res= k | (k-1); // the other number is res
			if(res<=arrLength) {
				System.out.println(k-1);
			} else { //k-1 will be odd hence (k-1)-1= k-2 can be achieved using (k-1-1=k-2)&(k-1)
				System.out.println(k-2);
			}
		}
	}

}
