package javapractice.linklist;

public class LinkedList {
	public Node head;

	public void printList(Node node) {
		while (node != null) {
			System.out.println(node.data);
			node = node.next;
		}
	}
	
	// To get Last Node in Linked List.
	public Node getLastNode() {
		while (head.next != null) {
			head = head.next;
		}
		return head;
	}

	// Insert Integer Elements in to Linked List.
	public void push(Object[] valLst) {
		boolean isFirstEle = false;
		Node tempNode = null;
		for (Object val : valLst) {
			Node newNode = new Node((Integer) val);
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
	
	public static class Node {
		public int data;
		public Node next;

		public Node(int data) {
			this.data = data;
			next = null;
		}

	}
}
