package leetcode;

/**
 * @author u230107
 *
 *         LeetCode Ques - 24 {Swap Nodes in Pairs}
 *         https://leetcode.com/problems/swap-nodes-in-pairs/
 *
 *         Given a linked list, swap every two adjacent nodes and return its
 *         head. You may not modify the values in the list’s nodes, only nodes
 *         itself may be changed.
 *
 *         For example, 
 *         Given 1->2->3->4, 
 *         you should return the list as 2->1->4->3.
 *
 *         Time Complexity = O(N) Space Complexity =o(1)
 */
public class SwapNodesInPairs {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SwapNodesInPairs obj = new SwapNodesInPairs();
		ListNode head = obj.new ListNode(1);
		head.next = obj.new ListNode(2);
		head.next.next = obj.new ListNode(3);
		head.next.next.next = obj.new ListNode(4);
		obj.printNodes(head);
		ListNode result_head = obj.swapPairs(head);
		System.out.println("**********AFTER ADJACENT NODES SWAP***********");
		obj.printNodes(result_head);
	}

	private void printNodes(ListNode head) {
		while (head != null) {
			System.out.print(head.val + " -->" + "\t");
			head = head.next;
		}
		System.out.println("null");
	}

	/**
	 *
	 * @param head
	 * @return
	 *
	 *         Input : 1->2-3->4 Expected Output : 2->1->4->3
	 *
	 *         Initialize three pointers. Below are the desciption abt them 1.>
	 *         previous - Point to dummy head{0} 2.> current - Point to head{1} 3.>
	 *         next{Inside While Loop} = Point to head.next{2}
	 *
	 *         Steps inside while loop 1.> current.next = next.next Modify node 1's
	 *         "next" to point to node 3. 2.> previous.next = next Modify node
	 *         0's{dummy node} "next" to point to node 2. 3.> next.next = current
	 *         Modify node 2's "next" to point to node 1.
	 *
	 *         ****** SWAP Completed*******
	 *
	 *         4.> previous = previous.next.next Modify Previous to point to Node 1.
	 *
	 *         5.> current = current.next Modify current to point to Node 3.
	 *
	 *         Repeat all 5 steps in while loop until current becomes null.
	 *
	 */
	public ListNode swapPairs(ListNode head) {
		ListNode result = new ListNode(0);
		result.next = head; // 0 1 2 3 4
		ListNode previous = result; // 0 1 2 3 4
		ListNode current = head; // 1 2 3 4
		while (current != null) {
			ListNode next = current.next; // 2 3 4
			if (next != null) {
				current.next = next.next; // 1 {2 3} => 1 {3 4}
				// printNodes(current);
				previous.next = next; // 0 {1 3 4} => 0 {2 3 4}
				// printNodes(previous);
				next.next = current; // 2 {3 4} => 2 {1 3 4}
				// printNodes(next);
				previous = previous.next.next; // {0 2 1 3 4} => 1 3 4
				// printNodes(previous);
				current = current.next; // 1 {3 4} => {3 4}
				// printNodes(current);
			} else {
				current = current.next;
			}
		}
		return result.next;
	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int val) {
			this.val = val;
		}
	}

}
