/**
 * 
 */
package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author SIVA SAI
 *
 *
 *Given a collection of intervals, merge all overlapping intervals.

Example 1:

Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
Example 2:

Input: [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 *
 *
 *Refer https://www.youtube.com/watch?v=OIqAVmD1RGk
 *
 *Time Complexity = O(NLOGN)
 *Space Complexity = o(1)
 */
public class MergeIntervals {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Interval> intervals= new ArrayList<>();
		intervals.add(new Interval(2,4));
		intervals.add(new Interval(3,5));
		intervals.add(new Interval(8,10));
		intervals.add(new Interval(9,12));
		intervals.add(new Interval(15,21));
		List<Interval> resultLi = merge(intervals);
		resultLi.forEach(interval->{
		 				 	System.out.print(interval.start +",");
		 				 	System.out.print(interval.end);
		 				 	System.out.println();
						 });
	}
	
	private static List<Interval> merge(List<Interval> intervals) {
		List<Interval> resultLi= new ArrayList<>();
		if(intervals==null || intervals.size()==0) {
			return resultLi;
		}
		Collections.sort(intervals, new IntervalComparator()); // O(NLogN), SORT
        int preStart=intervals.get(0).start;
        int preEnd=intervals.get(0).end;
        for(int i=1;i<intervals.size();i++) {
        	int currStart=intervals.get(i).start;
        	int currEnd=intervals.get(i).end;
        	if(currStart > preEnd ){ // No overlapping
        		resultLi.add(new Interval(preStart,preEnd)); // Add previous Interval
        		preStart=currStart;
        		preEnd=currEnd;
        	} else {
        		// Overlap
        		preEnd = Math.max(preEnd, currEnd); // Identify Bigger Boundary
        	}
        }
        resultLi.add(new Interval(preStart,preEnd)); // To add last Interval
		return resultLi;
    }
	
	private static class IntervalComparator implements Comparator<Interval>{
		public int compare(Interval i1, Interval i2) {
			return i1.start-i2.start;
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
