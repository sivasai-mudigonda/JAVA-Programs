/**
* 
*/
package leetcode;

/**
 * @author u230107
 *
 *         Leet Code -19
 *         https://leetcode.com/problems/remove-nth-node-from-end-of-list/ *
 *         Given a linked list, remove the nth node from the end of list and
 *         return its head?
 *
 *
 *         Example: Given linked list: 1->2->3->4->5, and n = 2. After removing
 *         the second node from the end, the linked list becomes 1->2->3->5.
 *
 *         Note: Given n will always be valid.
 *
 *         Time Complexity = O(N) Space Complexity = O(1)
 *
 */
public class RemoveNthNode {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Node linkLst = new Node(5); // 6th node
		linkLst.next = new Node(6); // 5th node
		linkLst.next.next = new Node(7); // 4th node
		linkLst.next.next.next = new Node(8); // 3rd node
		linkLst.next.next.next.next = new Node(9); // 2nd node
		linkLst.next.next.next.next.next = new Node(10); // 1st node
		System.out.println("Before : ");
		printLinkLst(linkLst);
		linkLst = removeNthFromEnd(linkLst, 4);
		// linkLst = removeNthFromEnd(linkLst,6);
		System.out.println("After : ");
		printLinkLst(linkLst);
	}

	private static Node removeNthFromEnd(Node head, int n) {
		Node slow = head;
		Node fast = head;
		for (int i = 0; i < n; i++) {
			if (fast != null) {
				fast = fast.next;
			}
		}

		if (fast == null) {
			head = head.next;
		} else {
			while (fast.next != null) {
				slow = slow.next;
				fast = fast.next;
			}
			slow.next = slow.next.next;
		}
		return head;
	}

	private static void printLinkLst(Node head) {
		Node curr = head;
		while (curr != null) {
			System.out.println(curr.data + " --> ");
			curr = curr.next;
		}
	}

	private static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			next = null;
		}
	}
}
