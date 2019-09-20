/**
 * 
 */
package leetcode;

/**
 * @author SivaM
 * LeetCode Ques - 116 {Populating Next Right Pointers in Each Node}
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
 * 
 * You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. 
 * The binary tree has the following definition:
	class Node {
		public int val;
		public Node left;
		public Node right;
		public Node next;
	}
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
 * Initially, all next pointers are set to NULL.
	Example:
	Input: {"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":null,"right":null,"val":4},"next":null,"right":{"$id":"4","left":null,"next":null,"right":null,"val":5},"val":2},"next":null,"right":{"$id":"5","left":{"$id":"6","left":null,"next":null,"right":null,"val":6},"next":null,"right":{"$id":"7","left":null,"next":null,"right":null,"val":7},"val":3},"val":1}
	Output: {"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":{"$id":"4","left":null,"next":{"$id":"5","left":null,"next":{"$id":"6","left":null,"next":null,"right":null,"val":7},"right":null,"val":6},"right":null,"val":5},"right":null,"val":4},"next":{"$id":"7","left":{"$ref":"5"},"next":null,"right":{"$ref":"6"},"val":3},"right":{"$ref":"4"},"val":2},"next":null,"right":{"$ref":"7"},"val":1}
	Explanation: Given the above perfect binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B.
 
 * Note:
 * You may only use constant extra space.
 * Recursive approach is fine, implicit stack space does not count as extra space for this problem.
 * 
 * For Solution, refer https://www.youtube.com/watch?v=xX_TdhAkjJs
 * 
 * Time Complexity = O(N) - Iterate all elements in  the tree
 * Space Complexity =o(1) - No extra space used to store elements
 *
 */
public class BinaryTreeNextRightPointer {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		Node node = new Node();
		node.val=1;
		node.left=new Node();
		node.left.val=2;
		node.right=new Node();
		node.right.val=3;
		node.left.left=new Node();
		node.left.val=4;
		node.left.right=new Node();
		node.left.val=5;
		node.right.left=new Node();
		node.right.val=6;
		node.right.right=new Node();
		node.right.val=7;
		Node res_dp = connect_dp(node); // Dynamic Programming
		print(res_dp);
		Thread.sleep(1000);
		System.out.println("*************************");
		Node res  = connect(node); // Recursive
		print(res);
	}
	
	// Pre-Order Traversal
	private static void print(Node root) {
		if(root==null) {
			return;
		}
		System.out.println("Root Val = " +root.val);
		if(root.next!=null) {
			System.out.println("Root Next Val = " +root.next.val);
		} else {
			System.out.println("Root Next Val = null");
		}
		print(root.left);
		print(root.right);
	}
	
	// Dynamic Program-Iterative
	private static Node connect_dp(Node root) {
        if(root==null) {
        	return null;
        }
        Node curr = root;
        while(curr!=null) {
        	Node temp = curr;
        	while(temp!=null ){
        		if(temp.left!=null) {
        			temp.left.next =  temp.right;
        		}
        		if(temp.right!=null && temp.next!=null) {
        			temp.right.next = temp.next.left;
        		}
        		temp=temp.next; // Horizontal Traversal, To get to right node
        	}
        	curr=curr.left; // Vertical Traversal, To get to below node
        }
        return root;
    }
	
	static class Node {
	    public int val;
	    public Node left;
	    public Node right;
	    public Node next;

	    public Node() {}

	    public Node(int _val,Node _left,Node _right,Node _next) {
	        val = _val;
	        left = _left;
	        right = _right;
	        next = _next;
	    }
	};
	
	// Recursive
	// Call stack can be considered as o(1) for this program
	private static Node connect(Node root) {
        if (root == null) {
            return null;
        }
        if (root.left != null) {
            root.left.next = root.right;
        }
        if (root.right != null && root.next != null) {
            root.right.next = root.next.left;
        }
        connect(root.left);
        connect(root.right);
        return root;
    }

}
