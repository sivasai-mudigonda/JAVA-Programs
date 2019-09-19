/**
 * 
 */
package leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author SivaM
 * 
 * LeetCode Ques - 102 {Binary Tree Level Order Traversal}
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 *
 * Given a binary tree, return the level order traversal of its nodes' values. 
 * (ie, from left to right, level by level).
	For example:
	Given binary tree [3,9,20,null,null,15,7],
	    3
	   / \
	  9  20
	    /  \
	   15   7
	return its level order traversal as:
	[
	  [3],
	  [9,20],
	  [15,7]
	]
 *
 * Sol:
 * Push the root to queue. 
 * Get the size of queue, and do a full iteration over the size of queue, pushing children on to queue, and popping the iterated one. 
 * So each iteration of the size thing-y ensures that we iterate over all the guys at one level in that loop, 
 * and all those guys are popped out of queue, while at the same time, 
 * their children, that is, the complete next level is present on the queue.
 * 
 * Time Complexity:  O(N)
 * Space Complexity: o(N)  
 */
public class LevelOrderTraversal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		List<List<Integer>> li = levelOrder(root);
		li.stream().forEach(System.out::println);
		/**
		 * Expected Output :
		   [
			 [3],
			 [9,20],
			 [15,7]
   		   ]
		 */
	}
	
	/**
	 * 
	 * @param root
	 * @return
	 */
	private static List<List<Integer>> levelOrder(TreeNode root) {
		if(root==null) {
			return new LinkedList<List<Integer>>();
		}
		List<List<Integer>> resultLi = new LinkedList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);

		while(!queue.isEmpty() ){
			List<Integer> currLi = new LinkedList<>();
			int queueSize = queue.size(); //Num of nodes in the current level
			for(int i=0;i<queueSize;i++) {
				TreeNode currNode = queue.poll();
				currLi.add(currNode.val);
				if(currNode.left!=null) {
					queue.offer(currNode.left);
				}
				if(currNode.right!=null) {
					queue.offer(currNode.right);
				}
			}
			resultLi.add(currLi);
		}
		return resultLi;
	}
	
	static class TreeNode{
		int val;
		TreeNode left, right;
		
		TreeNode(int data){
			this.val = data;
		}
	}

}
