/**
 * 
 */
package leetcode;

/**
* @author u230107
*
* LeetCode Ques - 328 {Odd Even Linked List} {Medium}
* https://leetcode.com/problems/odd-even-linked-list/
*
* Given a singly linked list, group all odd nodes together followed by the even nodes.
* Please note here we are talking about the node number and not the value in the nodes.
* You should try to do it in place.
* The program should run in O(1) space complexity and O(nodes) time complexity.
*
	Example 1:
	Input: 1->2->3->4->5->NULL
	Output: 1->3->5->2->4->NULL
	
	Example 2:
	Input: 2->1->3->5->6->4->7->NULL
	Output: 2->3->6->7->1->5->4->NULL
*
* Note:
* The relative order inside both the even and odd groups should remain as it was in the input.
* The first node is considered odd, the second node even and so on...
*
* Solution:
* We need to use 2 pointers.
* 1.> Start with pointers at first and second node.
* 2.> Hop first pointer over second by making link from first to third and then moving pointer from first to third node.
* 3.> Hop the second pointer over first pointer (currently pointed at third node) similarly Keep hopping until the end of list.
* 4.> Link the first pointer which is at the end of odd list to the second node which is the start of the even list
*
* Time Complexity = O(N) - Linear Time
* At each iteration it jumps two nodes for assigning new odd and even tail.
* So time complexity is O(n/2) = O(n) if n denotes to counts of nodes in this linked list.
*
* Space Complexity = o(1) - Constant Space
*
*/

public class OddEvenLinkedList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		OddEvenLinkedList obj = new OddEvenLinkedList();

		ListNode head = obj.new ListNode(1);
		head.next = obj.new ListNode(2);
		head.next.next = obj.new ListNode(3);
		head.next.next.next = obj.new ListNode(4);
		head.next.next.next.next = obj.new ListNode(5);
		obj.print(head);
		ListNode result = obj.oddEvenList(head);
		obj.print(result); // Expected Output = 1->3->5->2->4->NULL

		System.out.println("**************************");

		head = obj.new ListNode(2);
		head.next = obj.new ListNode(1);
		head.next.next = obj.new ListNode(3);
		head.next.next.next = obj.new ListNode(5);
		head.next.next.next.next = obj.new ListNode(6);
		head.next.next.next.next.next = obj.new ListNode(4);
		head.next.next.next.next.next.next = obj.new ListNode(7);
		obj.print(head);
		result = obj.oddEvenList(head);
		obj.print(result); // Expected Output = 2->3->6->7->1->5->4->NULL
	}

	public ListNode oddEvenList(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode result = head;
		ListNode oddNode = head; // head node is considered as 1st node
		ListNode evenNode = head.next; // 2nd Node
		ListNode connectEvenNode = head.next;
		while (oddNode != null && evenNode != null) {
			ListNode temp = evenNode.next;
			if (temp == null) { // p2's next will point to next available node in the List.
				break;
			}
			oddNode.next = evenNode.next;
			oddNode = oddNode.next;

			evenNode.next = oddNode.next;
			evenNode = evenNode.next;
		}
		oddNode.next = connectEvenNode;
		return result;
	}

	private void print(ListNode node) {
		while (node != null) {
			System.out.print(node.val + "->");
			node = node.next;
		}
		System.out.println("null");
	}

	class ListNode {
		int val;
		ListNode next;

		ListNode(int val) {
			this.val = val;
		}
	}
}
