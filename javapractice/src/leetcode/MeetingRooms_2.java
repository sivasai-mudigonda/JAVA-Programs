package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
* @author u230107
*
* LeetCode - 253 {Meeting Rooms II}
* https://leetcode.com/problems/meeting-rooms-ii
*
* Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
* find the minimum number of conference rooms required.
* 
	Example, 
	Input : [[0, 30],[5, 10],[15, 20]]
	Output : 2.
*
* Solution:
* When a room is taken, the room can not be used for anther meeting until the current meeting is over.
* As soon as the current meeting is finished, the room can be used for another meeting.
* We can sort the meetings by start time-stamps and sequentially assign each meeting to a room.
* Each time when we assign a room for a meeting, we check if any meeting is finished so that the room can be reused.
* In order to efficiently track the earliest ending meeting,
* we can use a min heap. Whenever an old meeting ends before a new meeting starts, we reuse the room
* (i.e., do not add more room).
* Otherwise, we need an extra room (i.e., add a room).
*
* Time Complexity = O(NLogN) - Sorting applied
* Space Complexity =o(N) - Space required store each interval in to Priority Queue
*
*/
public class MeetingRooms_2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MeetingRooms_2 obj = new MeetingRooms_2();

		int[][] intervals1 = { { 0, 30 }, { 5, 10 }, { 15, 20 } };
		System.out.println("Minimum Meeting Rooms Required = " + obj.minMeetingRooms(intervals1)); // Expected Output = 2

		int[][] intervals2 = { { 2, 15 }, { 36, 45 }, { 9, 29 }, { 16, 23 }, { 4, 9 } };
		System.out.println("Minimum Meeting Rooms Required = " + obj.minMeetingRooms(intervals2)); // Expected Output = 2
	}

	/**
	 *
	 * @param intervals
	 * @return
	 *
	 * A priority queue is a special type of queue wherein all elements are
	 * ordered as per their natural ordering by default
	 */
	public int minMeetingRooms(int[][] intervals) {
		if (intervals == null || intervals.length == 0) {
			return 0;
		}
		Arrays.sort(intervals, Comparator.comparing((int[] i) -> i[0])); // Java-8 custom comparator Sorting
		/*
		 * Java-7 Implementation 
		 * Arrays.sort(intervals,new Comparator<int[]>(){
		 * @Override public int compare(int[] s1, int[] s2) { 
		 * 	return s1[0]-s2[0]; 
		 * } 
		 * });
		 */
		// Min-Heap, Offer & Poll Based on end time.
		int meetingRoomsCnt = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int[] interval : intervals) {
			if (pq.isEmpty()) {
				meetingRoomsCnt++;
				pq.offer(interval[1]); // interval[0] - start time, interval[1] - end time
			} else {
				if (interval[0] >= pq.peek()) {
					// As current interval start time is greater than or equal to pq.peek(),
					// we can reuse pq.peek() meeting room. So, we don't need extra meeting room
					pq.poll();
				} else {
					// As there is meeting in progress in the existing rooms, we cannot reuse them.
					// So, we need to assign a new room.
					meetingRoomsCnt++;
				}
				pq.offer(interval[1]);
			}
		}
		return meetingRoomsCnt;
	}
}