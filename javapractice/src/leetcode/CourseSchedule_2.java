/**
 * 
 */
package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author SivaM
 * 
 * LeetCode Ques - 220 {Course Schedule II}
 * https://leetcode.com/problems/course-schedule-ii/
 * 
 * There are a total of n courses you have to take, labeled from 0 to n-1.
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, 
 * which is expressed as a pair: [0,1]
 * 
 * Given the total number of courses and a list of prerequisite pairs, 
 * return the ordering of courses you should take to finish all courses.
 * 
 * There may be multiple correct orders, you just need to return one of them. 
 * If it is impossible to finish all courses, return an empty array.
 * 
	Example 1:
	Input: 2, [[1,0]] 
	Output: [0,1]
	Explanation: There are a total of 2 courses to take. To take course 1 you should have finished   
	             course 0. So the correct course order is [0,1] .
	             
	Example 2:
	Input: 4, [[1,0],[2,0],[3,1],[3,2]]
	Output: [0,1,2,3] or [0,2,1,3]
	Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both     
	             courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0. 
	             So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3] .

 * Note:
 * The input prerequisites is a graph represented by a list of edges, not adjacency matrices. 
 * Read more about how a graph is represented.
 * You may assume that there are no duplicate edges in the input prerequisites.
 * 
 * Time Complexity = O(V+E) - Time to build adjMap with prerequisites and check for cycle for each vertex
 * Space Complexity = O(V+E) - Each course{Vertex} and its prerequisites{Edge} is stored in adjMap
 * 
 */
public class CourseSchedule_2 {

	/**
	 * @param args
	 */
	private int label = 0; // Index for courseOrder array.
	
	public static void main(String[] args) {
		CourseSchedule_2 obj = new CourseSchedule_2();
		
		int numCourses = 2;
		int[] courseOrder = obj.findOrder(numCourses,new int[][]{{1,0}});
		System.out.println(Arrays.toString(courseOrder));
		
		numCourses = 4;
		int[] courseOrder_2 = obj.findOrder(numCourses,new int[][] {{1,0},{2,0},{3,1},{3,2}}); 
		System.out.println(Arrays.toString(courseOrder_2));
	}
	
	/**
	 * 
	 * @param numCourses
	 * @param prerequisites
	 * @return
	 * 
	 * DFS+Backtracking
	 * Identifying a way through which we can visit all nodes of a graph{without circle} is called topological sorting
	 */
	public int[] findOrder(int numCourses, int[][] prerequisites) {
        if(numCourses==0) {
        	return new int[0];
        }
        if(prerequisites==null || prerequisites.length==0) {
        	List<Integer> li = new ArrayList<>();
        	while(numCourses-->0) {
        		li.add(numCourses);
        	}
        	int[] res = li.stream().mapToInt(n->n).toArray();
        	return res;
        }
        label = 0; // Reset index to zero
     // Construct Graph with vertices and edges, that is represented by prerequisites
        Map<Integer,List<Integer>> adjMap = new HashMap<>();
        for(int[] edge : prerequisites) {
        	List<Integer> neighbors=null;
        	if(adjMap.containsKey(edge[0]) ){
        		neighbors = adjMap.get(edge[0]);
        		neighbors.add(edge[1]);
        	} else {
        		neighbors = new ArrayList<>();
        		neighbors.add(edge[1]);
        	}
        	adjMap.put(edge[0], neighbors);
        }
        
        int visited[] = new int[numCourses];
        int[] courseOrder = new int[numCourses]; // Order in which we need to take courses to complete all courses
        for(int vertex=0;vertex<numCourses;vertex++ ){
        	if(hasCycle(vertex,visited,adjMap,courseOrder)) {
        		return new int[0]; 
        	}
        }
        return courseOrder;
    }
	
	/**
	 * 
	 * @param vertex
	 * @param visited
	 * @param adjMap
	 * @param resultArr
	 * @param index
	 * @return
	 * DFS + Backtracking
	 * Identifying a way through which we can visit all nodes of a graph{without circle} is called topological sorting
	 */
	private boolean hasCycle(int vertex,int visited[],Map<Integer,List<Integer>> adjMap,
			int[] resultArr) {
		if(visited[vertex]==-1) {
			return true; // It has a cycle
		}
		
		if(visited[vertex]==1) {
			return false; // Its neighbor which is already visited, does not have a dependency on current vertexId
		}
		
		visited[vertex] = -1; // Mark as Visited
		List<Integer> neighbors = adjMap.get(vertex);
		if(neighbors!=null && !neighbors.isEmpty() ){
			for(int neighbor : neighbors) {
				if(hasCycle(neighbor,visited,adjMap,resultArr)) {
					return true;
				}
			}
		}
		resultArr[label++] = vertex;
		visited[vertex] = 1; // BAcktrack as there is no cycle
		return false;
	}
}
