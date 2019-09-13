/**
 * 
 */
package leetcode;

/**
 * @author SivaM
 *Leet Code Ques - 70 {	Climbing Stairs}
 * https://leetcode.com/problems/climbing-stairs/
 *
 *You are climbing a stair case. It takes n steps to reach to the top.
 *Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *Note: Given n will be a positive integer.
Example 1:

Input: 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
Example 2:

Input: 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step
 *
 *
 *Time Complexity = O(N)
 *Space Complexity =o(1)
 */
public class ClimbingStairs {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(climbStairs(2)); // Expected output = 2
		System.out.println(climbStairs(3)); // Expected output = 3
		System.out.println(climbStairs(4)); // Expected output = 5
	}
	
	/* Greedy Algorithm Approach
	   To understand algorithm, refer https://www.youtube.com/watch?v=HzeK7g8cD0Y */
	private static int climbStairs(int n) {
		if(n<=2) {
			return n;
		}
		int first=1,second=2;
		int third=0;
		for(int i=3;i<=n;i++) {
			third = first + second;
			first = second;
			second = third;
		}
		return second;
    }
}
