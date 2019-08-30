/**
 * 
 */
package practice;

import java.util.Stack;

/**
 * @author SIVA SAI
 *
 *Check if a given array can represent Preorder Traversal of Binary Search Tree?
 *Given an array of numbers, return true if given array can represent preorder traversal of a Binary Search Tree, else return false. Expected time complexity is O(n).
 *
 *Refer https://www.geeksforgeeks.org/check-if-a-given-array-can-represent-preorder-traversal-of-binary-search-tree/
 */
public class PreOrderBTCheck {

	/**
	 * 
	 */
	public PreOrderBTCheck() {
	}
	
	private static boolean checkPreOrderTreeCheck(int arr[]) {
		Stack<Integer> st = new Stack<Integer>();
		int root= Integer.MIN_VALUE;
		
		for(int i=0;i<arr.length;i++) {
			
			// If right sub tree element is less than root, return false.
			if(arr[i] < root) {
				return false;
			}
			
			// If pre[i] is in right subtree of stack top, 
            // Keep removing items smaller than pre[i] 
            // and make the last removed item as new 
            // root. 
			while(!st.isEmpty() && arr[i] > st.peek()) {
				root=st.pop();
			}
			
			// At this point either stack is empty or 
            // pre[i] is smaller than root, push pre[i]
			st.push(arr[i]);
		}
		return true;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] pre1 = new int[]{40, 30, 35, 80, 100};
		System.out.println(checkPreOrderTreeCheck(pre1));
		
		int[] pre2 = new int[]{40, 30, 35, 20, 80, 100};
		System.out.println(checkPreOrderTreeCheck(pre2));
		// For root 30, 20 cannot come in right sub tree.
		// It is because 20<20.
	}

}
