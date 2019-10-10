/**
 * 
 */
package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author SivaM
 * 
 * LeetCode Ques - 179 {Largest Number}
 * https://leetcode.com/problems/largest-number/
 *
 * Given a list of non negative integers, arrange them such that they form the largest number.
 * 
	Example 1:
	Input: [10,2]
	Output: "210"
	
	Example 2:
	Input: [3,30,34,5,9]
	Output: "9534330"
 *
 * Note: The result may be very large, so you need to return a string instead of an integer.
 * 
 * Solution:
 * Refer https://medium.com/leetcode-%E6%BC%94%E7%AE%97%E6%B3%95%E6%95%99%E5%AD%B8/019-leetcode-179-%E6%BC%94%E7%AE%97%E6%B3%95-largest-number-%E6%9C%80%E5%A4%A7%E6%95%B4%E6%95%B8-3972e25a81ba
 * 
 * Time Complexity: O(NLogN) - As we applied sorting
 * Space Complexity: o(N) - To store N elements in String array
 */
public class LargestNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LargestNumber obj = new LargestNumber();
		int[] nums1 = {10,2};
		System.out.println("Largest Number = "+obj.largestNumber(nums1)); // Expected Output =210
		
		int[] nums2 = {3,30,34,5,9};
		System.out.println("Largest Number = "+obj.largestNumber(nums2)); // Expected Output = 9534330
		
		int[] nums3 = {0, 30, 3};
		System.out.println("Largest Number = "+obj.largestNumber(nums3)); // Expected Output = 3300
		
		int[] nums4 = {0,0};
		System.out.println("Largest Number = "+obj.largestNumber(nums4)); // Expected Output = 0
	}
	
	/*
	 * 
	 */
	public String largestNumber(int[] nums) {
        if(nums==null || nums.length==0) {
        	return "";
        }
        String[] strArr = new String[nums.length];
        int index=0;
        for(int num: nums) {
        	strArr[index]= Integer.toString(num);
        	index++;
        }
        Arrays.parallelSort(strArr,new Comparator<String>() {
        	@Override
        	public int compare(String s1,String s2) {
        		/*
        		 * This must be done to prevent the situation with 0, 30, 3.
        		 * 303,330, can't use -s1.compareTo(s2) directly;
        		 */
        		String str1 = s1+s2;// String concatenation
        		String str2 = s2+s1;// String concatenation
        		return str2.compareTo(str1); // We need descending order{Largest number in the beginning of array}
        		/*
        		 * // 1.
				    return str1.compareTo(str2); // ascending order [0, 5, 10, 15, 20]
				    // 2.
				    return -str1.compareTo(str2); // descending order [20, 15, 10, 5, 0]
				    // 3.
				    return str2.compareTo(str1); // descending order [20, 15, 10, 5, 0]
				    // 4.
				    return -str2.compareTo(str1); // ascending order [0, 5, 10, 15, 20]
				    // 5.
				    return +1; // insertion order [10, 0, 15, 5, 20, 20]
				    // 6.
				    return -1; // reverse of insertion order [20, 20, 5, 15, 0, 10]
				    // 7.
				    return 0; // only first element [10]
        		 */
        	}
        });
        if(strArr[0].charAt(0)=='0' ) {
        	return "0"; // To avoid "00"
        }
        StringBuilder sb = new StringBuilder();
        for(String s:strArr) {
        	sb.append(s);
        }
        return sb.toString();
    }
}
