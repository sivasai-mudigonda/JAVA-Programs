package leetcode;

import java.util.Stack;

import org.junit.Test;

/*
 * Leet Code Ques = https://leetcode.com/problems/min-stack/
* Refer to " https://www.geeksforgeeks.org/find-maximum-in-a-stack-in-o1-time-and-o1-extra-space/
* 
* To Find Min:
* IF X < current minEle
* PUSH(x): {x is the original element}
* 2 * x – prev minEle = y {y is pushed in to stack}
* && 
* x will be marked as current minEle
* POP(y):
* 2 * x{current minEle} – y = prev minEle
 
* To Find Max:
* if X > maxEle
* PUSH(x): {x is the original element}
* 2 * x – prev maxEle = y {y is pushed in to stack}
* && 
* x will be marked as current maxEle
* POP(y):
* 2 * x{current maxEle} – y = prev maxEle
*/

public class MinStack {
	Stack<Integer> s; // Min Ele
	Stack<Integer> s1; // Max Ele
	Integer minEle;
	Integer maxEle;

	public MinStack() {
		s = new Stack<>();
		s1 = new Stack<>();
	}

	private void push(Integer val) {
		System.out.println("Element Inserted is " + val);
		if (s.isEmpty()) {
			minEle = val;
			s.push(val);

			maxEle = val;
			s1.push(val);
			return;
		}

		// For Min
		if (val < minEle) {
			s.push(2 * val - minEle);
			minEle = val;
		} else {
			s.push(val);
		}

		// For Max
		if (val > maxEle) {
			s1.push(2 * val - maxEle);
			maxEle = val;
		} else {
			s1.push(val);
		}
	}

	private void pop() {
		if (isStackEmpty()) {
			System.out.println("Stack is empty");
			return;
		}

		// For Min
		if (s.peek() < minEle) {
			System.out.println("Element removed{MIN STACK} is " + minEle);
			minEle = 2 * minEle - s.peek();
		} else {
			System.out.println("Element removed{MIN STACK} is " + s.peek());
		}
		s.pop();

		// For Max
		if (s1.peek() > maxEle) {
			System.out.println("Element removed{MAX STACK} is " + maxEle);
			maxEle = 2 * maxEle - s1.peek();
		} else {
			System.out.println("Element removed{MAX STACK} is " + s1.peek());
		}
		s1.pop();
	}

	private boolean isStackEmpty() {
		return s.isEmpty();
	}

	// TOP
	private void peek() {
		if (isStackEmpty()) {
			System.out.println("Stack is empty");
			return;
		}

		// For Min
		if (s.peek() < minEle) {
			System.out.println("Top of stack{MIN} ele is " + minEle);
		} else {
			System.out.println("Top of stack{MIN} ele is " + s.peek());
		}

		// For Max
		if (s1.peek() > maxEle) {
			System.out.println("Top of stack{MAX} ele is " + maxEle);
			return;
		}
		System.out.println("Top of stack ele{MAX} is " + s1.peek());
	}

	private void getMinMax() {
		if (isStackEmpty()) {
			System.out.println("Stack is empty");
			return;
		}
		System.out.println("Min Ele is " + minEle);
		System.out.println("Max Ele is " + maxEle);
	}

	@Test
	public void testgetMin() {
		MinStack getMin = new MinStack();
		getMin.push(3);
		getMin.push(5);
		getMin.getMinMax();
		getMin.push(2);
		getMin.push(1);
		getMin.push(7);
		getMin.push(19);
		getMin.getMinMax();
		getMin.pop();
		getMin.getMinMax();
		getMin.pop();
		getMin.pop();
		getMin.getMinMax();
		getMin.peek();
	}
}
