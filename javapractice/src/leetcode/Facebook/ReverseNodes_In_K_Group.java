package leetcode.Facebook;

/**
* @author u230107
*
* Leet-Code Ques - 25 {Reverse Nodes in k-Group} {HARD}
* https://leetcode.com/problems/reverse-nodes-in-k-group/
*
* Given a linked list,
* reverse the nodes of a linked list k at a time and return its modified list.
*
* k is a positive integer and is less than or equal to the length of the linked list.
* If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
*
	Example:
	Given this linked list: 1->2->3->4->5
	For k = 2, you should return: 2->1->4->3->5
	For k = 3, you should return: 3->2->1->4->5
*
* Note:
* Only constant extra memory is allowed.
* You may not alter the values in the list’s nodes, only nodes itself may be changed.
*
* Time Complexity = O(N) - each node only needs to flip once
* Space Complexity = o(1) - Constant Space
*
*/
public class ReverseNodes_In_K_Group {

	/**
	 * @param args
	 * @throws CloneNotSupportedException
	 */
	public static void main(String[] args) throws CloneNotSupportedException {
		ReverseNodes_In_K_Group obj = new ReverseNodes_In_K_Group();

		ListNode head = obj.new ListNode(1);
		head.next = obj.new ListNode(2);
		head.next.next = obj.new ListNode(3);
		head.next.next.next = obj.new ListNode(4);
		head.next.next.next.next = obj.new ListNode(5);
		ListNode cloneHead = head.clone();
		obj.print(head);
		int k = 2;
		ListNode reverseNodeHead = obj.reverseKGroup(head, k);
		obj.print(reverseNodeHead);

		System.out.println("********************************");

		obj.print(cloneHead);
		k = 3;
		reverseNodeHead = obj.reverseKGroup(cloneHead, k);
		obj.print(reverseNodeHead);
	}

	/**
	 *
	 * @param node
	 */
	private void print(ListNode node) {
		while (node != null) {
			System.out.print(node.val + "-->");
			node = node.next;
		}
		System.out.println("null");
	}

	/**
	 *
	 * @param head
	 * @param k
	 * @return
	 *
	 * 0 is neither +ve nor -ve 
	 * 1 is the first +ve number
	 *
	 */
	public ListNode reverseKGroup(ListNode head, int k) {
		if (head == null || head.next == null || k == 0 || k == 1) {
			return head;
		}
		ListNode dummyHead = new ListNode(0);
		dummyHead.next = head;
		ListNode prev = dummyHead;
		ListNode curr = head;
		int counter = 0;
		while (curr != null) {
			counter++;
			if (counter % k == 0) {
				prev = reverseKNodeHelper(prev, curr.next);
				curr = prev.next; // Assign curr to node after K-List{Nodes that got reversed so far}.
			} else {
				curr = curr.next;
			}
		}
		return dummyHead.next;
	}
	
	/**
	*
	* @param prev
	* @param end
	*
	* Step-1: {For k=2}
	* prev head curr next/end
	* 0 1 2 3
	*
	* Step-2:
	* prev curr/prev.next head next/end
	* 0 2 1 3
	* head:
	* After reversing, this will be the head of linked-list.
	* So, do not change it.
	*
	* k-list:
	* Range{SubList} of nodes that need to be reversed in a linked list.
	*
	* prev:
	* It is pointing to node starting before the k-list.
	*
	* Note:
	* Please refer Reverse Linked List program before understanding this logic.
	*
	*/
	private ListNode reverseKNodeHelper(ListNode prev, ListNode end) {
		ListNode next = null;
		ListNode head = prev.next;
		ListNode curr = head.next;
		while (curr != end) {
			next = curr.next;
			curr.next = prev.next; // Reversing Node. For k=2, connect Node-2's next with Node-1
			// Below step is for next iteration. For k=2, connect prev.next to Node-2 so that in next iteration we connect Node-3 to Node-2 using prev.next
			prev.next = curr;
			curr = next;
		}
		// Link head(It will be in last pos after reversal) of Reversed k-List with node immediately after k-List.
		head.next = end; // For k=2, Connecting Node-1's next with Node-3
		return head;
	}

	class ListNode implements Cloneable {
		int val;
		ListNode next;
		
		/**
		*
		* Advantages of clone method:
		*
		* Copy Reference
		* If we use assignment operator to assign an object reference to another reference variable,
		* then it will point to same address location of the old object and no new copy of the object will be created.
		* Due to this any changes in reference variable will be reflected in original object.
		*
		* Copy Constructor
		* If we use copy constructor, then we have to copy all of the data over explicitly
		* i.e. we have to reassign all the fields of the class in constructor explicitly.
		*
		* Clone Method:
		* But in clone method this work of creating a new copy is done by the method itself.
		* So to avoid extra processing we use object cloning.
		*
		* Deep-Cloning of ListNode
		* 
		*/
		@Override
		protected ListNode clone() throws CloneNotSupportedException {
			ListNode deepClone = (ListNode) super.clone();
			ListNode clonePtr = deepClone;
			while (clonePtr != null) {
				if (clonePtr.next != null) {
					clonePtr.next = clonePtr.next.clone();
				}
				clonePtr = clonePtr.next;
			}
			return deepClone;
		}

		ListNode(int val) {
			this.val = val;
			next = null;
		}
	}
}