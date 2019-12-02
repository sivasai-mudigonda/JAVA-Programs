/**
 * 
 */
package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author SivaM
 * 
 * Leet-code Ques - 347 {Top K Frequent Elements} {Medium}
 * https://leetcode.com/problems/top-k-frequent-elements/
 * 
 * Given a non-empty array of integers, return the k most frequent elements.
 * 
	Example 1:
	Input: nums = [1,1,1,2,2,3], k = 2
	Output: [1,2]
	
	Example 2:
	Input: nums = [1], k = 1
	Output: [1]
 * 
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 * 
 * Solution:
 * Method-1:
 * 1.> Use map/dictionary and store the frequency of the number 
 * 
 * 2.> Apply bucket-sort
 *    2.1> Create a multi-storage bucket with (maximum frequency + 1)as its size. 
 *         Now, based on frequency of the word, put it in the appropriate bucket level. 
 *         In our example, Put 1 at level 3, put 2 at level 2 and put 3 at level 1.
 *    
 *    2.2> There might be more than one numbers with the same frequency. 
 *         So, we can use array list to store more than one elements at the same level.
 *  
 * 3.> Iterate over the bucket elements and keep a counter to match with the input value k.
 * 
 * Method-2:
 * 1.> Use map/dictionary and store the frequency of the number 
 * 2.> Use Priority-Queue{Min Heap + comparator to sort keys based on frequencies} and store k elements only.
 * 3.> Convert PriorityQueue to List{Reverse the list} and return list.
 * 
 * Complexities:
 * 
 * Method-1 - Bucket Array
 * Time Complexity = O(N) - Loop through nums array - Linear Time
 * Space Complexity = o(N) - Store frequencies in frequenciesLi
 * 
 * Method-2 - Priority Queue
 * Time Complexity = O(NLogK) - Loop through nums and insert{O(logK)} in to priority queue
 * Space Complexity = o(K) - Store k elements in priority queue
 * 
 */
public class Top_K_Frequent_Elements {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Top_K_Frequent_Elements obj = new Top_K_Frequent_Elements();
		
		final int[] nums1 = {1,1,1,2,2,3};
		int k=2;
		System.out.println(k+" most frequent elements = "+obj.topKFrequent(nums1,k)); // Expected Output = {1 2}
		System.out.println(k+" most frequent elements = "+obj.topKFrequent_PriorityQueue(nums1,k)); // Expected Output = {1 2}
		
		System.out.println("******************************");
		final int[] nums2= {1};
		k=1;
		System.out.println(k+" most frequent elements = "+obj.topKFrequent(nums2,k)); // Expected Output = {1}
		System.out.println(k+" most frequent elements = "+obj.topKFrequent_PriorityQueue(nums2,k)); // Expected Output = {1}
	}
	
	/**
	 * 
	 * @param nums
	 * @param k
	 * @return
	 * 
	 * Method-1 - Bucket Array
	 * 
	 */
	public List<Integer> topKFrequent(int[] nums, int k) {
        if(nums==null || nums.length==0 || k<=0 ){
        	return null;
        }
        // Step-1
        Map<Integer,Integer> map = new HashMap<>();
        Arrays.stream(nums).forEach(n->{
        	map.compute(n,(key,val)->
        		val==null?1:val+1
        	);
        	// map.put(n,map.getOrDefault(n, 0)+1);
        });
        
        // Step-2
        // We want to access through index, So we choose array of list
        // +1 ==> As frequencies starts from 1 and array index starts from zero, we need one unit of extra space
        List<Integer>[] frequenciesLi = new ArrayList[nums.length+1];
        map.keySet().forEach(key->{
        	Integer freq  = map.get(key);
        	List<Integer> subLi;
        	// Step 2.1
    		if(frequenciesLi[freq]!=null ){
    			subLi = frequenciesLi[freq];
    		} else {
    			// Step 2.2
    			subLi = new ArrayList<>();
    		}
    		subLi.add(key);
    		frequenciesLi[freq]=subLi;
        });
        
        // Step-3
        List<Integer> resultLi = new ArrayList<>();
        for(int freq=frequenciesLi.length-1;freq>=0;freq--) {
        	List<Integer> subLi = frequenciesLi[freq];
        	if(subLi!=null ){
        		resultLi.addAll(subLi);
        	}
        	if(resultLi.size()==k) {
        		break;
        	}
        }
        return resultLi;
    }
	
	/**
	 * 
	 * @param nums
	 * @param k
	 * @return
	 * 
	 * Method-2:
	 * Priority Queue- MinHeap{Sorts from Low to High}
	 * queue.peek() will give values from front
	 * 
	 */
	public List<Integer> topKFrequent_PriorityQueue(int[] nums, int k) {
        if(nums==null || nums.length==0 || k<=0 ){
        	return null;
        }
     // Step-1
        Map<Integer,Integer> map = new HashMap<>();
        Arrays.stream(nums).forEach(n->{
        	map.compute(n,(key,val)->
        		val==null?1:val+1
        	);
        	// map.put(n,map.getOrDefault(n, 0)+1);
        });
        
        // Step -2 
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k,(m,n)->map.get(m)-map.get(n));
        map.keySet().forEach(key->{
        	minHeap.offer(key);
        	if(minHeap.size()>k ){
        		minHeap.poll();
        	}
        });
        
        // Step-3
        List<Integer> resultLi = new LinkedList<>(minHeap);
        Collections.reverse(resultLi);
        return resultLi;
	}
}
