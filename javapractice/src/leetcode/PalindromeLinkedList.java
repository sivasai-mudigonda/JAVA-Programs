/**
 * 
 */
package leetcode;

/**
 * @author SivaM
 *
 * LeetCode Ques - 234 {Palindrome Linked List}
 * https://leetcode.com/problems/palindrome-linked-list/
 * 
 * Given a singly linked list, determine if it is a palindrome.
 * 
	Example 1:
	Input: 1->2
	Output: false
	
	Example 2:
	Input: 1->2->2->1
	Output: true
 *
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 * 
 * Time Complexity = O(N) - Iterate over linked list{Linear time Complexity}
 * Space Complexity = O(1) - Constant space
 */
public class PalindromeLinkedList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PalindromeLinkedList obj = new PalindromeLinkedList();
		
		ListNode head = obj.new ListNode(1);
		head.next = obj.new ListNode(2);
		System.out.println("Is Linked List Palindrome = " +obj.isPalindrome(head)); // Expected Output = false
		
		head=null;
		head = obj.new ListNode(1);
		head.next = obj.new ListNode(2);
		head.next.next = obj.new ListNode(2);
		head.next.next.next = obj.new ListNode(1);
		System.out.println("Is Linked List Palindrome = " +obj.isPalindrome(head)); // Expected Output = true
	}
	
	/**
	 * 
	 * @param head
	 * @return
	 * 
	 * Floyd's cycle theorem {2 pointers}
	 */
	public boolean isPalindrome(ListNode head ){
		if(head==null || head.next==null) {
			return true;
		}
		// 1.> Use slow and fast pointers for find mid node.
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null) {
        	slow = slow.next;
        	fast = fast.next.next;
        }
        
        // 2.> Reverse the second half list
		slow = reverse(slow);
		
		// 3.> Match each element in the first half list{head} and reversed second half list{slow}
		while(head!=null && slow!=null) {
			if(head.val!=slow.val) {
				return false;
			}
			head = head.next;
			slow = slow.next;
		}
		return true;
    }
	
	/**
	 * 
	 * @param head
	 * @return
	 * 
	 * Reverse Linked List
	 */
	private ListNode reverse(ListNode head) {
		ListNode prev=null;
		while(head!=null) {
			ListNode tmp = head.next;
			head.next = prev;
			prev = head;
			head = tmp;
		}
		return prev;
	}
	
	class ListNode {
		int val;
		ListNode next;
		
		ListNode(int val){
			this.val = val;
		}
	}
}
