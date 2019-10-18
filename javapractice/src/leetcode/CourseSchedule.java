/**
 * 
 */
package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author SivaM
 * 
 * LeetCode Ques - 207 {Course Schedule}
 * https://leetcode.com/problems/course-schedule/
 * 
 * There are a total of n courses you have to take, labeled from 0 to n-1.
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, 
 * which is expressed as a pair: [0,1]
 * 
 * Given the total number of courses and a list of prerequisite pairs, 
 * is it possible for you to finish all courses?
 * 
	Example 1:
	Input: 2, [[1,0]] 
	Output: true
	Explanation: There are a total of 2 courses to take. 
	             To take course 1 you should have finished course 0. So it is possible.
	
	Example 2:
	Input: 2, [[1,0],[0,1]]
	Output: false
	Explanation: There are a total of 2 courses to take. 
	             To take course 1 you should have finished course 0, and to take course 0 you should
	             also have finished course 1. So it is impossible.

 * 
 * Note:
 * The input prerequisites is a graph represented by a list of edges, not adjacency matrices.
 * Read more about how a graph is represented.
 * You may assume that there are no duplicate edges in the input prerequisites.
 * 
 * Time Complexity = O(V+E) - Time to build adjMap with prerequisites and check for cycle for each vertex
 * Space Complexity = O(V+E) - Each course{Vertex} and its prerequisites{Edge} is stored in adjMap
 * 
 */
public class CourseSchedule {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CourseSchedule obj = new CourseSchedule();
		
		int n=2;
		int[][] nums = {{1,0}};
		System.out.println("Can finish all courses = " +obj.canFinish(n,nums)); // Expected Output = true
		
		int[][] nums1 = {{1,0},{0,1}};
		System.out.println("Can finish all courses = " +obj.canFinish(n,nums1)); // Expected Output = false
	}
	
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		if(numCourses<=0 || prerequisites==null || prerequisites.length==0) {
			return true; // We can complete all the courses
		}
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
		
		int[] visited = new int[numCourses];
		for(int i=0;i<numCourses;i++) {
			if(isCycle(i,visited,adjMap)) {
				return false; // As there is a cycle{deadlock}, we cannot complete all the courses 
			}
		}
		return true; // We can complete all the courses
	}
	
	/**
	 * 
	 * @param vertexId
	 * @param visited
	 * @param adjMap
	 * @return
	 * 
	 * DFS+Backtracking
	 * Identifying a way through which we can visit all nodes of a graph{without circle} is called topological sorting
	 */
	private boolean isCycle(int vertexId, int[] visited, Map<Integer,List<Integer>> adjMap) {
		if(visited[vertexId]==-1) {
			return true; // It has a cycle
		}
		
		if(visited[vertexId]==1) {
			return false; // Its neighbor which is already visited, does not have a dependency on current vertexId
		}
		
		visited[vertexId] = -1; // Mark as visited
		List<Integer> adjNodes = adjMap.get(vertexId);
		if(adjNodes!=null) {
			for(int neighbor : adjNodes) { // Check for cycle for neighboring nodes
				if(isCycle(neighbor,visited,adjMap) ) {
					return true;
				}
			}
		}
		visited[vertexId]=1; // Marking it to one, which indicates that current vertexId does not have any cycles{Backtracking}
		return false;// No cycle with the current vertex
	}
}