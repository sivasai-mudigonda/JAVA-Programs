/**
 * 
 */
package leetcode;

/**
 * @author SivaM
 *
 */
public class ListNode {
	public int data;
	public ListNode next;

	public ListNode(int data) {
		this.data = data;
		next = null;
	}
	
	public void printList(ListNode node) {
		while (node != null) {
			System.out.println(node.data);
			node = node.next;
		}
	}
}
