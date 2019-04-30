package interviews;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author u230107
 * 
 *         Detect Cycle in a Directed Graph
 *
 *
 *         Refer https://www.geeksforgeeks.org/detect-cycle-in-a-graph/ Time
 *         Complexity = O(V + E)
 */
public class DirectedCircularGraph_Google {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Graph graph = new Graph(4); // 4 vertex
		graph.addEdge(0, 1);
		graph.addEdge(1, 2);
		graph.addEdge(2, 3);
		graph.addEdge(2, 0);
		graph.addEdge(3, 3);
		boolean isCircularGraph = graph.isCircularDirectedGraph();
		System.out.println("Is Directed Graph Circular = " + isCircularGraph); // Expected Output = true.
	}

	private static class Graph {
		static int V; // Number of Vertices
		private List<List<Integer>> adjNodes;

		Graph(int V) {
			Graph.V = V;
			adjNodes = new ArrayList<>();
			for (int i = 0; i < V; i++) {
				adjNodes.add(new LinkedList<>());
			}
		}

		private void addEdge(int source, int destination) {
			adjNodes.get(source).add(destination);
		}

		private boolean isCircularDirectedGraph() {
			boolean visited[] = new boolean[V];
			boolean recurssionSt[] = new boolean[V];

			for (int vertex = 0; vertex < V; vertex++) {
				if (isCircularDirectedGraphUtil(visited, recurssionSt, vertex)) {
					return true;
				}
			}
			return false;
		}

		private boolean isCircularDirectedGraphUtil(boolean[] visited, boolean[] recurssionSt, int vertex) {

			if (recurssionSt[vertex]) {
				return true; // If node is already present in the recursion stack, return true
			}

			if (visited[vertex]) {
				return false; // if node is already visited, return false.
			}

			// Mark current Vertex as Visited and recurssionSt as true.
			recurssionSt[vertex] = true;
			visited[vertex] = true;

			for (int v : adjNodes.get(vertex)) {
				if (isCircularDirectedGraphUtil(visited, recurssionSt, v)) {
					return true;
				}
			}
			recurssionSt[vertex] = false; // remove the vertex from recursion stack
			return false;
		}

	}
}
