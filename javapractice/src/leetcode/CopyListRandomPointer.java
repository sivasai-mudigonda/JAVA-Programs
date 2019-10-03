/**
 * 
 */
package leetcode;

/**
 * @author u230107
 *
 *         LeetCode Ques - 138 {Copy List with Random Pointer}
 *         https://leetcode.com/problems/copy-list-with-random-pointer/
 *
 *         A linked list is given such that each node contains an additional
 *         random pointer which could point to any node in the list or null.
 *         Return a deep copy of the list.
 *
 *         Note: You must return the copy of the given head as a reference to
 *         cloned list.
 *
 *         Solution: 
 *         1.> Traverse the original list and clone the nodes as you
 *         go and place the cloned copy next to its original node. This new
 *         linked list is essentially an interweaving/separating of original and
 *         cloned nodes.
 *         
 *         2.> Iterate the list having both the new and old nodes
 *         intertwined with each other and use the original nodes’ random
 *         pointers to assign references to random pointers for cloned nodes.
 *         For eg. If B has a random pointer to A, this means B' has a random
 *         pointer to A'.
 *         
 *         3.> Unweaving/separating the linked lists
 *
 *         Also, refer
 *         https://medium.com/@abhimanyu.rana117/copy-a-linked-list-with-random-pointers-3e99b48281ce{Pictorial
 *         depiction}
 *
 *         Time Complexity = O(N) Space Complexity =o(1)
 */
public class CopyListRandomPointer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Node head = new Node();
		head.val = 1;
		head.next = new Node();
		head.random = head.next;

		head.next.val = 2;
		head.next.next = null;
		head.next.random = head.next;

		CopyListRandomPointer obj = new CopyListRandomPointer();
		Node new_head = obj.copyRandomList(head);
		System.out.println("Original List-Node");
		obj.print(head);
		System.out.println("********************");
		System.out.println("Deep Copied List-Node");
		obj.print(new_head);
	}

	private void print(Node head) {
		System.out.println("Node Val = " + head.val);
		System.out.println("Node Random Node Val = " + head.random.val);
		head = head.next;
	}

	/**
	 *
	 * @param head
	 * @return
	 *
	 */
	private Node copyRandomList(Node head) {
		if (head == null) {
			return null;
		}
// 1.> Insert new node after each original node
		Node tmp_head = head;
		while (tmp_head != null) {
			Node newNode = new Node();
			newNode.val = tmp_head.val;
			newNode.next = tmp_head.next;
			tmp_head.next = newNode;
			tmp_head = newNode.next;
		}

// 2.> set random pointer
		tmp_head = head; // Reset to head
		while (tmp_head != null) {
			tmp_head.next.random = tmp_head.random != null ? tmp_head.random.next : null; // head.random.next = Node to
																							// which Random is connected
																							// to
			tmp_head = tmp_head.next.next;
		}

// 3.> Unweaving/Separating the linked lists
		Node new_head = head.next; // final result
		tmp_head = head; // Reset to head
		Node temp_new_head = head.next;
		while (tmp_head != null) {
			tmp_head.next = tmp_head.next.next;
			temp_new_head.next = temp_new_head.next != null ? temp_new_head.next.next : null;
			tmp_head = tmp_head.next;
			temp_new_head = temp_new_head.next;
		}
		return new_head;
	}

	static class Node {
		int val;
		Node next;
		Node random;

		Node() {
		}

		Node(int val, Node next, Node random) {
			this.val = val;
			this.next = next;
			this.random = random;
		}
	}

}
