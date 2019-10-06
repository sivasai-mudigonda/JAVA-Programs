/**
 * 
 */
package leetcode;

/**
 * @author SivaM
 * LeetCode Ques - 230 {Kth Smallest Element in a BST}
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 * 
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 * 
	Example 1:
	
	Input: root = [3,1,4,null,2], k = 1
	   3
	  / \
	 1   4
	  \
	   2
	Output: 1
	Example 2:
	
	Input: root = [5,3,6,2,4,null,null,1], k = 3
	       5
	      / \
	     3   6
	    / \
	   2   4
	  /
	 1
	Output: 3
 *
 * Follow up:
 * What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? 
 * How would you optimize the kthSmallest routine?
 * 
 * Time Complexity = O(K) - counting until counter matching K
 * Space Complexity = o(logN) - call stack
 */
public class Kth_Smallest_Element_BST {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Kth_Smallest_Element_BST obj = new Kth_Smallest_Element_BST();
		
		TreeNode node = obj.new TreeNode(3);
		node.left = obj.new TreeNode(1);
		node.right = obj.new TreeNode(4);
		node.left.right = obj.new TreeNode(2);
		int k=1;
		System.out.println(k +"st Smallest Element BST is " +obj.kthSmallest(node,k));
		
		node=null;
		node = obj.new TreeNode(5);
		node.left = obj.new TreeNode(3);
		node.right = obj.new TreeNode(6);
		node.left.left = obj.new TreeNode(2);
		node.left.right = obj.new TreeNode(4);
		node.left.left.left = obj.new TreeNode(1);
		k=3;
		System.out.println(k +"rd Smallest Element BST is " +obj.kthSmallest(node,k));
	}
	int result=0;
	int count=0;// To count smallest elements visited in the BST
	public int kthSmallest(TreeNode root, int k) {
		count=0;
		kthSmallestHelper(root,k);
		return result;
	}
	
	/**
	 * 
	 * @param node
	 * @param target
	 * 
	 * In-Order Traversal {Left Node, Root, Right Node}
	 */
	private void kthSmallestHelper(TreeNode node, int target ){
		if(node.left!=null) {
			kthSmallestHelper(node.left,target);
		}
		count++;
		if(target==count) {
			result = node.val;
			return;
		}  
		if(node.right!=null) {
			kthSmallestHelper(node.right,target);
		}
	}
	
	class TreeNode {
		int val;
		TreeNode left,right;
		
		TreeNode(int val){
			this.val = val;
			left = right = null;
		}
	}
}
