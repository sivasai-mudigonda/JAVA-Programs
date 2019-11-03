/**
* 
*/
package Interviews;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author u230107 Detect cycle in an undirected graph
 *
 *         Refer https://www.geeksforgeeks.org/detect-cycle-undirected-graph/
 *
 *         Time Complexity = O(V+E)
 */
public class UndirectedCircularGraph_Google {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Graph g1 = new Graph(5);
		g1.addEdge(1, 0);
		g1.addEdge(0, 2);
		g1.addEdge(2, 0);
		g1.addEdge(0, 3);
		g1.addEdge(3, 4);
		if (g1.isCircularUnDirectedGraph())
			System.out.println("Graph contains cycle");
		else
			System.out.println("Graph doesn't contains cycle");

		Graph g2 = new Graph(3);
		g2.addEdge(0, 1);
		g2.addEdge(1, 2);
		if (g2.isCircularUnDirectedGraph())
			System.out.println("Graph contains cycle");
		else
			System.out.println("Graph doesn't contains cycle");
	}

	private static class Graph {
		int V;
		List<List<Integer>> adjNodes;

		Graph(int V) {
			this.V = V;
			adjNodes = new ArrayList<>();
			for (int vertex = 0; vertex < V; vertex++) {
				adjNodes.add(new LinkedList<>());
			}
		}

		void addEdge(int v, int w) {
			adjNodes.get(v).add(w);
			adjNodes.get(w).add(v);
		}

		private boolean isCircularUnDirectedGraph() {
			boolean visited[] = new boolean[V];
			Arrays.fill(visited, Boolean.FALSE);
			for (int u = 0; u < V; u++) {
				if (!visited[u]) {
					if (isCircularUnDirectedGraphUtil(visited, u, -1)) {
						return true;
					}
				}
			}
			return false;
		}

		private boolean isCircularUnDirectedGraphUtil(boolean visited[], int u, int parent) {

			visited[u] = true;
			Iterator<Integer> it = adjNodes.get(u).listIterator();
			while (it.hasNext()) {
				int v = it.next();
				if (!visited[v]) {
					if (isCircularUnDirectedGraphUtil(visited, v, u)) {
						return true;
					}
				} else if (parent != v) {
					// If an adjacent is visited and not parent of current
					// vertex, then there is a cycle.
					return true;
				}
			}
			return false;
		}
	}

}
