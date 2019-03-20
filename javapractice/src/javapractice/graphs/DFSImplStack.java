/**
* 
*/
package graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author u230107
 *
 */
public class DFSImplStack {

	/**
	 * @param args
	 * Refer https://www.geeksforgeeks.org/iterative-depth-first-traversal/
	 * 
	 * Time Complexity =  O(V + E)
	 */
	public static void main(String[] args) {
		// Collections.nCopies(60, 0);
		Graph dfsGraph = new Graph(5);
		dfsGraph.addEdge(1, 0);
		dfsGraph.addEdge(2, 1);
		dfsGraph.addEdge(3, 4);
		dfsGraph.addEdge(4, 0);
		dfsGraph.dfs();
	}

	private static class Graph {
		int V; // Total num of Vertices
		List<List<Integer>> adjNodes;

		public Graph(int v) {
			this.V = v;
			this.adjNodes = new LinkedList<List<Integer>>();
			for (int i = 0; i < v; i++) {
				adjNodes.add(i, new LinkedList<Integer>());
			}
		}

		//
		private void addEdge(int vertix, int connectingNode) {
			this.adjNodes.get(vertix).add(connectingNode);
		}

		private void dfs() {
			List<Boolean> visited = new ArrayList<>(Collections.nCopies(V, false));
			for (int vertix = 0; vertix < V; vertix++) {
				if (visited.get(vertix).equals(false)) {
					dfsUtil(vertix, visited);
				}
			}
		}

		private void dfsUtil(int v, List<Boolean> visited) {

			Stack<Integer> st = new Stack<>();
			st.push(v);

			while (!st.isEmpty()) {
				int vertix = st.pop();
				if (visited.get(vertix).equals(false)) {
					System.out.println(vertix + " ");
					visited.set(vertix, true);
				}
				List<Integer> adjNode = adjNodes.get(vertix);
				for (Integer i : adjNode) {
					if (visited.get(i).equals(false)) {
						st.push(i);
					}
				}
			}
		}
	}

}