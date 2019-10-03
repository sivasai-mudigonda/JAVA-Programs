package leetcode;

/**
 * @author u230107
 *
 *         LeetCode Ques -141 {Linked List Cycle}
 *         https://leetcode.com/problems/linked-list-cycle/
 *
 *         Given a linked list, determine if it has a cycle in it. To represent
 *         a cycle in the given linked list, we use an integer pos which
 *         represents the position (0-indexed) in the linked list where tail
 *         connects to. If pos is -1, then there is no cycle in the linked list.
 *
 *         Example 1: Input: head = [3,2,0,-4], pos = 1 Output: true
 *         Explanation: There is a cycle in the linked list, where tail connects
 *         to the second node.
 * 
 *         Example 2: Input: head = [1,2], pos = 0 Output: true 
 *         Explanation:
 *         There is a cycle in the linked list, where tail connects to the first
 *         node.
 * 
 *         Example 3: Input: head = [1], pos = -1 Output: false 
 *         Explanation:
 *         There is no cycle in the linked list. Follow up: Can you solve it
 *         using O(1) (i.e. constant) memory?
 *
 *         Time Complexity = O(N) where N are nodes in linked list Space
 *         Complexity =o(1)
 */
public class LinkedListCycle {

	/**
	 * @param args
	 *
	 *  Inner class access in Outer class & vice versa
	 *  https://www.programiz.com/java-programming/nested-inner-class
	 */
	public static void main(String[] args) {
		LinkedListCycle obj = new LinkedListCycle();
		ListNode head = obj.new ListNode(3);
		head.next = obj.new ListNode(2);
		head.next.next = obj.new ListNode(0);
		head.next.next.next = obj.new ListNode(-4);
		head.next.next.next.next = head.next;
		System.out.println("Has Cycle = " + obj.hasCycle(head)); // Expected Output = true

		head = null;
		head = obj.new ListNode(1);
		head.next = obj.new ListNode(2);
		System.out.println("Has Cycle = " + obj.hasCycle(head)); // Expected Output = false

		head = null;
		head = obj.new ListNode(1);
		System.out.println("Has Cycle = " + obj.hasCycle(head)); // Expected Output = false
	}

	private boolean hasCycle(ListNode head) {
		if (head == null) {
			return false;
		}
		ListNode n1 = head;
		ListNode n2 = head;

		while (n2!=null && n2.next!=null ){
			n1 = n1.next; // slow pointer
			n2 = n2.next.next; // fast pointer
			if (n1 == n2) {
				// meeting point
				return true;
			}
		}
		return false;
	}

	class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}
	}

}
