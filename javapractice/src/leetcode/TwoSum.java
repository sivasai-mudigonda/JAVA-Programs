package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author SivaM
 * 
 * Leet-Code Ques - 1 {Two Sum} {Easy}
 * https://leetcode.com/problems/two-sum/
 * 
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * 
	Example:
	Given nums = [2, 7, 11, 15], target = 9,
	Because nums[0] + nums[1] = 2 + 7 = 9,
	return [0, 1].
 *
 * Time Complexity: O(N)
 * Space Complexity: o(N)
 *
 */
public class TwoSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] nums= {3,2,3};
		TwoSum twoSum= new TwoSum();
		//int[] res= twoSum.twoSum(nums,6);
		//System.out.println(res[0]+","+res[1]);
		int[] res= twoSum.twoSumOnePass(nums,6);
		System.out.println(res[0]+","+res[1]);
	}
	
	/**
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
	public int[] twoSumOnePass(int[] nums, int target) {
		Map<Integer,Integer> map= new HashMap<Integer, Integer>();
		for(int i=0;i<nums.length;i++) {
			int compliment= target - nums[i];
			if(map.containsKey(compliment)) {
				return new int[] {map.get(compliment),i};
			}
			map.put(nums[i], i);
		}
		return new int[0];
	}
	
	/**
	 * 
	 * @param nums
	 * @param target
	 * @return
	 * 
	 * Brut force-- without using compliment
	 * 
	 * Time Complexity = O(N^2)
	 * Space Complexity = o(1)
	 * 
	 */
	public int[] twoSum(int[] nums, int target) {
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums.length;j++){
            	if(i==j){
                    continue;
                }
                int tot= nums[i]+nums[j];
                if(tot==target){
                    int[] res=new int[2];
                    res[0]=i;
                    res[1]=j;
                    return res;
                }
            }
        }
        return null;
    }

}
