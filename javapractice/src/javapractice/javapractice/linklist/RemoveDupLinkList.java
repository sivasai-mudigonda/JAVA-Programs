package javapractice.linklist;

import java.util.HashSet;
import java.util.Set;

public class RemoveDupLinkList {

	public static void main(String[] args) {
		LinkList lst= new LinkList();
		lst.node=new LinkListNode(4);
		lst.node.next=new LinkListNode(7);
		lst.node.next.next=new LinkListNode(4);
		printLinkedList(lst.node);
		RemDupExtBuff(lst.node);
		System.out.println("*********************");
		printLinkedList(lst.node);
		System.out.println("----------------------");
		LinkList lst1= new LinkList();
		lst1.node=new LinkListNode(4);
		lst1.node.next=new LinkListNode(7);
		lst1.node.next.next=new LinkListNode(4);
		printLinkedList(lst1.node);
		RemDup(lst1.node);
		System.out.println("*********************");
		printLinkedList(lst1.node);
	}
	
	// Without using Extra buffer
	private static void RemDup(LinkListNode lst) {
		if(lst==null ) {
			return;
		}
		LinkListNode runner = null;
		while(lst!=null) {
			runner=lst;
			while(runner.next!=null) {
				if(lst.data==runner.next.data) {
					runner.next=runner.next.next;
				} else {
					runner=runner.next;
				}
			}
			lst=lst.next;
		}
	}
	
	// Using Extra Buffer
	private static void RemDupExtBuff(LinkListNode lst) {
		if(lst==null ) {
			return;
		}
		LinkListNode runner= lst;
		Set<Integer> uniqNodes= new HashSet<>();
		
		while(lst!=null ){
			if(uniqNodes.contains(lst.data) ) {
				runner.next=lst.next;
			}
			uniqNodes.add(lst.data);
			runner=lst;
			lst=lst.next;
		}
	}
	
	private static void printLinkedList(LinkListNode lst) {
		while(lst!=null) {
			System.out.println(lst.data);
			lst=lst.next;
		}
	}
}

class LinkList{
	LinkListNode node;
}

class LinkListNode{
	int data;
	LinkListNode next;
	
	LinkListNode(int data){
		this.data= data;
		next=null;
	}
}