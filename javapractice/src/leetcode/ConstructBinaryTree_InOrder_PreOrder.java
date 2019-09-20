package leetcode;

/**
 * @author u230107
 *
 *         LeetCode Ques - 105 {Construct Binary Tree from Preorder and Inorder
 *         Traversal}
 *         https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 *
 *         Given preorder and inorder traversal of a tree, construct the binary
 *         tree. Note: You may assume that duplicates do not exist in the tree.
 *         For example, given preorder = [3,9,20,15,7] inorder = [9,3,15,20,7]
 *         Return the following binary tree: 3 / \ 9 20 / \ 15 7
 *
 *         Solution: Refer
 *         https://medium.com/@harycane/construct-binary-tree-from-preorder-and-inorder-traversal-2b6797cd209d.
 *         For Video Explanation, Refer
 *         https://www.youtube.com/watch?v=PoBGyrIWisE
 *
 *         Time Complexity =O(N) Space Complexity = o(N)
 */
public class ConstructBinaryTree_InOrder_PreOrder {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] preorder = { 3, 9, 20, 15, 7 };
		int[] inorder = { 9, 3, 15, 20, 7 };
		TreeNode root = buildTree(preorder, inorder);
		preOrderTraverse_Print(root);
	}

	private static void preOrderTraverse_Print(TreeNode root) {
		if (root == null) {
			return;
		}
		System.out.print(root.val + " ");
		preOrderTraverse_Print(root.left);
		preOrderTraverse_Print(root.right);
	}

	private static TreeNode buildTree(int[] preorder, int[] inorder) {
		return constructBinaryTree(0, 0, inorder.length - 1, preorder, inorder);
	}

	/**
	 *
	 * @param preStart
	 * @param inStart
	 * @param inEnd
	 * @param preorder
	 * @param inorder
	 * @return
	 *
	 *         To find root, Need to get it from preorder Array. To find right and
	 *         left subtree/subtrees of a root, search in inorder array. preStart =
	 *         index pointer to access element in pre-order array. i.e.,
	 *         preorder[preStart] inStart = index pointer indicating start of
	 *         inorder array inEnd = index pointer indicating end of inorder array
	 *         inIndex= Location of root element in inorder array.
	 */
	private static TreeNode constructBinaryTree(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
		if (preStart > preorder.length - 1 || inStart > inEnd) {
			return null;
		}
		TreeNode root = new TreeNode(preorder[preStart]);
		int inIndex = 0; // Index of current root in in-order
		for (int i = inStart; i <= inEnd; i++) {
			if (root.val == inorder[i]) {
				inIndex = i;
			}
		}
		/*
		 * In preorder{Root, L, R} array, left element is just beside root. Therefore
		 * preStart + 1 will tell left subtree node in pre-order array.
		 */
		root.left = constructBinaryTree(preStart + 1, inStart, inIndex - 1, preorder, inorder);
		/*
		 * inIndex{length in the left subtree+Root} - inStart{length in left subtree} =
		 * Will give last right element position of the sub-tree in preOrder array
		 * preStart indicates how many locations need to be jumped in preOrder array to
		 * reach root. +1 is to get to element beside last right element in the pre-oder
		 * array.
		 */
		root.right = constructBinaryTree(preStart + 1 + inIndex - inStart, inIndex + 1, inEnd, preorder, inorder);
		return root;
	}

	static class TreeNode {
		int val;
		TreeNode left, right;

		TreeNode(int val) {
			this.val = val;
		}
	}

}