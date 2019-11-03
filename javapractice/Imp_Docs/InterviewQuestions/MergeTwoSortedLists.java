/**
 * 
 */
package Interviews;

import leetcode.ListNode;

/**
 * @author SivaM
 *
 *Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

Example:

Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4
 *
 *
 *Sol : https://github.com/chubbysingh/coding/blob/master/src/Leetcode/Q021_Merge_Two_Sorted_Lists.java
 *
 *Time Complexity = O(n)
 *Space Complexity = o(m + n) where m and n are two lists.
 *
 */
public class MergeTwoSortedLists {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ListNode head1 = new ListNode(5); 
	    head1.next = new ListNode(10); 
	    head1.next.next = new ListNode(15); 
	    head1.printList(head1);
	    System.out.println("***************************");
	    
	    ListNode head2 = new ListNode(2); 
	    head2.next = new ListNode(3); 
	    head2.next.next = new ListNode(20);
	    head2.printList(head2);
	    System.out.println("***************************");
	    
	    ListNode resHead = mergeTwoLists(head1,head2);
	    head2.printList(resHead);
	}
	
	 private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
	        ListNode result = new ListNode(0);
	        ListNode resHead = result;
	        int data=0;
	        while(l1!=null && l2!=null) {
	        	if(l1.data<l2.data) {
	        		data = l1.data;
	        		l1 = l1.next;
	        	} else {
	        		data = l2.data;
	        		l2 = l2.next;
	        	}
	        	
	        	result.next=new ListNode(data);
	        	result = result.next;
	        }
	        if(l1==null) {
	        	result.next = l2;
	        } else if(l2!=null) {
	        	result.next = l1;
	        }
	        return resHead.next;
	 }
}