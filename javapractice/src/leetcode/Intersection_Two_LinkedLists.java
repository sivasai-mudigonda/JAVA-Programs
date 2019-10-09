/**
 * 
 */
package leetcode;

/**
 * @author SivaM
 * LeetCode - 160 {Intersection of Two Linked Lists}
 * https://leetcode.com/problems/intersection-of-two-linked-lists/
 * 
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 * 
	For example, the following two linked lists:
	begin to intersect at node c1.
	Example 1:
	Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
	Output: Reference of the node with value = 8
	Input Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect). 
	From the head of A, it reads as [4,1,8,4,5]. 
	From the head of B, it reads as [5,0,1,8,4,5]. 
	There are 2 nodes before the intersected node in A; 
	There are 3 nodes before the intersected node in B.
	
	Example 2:
	Input: intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
	Output: Reference of the node with value = 2
	Input Explanation: The intersected node's value is 2 (note that this must not be 0 if the two lists intersect). 
	From the head of A, it reads as [0,9,1,2,4]. 
	From the head of B, it reads as [3,2,4]. 
	There are 3 nodes before the intersected node in A; 
	There are 1 node before the intersected node in B.
	 
	Example 3:
	Input: intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
	Output: null
	Input Explanation: From the head of A, it reads as [2,6,4]. 
	From the head of B, it reads as [1,5]. 
	Since the two lists do not intersect, intersectVal must be 0, while skipA and skipB can be arbitrary values.
	Explanation: The two lists do not intersect, so return null.
 *
 * Notes:
 * If the two linked lists have no intersection at all, return null.
 * The linked lists must retain their original structure after the function returns.
 * You may assume there are no cycles anywhere in the entire linked structure.
 * Your code should preferably run in O(n) time and use only O(1) memory.
 * 
 * Solution:
 * Use two pointers which are assigned to corresponding heads of these two lists. 
 * In each iteration, check each node they point to are equal or not and move to their next node if not. 
 * Once a pointer reaches the end of a list, assign it to the head of another list.
 * Explanation:
 * if they have same length, only traversal once,
 * if they have different length, at most traversal twice, they would be meet,
 * because each pointer go through A and B once.
 * 
 * Time Complexity:O(M+N) Where M and N are lengths of two lists that need to be traversed.
 * Space Complexity:o(1)
 * 
 */
public class Intersection_Two_LinkedLists {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Intersection_Two_LinkedLists obj = new Intersection_Two_LinkedLists();
		ListNode intersection = obj.new ListNode(8);
		intersection.next = obj.new ListNode(4);
		intersection.next.next = obj.new ListNode(5);
		
		ListNode l1 = obj.new ListNode(4);
		l1.next = obj.new ListNode(1);
		l1.next.next= intersection;
		
		ListNode l2 = obj.new ListNode(5);
		l2.next = obj.new ListNode(0);
		l2.next.next = obj.new ListNode(1);
		l2.next.next.next = intersection;
		
		ListNode result_head = obj.getIntersectionNode(l1,l2);
		if(result_head==intersection ){
			System.out.println("Node Intersected At : ");
			obj.print(result_head);
		}
		
		System.out.println("****************");
		intersection=null;
		l1=null;
		l2=null;
		
		intersection = obj.new ListNode(2);
		intersection.next = obj.new ListNode(4);
		
		l1 = obj.new ListNode(0);
		l1.next = obj.new ListNode(9);
		l1.next.next = obj.new ListNode(1);
		l1.next.next.next= intersection;
		
		l2 = obj.new ListNode(3);
		l2.next=intersection;
		
		result_head = obj.getIntersectionNode(l1,l2);
		if(result_head==intersection ){
			System.out.println("Node Intersected At : ");
			obj.print(result_head);
		}
		
		System.out.println("****************");
		intersection=null;
		l1=null;
		l2=null;
		
		l1 = obj.new ListNode(2);
		l1.next = obj.new ListNode(6);
		l1.next.next = obj.new ListNode(4);
		
		l2 = obj.new ListNode(1);
		l2.next = obj.new ListNode(5);
		
		result_head = obj.getIntersectionNode(l1,l2);
		if(result_head == intersection ){
			System.out.println("Node Intersected At : ");
			obj.print(result_head);
		}
	}
	
	private void print(ListNode li) {
		while(li!=null) {
			System.out.print(li.val + "->");
			li = li.next;
		}
		System.out.println("null");
	}
	
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		ListNode temp_headA=headA;
		ListNode temp_headB=headB;
		
		while(temp_headA!=temp_headB){
			temp_headA = temp_headA!=null?temp_headA.next:headB;
			temp_headB = temp_headB!=null?temp_headB.next:headA;
		}
		return temp_headA;
	}
	
	public class ListNode{
		int val;
		ListNode next;
		ListNode(int val){
			this.val = val;
		}
	}

}
