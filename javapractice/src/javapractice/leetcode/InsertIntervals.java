/**
 * 
 */
package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author SIVA SAI
 *
 *
 *Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

Example 1:

Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]
Example 2:

Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 *
 *
 *Refer https://www.youtube.com/watch?v=Zk77nLzswSQ
 *
 *Time Complexity = O(N)
 *Space Complexity =  o(1)
 *
 */
public class InsertIntervals {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Interval> resultLi;
		List<Interval> intervals= new ArrayList<>();		
		Interval interval1= new Interval(1,3);
		Interval interval2= new Interval(6,9);
		intervals.add(interval1);
		intervals.add(interval2);
		Interval newInterval1= new Interval(2,5);
		resultLi=insert(intervals,newInterval1);
		resultLi.forEach(interval->{
			// Expected Output = [[1,5],[6,9]]
			System.out.print(interval.start +" , ");
			System.out.print(interval.end);
			System.out.println();
		});
		
		System.out.println("**********************");
		intervals.clear();
		Interval interval3= new Interval(1,2);
		Interval interval4= new Interval(3,5);
		Interval interval5= new Interval(6,7);
		Interval interval6= new Interval(8,10);
		Interval interval7= new Interval(12,16);
		intervals.add(interval3);
		intervals.add(interval4);
		intervals.add(interval5);
		intervals.add(interval6);
		intervals.add(interval7);
		Interval newInterval2= new Interval(4,8);
		resultLi=insert(intervals,newInterval2);
		resultLi.forEach(interval->{
			// Expected Output = [[1,2],[3,10],[12,16]]
			System.out.print(interval.start +" , ");
			System.out.print(interval.end);
			System.out.println();
		});
		
	}
	
	private static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		List<Interval> resultLi= new ArrayList<>();
		if(intervals==null || newInterval ==null || intervals.size()<1) {
			resultLi.add(newInterval);
			return resultLi;
		}
		boolean isOverlapInserted=false;
		Interval overlap=new Interval();
		overlap.start=newInterval.start;
		overlap.end=newInterval.end;
		for(Interval interval:intervals) {
			if(interval.end < newInterval.start) {
				resultLi.add(interval); // Insert Elements before Overlap
			} else if(interval.start <= newInterval.end){ // Overlapped
				overlap.start=Math.min(overlap.start, interval.start);
				overlap.end=Math.max(overlap.end, interval.end);
			} else {
				if(!isOverlapInserted) {
					resultLi.add(overlap); // Insert Overlap
					isOverlapInserted=true;
				} 
				resultLi.add(interval); // Insert Remaining
			}
		}
		if(!isOverlapInserted) {
			resultLi.add(overlap); // If the new Interval is at the end
		}
		return resultLi;
    }
	
	private static class Interval {
		 int start;
		 int end;
		 Interval() { start = 0; end = 0; }
		 Interval(int s, int e) { start = s; end = e; }
	}

}
