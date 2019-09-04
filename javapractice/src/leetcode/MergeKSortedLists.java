/**
 * 
 */
package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author SIVA SAI
 *
 */
public class MergeKSortedLists {

	/**
	 * @param args
	 * 
	 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
	 * 
	 * Refer https://www.programcreek.com/2013/02/leetcode-merge-k-sorted-lists-java/
	 * 
	 * Time Complexity = O(log k)*N
	 * Space Complexity = o(1) --> For one priority Queue
	 */
	public static void main(String[] args) {
		
		//{34,87,96},{11,56,88},{88,93,95}
		ListNode head1=new ListNode(34);
		head1.next=new ListNode(87);
		head1.next.next=new ListNode(96);
		
		ListNode head2=new ListNode(11);
		head2.next=new ListNode(56);
		head2.next.next=new ListNode(88);
		
		ListNode head3=new ListNode(88);
		head3.next=new ListNode(93);
		head3.next.next=new ListNode(95);
		
		ListNode[] lists= {head1,head2,head3};
		ListNode res=mergeLists(lists);
		
		printListNode(res);
	}
	
	private static void printListNode(ListNode li) {
		while(li!=null) {
			System.out.println(li.data);
			li=li.next;
		}
	}
	
	private static ListNode mergeLists(ListNode[] lists) {
		if(lists==null || lists.length==0) {
			return null;
		}
		PriorityQueue<ListNode> pq= new PriorityQueue<ListNode>(new Comparator<ListNode>() {
			public int compare(ListNode l1, ListNode l2) {
				return l1.data-l2.data;
			}
		});
				
		for(ListNode li:lists) {
			if(li!=null) {
				pq.add(li);
			}
		}
		
		ListNode head= new ListNode(0);
		ListNode temp=head;
		while(!pq.isEmpty() ){
			ListNode li = pq.poll();
			temp.next=li;
			temp=temp.next;
			if(li.next!=null ){
				pq.add(li.next);
				
			}
		}
		return head.next;
	}
}
