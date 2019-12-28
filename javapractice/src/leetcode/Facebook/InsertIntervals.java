/**
 * 
 */
package leetcode.Facebook;

import java.util.ArrayList;
import java.util.List;

/**
 * @author SIVA SAI
 *
 * Leet-code Ques - 57 {Insert Interval} {Hard}
 * https://leetcode.com/problems/insert-interval/
 *
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 * You may assume that the intervals were initially sorted according to their start times.
 * 
	Example 1:
	Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
	Output: [[1,5],[6,9]]
	
	Example 2:
	Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
	Output: [[1,2],[3,10],[12,16]]
	Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 *
 * Solution:
 * Refer https://www.youtube.com/watch?v=Zk77nLzswSQ
 *
 * Time Complexity = O(N)
 * Space Complexity =  o(1)
 *
 */
public class InsertIntervals {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		InsertIntervals obj = new InsertIntervals();
		
		System.out.println("Input & output as Array");
		int[][] nums1 = {{1,3},{6,9}};
		int[] newInterval1 = {2,5};
		int[][] resultArr = obj.insert(nums1, newInterval1);
		for (int[] n : resultArr) {
			System.out.println(n[0] + "," + n[1]); // Expected Output = [[1,5],[6,9]]
		}
		System.out.println("^^^^^^^^^^^^^^^^^^^^");
		int[][] nums2 = {{1,2},{3,5},{6,7},{8,10},{12,16}};
		int[] newInterval2 = {4,8};
		resultArr = obj.insert(nums2, newInterval2);
		for (int[] n : resultArr) {
			System.out.println(n[0] + "," + n[1]); // Expected Output = [[1,2],[3,10],[12,16]]
		}
		
		System.out.println("************************************");
		
		System.out.println("Input & output as List");
		List<Interval> resultLi;
		List<Interval> intervals= new ArrayList<>();		
		Interval interval1= new Interval(1,3);
		Interval interval2= new Interval(6,9);
		intervals.add(interval1);
		intervals.add(interval2);
		Interval newInterval3= new Interval(2,5);
		resultLi=insert(intervals,newInterval3);
		resultLi.forEach(interval->{
			// Expected Output = [[1,5],[6,9]]
			System.out.print(interval.start +" , ");
			System.out.print(interval.end);
			System.out.println();
		});
		System.out.println("^^^^^^^^^^^^^^^^^^^^");
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
		Interval newInterval4= new Interval(4,8);
		resultLi=insert(intervals,newInterval4);
		resultLi.forEach(interval->{
			// Expected Output = [[1,2],[3,10],[12,16]]
			System.out.print(interval.start +" , ");
			System.out.print(interval.end);
			System.out.println();
		});
	}
	
	/**
	 * 
	 * @param intervals
	 * @param newInterval
	 * @return
	 * 
	 * Input & Output as Array
	 * 
	 */
	public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals==null || newInterval==null || newInterval.length==0  ){
        	return new int[0][];
        }
        boolean isOverlapInserted=false;
		List<int[]> resultLi = new ArrayList<>();
		int overlapStart=newInterval[0];
		int overlapEnd=newInterval[1];
		for(int[] interval : intervals  ){
			if(interval[1] < overlapStart ){
				// No overlap
				resultLi.add(new int[]{interval[0],interval[1]});
			} else if(interval[0] <= overlapEnd ){ // There could be more than one overlap, So we need this condition.
				// There is an overlap.
				overlapStart = Math.min(interval[0],overlapStart);
				overlapEnd = Math.max(interval[1],overlapEnd);
			} else {
				if(!isOverlapInserted ){
					resultLi.add(new int[]{overlapStart,overlapEnd}); // Insert overlapped interval if not inserted.
					isOverlapInserted=true;
				}
				resultLi.add(new int[]{interval[0],interval[1]}); // Insert current interval
			}
		}
		if(!isOverlapInserted ){
			resultLi.add(new int[]{overlapStart,overlapEnd}); // If the new Interval is at the end.
			isOverlapInserted=true;
		}
		/*
		 * Returns an array containing all of the elements in this list in proper sequence (from first to last element); 
		 * the runtime type of the returned array is that of the specified array. 
		 * If the list fits in the specified array, it is returned therein. 
		 * Otherwise, a new array is allocated with the runtime type of the specified array and the size of this list.
		 * 
		 * Type Parameters:
		 * T - the runtime type of the array to contain the collection
		 * 
		 * Parameters:
		 * a - the array into which the elements of this list are to be stored, 
		 * if it is big enough; otherwise, 
		 * a new array of the same runtime type is allocated for this purpose.
		 * 
		 * Returns:
		 * an array containing the elements of this list 
		 * 
		 * Suppose x is a list known to contain only strings. 
		 * The following code can be used to dump the list into a newly allocated array of String:
		 * String[] y = x.toArray(new String[0]);
		 * 
		 * Note that toArray(new Object[0]) is identical in function to toArray().
		 * 
		 */
		return resultLi.toArray(new int[resultLi.size()][2]);
    }
	
	/**
	 * 
	 * @param intervals
	 * @param newInterval
	 * @return
	 * 
	 * Input & Output as List
	 * 
	 */
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
	
	/**
	 * 
	 * @author SivaM
	 *
	 */
	private static class Interval {
		 int start;
		 int end;
		 Interval() { start = 0; end = 0; }
		 Interval(int s, int e) { start = s; end = e; }
	}
}