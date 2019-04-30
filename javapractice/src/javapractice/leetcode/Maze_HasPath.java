/**
* 
*/
package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author u230107
 *
 *         Leetcode : 490 URL =
 *
 *         There is a ball in a maze with empty spaces and walls. The ball can
 *         go through empty spaces by rolling up, down, left or right, but it
 *         won't stop rolling until hitting a wall. When the ball stops, it
 *         could choose the next direction. Given the ball's start position, the
 *         destination and the maze, determine whether the ball could stop at
 *         the destination. The maze is represented by a binary 2D array. 1
 *         means the wall and 0 means the empty space. You may assume that the
 *         borders of the maze are all walls. The start and destination
 *         coordinates are represented by row and column indexes.
 *
 *         Example 1 Input 1: a maze represented by a 2D array
 *
 *         0 0 1 0 0 0 0 0 0 0 0 0 0 1 0 1 1 0 1 1 0 0 0 0 0
 * 
 *         Input 2: start coordinate (rowStart, colStart) = (0, 4) Input 3:
 *         destination coordinate (rowDest, colDest) = (4, 4)
 * 
 *         Output: true Explanation: One possible way is : left -> down -> left
 *         -> down -> right -> down -> right.
 * 
 *         Example 2 Input 1: a maze represented by a 2D array
 * 
 *         0 0 1 0 0 0 0 0 0 0 0 0 0 1 0 1 1 0 1 1 0 0 0 0 0
 * 
 *         Input 2: start coordinate (rowStart, colStart) = (0, 4) Input 3:
 *         destination coordinate (rowDest, colDest) = (3, 2)
 * 
 *         Output: false Explanation: There is no way for the ball to stop at
 *         the destination.
 * 
 *         Note: There is only one ball and one destination in the maze. Both
 *         the ball and the destination exist on an empty space, and they will
 *         not be at the same position initially. The given maze does not
 *         contain border (like the red rectangle in the example pictures), but
 *         you could assume the border of the maze are all walls. The maze
 *         contains at least 2 empty spaces, and both the width and height of
 *         the maze won't exceed 100.
 *
 *         Solution :
 *
 */
public class Maze_HasPath {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] maze = { { 0, 0, 1, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 1, 0 }, { 1, 1, 0, 1, 1 },
				{ 0, 0, 0, 0, 0 } };
		int[] start = { 0, 4 };
		int[] destination = { 4, 4 };
		boolean result = hasPath(maze, start, destination);
		System.out.println("HasPath = " + result); // Expected Result = True

		int[] destination1 = { 3, 2 };
		result = hasPath(maze, start, destination1);
		System.out.println("HasPath = " + result); // Expected Result = False

	}

	private static boolean hasPath(int[][] maze, int[] start, int[] destination) {
		if (maze == null || maze.length == 0 || start == null || start.length == 0 || destination == null
				|| destination.length == 0) {
			return false;
		}
		boolean[][] visited = new boolean[maze.length][maze[0].length];
		int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

		Queue<int[]> bfsQueue = new LinkedList<>();
		bfsQueue.add(start);
		visited[start[0]][start[1]] = true;
		while (!bfsQueue.isEmpty()) {
			int[] curr = bfsQueue.remove();
			if (curr[0] == destination[0] && curr[1] == destination[1]) {
				return true;
			}
			for (int[] dir : dirs) {
				int x = curr[0] + dir[0];
				int y = curr[1] + dir[1];
				while (x > 0 && y > 0 && x < maze.length && y < maze[0].length && maze[x][y] == 0) {
					x += dir[0];
					y += dir[1];
				}
				if (!visited[x - dir[0]][y - dir[1]]) {
					int[] tempStart = { x - dir[0], y - dir[1] };
					bfsQueue.add(tempStart);
					visited[x - dir[0]][y - dir[1]] = true;
				}
			}
		}
		return false;
	}
}
