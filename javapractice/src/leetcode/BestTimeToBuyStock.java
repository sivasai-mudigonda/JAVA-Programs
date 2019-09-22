/**
 * 
 */
package leetcode;

/**
 * @author SivaM
 *
 * LeetCode Ques - 121 {Best Time to Buy and Sell Stock}
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * 
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), 
 * design an algorithm to find the maximum profit.
 * Note that you cannot sell a stock before you buy one.
 * 
	Example 1:
	
	Input: [7,1,5,3,6,4]
	Output: 5
	Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
	             Not 7-1 = 6, as selling price needs to be larger than buying price.
	Example 2:
	
	Input: [7,6,4,3,1]
	Output: 0
	Explanation: In this case, no transaction is done, i.e. max profit = 0.
 *
 * For Solution, refer https://www.youtube.com/watch?v=76-CYD0jn7s
 * Time Complexity is O(n) - Iterate through each stock price in the array
 * Space Complexity =o(1)
 */
public class BestTimeToBuyStock {

	/**
	 * @param args
	 * 
	 *  Max Profit is obtained by buying stock when the price is lowest and
	 *  selling the stock when the price is highest.
	 *  
	 */
	public static void main(String[] args) {
		int[] arr1 = {7,1,5,3,6,4};
		System.out.println(maxProfit(arr1)); // Expected Output= 5
		
		int[] arr2 = {7,6,4,3,1};
		System.out.println(maxProfit(arr2)); // Expected Output= 0
	}
	
	private static int maxProfit(int[] prices) {
		if(prices==null || prices.length==0) {
			return 0;
		}
        int profit=0;
        int minBuyPrice = prices[0]; // Initialize to stock price on day one
        for(int price : prices) {
        	minBuyPrice = Math.min(minBuyPrice, price); // Buy on the day when the stock price is lowest
        	profit = Math.max(profit, price - minBuyPrice); // Sell on the day when the stock price is highest
        }
        return profit;
    }
}
