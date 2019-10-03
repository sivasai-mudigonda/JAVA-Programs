/**
 * 
 */
package leetcode;

/**
 * @author SivaM
 * 
 * LeetCode Ques - 148 {Sort List}
 * https://leetcode.com/problems/sort-list/
 * 
 * Sort a linked list in O(n log n) time using constant space complexity.
 * 
	Example 1:
	
	Input: 4->2->1->3
	Output: 1->2->3->4
	Example 2:
	
	Input: -1->5->3->4->0
	Output: -1->0->3->4->5
 *
 * For solution, refer 
 * https://medium.com/@desolution/%E5%BE%9Eleetcode%E5%AD%B8%E6%BC%94%E7%AE%97%E6%B3%95-36-merge-sort-1-21dde785b0df
 * 
 * Time Complexity = O(N)
 * Space Complexity = o(1) 
 */
public class SortList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//4->2->1->3
		SortList obj = new SortList();
		
		ListNode head = obj.new ListNode(4);
		head.next = obj.new ListNode(2);
		head.next.next = obj.new ListNode(1);
		head.next.next.next = obj.new ListNode(3);
		System.out.println("*************Original List*************");
		obj.print(head);
		ListNode result_li = obj.sortList(head);
		System.out.println("*************Sorted List*************");
		obj.print(result_li); // Expected Output = 1	2	3	4
		
		System.out.println("**********************************");
		
		ListNode head2 = obj.new ListNode(1);
		head2.next = obj.new ListNode(5);
		head2.next.next = obj.new ListNode(3);
		head2.next.next.next = obj.new ListNode(4);
		head2.next.next.next.next = obj.new ListNode(0);
		System.out.println("*************Original List*************");
		obj.print(head2);
		ListNode result_li2 = obj.sortList(head2);
		System.out.println("*************Sorted List*************");
		obj.print(result_li2); // Expected Output = 0	1	3	4	5
	}
	
	private void print(ListNode head) {
		while(head!=null) {
			System.out.print(head.val+"\t");
			head = head.next;
		}
		System.out.println();
	}
	
	/**
	 * 
	 * @param head
	 * @return
	 * 
	 * Split & Merge Approach
	 * Split original list in to two list by using prev,slow and fast pointers.
	 * Follow this process recursively
	 * Provide those lists to mergeSort() method for sorting.
	 */
	public ListNode sortList(ListNode head ){
		if(head==null || head.next==null) {
			return head;
		}
		ListNode prev=null, slow=head, fast=head;
		while(fast!=null && fast.next!=null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;		
		}
		prev.next =null; // Break connection between head and slow pointers
		
		// sort each half
		ListNode list_1 = sortList(slow);
		ListNode list_2 = sortList(head);
		return merge_helper(list_1,list_2);
    }
	
	/**
	 * 
	 * @param node1
	 * @param node2
	 * @return
	 * 
	 * Merge-Sort
	 */
	public ListNode merge_helper(ListNode node1, ListNode node2) {
		ListNode result_head = new ListNode(0);
		ListNode temp_head = result_head;
		while(node1!=null && node2!=null) {
		  	if(node1.val<node2.val) {
		  		temp_head.next = new ListNode(node1.val);
		  		node1 = node1.next;
		  	} else if(node2.val<node1.val) {
		  		temp_head.next = new ListNode(node2.val);
		  		node2 = node2.next;
		  	}
		  	temp_head = temp_head.next;
		}
		
		if(node1!=null) {
			temp_head.next = node1;
		}
		
		if(node2!=null) {
			temp_head.next = node2;
		}
		return result_head.next;
	}
	
	public class ListNode {
		 int val;
		 ListNode next;
		 ListNode(int x) {
			 val = x; 
		 }
	}
}
