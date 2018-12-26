package javapractice.stacks_queues;

import static org.junit.Assert.*;
import java.util.Arrays;
import org.junit.Test;

/* https://www.youtube.com/watch?v=DxW7VAsdX0o

* Refer this video to understand the logic.
*
*/
public class ConvertArrayToNStacks {

	int[] top;
	int[] nextArr;
	int[] dataArr;
	int freeEle = 0;

	// 3 stacks, Array size is 3
	int stack = 3;
	int sizeOfArr = 3;

	public ConvertArrayToNStacks() {
		top = new int[stack];
		Arrays.fill(top, -1);

		nextArr = new int[sizeOfArr];
		dataArr = new int[sizeOfArr];

		for (int i = 0; i < nextArr.length; i++) {
			nextArr[i] = i + 1;
		}
		nextArr[sizeOfArr - 1] = -1; // Assign last element to -1 as there are no more free slots.
		Arrays.fill(dataArr, 0);
	}

	private boolean isFull() {
		return (freeEle == -1);
	}

	private void push(int stack, int val) {
		if (isFull()) {
			System.out.println("Stack is full");
			return;
		}

		// Allocate Free slot to current Index.
		int currentIndex = freeEle;

		// Put next available slot in freeEle.
		freeEle = nextArr[currentIndex];

		// Store Previous top to current index.
		nextArr[currentIndex] = top[stack];

		// store current index as top of stack.
		top[stack] = currentIndex;

		// Set Value in Arrya's current index
		dataArr[currentIndex] = val;
		System.out.println("Pushed Val = " + dataArr[currentIndex] + " in to " + stack + " stack");
	}

	private boolean isEmpty(int stack) {
		return (top[stack] == -1);
	}

	private Boolean pop(int stack) {
		if (isEmpty(stack)) {
			System.out.println("Stack is Empty");
			return false;
		}

		// Put index of top element in to current index.
		int currentIndex = top[stack];

		// Place previous top index to top of stack.
		top[stack] = nextArr[currentIndex];

		// Connect next free element by placing it to nextArr Current index.
		nextArr[currentIndex] = freeEle;

		// Mark current index as free element.
		freeEle = currentIndex;

		System.out.println("Popped Val = " + dataArr[currentIndex] + " in to " + stack + " stack");
		return true; // Return popped value
	}

	@Test
	public void testArrayToNStack() {
		ConvertArrayToNStacks ArrToStk = new ConvertArrayToNStacks();
		ArrToStk.push(0, 3);
		ArrToStk.push(1, 5);
		ArrToStk.push(2, 9);
		ArrToStk.push(2, 11);
		assertTrue(ArrToStk.pop(0));
		assertFalse(ArrToStk.pop(0));
		assertTrue(ArrToStk.pop(1));
		assertTrue(ArrToStk.pop(2));
		assertTrue(ArrToStk.pop(2));
	}

}