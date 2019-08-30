package linklist;

import leetcode.Node;

public class DelMiddleNodeLinkList {

	public static void main(String[] args) {
		LinkedList linkLst = new LinkedList();
		linkLst.head = new Node(4);
		linkLst.head.next = new Node(5);
		linkLst.head.next.next = new Node(6);
		linkLst.head.next.next.next = new Node(7);
		linkLst.head.next.next.next.next = new Node(8);
		printLinkLst(linkLst.head);
		delMiddleNodeLinkLst(linkLst.head.next.next); // Delete 6
		System.out.println("**********After Deleting*********");
		printLinkLst(linkLst.head);
	}

	private static boolean delMiddleNodeLinkLst(Node node) {
		if (node == null || node.next == null) {
			return false; // We cannot delete last node
		}
		Node newNode = node.next;
		node.data = newNode.data;
		node.next = newNode.next;
		return true;
	}

	private static void printLinkLst(Node node) {
		while (node != null) {
			System.out.println(node.data);
			node = node.next;
		}
	}
}
