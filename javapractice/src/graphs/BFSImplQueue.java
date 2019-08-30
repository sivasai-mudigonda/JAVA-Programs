package graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 
 * @author SIVA SAI
 * 
 *         Refer
 *         https://www.geeksforgeeks.org/breadth-first-search-or-bfs-for-a-graph/
 * 
 *         Time Complexity: O(V+E) where V is number of vertices in the graph
 *         and E is number of edges in the graph.
 *
 */

public class BFSImplQueue {

	public static void main(String args[]) {
		Graph graph = new Graph(4);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 2);
		graph.addEdge(2, 0);
		graph.addEdge(2, 3);
		graph.addEdge(3, 3);
		graph.bfs();
	}

	private static class Graph {
		int V; // Total num of vertices
		List<List<Integer>> adjNodes;

		Graph(int v) {
			this.V = v;
			adjNodes = new LinkedList<List<Integer>>();
			int i = 0;
			while (i < V) {
				adjNodes.add(i, new LinkedList<Integer>());
				i++;
			}
		}

		private void addEdge(int source, int destination) {
			this.adjNodes.get(source).add(destination);
		}

		private void bfs() {
			List<Boolean> visited = new ArrayList<>(Collections.nCopies(V, false));
			for (int vertex = 0; vertex < V; vertex++) {
				if (visited.get(vertex).equals(false) ){
					bfsUtil(vertex, visited);
				}
			}
		}

		private void bfsUtil(int v, List<Boolean> visited) {
			Queue<Integer> queue = new LinkedList<>();
			queue.offer(v); // queue.add(v);

			while (!queue.isEmpty()) {
				int vertex = queue.poll(); // queue.remove();
				if (visited.get(vertex).equals(false)) {
					System.out.println(vertex + " ");
					visited.set(vertex, true);
				}

				// Add all adjacent Vertices.
				List<Integer> adjNode = this.adjNodes.get(v);
				for (Integer i : adjNode) {
					if (visited.get(i).equals(false)) {
						queue.offer(i);
					}
				}
			}
		}
	}
}
