/**
 * 
 */
package leetcode;

/**
 * @author u230107
 *
 *         LeetCode Ques - 236 {Lowest Common Ancestor of a Binary Tree}
 *         https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 *
 *         Given a binary tree, find the lowest common ancestor (LCA) of two
 *         given nodes in the tree. According to the definition of LCA on
 *         Wikipedia : "The lowest common ancestor is defined between two nodes
 *         p and q as the lowest node in T that has both p and q as descendants
 *         (where we allow a node to be a descendant of itself ). ”
 *
 *         Given the following binary tree: root = [3,5,1,6,2,0,8,null,null,7,4]
 *         Example 1:
 *         Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 *         Output: 3 
 *         Explanation: The LCA of nodes 5 and 1 is 3.
 * 
 *         Example 2: 
 *         Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 *         Output: 5 
 *         Explanation: The LCA of nodes 5 and 4 is 5 , Since a node
 *         can be a descendant of itself according to the LCA definition.
 *
 *         Note: All of the nodes' values will be unique. p and q are different
 *         and both values will exist in the binary tree.
 *
 *         Time Complexity = O(N) 
 *         Space COmplexity = o(1) - If we exclude call stack
 *
 */
public class LowestCommonAncestor_BinaryTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LowestCommonAncestor_BinaryTree obj = new LowestCommonAncestor_BinaryTree();

		TreeNode root = obj.new TreeNode(3);
		TreeNode p = root.left = obj.new TreeNode(5);
		TreeNode q = root.right = obj.new TreeNode(1);
		root.right.left = obj.new TreeNode(0);
		root.right.right = obj.new TreeNode(8);

		root.left.left = obj.new TreeNode(6);
		root.left.right = obj.new TreeNode(2);
		root.left.right.left = obj.new TreeNode(7);
		TreeNode r = root.left.right.right = obj.new TreeNode(4);

		TreeNode commonAncestorNode = obj.lowestCommonAncestor(root, p, q);
		System.out.println("Common Ancestor Node = " + commonAncestorNode.val); // Expected Output = 3

		commonAncestorNode = obj.lowestCommonAncestor(root, p, r);
		System.out.println("Common Ancestor Node = " + commonAncestorNode.val); // Expected Output = 5
	}

	/**
	 *
	 * @param root
	 * @param p
	 * @param q
	 * @return
	 *
	 *         Method to find Lowest Common Ancestor for Binary Tree. bottom up
	 *         approach
	 */
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		//1.> If the root is null then return null.
		if (root == null) {
			return null;
		}
		//2.> If the one of the nodes(p or q) is root, then return root
		if (p == root || q == root) {
			return root;
		}
		//3.> Find the left node and the right node by recursively calling lowestCommonAncestor
		// on left, right subtrees
		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);
		//4.> Check if both left and right are not null, then root is the lowest common ancestor
		if (left != null && right != null) {
			return root;
		}
		// 5.> Check if left is null then both the nodes are in right subtree and the right node is the LCA.
		// 6.> Check if right is null then both nodes are in the left subtree and the left node is the LCA
		TreeNode ancestor = left == null ? right : left;
		return ancestor;
	}

	/**
	 *
	 * @author u230107 Definition of a binary tree
	 */
	class TreeNode {
		int val;
		TreeNode left, right;

		TreeNode(int val) {
			this.val = val;
		}
	}

	/**
	 *
	 * @param root
	 * @param p
	 * @param q
	 * @return
	 *
	 *         Method to find Lowest Common Ancestor for Binary Search Tree. Here we
	 *         can depend on value unlike Binary Tree where we depend on node.
	 *
	 *         Binary Tree is a specialized form of tree with two child (left child
	 *         and right Child). It is simply representation of data in Tree
	 *         structure
	 *
	 *         Binary Search Tree (BST) is a special type of Binary Tree that
	 *         follows following condition: left child node is smaller than its
	 *         parent Node right child node is greater than its parent Node
	 */
	private TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
		//1.> If the root is null then return null.
		if (root == null) {
			return null;
		}
		//2.> if root node value is greater than Max of p or q nodes value,
		// make recursive call on root.left
		if (root.val > Math.max(p.val, q.val)) {
			return lca(root.left, p, q);
		}
		//3.> if root node value is less than Min of p or q nodes value,
		// make recursive call on root.right
		if (root.val < Math.min(p.val, q.val)) {
			return lca(root.right, p, q);
		}
		// 4.> Else return root
		return root;
	}
}
