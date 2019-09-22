/**
 * 
 */
package leetcode;

/**
 * @author SivaM
 *
 * LeetCode Ques - 122 {Best Time to Buy and Sell Stock II}
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 * 
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. 
 * You may complete as many transactions as you like 
 * (i.e., buy one and sell one share of the stock multiple times).
 * Note: You may not engage in multiple transactions at the same time 
 * (i.e., you must sell the stock before you buy again).
 * 
	Example 1:
	
	Input: [7,1,5,3,6,4]
	Output: 7
	Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
	             Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
	Example 2:
	
	Input: [1,2,3,4,5]
	Output: 4
	Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
	             Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
	             engaging multiple transactions at the same time. You must sell before buying again.
	Example 3:
	
	Input: [7,6,4,3,1]
	Output: 0
	Explanation: In this case, no transaction is done, i.e. max profit = 0.
 * 
 *  For Solution, Refer https://www.youtube.com/watch?v=vxIMqdR8flY&list=PLV8H0QrJHjOmhbwotwt3Sy8qlfzqGhVW-&t=0s&index=42
 * 
 *  Time Complexity = O(N) - Iterate through each stock price in the array
 *  Space Complexity =o(1)
 */
public class BestTimeToBuy_Sell_Stock_2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums1 = {7,1,5,3,6,4};
		System.out.println(maxProfit(nums1)); // Expected Output = 7
		int[] nums2 = {1,2,3,4,5};
		System.out.println(maxProfit(nums2)); // Expected Output = 4
		int nums3[] = {7,6,4,3,1};
		System.out.println(maxProfit(nums3)); // Expected Output = 0
	}
	
	/**
	 * 
	 * @param prices
	 * @return
	 * 
	 *  As we can complete as many transactions as we like multiple times, Below is the way Max Profit is calculated.
	 *  If the current day stock price is greater than previous day stock price, We will get profit.
	 *  Adding all of them will give max profit.
	 */
	private static int maxProfit(int[] prices) {
        if(prices==null || prices.length==0) {
        	return 0;
        }
        int maxProfit=0;
        for(int price=1;price<prices.length;price++) {
        	if(prices[price] > prices[price-1] ){
        		maxProfit+= prices[price]-prices[price-1];
        	}
        }
        return maxProfit;
    }
}
