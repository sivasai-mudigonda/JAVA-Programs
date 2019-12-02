/**
 * 
 */
package leetcode;

/**
* @author u230107
*
* LeetCode Ques - 295 {Find Median from Data Stream}
* https://leetcode.com/problems/find-median-from-data-stream/
*
* Median is the middle value in an ordered integer list.
* If the size of the list is even, there is no middle value.
* So the median is the mean of the two middle value.
*
For example,
[2,3,4], the median is 3 {Odd}
[2,3], the median is (2 + 3) / 2 = 2.5 {Even}
*
* Design a data structure that supports the following two operations:
* void addNum(int num) — Add an integer number from the data stream to the data structure.
* double findMedian() — Return the median of all elements so far.
*
	Example:
	addNum(1)
	addNum(2)
	findMedian() -> 1.5
	addNum(3)
	findMedian() -> 2
* 
* Follow up:
* If all integer numbers from the stream are between 0 and 100, how would you optimize it?
* If 99% of all integer numbers from the stream are between 0 and 100, how would you optimize it?
*
* Solution:
* The main idea of this solution is to use a maximum heap and another minimum heap,
* which store half of the numbers, so the theoretical median is the top element of the two heaps
* (maximum heap top of the element is the maximum value, and the minimum is the opposite),
* so just pay attention to the number of the two heaps to be similar,
* and then pay attention to the odd and even numbers can be solved smoothly.
*
* In Java, Priority_queue is the heap data structure,
* which will be controlled by the comparator as the Min or Max heap:
* PriorityQueue<Integer> minHeap = new PriorityQueue<>(); Natural Ordering
* PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
*
* For the convenience of calculation,
* we will first put the element into leftMaxHeap,
* and control 0 ≤ |leftMaxHeap| — |rightMinHeap| ≤ 1,
* because we can use the number of the two to quickly find the median:
* If |leftMaxHeap| > |rightMinHeap|, we can directly return leftMaxHeap.top(), because the total number of digits is odd at this time.
* If |leftMaxHeap| =|rightMinHeap|, because the total number of digits is even, we need to pass back the average of leftMaxHeap.top() and rightMinHeap.top().
* PS1. 0≤|leftMaxHeap| — |rightMinHeap| ≤ 1 This policy is for the convenience of the above calculations 1. and 2.
* PS2. The way to control the balance of two heaps is to see if the push number goes into one of the heaps and observe whether it violates our policy: 0≤|leftMaxHeap| — |rightMinHeap| ≤ 1,
* if it violates, it will be the heap of too many elements. Top() pushes into another heap and deletes it.
* PS3. Time complexity of this algorithm:
* findMedian(): O(1)
* AddNum(): O(logN), push a number into a heap.
* Total: log1 + log2 + .... + logN = O(NlogN), where N is the number of AddNum() calls.
*
* Also refer https://zxi.mytechroad.com/blog/leetcode/leetcode-295-find-median-from-data-stream/, if u need more explanation
*
* Time Complexity = O(NlogN)
* Space Complexity = O(N) - to store half elements in minHeap and another half in maxHeap
*
*/

// import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class FindMedian_From_DataStream {

	/**
	 * @param args
	 */

	PriorityQueue<Integer> minHeap;
	PriorityQueue<Integer> maxHeap;

	public static void main(String[] args) {
		FindMedian_From_DataStream obj = new FindMedian_From_DataStream();

		obj.addNum(41);
		System.out.println("Median = " + obj.findMedian()); // Expected Output = 41.0
		obj.addNum(35);
		System.out.println("Median = " + obj.findMedian()); // Expected Output = 38.0
		obj.addNum(62);
		System.out.println("Median = " + obj.findMedian()); // Expected Output = 41.0
		obj.addNum(5);
		System.out.println("Median = " + obj.findMedian()); // Expected Output = 38.0
		obj.addNum(97);
		System.out.println("Median = " + obj.findMedian()); // Expected Output = 41.0
		obj.addNum(108);
		System.out.println("Median = " + obj.findMedian()); // Expected Output = 51.0
		
		System.out.println("********************************");
		
		FindMedian_From_DataStream obj2 = new FindMedian_From_DataStream();
		obj2.addNum(1);
		obj2.addNum(2);
		System.out.println("Median = " + obj2.findMedian()); // Expected Output = 1.5
		obj2.addNum(3);
		System.out.println("Median = " + obj2.findMedian()); // Expected Output = 2

	}

	FindMedian_From_DataStream() {
		minHeap = new PriorityQueue<>();
		maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
		// maxPq = new PriorityQueue<>(Collections.reverseOrder()); - Java 7
	}

	public void addNum(int num) {
		/**
		 * The way to control the balance of two heaps is to see, if the push number
		 * goes into one of the heaps and observe whether it violates our policy:
		 * 0≤|leftMaxHeap| — |rightMinHeap| ≤ 1, if it violates, it will be the heap of
		 * too many elements. Top() pushes into another heap and deletes it.
		 */
		maxHeap.offer(num);
		minHeap.offer(maxHeap.poll());
		if (maxHeap.size() < minHeap.size()) { // 0 ≤ |leftMaxHeap| — |rightMinHeap| ≤ 1
			maxHeap.offer(minHeap.poll());
		}
	}

	public double findMedian() {
		if (maxHeap.size() == minHeap.size()) {
			// If |leftMaxHeap| =|rightMinHeap|, because the total number of digits is even, we need to pass back the average of maxHeap.peek() and minHeap.peek().
			return (minHeap.peek() + maxHeap.peek()) / 2.0;
		} else {
			// If |leftMaxHeap| > |rightMinHeap|, we can directly return maxHeap.peek(), because the total number of digits is odd at this time.
			return maxHeap.peek();
		}
	}
}
