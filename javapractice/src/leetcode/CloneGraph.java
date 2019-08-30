/**
 * 
 */
package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * @author SIVA SAI
 *
 *
 *Given a reference of a node in a connected undirected graph, return a deep copy (clone) of the graph. Each node in the graph contains a val (int) and a list (List[Node]) of its neighbors.
 *Input:
{"$id":"1","neighbors":[{"$id":"2","neighbors":[{"$ref":"1"},{"$id":"3","neighbors":[{"$ref":"2"},{"$id":"4","neighbors":[{"$ref":"3"},{"$ref":"1"}],"val":4}],"val":3}],"val":2},{"$ref":"4"}],"val":1}

Explanation:
Node 1's value is 1, and it has two neighbors: Node 2 and 4.
Node 2's value is 2, and it has two neighbors: Node 1 and 3.
Node 3's value is 3, and it has two neighbors: Node 2 and 4.
Node 4's value is 4, and it has two neighbors: Node 1 and 3.
 *
 *
 *Refer https://www.youtube.com/watch?v=vma9tCQUXk8
 *Refer https://leetcode.com/problems/clone-graph/description/-->{Code}
 *
 *Time Complexity = O(Vertexes+Edges)
 *Space Complexity = o(Vertexes)
 */
public class CloneGraph {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Node start= new Node(1);
		Node node2= new Node(2);
		Node node3= new Node(3);
		Node node4= new Node(4);
		
		start.neighbors.add(node2);
		start.neighbors.add(node4);
		
		node2.neighbors.add(start);
		node2.neighbors.add(node3);
		
		node3.neighbors.add(node2);
		node3.neighbors.add(node4);
		
		node3.neighbors.add(start);
		node3.neighbors.add(node3);
		
		cloneGraph(start);
	}
	
	private static Node cloneGraph(Node node) {
		if(node==null) {
			return null;
		}
		
        Queue<Node> queue= new LinkedList<>();
        Map<Node,Node> vertixMap=new HashMap<>();
        
        queue.add(node);
        vertixMap.put(node, new Node(node.val));
        while(!queue.isEmpty() ) {
        	Node currentNode= queue.poll();
        	for(Node neighbor :currentNode.neighbors) {
        		if(!vertixMap.containsKey(neighbor) ){
        			// Add Vertex if not present in Map and Queue.        			
        			vertixMap.put(neighbor, new Node(neighbor.val));
        			queue.add(neighbor);
            	}
        		vertixMap.get(currentNode).neighbors.add(vertixMap.get(neighbor));// Add edges for currentNode
        	}
        }
        return vertixMap.get(node);
    }
	
	private static class Node {
	    public int val;
	    public List<Node> neighbors;

	    public Node(int _val) {
	        val = _val;
	        neighbors = new ArrayList<Node>();
	    }
	};

}
