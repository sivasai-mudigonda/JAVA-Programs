package linklist;

import leetcode.ListNode;

public class DelMiddleNodeLinkList {

	public static void main(String[] args) {
		LinkedList linkLst = new LinkedList();
		linkLst.head = new ListNode(4);
		linkLst.head.next = new ListNode(5);
		linkLst.head.next.next = new ListNode(6);
		linkLst.head.next.next.next = new ListNode(7);
		linkLst.head.next.next.next.next = new ListNode(8);
		printLinkLst(linkLst.head);
		delMiddleNodeLinkLst(linkLst.head.next.next); // Delete 6
		System.out.println("**********After Deleting*********");
		printLinkLst(linkLst.head);
	}

	private static boolean delMiddleNodeLinkLst(ListNode node) {
		if (node == null || node.next == null) {
			return false; // We cannot delete last node
		}
		ListNode newNode = node.next;
		node.data = newNode.data;
		node.next = newNode.next;
		return true;
	}

	private static void printLinkLst(ListNode node) {
		while (node != null) {
			System.out.println(node.data);
			node = node.next;
		}
	}
}
