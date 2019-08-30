package leetcode;

import java.util.ArrayList;
import java.util.List;

import linklist.LinkedList;

/*
* You have two numbers represented by a linked list, where each node contains a single
* digit. The digits are stored in reverse order, such that the 1’s digit is at the head of
* the list. Write a function that adds the two numbers and returns the sum as a linked
* list.
* EXAMPLE
* Input: (3 -> 1 -> 5), (5 -> 9 -> 2)
* Output: 8 -> 0 -> 8
*/
public class AddDigitsLinkList {

	public static void main(String[] args) {
		LinkedList linkLst1 = new LinkedList();
		List<Integer> lst1= new ArrayList<Integer>();
		lst1.add(6);
		lst1.add(7);
		lst1.add(8);
		linkLst1.push(lst1.toArray());
		linkLst1.printList(linkLst1.head);
		
		System.out.println("********************");
		LinkedList linkLst2 = new LinkedList();
		List<Integer> lst2= new ArrayList<>();
		lst2.add(1);
		lst2.add(3);
		lst2.add(4);
		lst2.add(9);
		linkLst2.push(lst2.toArray());
		linkLst2.printList(linkLst2.head);
		
		System.out.println("********Using Loop************");
		LinkedList resultLst = addDigits(linkLst1.head, linkLst2.head);
		resultLst.printList(resultLst.head);

		System.out.println("*********Using Recursion***********");
		resultLst.head = addDigitsUsingRecurssion(linkLst1.head, linkLst2.head, null, 0);
		resultLst.printList(resultLst.head);
	}

	// Using Recursive
	static LinkedList result = null;
	static Node prev;
	private static Node addDigitsUsingRecurssion(Node d1, Node d2, Node res, int carry) {
		
		if (d1 == null && d2 == null && carry==0) {
			return null;
		}
		int sum=carry;
		if(d1!=null) {
			sum+=d1.data;
		}
		
		if(d2!=null) {
			sum+=d2.data;
		}
		if(sum>9) {
			carry=1;
		} else {
			carry=0;
		}
		res=new Node(sum%10);
		if(result==null) {
			result= new LinkedList();
			prev=result.head=res;
			addDigitsUsingRecurssion( (d1!=null?d1.next:null),(d2!=null?d2.next:null),res,carry);
		} else {
			prev.next=res;
			prev=prev.next;
			addDigitsUsingRecurssion( (d1!=null?d1.next:null),(d2!=null?d2.next:null),res,carry);
		}
		
		if (d1 == null && d2 == null && carry>0) {
			prev.next=new Node(carry);
		}
		return result.head;
	}
	
	

	// Using Dynamic Programming{Loop}
	private static LinkedList addDigits(Node d1, Node d2) {
		LinkedList result = null;
		Node prev = null, temp = null;
		int sum, carry = 0;
		if (d1 == null && d2 == null) {
			return result;
		}
		while (d1 != null || d2 != null) {
			sum = (d1 != null ? d1.data : 0) + (d2 != null ? d2.data : 0) + carry;
			if (sum > 9) {
				carry = 1;
			} else {
				carry = 0;
			}
			temp = new Node(sum % 10);
			if (result == null) {
				result = new LinkedList();
				result.head = temp;
			} else {
				prev.next = temp;
			}
			prev = temp;
			if (d1 != null) {
				d1 = d1.next;
			}
			if (d2 != null) {
				d2 = d2.next;
			}
		}
		if (carry > 0) {
			temp.next = new Node(carry);
		}
		return result;
	}
}