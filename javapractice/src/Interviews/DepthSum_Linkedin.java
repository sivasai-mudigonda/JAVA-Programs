package Interviews;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 
 * @author u230107
 *
 * Refer https://www.programcreek.com/2014/05/leetcode-nested-list-weight-sum-java/
 */
public class DepthSum_Linkedin {
	public static void main(String[] args) {
		addList();
	}

	private static void addList() {
		// {{1,1},2,{1,1}}
		List<Object> li = new ArrayList<>();

		List<Object> subLi1 = new ArrayList<>();
		subLi1.add(1); // Second Level
		// subLi1.add(1);
		List<Object> sub_subLi2 = new ArrayList<>();
		sub_subLi2.add(2); // Third Level
		subLi1.add(sub_subLi2);

		List<Object> sub_sub_subLi3 = new ArrayList<>();
		sub_sub_subLi3.add(3); // Fourth Level
		sub_subLi2.add(sub_sub_subLi3);
		li.add(subLi1);

		li.add(2);

		List<Object> subLi2 = new ArrayList<>();
		subLi2.add(1);
		subLi2.add(1);
		li.add(subLi2);

		System.out.println(Arrays.asList(li));
		depthSumRecursive(li);
		depthSumIterative(li);
	}

	// Iterative Approach
	private static void depthSumIterative(List<Object> li) {
		int sum = 0;
		Queue<Object> queue = new LinkedList<>();
		LinkedList<Integer> level = new LinkedList<>(); // depth
		for (Object o : li) {
			queue.offer(o); // queue.add(o);
			level.offer(1); // level.add(o)

			// Below functions are helpful when implementing priority Queues.
			// level.offerFirst(e); -- Insert in the start of the linked list.
			// level.offerLast(e); -- Insert in the end of the linked list.
			// level.poll(e); -- Remove in the start of the linked list.
			// level.poll(e); -- Remove in the end of the linked list.
		}

		while (!queue.isEmpty()) {
			Object obj = queue.poll(); // queue.remove();
			int depth = level.poll();

			if (obj instanceof Integer) {
				sum += (Integer) obj * depth;
			} else {
				List<Object> list = (List) obj;
				for (Object o : list) {
					queue.offer(o);
					level.offer(depth + 1);
				}
			}
		}

		System.out.println(sum);
	}

	// Recursive approach
	private static void depthSumRecursive(List<Object> li) {
		int sum = depthSumUtil(1, li);
		System.out.println(sum);
	}

	private static int depthSumUtil(int level, Object o) {
		List<Object> li = (List) o;
		if (li == null || li.size() == 0) {
			return 0;
		}
		int sum = 0;
		for (int i = 0; i < li.size(); i++) {
			if (li.get(i) instanceof Integer) {
				sum += level * (Integer) li.get(i);
			} else {
				sum += depthSumUtil(level + 1, li.get(i));
			}
		}
		return sum;
	}
	
	
}
