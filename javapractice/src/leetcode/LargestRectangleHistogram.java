package leetcode;

import java.util.Stack;

/**
 * @author u230107
 *
 *         LeetCode Ques -84 {Largest Rectangle in Histogram}
 *         https://leetcode.com/problems/largest-rectangle-in-histogram/
 *
 *         Given n non-negative integers representing the histogram’s bar height
 *         where the width of each bar is 1, find the area of largest rectangle
 *         in the histogram. Example : Input: [2,1,5,6,2,3] Output: 10
 *
 *         For solution, refer https://www.youtube.com/watch?v=ZmnqCZp9bBs Also,
 *         refer
 *         https://www.geeksforgeeks.org/largest-rectangle-under-histogram/ for
 *         more understanding on the problem
 *
 *         Time Complexity = O(N)- every element in the array is pushed only
 *         once and every element in the stack is eventually popped Space
 *         Complexity = o(N) - array elements inserted to stack
 */
public class LargestRectangleHistogram {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Area{Max} of Largest Rectangle= " + largestRectangleArea(new int[] { 2, 1, 5, 6, 2, 3 })); // Expected
																														// Output
																														// =
																														// 10
	}

	/**
	 * @param heights
	 * @return
	 *
	 *         Area of Rectangle = l*b l = height of bar{top} , b= Obtained by
	 *         popping bar{array index} in the stack
	 *
	 *         Techniques is to calculate area for with each bar{Width of each bar =
	 *         1} and see which one is the max.
	 *
	 *         Its immediately clear that the lengths of the feasible solutions have
	 *         a nested structure. The nested structures should be followed by a
	 *         voice in mind which says STACKS!
	 */
	private static int largestRectangleArea(int[] heights) {
		if (heights == null || heights.length == 0) {
			return 0;
		}
		int maxArea = 0;
		int i = 0;
		Stack<Integer> st = new Stack<>();
		while (i < heights.length) {
			if (st.isEmpty() || heights[i] >= heights[st.peek()]) {
// Keep adding bars to stack
				st.push(i);
				i++;
			} else {
				int top = st.pop();
				int area = heights[top] * (st.isEmpty() ? i : (i - st.peek() - 1)); // l*b
				maxArea = Math.max(maxArea, area);
			}
		}

// Cal area for left over bars in the stack to see if it has greater area{maxArea} than existing area.
		while (!st.isEmpty()) {
			int top = st.pop();
// -1 reason, After pushing bar in to stack, we are incrementing i. eg: At index 4, i value will be 5.
			int area = heights[top] * (st.isEmpty() ? i : (i - st.peek() - 1));
			maxArea = Math.max(maxArea, area);
		}
		return maxArea;
	}
}
