package javapractice.linklist;

public class LinkedList {
	Node head;
	
	public void printList(Node node){
		while(node!=null) {
			System.out.println(node.data);
			node=node.next;
		}
	}
}

class Node {
	int data;
	Node next;

	Node(int data) {
		this.data = data;
		next = null;
	}

}
