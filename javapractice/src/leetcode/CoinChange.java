package leetcode;

import java.util.Arrays;

/**
 * 
 * @author SivaM
 *
 * LeetCode Ques - 322 {Coin Change} -Medium
 * https://leetcode.com/problems/coin-change/
 * 
 * You are given coins of different denominations and a total amount of money amount. 
 * Write a function to compute the fewest number of coins that you need to make up that amount. 
 * If that amount of money cannot be made up by any combination of the coins, return -1.
 * 
	Example 1:
	Input: coins = [1, 2, 5], amount = 11
	Output: 3 
	Explanation: 11 = 5 + 5 + 1
	
	Example 2:
	Input: coins = [2], amount = 3
	Output: -1
 * 
 * Note:
 * You may assume that you have an infinite number of each kind of coin.
 * 
 * Solution:
 * We may think if we take the largest coin every time, 
 * we may need fewest coins, but actually it is not, 
 * because there is possibility that the coins can’t form the amount. 
 * We need to use dynamic programming here, 
 * we generate an array{dp} with the length of the amount we need. 
 * Search through all coin value to see if we have reached at any amount before,
 * so we can add{+1} just another coin to get current amount.
 * The number in the array means the minimum amount of coins needed to reach current amount. 
 * So we can just return the last element in the array.
 * 
 * The concept of this problem is like Knapsack problem which can be solved by using dynamic programming approach.
 * dp[i] = min(dp[i-coin] + 1), for all coin in coins
 * 
 * Time Complexity = O(M*N) where M denotes to amount and n denotes to counts of coins.
 * Space Complexity = o(M) where m denotes space required to store dp[amount]
 * 
 */
public class CoinChange {
	
		public static void main(String args[]) {
			CoinChange obj = new CoinChange();
			
			int coins1[] = {1,2,5};
			int amount = 11;
			System.out.println("fewest number of coins required make up amount = " +obj.coinChange(coins1, amount)); // Expected Output = 11
			
			int coins2[] = {2};
			amount = 3;
			System.out.println("fewest number of coins required make up amount = " +obj.coinChange(coins2, amount)); // Expected Output = -1
		}
	
	/** 
	 * 
	 * @param coins
	 * @param amount
	 * @return
	 * 
	 * Dynamic Programming{Solve sub-problem}+KnapSack Approach
	 * 
	 */
	 public int coinChange(int[] coins, int amount) {
		 if(coins==null || coins.length==0 || amount==0) {
			 return 0;
		 }
		 int[] dp = new int[amount+1];
		 Arrays.fill(dp, amount+1);
		 dp[0] =0;
		 for(int coin : coins) {
			 for(int i= coin; i<=amount;i++) {
				 dp[i] = Math.min(dp[i], dp[i-coin]+1);
			 }
		 }
		 if(dp[amount]>amount) {
			 return -1;
		 }
	     return dp[amount];   
	 }
}