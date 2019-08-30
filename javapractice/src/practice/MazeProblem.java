package practice;

public class MazeProblem {
	static int N = 4; // Number of Rows/Columns

	public static void main(String[] args) {
		// 0 means no route
		// 1 means traversable
		int maze[][] = { { 1, 0, 0, 0 }, 
						 { 1, 1, 0, 0 }, 
						 { 0, 1, 0, 0 }, 
						 { 1, 1, 1, 1 } 
					   };

		mazeSol(maze);
	}

	private static void printSol(int sol[][]) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(sol[i][j]==1) {
					System.out.print(" " + sol[i][j]);
				} else {
					System.out.print(" " +"-");
				}
			}
			System.out.println();
		}
	}

	private static boolean mazeUtil(int maze[][], int x, int y, int sol[][]) {
		if (x == N - 1 && y == N - 1) {
			sol[x][y] = 1;
			return true;
		}
		if (isSafe(maze, x, y)) {
			sol[x][y] = 1;
			if (mazeUtil(maze, x + 1, y, sol)) {
				return true;
			}
			if (mazeUtil(maze, x, y + 1, sol)) {
				return true;
			}
			sol[x][y] = 0; // Backtrack, unmark
			return false;
		}

		return false;
	}

	private static boolean isSafe(int maze[][], int x, int y) {
		if (x >= 0 && y >= 0 && x < N && y < N && maze[x][y] == 1) {
			return true;
		}
		return false;
	}

	private static boolean mazeSol(int maze[][]) {
		int sol[][] = { { 0, 0, 0, 0 }, 
				        { 0, 0, 0, 0 }, 
				        { 0, 0, 0, 0 }, 
				        { 0, 0, 0, 0 } 
				      };
		if (mazeUtil(maze, 0, 0, sol)) {
			System.out.println("Sol found");
			printSol(sol);
			return true;
		}
		System.out.println("Sol not found");
		return false;
	}

}
