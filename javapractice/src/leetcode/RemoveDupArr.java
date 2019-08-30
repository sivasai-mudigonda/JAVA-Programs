package leetcode;

public class RemoveDupArr {

	public static void main(String[] args) {
		int[] nums= {1,3,2};
		int len=removeDuplicates(nums);
		for(int i=0; i<len;i++) {
			System.out.println(nums[i]);
		}
	}
	
	public static int removeDuplicates(int[] nums) {
	    if (nums.length == 0) return 0;
	    int i = 0;
	    for (int j = 1; j < nums.length; j++) {
	        if (nums[j] != nums[i]) {
	        	// Duplicate value sits in b/w i and j. 
	        	// so increment i by 1 and then place value at j in i index of array.
	            i++; // For every unique value, increment i.
	            nums[i] = nums[j];
	        }
	    }
	    return i + 1; // As i starts with 0, increment it by 1.
	}

}
