/**
 * 
 */
package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author SIVA SAI
 *
 *  Given a collection of intervals, merge all overlapping intervals.
 *  
    Example 1:
    Input: [[1,3],[2,6],[8,10],[15,18]]
    Output: [[1,6],[8,10],[15,18]]
    Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
    
    Example 2:
    Input: [[1,4],[4,5]] 
    Output: [[1,5]] 
    Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 *
 *  Refer https://www.youtube.com/watch?v=OIqAVmD1RGk
 *
 *  Time Complexity = O(NLOGN) 
 *  Space Complexity = o(1)
 */
public class MergeIntervals {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Interval> intervals = new ArrayList<>();
		intervals.add(new Interval(2, 4));
		intervals.add(new Interval(3, 5));
		intervals.add(new Interval(8, 10));
		intervals.add(new Interval(9, 12));
		intervals.add(new Interval(15, 21));
		List<Interval> resultLi = merge(intervals);
		resultLi.forEach(interval -> {
			System.out.print(interval.start + ",");
			System.out.print(interval.end);
			System.out.println();
		});
		System.out.println("*************************************");
		//int[][] nums = { { 2, 6 }, { 1, 3 }, { 8, 10 }, { 15, 18 } };
		int[][] nums = {{1,4},{2,3}};
		int[][] res = merge(nums);
		for (int[] n : res) {
			System.out.println(n[0] + "," + n[1]); // Expected Output = [[1,6],[8,10],[15,18]]
		}
	}

	// Integer Array as Input & Output
	private static int[][] merge(int[][] intervals) {
		if (intervals == null || intervals.length == 0) {
			return new int[][] {};
		}
		Arrays.sort(intervals, new Comparator<int[]>() {
			public int compare(int[] i1, int[] i2) {
				return i1[0] - i2[0];
			}
		});
		List<int[]> res = new ArrayList<>();
		int preStart = intervals[0][0];
		int preEnd = intervals[0][1];
		for (int i = 1; i < intervals.length; i++) {
			if (intervals[i][0] > preEnd) { // No overlap
				int[] intArr = new int[2];
				intArr[0] = preStart;
				intArr[1] = preEnd;
				res.add(intArr);
				preStart = intervals[i][0];
				preEnd = intervals[i][1];
			} else { // Overlapped
				preEnd = Math.max(preEnd, intervals[i][1]);
			}
		}
		int[] intArr = new int[2];
		intArr[0] = preStart;
		intArr[1] = preEnd;
		res.add(intArr);
		int[][] resArr = new int[res.size()][2];
		for (int i = 0; i < res.size(); i++) {
			int[] arr = res.get(i);
			resArr[i] = arr;
		}
		return resArr;
	}

	// Array List as Input & Output
	private static List<Interval> merge(List<Interval> intervals) {
		List<Interval> resultLi = new ArrayList<>();
		if (intervals == null || intervals.size() == 0) {
			return resultLi;
		}
		Collections.sort(intervals, new IntervalComparator()); // O(NLogN), SORT
		int prevStart = intervals.get(0).start;
		int prevEnd = intervals.get(0).end;
		for (int i = 1; i < intervals.size(); i++) {
			int currStart = intervals.get(i).start;
			int currEnd = intervals.get(i).end;
			if (currStart > prevEnd) { // No overlapping
				resultLi.add(new Interval(prevStart, prevEnd)); // Add previous Interval
				prevStart = currStart;
				prevEnd = currEnd;
			} else {
				// Overlap
				prevEnd = Math.max(prevEnd, currEnd); // Identify Bigger Boundary
			}
		}
		resultLi.add(new Interval(prevStart, prevEnd)); // To add last Interval
		return resultLi;
	}

	private static class IntervalComparator implements Comparator<Interval> {
		public int compare(Interval i1, Interval i2) {
			return i1.start - i2.start;
		}
	}

	private static class Interval {
		int start;
		int end;

		Interval(int s, int e) {
			start = s;
			end = e;
		}
	}
}
