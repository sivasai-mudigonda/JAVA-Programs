package leetcode;

/**
 * @author u230107
 *
 *         LeetCode Ques - 172 {Factorial Trailing Zeroes}
 *         https://leetcode.com/problems/factorial-trailing-zeroes/
 *
 *         Given an integer n, return the number of trailing zeroes in n!
 *
 *         Example 1: Input: 3 Output: 0 Explanation: 3! = 6, no trailing zero.
 * 
 *         Example 2: Input: 5 Output: 1 Explanation: 5! = 120, one trailing
 *         zero.
 *
 *         Note: Your solution should be in logarithmic time complexity.
 *
 *         For Solution, refer
 *         https://medium.com/@monisha.mary.mathew/factorial-trailing-zeroes-3232a5a8989e
 *         And
 *         https://medium.com/@SawyerMerchant_46940/factorial-trailing-zeros-2e9e3730aec3
 *
 *         Time Complexity = O(NLogN) where N is the time unit for computing
 *         n/5's. 
 *         Space Complexity =o(NLogN) with recursive programming for call
 *         stacks and O(1) for dynamic programming.
 */
public class FactorialTrailingZeros {

    /**
     * @param args
     */
    public static void main(String[] args) {
	FactorialTrailingZeros obj = new FactorialTrailingZeros();
	int n = 3;
	System.out.println("Number of Trailing Zero's in " + n + "! is " + +obj.trailingZeroes_DP(n)); // Expected Output =
												    // 0
	n = 5;
	System.out.println("Number of Trailing Zero's in " + n + "! is " + +obj.trailingZeroes_DP(n)); // Expected Output =
												    // 1
	n = 50;
	System.out.println("Number of Trailing Zero's in " + n + "! is " + +obj.trailingZeroes(n)); // Expected Output =
    }

    /**
     *
     * @param n
     * @return
     *
     *         (n<5) -> There are no trailing zero's until 5! n/5 Explanation: In
     *         order to get zero at the end, a number must be multiplied by 10.
     *         Therefore we check what are the factors that can give 10. Factors of
     *         10 are 5 and 2. If we select 2, then there are more 2's than we need. 
     *         So, we will choose 5.
     *
     */
    public int trailingZeroes_DP(int n) {
        int result=0;
        while(n!=0){
            result+=+n/5;
            n=n/5;
        }
        return result;
    }
    
    /*
     * Recursive approach
     */
    public int trailingZeroes(int n) {
	if (n == 0) {
	    return 0;

	}
	return (n < 5) ? 0 : n / 5 + trailingZeroes(n / 5);
    }
}