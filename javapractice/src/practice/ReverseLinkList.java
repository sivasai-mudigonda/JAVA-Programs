package practice;

// Reverse Linked List
public class ReverseLinkList {
	static Node head;

	public static void main(String[] s) {
		ReverseLinkList.head = new ReverseLinkList.Node(4);
		ReverseLinkList.head.next = new Node(5);
		ReverseLinkList.head.next.next = new Node(6);
		print(ReverseLinkList.head);
		ReverseLinkList.head = reverseLinkListUsingIteration(ReverseLinkList.head);
		print(ReverseLinkList.head);
		ReverseLinkList.head = reverseLinkListUsingRecursion(ReverseLinkList.head, null);
		print(ReverseLinkList.head);
	}

	// Iterative Approach or Dynamic Programming
	// Time Complexity: O(n)
	// Space Complexity: O(1)
	static Node reverseLinkListUsingIteration(Node head) {
		Node prev = null;
		Node curr = head;
		Node next = null;
		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}
	
	// Recursive Approach
	// Time Complexity: O(n)
	// Space Complexity: O(1)
	static Node reverseLinkListUsingRecursion(Node curr, Node prev) {
		// To fix head
		if (curr.next == null) {
			head = curr;
			curr.next = prev;
			return head;
		}
		Node next = curr.next;
		curr.next = prev;
		reverseLinkListUsingRecursion(next, curr);
		return head;
	}

	static void print(Node current) {
		while (current != null) {
			System.out.println(current.data);
			current = current.next;
		}
	}

	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			next = null;
		}
	}

}
