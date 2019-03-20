/**
 * 
 */
package leetcode;

import java.util.Stack;

/**
 * @author SIVA SAI
 * 
 * 
 * LeetCode - 173. Binary Search Tree Iterator
 * https://leetcode.com/problems/binary-search-tree-iterator/
 * 
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
 * Calling next() will return the next smallest number in the BST.
 * 
 * 
 * BSTIterator iterator = new BSTIterator(root);
iterator.next();    // return 3
iterator.next();    // return 7
iterator.hasNext(); // return true
iterator.next();    // return 9
iterator.hasNext(); // return true
iterator.next();    // return 15
iterator.hasNext(); // return true
iterator.next();    // return 20
iterator.hasNext(); // return false
 *
 *
 *Note:
 *
 *next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
 *You may assume that next() call will always be valid, that is, there will be at least a next smallest number in the BST when next() is called.
 *
 *Time Complexity = O(h) or O(log n) or O(n) in worst case.
 *Space Complexity = o(h) -stack data structure.
 *
 *Refer https://www.youtube.com/watch?v=aRLSJFv-80k
 */
public class BSTIterator {

	/**
	 * Your BSTIterator object will be instantiated and called as such:
	 * BSTIterator obj = new BSTIterator(root);
	 * int param_1 = obj.next();
	 * boolean param_2 = obj.hasNext();
	 */
	
	Stack<TreeNode> st;
	public static void main(String[] args) {
		TreeNode root = new TreeNode(7);
		root.left=new TreeNode(3);
		root.right= new TreeNode(15);
		root.right.left= new TreeNode(9);
		root.right.right= new TreeNode(20);
		BSTIterator bstIterator = new BSTIterator(root);
		System.out.println();
		System.out.println(bstIterator.next());    // return 3
		System.out.println(bstIterator.next());    // return 7
		System.out.println(bstIterator.hasNext()); // return true
		System.out.println(bstIterator.next());    // return 9
		System.out.println(bstIterator.hasNext()); // return true
		System.out.println(bstIterator.next());    // return 15
		System.out.println(bstIterator.hasNext());; // return true
		System.out.println(bstIterator.next());    // return 20
		System.out.println(bstIterator.hasNext()); // return false
	}
	
    public BSTIterator(TreeNode root) {
    	st = new Stack<>();
    	pushAll(root);
    }
    
    private void pushAll(TreeNode node) {
    	while(node!=null) {
    		st.push(node);
    		node=node.left;
    	}
    }
	    
    /** @return the next smallest number */
    public int next() {
        TreeNode node = st.pop();
        pushAll(node.right);
        return node.val;
    }
	    
    /** @return whether we have a next smallest number */
    public boolean hasNext() { 
        return !st.isEmpty();
    }

    /**
	 * Definition for a binary tree node. */
	 public static class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	 }
}
