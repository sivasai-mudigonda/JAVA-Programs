/**
 * 
 */
package leetcode;

/**
 * @author SivaM
 *
 */
public class ReverseLinkedList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ReverseLinkedList obj = new ReverseLinkedList();
		ListNode head = obj.new ListNode(1);
		head.next = obj.new ListNode(2);
		head.next.next = obj.new ListNode(3);
		head.next.next.next = obj.new ListNode(4);
		System.out.println("*******Before Reversing*******");
		obj.printNode(head);
		ListNode result_head = obj.reverseList_DP(head);
		System.out.println("***********After Reversing {Dynamic Programming}************");
		obj.printNode(result_head);
		
		System.out.println("*******Before Reversing*******");
		obj.printNode(head);
		result_head = obj.reverseList(head);
		System.out.println("***********After Reversing {Recurssive}************");
		obj.printNode(result_head);
	}
	
	private void printNode(ListNode head) {
		while(head!=null) {
			System.out.print(head.val+"->");
			head = head.next;
		}
		System.out.println();
	}
	
	/**
	 * 
	 * @param head
	 * @return
	 * 
	 * Dynamic Programming Approach
	 */
	public ListNode reverseList_DP(ListNode head) {
		if(head==null) {
			return head;
		}
		ListNode prev=null;
		ListNode current=head;
		while(current!=null ){
			ListNode temp = new ListNode(current.val); // {1->2->3->4->null} // {2->3->4} // {3->4} //{4}
			temp.next = prev;// {1->null} // {2->1->null} // 3->2->1->null} // {4->3->2->1->null}
			prev = temp; //{1->null} //{2->1->null} //{ 3->2->1->null} {4->3->2->1->null}
			current=current.next; // {2->3->4} // {3->4} // {4} //null
		}
		return prev;
	}
	
	/**
	 * 
	 * @param head
	 * @return
	 * 
	 * Recursive Programming Approach
	 */
	public ListNode reverseList(ListNode head) {
		if(head==null || head.next==null) {
			return head;
		}
		ListNode prev = reverseList(head.next); //{4}
		head.next.next=head; //{3->4->{3}}
		head.next = null; //{3->null}
		return prev; //{4}
	}
	
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int val) {
			this.val = val; 
		}
	}

}
