/**
 * 
 */
package leetcode;

/**
 * @author SivaM
 *
 * LeetCode Ques -108 {Convert Sorted Array to Binary Search Tree}
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 * 
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
	Example:
	Given the sorted array: [-10,-3,0,5,9],
	One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
	
	      0
	     / \
	   -3   9
	   /   /
	 -10  5
 *
 * Solution:
 * If nums list exists, take the middle element and make that into the root node. 
 * For root.left and root.right, pass in the elements to the left and right of the middle of the list. 
 * Recursively create subtree root nodes. 
 * Return the root node of the whole tree
 *
 * Time Complexity =O(N)
 * space Complexity=o(N)
 */
public class ConvertSortedArrayToBinarySearchTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int nums[] = {-10,-3,0,5,9};
		TreeNode root = sortedArrayToBST(nums);
		print(root); // Expected Output = 0 -10 -3 5 9
	}
	
	//PreOrderTreversal
	private static void print(TreeNode root) {
		if(root==null) {
			return;
		}
		System.out.print(root.val +" ");
		print(root.left);
		print(root.right);
	}
	private static TreeNode sortedArrayToBST(int[] nums) {
        if(nums==null || nums.length==0) {
        	return null;
        }
        return sort(nums,0,nums.length-1);
    }
	
	private static TreeNode sort(int[] nums, int low, int high){
		if(low > high) {
			return null;
		}
		int mid = low + (high-low)/2;
		TreeNode root = new TreeNode(nums[mid]);
		root.left = sort(nums,low,mid-1);
		root.right = sort(nums,mid+1,high);
		return root;
	}
	
	static class TreeNode{
		int val;
		TreeNode left,right;
		
		TreeNode(int val){
			this.val = val;
		}
	}
}
