/**
 * 
 */
package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author SIVA SAI
 *
 *
 *Merge k sorted Arrays and return it as one sorted list. Analyze and describe its complexity?
 *
 *Refer https://www.youtube.com/watch?v=6bvnZzwiKzs
 *
 *  Time Complexity= O(log k)*n
 *  Idea is to use Priority Queues.
 */
public class MergeKSortedArrays {

	/**
	 * @param args
	 * 
	 */
	public static void main(String[] args) {
		int[][] arrays= {{34,87,96},{11,56,88},{88,93,95}};
		List<Integer> res=mergeArrays(arrays);
		System.out.println(res.toString());
	}
	
	// Dynamic Programming.- Merge K sorted Arrays.
	private static List<Integer> mergeArrays(int[][] arrays) {
		PriorityQueue<QueueNode> pq = new PriorityQueue<>();
		int size=0;
		// Insert first element of of each array in to priority queue.
		for(int i=0;i<arrays.length;i++) {
			size+=arrays[i].length;
			if(arrays[i].length > 0) {
				pq.add(new QueueNode(i,0,arrays[i][0]));
			}
		}
		List<Integer> res= new ArrayList<>(size);
		
		// Insert rest of the elements.
		while(!pq.isEmpty() ){
			QueueNode queueNode=pq.poll();
			res.add(queueNode.value);
			int newIndex=queueNode.index+1;
			if(newIndex < arrays[queueNode.array].length) { // checking if index is not crossing array length.
				pq.add(new QueueNode(queueNode.array,newIndex, arrays[queueNode.array][newIndex]));
			}
		}
		return res;
	}
	
	private static class QueueNode implements Comparable<QueueNode>{
		public int array;
		public int index;
		public int value;
		
		public QueueNode(int array, int index, int value) {
			this.array=array;
			this.index=index;
			this.value=value;
		}
		public int compareTo(QueueNode quequeNode) {
			if(value > quequeNode.value) {
				return 1;
			} else if(value < quequeNode.value) {
				return -1;
			}
			return 0;
		}
	}
}
