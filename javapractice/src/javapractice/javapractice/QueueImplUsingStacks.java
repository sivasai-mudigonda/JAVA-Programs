package javapractice;

import java.util.Stack;

/**
 * @author u230107
 *
 */
public class QueueImplUsingStacks {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		enQueue(5);
		enQueue(6);
		enQueue(7);
		enQueue(8);
		deQueue();
	}

	static Stack s1 = new Stack();
	static Stack s2 = new Stack();
	static int statckSize = 10;

	private static void enQueue(int n) {
		if (s1.size() == 10) {
			System.out.println("Stack is full");
			return;
		}
		s1.push(n);
		System.out.println("Element inserted =" + n);
	}

	private static void deQueue() {
		if (s1.isEmpty()) {
			System.out.println("Stack is empty");
			return;
		}
		while (s1.size() > 0) {
			s2.push(s1.pop());
		}
		System.out.println("Element Popped = " + s2.pop());
		while (s2.size() > 0) {
			s1.push(s2.pop());
		}
	}

}