/**
 * 
 */
package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

/**
 * @author SIVA SAI
 *
 *Leet Code : 218. The Skyline Problem
 *https://leetcode.com/problems/the-skyline-problem/
 *
 *A city's skyline is the outer contour of the silhouette formed by all the buildings in that city when viewed from a distance. Now suppose you are given the locations and height of all the buildings as shown on a cityscape photo (Figure A), write a program to output the skyline formed by these buildings collectively (Figure B).
 *The geometric information of each building is represented by a triplet of integers [Li, Ri, Hi], where Li and Ri are the x coordinates of the left and right edge of the ith building, respectively, and Hi is its height. It is guaranteed that 0 ≤ Li, Ri ≤ INT_MAX, 0 < Hi ≤ INT_MAX, and Ri - Li > 0. You may assume all buildings are perfect rectangles grounded on an absolutely flat surface at height 0.

For instance, the dimensions of all buildings in Figure A are recorded as: [ [2 9 10], [3 7 15], [5 12 12], [15 20 10], [19 24 8] ] .

The output is a list of "key points" (red dots in Figure B) in the format of [ [x1,y1], [x2, y2], [x3, y3], ... ] that uniquely defines a skyline. A key point is the left endpoint of a horizontal line segment. Note that the last key point, where the rightmost building ends, is merely used to mark the termination of the skyline, and always has zero height. Also, the ground in between any two adjacent buildings should be considered part of the skyline contour.

For instance, the skyline in Figure B should be represented as:[ [2 10], [3 15], [7 12], [12 0], [15 10], [20 8], [24, 0] ].

Notes:

The number of buildings in any input list is guaranteed to be in the range [0, 10000].
The input list is already sorted in ascending order by the left x position Li.
The output list must be sorted by the x position.
There must be no consecutive horizontal lines of equal height in the output skyline. For instance, [...[2 3], [4 5], [7 5], [11 5], [12 7]...] is not acceptable; the three lines of height 5 should be merged into one in the final output as such: [...[2 3], [4 5], [12 7], ...]
 *
 *Time Complexity = O(NLOGN)
 *Space Complexity = o(N)
 *
 *Refer https://www.youtube.com/watch?v=GSBLe8cKu0s {Video}
 *https://github.com/mission-peace/interview/blob/master/src/com/interview/geometry/SkylineDrawing.java {Code}
 */
public class SkyLineDrawing {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int [][] buildings = {{1,3,4},{3,4,4},{2,6,2},{8,11,4}, {7,9,3},{10,11,2}};
		SkyLineDrawing sd = new SkyLineDrawing();
        List<int[]> criticalPoints = sd.getSkyline(buildings);
        criticalPoints.forEach(building->{
        	System.out.println(building[0] +" , "+ building[1]);
        });
	}
	
	private List<int[]> getSkyline(int[][] buildings) {
		List<int[]> resultLi = new ArrayList<>();
		List<Building> buildingsLi = new ArrayList<>(buildings.length*2);
		for(int[] building : buildings) {
			buildingsLi.add(new Building(building[0],true,building[2]));
			buildingsLi.add(new Building(building[1],false,building[2]));
		}
		Collections.sort(buildingsLi);
		TreeMap<Integer,Integer> priorityQueue = new TreeMap<>(); //using TreeMap because it gives log time performance.
		priorityQueue.put(0, 1);
		int prev_max=0;
		for(Building building : buildingsLi) {
			
			if(building.isStart) {
				// Add to priorityQueue if new entry, Else increment Value.
				priorityQueue.compute(building.height,(k,v)->{
					return v==null?v=1:v+1;
				});
				
			} else {
				// Remove from priorityQueue if new Entry, Else decrement Value.
				priorityQueue.compute(building.height,(k,v) ->{
					return v==1?null:v-1;
				});
			}
			//peek the current height after addition or removal of building x.
			int curr_max= priorityQueue.lastKey();
			
			 //if height changes from previous height then this building x becomes critcal x.
            // So add it to the result.
			if(prev_max!=curr_max) {
				int[] res = {building.x,curr_max};
				resultLi.add(res );
				prev_max=curr_max;
			}
		}
		return resultLi;
	}
	
	private static class Building implements Comparable<Building>{
		int x;
		boolean isStart;
		int height;
		
		public Building(int x, boolean isStart, int height) {
			this.x=x;
			this.isStart= isStart;
			this.height= height;
		}
		
		//first compare by x.
        //If they are same then use this logic
        //if two starts are compared then higher height building should be picked first
        //if two ends are compared then lower height building should be picked first
        //if one start and end is compared then start should appear before end
		public int compareTo(Building bud) {
			if(this.x!=bud.x) {
				return this.x-bud.x;
			} else {
				return ((this.isStart ? -this.height : this.height) - (bud.isStart ? -bud.height : bud.height));
			}
		}
	}

}
