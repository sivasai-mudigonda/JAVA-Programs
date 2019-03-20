package leetcode;

import java.util.HashMap;

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
	
	public int[] twoSumOnePass(int[] nums, int target) {
		HashMap<Integer,Integer> hm= new HashMap<Integer, Integer>();
		for(int i=0;i<nums.length;i++) {
			int compliment= target - nums[i];
			if(hm.containsKey(compliment)) {
				return new int[] {hm.get(compliment),i};
			}
			hm.put(nums[i], i);
		}
		throw new IllegalArgumentException("No two sum solution");
	}
	
	// Brut force-- without using compliment
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
