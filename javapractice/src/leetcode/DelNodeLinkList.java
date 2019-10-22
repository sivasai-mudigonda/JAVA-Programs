package leetcode;
/**
 * 
 * @author SivaM
 * 
 * LeetCode Ques - 237 {Delete Node in a Linked List}
 * https://leetcode.com/problems/delete-node-in-a-linked-list/
 * 
 * Write a function to delete a node (except the tail) in a singly linked list, 
 * given only access to that node.
 * 
	Given linked list -- head = [4,5,1,9], which looks like following:
	Example 1:
	Input: head = [4,5,1,9], node = 5
	Output: [4,1,9]
	Explanation: You are given the second node with value 5, 
	             the linked list should become 4 -> 1 -> 9 after calling your function.
	
	Example 2:
	Input: head = [4,5,1,9], node = 1
	Output: [4,5,9]
	Explanation: You are given the third node with value 1, 
	             the linked list should become 4 -> 5 -> 9 after calling your function.
 * 
 * Note:
 * The linked list will have at least two elements.
 * All of the nodes' values will be unique.
 * The given node will not be the tail and it will always be a valid node of the linked list.
 * Do not return anything from your function.
 *
 * Time Complexity =O(1)
 * Space Complexity =o(1)
 */
public class DelNodeLinkList {

	public static void main(String[] args) {
		DelNodeLinkList obj = new DelNodeLinkList();
		
		ListNode head = obj.new ListNode(4);
		ListNode x = head.next = obj.new ListNode(5);
		head.next.next = obj.new ListNode(1);
		head.next.next.next = obj.new ListNode(9);
		obj.printLinkLst(head); // Expected Result = 4 5 1 9
		obj.deleteNode(x); // Delete 5
		System.out.println("**********After Deleting*********");
		obj.printLinkLst(head); // Expected Result = 4 1 9
		System.out.println("******************************");
		head=null;
		head = obj.new ListNode(4);
		head.next = obj.new ListNode(5);
		x = head.next.next = obj.new ListNode(1);
		head.next.next.next = obj.new ListNode(9);
		obj.printLinkLst(head); // Expected Result = 4 5 1 9
		obj.deleteNode(x); // Delete 1
		System.out.println("**********After Deleting*********");
		obj.printLinkLst(head); // Expected Result = 4 5 9
		
	}
    
	/**
	 * 
	 * @param node
	 */
	public void deleteNode(ListNode node) {
        if (node == null || node.next == null) {
			return; // We cannot delete last node
		}
		ListNode newNode = node.next;
		node.val = newNode.val;
		node.next = newNode.next;
		return;
    }

	private void printLinkLst(ListNode node) {
		while (node != null) {
			System.out.print(node.val+"->");
			node = node.next;
		}
		System.out.println("null");
	}
	
	class ListNode {
		public int val;
		public ListNode next;

		public ListNode(int data) {
			this.val = data;
			next = null;
		}
	}
}
