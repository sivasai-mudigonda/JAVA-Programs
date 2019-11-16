/**
 * 
 */
package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author SivaM
 * 
 * LeetCode Ques - 315 {Count of Smaller Numbers After Self} - HARD
 * https://leetcode.com/problems/count-of-smaller-numbers-after-self/
 * 
 * You are given an integer array nums and you have to return a new counts array. 
 * The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].
 * 
	Example:
	Input: [5,2,6,1]
	Output: [2,1,1,0] 
	Explanation:
	To the right of 5 there are 2 smaller elements (2 and 1).
	To the right of 2 there is only 1 smaller element (1).
	To the right of 6 there is 1 smaller element (1).
	To the right of 1 there is 0 smaller element.
 * 
 * Solution:
 * BST Approach
 * 
 * Time Complexity = O(NLogN) - To loop through Array and insert{O(LogN)} to Binary Search Tree
 * Space Complexity = o(N)
 *  
 */
public class Count_Smaller_Numbers_After_Self {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Count_Smaller_Numbers_After_Self obj = new Count_Smaller_Numbers_After_Self();
		System.out.println(obj.countSmaller(new int[]{7,6,5,2,6,1})); // Expected Output = [5, 3, 2, 1, 1, 0]
	}
	
	public List<Integer> countSmaller(int[] nums) {
        if(nums==null || nums.length==0 ){
        	return new ArrayList<>();
        }
        Integer[] solution = new Integer[nums.length];
        // We treat the results in reverse (i: from nums.length-1 to 0).
        Node root = null;
        for(int i=nums.length-1;i>=0;i--) {
        	root = smaller(nums[i], i, root, 0, solution);
        }
        return Arrays.asList(solution);
    }
	
	/**
	 * 
	 * @author SivaM
	 * Binary Search Tree
	 * 
	 * Note:
	 * We traverse from last index to first index for this problem.
	 *
	 * smallrCnt - 
	 * When we traverse to 5 in Array, We update node 6{Index = 4} smallrCnt as 2.
	 * Meaning, 5 and 2 are smaller than 6.
	 * When 6{Index = 1} appears again, We know that there are 2 numbers smaller than 6.
	 * So, we sum up 2 to PreSum and store in result[i]. Also we increase duplicate count for Node 6.
	 * 
	 * dup - To keep track of count of duplicates.
	 * When we traverse for 7 in Array , From Node 1, we reach Node 6{Index=4}{root.right}.
	 * Node 6 has a duplicate count of 2 and smallrCnt of 2 which we sum up to PreSum and recurse further.
	 * 
	 */
	class Node{
		int val;
		Node left,right;
		int smallerCnt;
		int dup=1;
		Node(int val){
			this.val = val;
		}
	}
	
	/**
	 * 
	 * @param num
	 * @param index
	 * @param node
	 * @param preSum
	 * @param result
	 * @return
	 * 
	 * PreSum = To keep track of count of smaller nodes after self{Result}
	 * 
	 */
	public Node smaller(int num, int index, Node node, int preSum, Integer[] result ){
		if(node==null ){
			// Termination condition
			node = new Node(num);
			result[index] = preSum;
		} else if(num == node.val ){
			node.dup++;
			result[index] = preSum + node.smallerCnt;
		} else if(num < node.val ){
			node.smallerCnt++;
			/* we need to go to the "left subtree" of the node.
             * Value we want to count is smaller than node.val,
             * we don't need to accumulate any results, just continue to the left subtree recursively.
             * 
             */
			node.left = smaller(num,index, node.left, preSum, result);
		} else if(num > node.val) {
			/*
        	 * we need to go to the "right subtree" of the node.
        	 * Num is greater than node.val, meaning towards it right there is a smaller value present.
        	 * So, sum up  node.smallerCnt,  node.dup{By default it is one} and preSum.
        	 * 
        	 */
			node.right = smaller(num, index, node.right, preSum+ node.dup + node.smallerCnt, result);
		}
		return node;
	}
}
