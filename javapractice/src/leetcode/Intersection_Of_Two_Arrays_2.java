/**
 * 
 */
package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author SivaM
 * 
 * Leet-code Ques - 350 {Intersection of Two Arrays II} {Easy}
 * https://leetcode.com/problems/intersection-of-two-arrays-ii/
 * 
 * Given two arrays, write a function to compute their intersection.
 * 
	Example 1:
	Input: nums1 = [1,2,2,1], nums2 = [2,2]
	Output: [2,2]
	
	Example 2:
	Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
	Output: [4,9]
 * 
 * Note:
 * Each element in the result should appear as many times as it shows in both arrays.
 * The result can be in any order.
 * 
 * Follow up:
 * Q> What if the given array is already sorted? How would you optimize your algorithm?
 * Ans> Use Method-2{Helper method}
 * 
 * Q> What if nums1’s size is small compared to nums2’s size? Which algorithm is better?
 * ANs> Use Method-2{Sorting+Helper Methods}. We can also optimize it by using Binary Tree.
 * 
 * Q> What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
 * Ans> In this case, it implies that n is far larger than m, which means we should let n be reduced as possible as we can. 
 *      Hence, it will be better to take hash map approach because its time complexity is O(N) only.
 * 
 * SOLUTION:
 * Method-1:
 * Use a HashMap to store the first array{nums1}, then check each element of the second array{nums2} and see if it is in the map. 
 * Note that since we need to output all repeated elements, we also need to count the occurrence of each array element in the map.
 * 
 * Method-2:
 * Sort the two arrays and iterate over to find out the intersections.{Two Pinter Approach}
 * 
 * Complexity:
 * Method-1:
 * Time Complexity = O(N) - N unit of time to build HashMap and check for matching elements
 * Space Complexity = o(M) - Space for M elements stored in HashMap
 * 
 * Method-2:
 * Time Complexity = O(NLogN) - Sorting
 * Space Complexity = o(1) - Constant Space
 *  
 */
public class Intersection_Of_Two_Arrays_2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Intersection_Of_Two_Arrays_2 obj = new Intersection_Of_Two_Arrays_2();
		
		final int[] nums1 = {1,2,2,1};
		final int[] nums2 = {2,2};
		int[] resultArr = obj.intersect(nums1, nums2);
		System.out.println("Intersection Elements{HASH-MAP} = "+Arrays.toString(resultArr));
		resultArr = obj.intersect_SORT(nums1, nums2);
		System.out.println("Intersection Elements{SORT} = "+Arrays.toString(resultArr));
		
		System.out.println("******************************");
		
		final int[] nums3 = {4,9,5};
		final int[] nums4 = {9,4,9,8,4};
		resultArr = obj.intersect(nums3, nums4);
		System.out.println("Intersection Elements{HASH-MAP} = "+Arrays.toString(resultArr));
		resultArr = obj.intersect_SORT(nums3, nums4);
		System.out.println("Intersection Elements{SORT} = "+Arrays.toString(resultArr));
	}
	
	/**
	 * 
	 * @param nums1
	 * @param nums2
	 * @return
	 * 
	 * Using HashMap
	 * 
	 */
	public int[] intersect(int[] nums1, int[] nums2 ){
		if(nums1==null || nums2==null || nums1.length==0 || nums2.length==0 ){
			return new int[0];
		}
		Map<Integer,Integer> map = new HashMap<>();
		List<Integer> intersectionLi = new ArrayList<>();
		for(int n1 : nums1 ){
			map.compute(n1, (key,val)->val==null?1:val+1);
		}
		for(int n2 : nums2 ){
			map.compute(n2, (key,val)->{
			     if(val!=null ){
			    	 if(val>0 ){
			    		 intersectionLi.add(n2);
			    		 val--;
			    	 } 
			    	 if(val==0 ){
			    		 val=null;
			    	 }
			     }
			     return val;
			});
		}
		// "n->n.intValue()" "Integer::intValue"
		int[]  resultArr = intersectionLi.stream().mapToInt(Integer::intValue).toArray();
		return resultArr;
    }
	
	/**
	 * 
	 * @param nums1
	 * @param nums2
	 * @return
	 * 
	 * Using SORTING
	 * 
	 */
	public int[] intersect_SORT(int[] nums1, int[] nums2 ){
		if(nums1==null || nums2==null || nums1.length==0 || nums2.length==0 ){
			return new int[0];
		}
		// Arrays.stream(nums1).sorted(); 
		// Arrays.stream(nums2).sorted();
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		
		int[] resultArr;
		if(nums1.length > nums2.length ){
			resultArr = intersect_helper(nums1,nums2);
		} else {
			resultArr = intersect_helper(nums2,nums1);
		}
		return resultArr;
	}
	
	/**
	 * 
	 * @param nums1
	 * @param nums2
	 * @return
	 */
	private int[] intersect_helper(int[] nums1, int[] nums2 ){
		List<Integer> intersectionLi = new ArrayList<>();
		int i=0;
		int j=0;
		while(i<nums1.length && j<nums2.length){
			if(nums1[i]==nums2[j] ) {
				intersectionLi.add(nums1[i]);
				i++;
				j++;
			} else if(nums1[i]>nums2[j] ){
				j++;
			} else {
				i++;
			}
		}
		// "n->n.intValue()" "Integer::intValue"
		int[] resultArr = intersectionLi.stream().mapToInt(Integer::intValue).toArray();
		return resultArr;
	}
}