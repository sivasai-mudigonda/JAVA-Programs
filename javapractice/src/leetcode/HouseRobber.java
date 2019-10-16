/**
 * 
 */
package leetcode;

/**
 * @author SivaM
 *
 * LeetCode Ques - 198 {House Robber}
 * https://leetcode.com/problems/house-robber/
 * 
 * You are a professional robber planning to rob houses along a street. 
 * Each house has a certain amount of money stashed, 
 * the only constraint stopping you from robbing each of them is that adjacent houses have security system connected 
 * and it will automatically contact the police if two adjacent houses were broken into on the same night.
 * 
 * Given a list of non-negative integers representing the amount of money of each house, 
 * determine the maximum amount of money you can rob tonight without alerting the police.
 * 
    Example 1:
    Input: [1,2,3,1]
    Output: 4
    Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
                 Total amount you can rob = 1 + 3 = 4.
    
    Example 2:
    Input: [2,7,9,3,1]
    Output: 12
    Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
                 Total amount you can rob = 2 + 9 + 1 = 12.
 *
 * For solution, refer 
 * https://medium.com/@tlchang9/solving-leetcodes-house-robber-f1b1f2def17f
 * And
 * https://medium.com/@DowntownGuy/leetcode-house-robber-house-robber-ii-e28c0f385987 {Pictorial view}
 * 
 * Time Complexity = O(N)
 * Space Complexity = o(1)
 */
public class HouseRobber {

    /**
     * @param args
     */
    public static void main(String[] args) {
	HouseRobber obj = new HouseRobber();
	
	int[] nums = {1,2,3,1};
	System.out.println("Max amount that can be rob tonight without alerting the police : " +obj.rob(nums));
	// Expected output = 4
	
	int[] nums1 = {2,7,9,3,1};
	System.out.println("Max amount that can be rob tonight without alerting the police : " +obj.rob(nums1));
	// Expected output = 12
    }
    
    /**
     * 
     * @param nums
     * @return
     * 
     * It’s a classical dynamic programming problem. We define each state as, 
     * the maximum number of value we can get if we include ith house, 
     * not necessarily rob ith house. dp[i] = max(dp[i-1], dp[i-2]+nums[i]) means that:
     * 
     * If we choose not to rob i-1 house, dp[i-1] will be same as dp[i-2] , 
     * so rob i house will be definitely be better off.
     * 
     * If we choose to rob i-1 house, we can’t rob i house, 
     * so we just use dp[i-1] as the current gain.
     * 
     * So we choose the larger gain between the two elements.
     * In the end we just return the last element in dp
     * 
     * Also, We don’t need to store all the state in the dp array, 
     * we only need to retain the last two elements.
     * 
     */
    public int rob(int[] nums) {
	if(nums==null || nums.length==0) {
	    return 0;
	} else if(nums.length==1) {
	    return nums[0];
	}
	int prevMax = nums[0];
	int currMax = Math.max(nums[0], nums[1]); // Max of first two values in nums[]
	int i=2; // starting with 3rd element in nums[]
	while(i<nums.length) {
	  int temp = currMax; // copy currMax to temp so that we can copy it to prevmax after computing currMax
	  currMax = Math.max(currMax, prevMax+nums[i]); // As per rule, we cannot rob adjacent cells, So, Rob F(n-2)+F(n) and compare with currMax
	  prevMax = temp;
	  i++;
	}
	return currMax;
    }
}