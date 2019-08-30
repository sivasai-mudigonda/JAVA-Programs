package trees;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

/*
 * Best-case performance	- O(1)  
   Average performance	- O(log n)
   Worst-case space complexity - O(n)
 * 
 */

public class BinarySearchTree {

	private static class Node {
		int key;
		Node left, right;

		Node(int key) {
			this.key = key;
			left = null;
			right = null;
		}
	}

	Node root = null;

	private void insertToBST(int key) {
		root = insert(key, root);
	}

	private Node insert(int key, Node root) {

		/* If the tree is empty, return a new node */
		if (root == null) {
			root = new Node(key);
			return root;
		}

		/* Otherwise, recur down the tree */
		if (key > root.key) {
			root.right = insert(key, root.right); // Insert right side
		} else if (key < root.key) {
			root.left = insert(key, root.left); // Insert left side
		}

		/* return the (unchanged) node pointer */
		return root;
	}

	private void deleteFromBST(int key) {
		root = delete(key, root);
	}

	private Node delete(int key, Node root) {
		if (root == null) {
			return root;
		}

		if (key < root.key) {
			// Move Left and Store
			root.left = delete(key, root.left);
		} else if (key > root.key) {
			// Move Right and Store
			root.right = delete(key, root.right);
		} else {
			if (root.left == null) {
				return root.right;
			} else if (root.right == null) {
				return root.left;
			} else {
				root.key=minValue(root.right);
				root.right=delete(root.key,root.right); //?
			}
		}
		return root;
	}

	private int minValue(Node root) {
		int minVal=root.key;
		while(root.left!=null) {
			minVal=root.left.key;
			root=root.left;
		}
		return minVal;
	}

	private void Traversal() {
		System.out.println("IN-ORDER");
		inOrder(root);
		System.out.println("PRE-ORDER");
		preOrder(root);
		System.out.println("POST-ORDER");
		postOrder(root);
	}

	/*
	 * In an inorder traversal, we recursively do an inorder traversal on the left
	 * subtree, visit the root node, and finally do a recursive inorder traversal of
	 * the right subtree.
	 */
	private void inOrder(Node root) {
		if (root != null) {
			inOrder(root.left);
			System.out.println(root.key);
			inOrder(root.right);
		}
	}

	/*
	 * In a preorder traversal, we visit the root node first, then recursively do a
	 * preorder traversal of the left subtree, followed by a recursive preorder
	 * traversal of the right subtree.
	 */
	private void preOrder(Node root) {
		if (root != null) {
			System.out.println(root.key);
			preOrder(root.left);
			preOrder(root.right);
		}
	}

	/*
	 * In a postorder traversal, we recursively do a postorder traversal of the left
	 * subtree and the right subtree followed by a visit to the root node.
	 */
	private void postOrder(Node root) {
		if (root != null) {
			postOrder(root.left);
			postOrder(root.right);
			System.out.println(root.key);
		}
	}

	private boolean searchBST(int key) {
		return search(key, root);
	}

	private boolean search(int key, Node root) {
		boolean isElementFound = false;
		if (root == null) {
			System.out.println("isElementFound in BST = " + isElementFound);
			return isElementFound;
		}
		if (key == root.key) {
			isElementFound = true;
			System.out.println("isElementFound in BST = " + isElementFound);
			return isElementFound;
		}
		if (key < root.key) {
			// Search left side
			isElementFound = search(key, root.left);
		} else if (key > root.key) {
			// Search right side
			isElementFound = search(key, root.right);
		}
		return isElementFound;
	}

	BinarySearchTree bst;
	@Before
	public void insertToBST() {
		bst = new BinarySearchTree();
		Integer arr[] = { 50, 40, 70, 60, 80 };
		List<Integer> al = new ArrayList<Integer>();
		al = Arrays.asList(arr);
		// Insert+Traversal
		al.forEach(key -> {
			bst.insertToBST(key);
		});
		bst.Traversal();
	}
	
	@Test
	public void searchItemBST() throws AssertionError {
		// Search
		assertEquals(true, bst.searchBST(80));
	}
	
	@Test
	public void delItemBST() {
		// Delete+Traversal+Search
		System.out.println("Entered in to delItemBST");
		  bst.deleteFromBST(50);
		  bst.Traversal();
		  System.out.println("Exit delItemBST");
		  assertTrue(bst.searchBST(50));
	}
}