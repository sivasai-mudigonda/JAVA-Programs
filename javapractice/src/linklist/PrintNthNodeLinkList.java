package linklist;

import java.util.Iterator;
import java.util.LinkedList;

/*
* Implement an algorithm to !nd the nth to last element of a singly linked list.
*/
public class PrintNthNodeLinkList {

	static int N = 3;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<String> linkLst = new LinkedList<>();
		linkLst.add("hello");
		linkLst.add("world");
		linkLst.add("welcome");
		linkLst.add("hai");
		linkLst.add("buddy");
		printNthNode(linkLst);
	}

	@SuppressWarnings("rawtypes")
	private static void printNthNode(LinkedList linkLst) {

		if (linkLst == null) {
			System.out.println("List is empty");
		}

		LinkedList refLinkLst = linkLst;
		Iterator it = linkLst.iterator();
		for (int i = 0; i < N; i++) {
			it.next();
		}

		Iterator refIt = refLinkLst.iterator();
		while (it.hasNext()) {
			it.next();
			refIt.next();
		}
		System.out.println(N + " Element from last is " + refIt.next());
	}

}
