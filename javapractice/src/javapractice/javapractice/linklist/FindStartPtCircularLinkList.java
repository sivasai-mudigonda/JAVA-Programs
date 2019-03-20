package javapractice.linklist;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javapractice.linklist.LinkedList.Node;

/*
* Given a circular linked list, implement an algorithm which returns node at the beginning
* of the loop.
* DEFINITION
* Circular linked list: A (corrupt) linked list in which a node’s next pointer points to an
* earlier node, so as to make a loop in the linked list.
* EXAMPLE
* input: A -> B -> C -> D -> E -> C [the same C as earlier]
* output: C
* 
* SOL:
* 1. Head is k nodes from LoopStart (by definition).
* 2. MeetingPoint for n1 and n2 is k nodes from LoopStart
*/
public class FindStartPtCircularLinkList {

	public static void main(String[] args) {
		LinkedList lst = new LinkedList();
		List<Integer> arrLst = new ArrayList<>();
		arrLst.add(1);
		arrLst.add(2);
		arrLst.add(3);
		arrLst.add(4);
		lst.push(arrLst.toArray());
		Node lastNode = lst.getLastNode(); // Loop start point is 4
		lastNode.next = lst.head;
		System.out.println("Hashing Approach");
		Node cirstartPt = findLoopStartPt(lst.head);
		lst.printList(cirstartPt);

		System.out.println("Two Pointer Approach");
		cirstartPt = findLoopStartPtTwoPt(lst.head);
		lst.printList(cirstartPt);
	}

	// Using Hashing
	private static Node findLoopStartPt(Node n) {
		Set<Integer> uniqSet = new HashSet<>();
		while (n != null) {
			if (uniqSet.contains(n.data)) {
				return new Node(n.data);
			}
			uniqSet.add(n.data);
			n = n.next;
		}
		return null;
	}

	// Using 2 pointers
	private static Node findLoopStartPtTwoPt(Node n) {
		if (n == null) {
			return null;
		}
		// Two pointers
		Node n1 = n;
		Node n2 = n;

		// Find meeting point
		while (n2.next != null) {
			if (n1.data == n2.data) {
				break;
			}
			n1 = n1.next;
			n2 = n2.next.next;// Twice the speed
		}

		// Error check- there is no meeting point, and therefore no loop
		if (n2.next == null) {
			System.out.println("There is no meeting point");
			return null;
		}
		n1 = n;
		/*
		 * Move n1 to Head. Keep n2 at Meeting Point. Each are k steps from the Loop
		 * Start. If they move at the same pace, they must meet at Loop Start.
		 */
		while (n1 != n2) {
			n1 = n1.next;
			n2 = n2.next;
		}

		// Now n2 points to the start of the loop.
		return new Node(n2.data);
	}

}