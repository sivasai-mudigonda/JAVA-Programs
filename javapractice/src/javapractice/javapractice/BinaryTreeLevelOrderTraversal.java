/**
 * 
 */
package javapractice;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author SIVA SAI
 * Refer https://www.geeksforgeeks.org/level-order-tree-traversal/
 * Also refer https://docs.oracle.com/javase/7/docs/api/java/util/Queue.html
 * 
 * Time Complexity is O(N)
 */
public class BinaryTreeLevelOrderTraversal {

	/**
	 * @param args
	 */
	
	private Node root;
	public static void main(String[] args) {
		BinaryTreeLevelOrderTraversal binaryTree= new BinaryTreeLevelOrderTraversal();
		binaryTree.root= new Node(12);
		binaryTree.root.left= new Node(6);
		binaryTree.root.right= new Node(16);
		binaryTree.root.left.right= new Node(8);
		printLevelOrder(binaryTree.root);
	}
	
	private static void printLevelOrder(Node root) {
		if(root==null ){
			return;
		}
		
		Queue<Node> queue = new LinkedList<>();
		queue.offer(root); // queue.add(root);
		while(!queue.isEmpty() ){
			System.out.println(queue.peek().data); //queue.element();			
			Node tempNode=queue.poll();	//queue.remove();
			if(tempNode.left!=null) {
				queue.offer(tempNode.left); // queue.add(tempNode.left);
			}
			
			if(tempNode.right!=null ){
				queue.offer(tempNode.right); // queue.add(tempNode.right);
			}
		}
	}
	
	private static class Node{
		int data;
		Node left,right;
		
		Node(int data){
			this.data=data;
			left=right=null;
		}
	}

}
