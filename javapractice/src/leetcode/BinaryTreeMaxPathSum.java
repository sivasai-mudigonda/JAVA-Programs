/**
 * 
 */
package leetcode;

/**
 * @author SivaM
 * 
 * LeetQues - 124 {Binary Tree Maximum Path Sum}
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/
 * 
 * Given a non-empty binary tree, find the maximum path sum.
 * For this problem, a path is defined as any sequence of nodes 
 * from some starting node to any node in the tree along the parent-child connections. 
 * The path must contain at least one node and does not need to go through the root.
 * 
	Example 1:
	
	Input: [1,2,3]
	
	       1
	      / \
	     2   3
	
	Output: 6
	Example 2:
	
	Input: [-10,9,20,null,null,15,7]
	
	   -10
	   / \
	  9  20
	    /  \
	   15   7
	
	Output: 42
 * 
 * For Solution, refer https://www.youtube.com/watch?v=p8P4Iv1rrtg
 *  
 * Time Complexity = O(N) - Pass through each node of binary tree.
 * Space Complexity = o(N) - Call stack used to store each node
 */
public class BinaryTreeMaxPathSum {
	int result = Integer.MIN_VALUE;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BinaryTreeMaxPathSum btMaxPathSum = new BinaryTreeMaxPathSum();
		
		TreeNode node1 = new TreeNode(1);
		node1.left = new TreeNode(2);
		node1.right = new TreeNode(3);
		System.out.println(btMaxPathSum.maxPathSum(node1)); // Expected Output = 6
		
		TreeNode node2 = new TreeNode(-10);
		node2.left = new TreeNode(9);
		node2.right = new TreeNode(20);		
		node2.right.left = new TreeNode(15);
		node2.right.right = new TreeNode(7);
		System.out.println(btMaxPathSum.maxPathSum(node2)); // Expected Output = 42
	}
	 
	 private int maxPathSum(TreeNode root) {
		 maxPathSumHelper(root);
	     return result;  
	 }
	 
	 /**
	  * 
	  * @param root
	  * @return
	  * 
	  * maximum path of the current node root can be one of the following.
	  * 1.> Current Node or
	  * 2.> Current Node + Left SubTree or
	  * 3.> Current Node + Right Sub Tree or
	  * 4.> Current Node +Left Sub Tree + Right Sub Tree
	  * 
	  * We will consider highest{Max} among the above
	  */
	 private int maxPathSumHelper(TreeNode root) {
		 if(root==null) {
			 return 0;
		 }
		 int left = maxPathSumHelper(root.left);
		 int right = maxPathSumHelper(root.right);
		 
		 // largest path under the current node
		 // left subtree plus current node or right subtree plus current node or current node
		 int max_val = Math.max(root.val+Math.max(left, right), root.val);
		 
		 // largest path sum if the parent node is to be connected
		 // left and right subtree plus current node
		 int max_top = Math.max(max_val,root.val+left+right);
		 
		 // update with result{global max} or "largest path sum if the parent node is to be connected"{max_top}
		 result = Math.max(result, max_top); 
		 
		 //  If there is a node on the current node, then its parent node cannot be accumulated.
		 // So, return "largest path under the current node" {max_val}
		 return max_val; // return left subtree plus current node or right subtree plus current node or current node to parent
	 }
	 
	 static class TreeNode {
		 int val;
		 TreeNode left,right;
		 
		 TreeNode(int val){
			 this.val = val;
		 }
	 }

}
