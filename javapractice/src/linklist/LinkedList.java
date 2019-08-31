package linklist;

import leetcode.ListNode;

public class LinkedList {
	public ListNode head;

	public void printList(ListNode node) {
		while (node != null) {
			System.out.println(node.data);
			node = node.next;
		}
	}
	
	// To get Last Node in Linked List.
	public ListNode getLastNode() {
		while (head.next != null) {
			head = head.next;
		}
		return head;
	}

	// Insert Integer Elements in to Linked List.
	public void push(Object[] valLst) {
		boolean isFirstEle = false;
		ListNode tempNode = null;
		for (Object val : valLst) {
			ListNode newNode = new ListNode((Integer) val);
			if (tempNode == null && !isFirstEle) {
				tempNode = newNode;
				head = tempNode;
				isFirstEle = true;
				continue;
			}
			if (tempNode != null) {
				tempNode.next = newNode;
				tempNode = tempNode.next;
			}
		}
	}
}
