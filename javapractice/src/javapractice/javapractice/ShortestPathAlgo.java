package javapractice;

// Greedy Method
// Disadvantage- Will not work for negative numbers.
public class ShortestPathAlgo {
	int VERTICES=9;
	public static void main(String[] args) {
		/* Let us create the example graph discussed above */
	       int graph[][] = new int[][]{{0, 4, 0, 0, 0, 0, 0, 8, 0}, 
	                                  {4, 0, 8, 0, 0, 0, 0, 11, 0}, 
	                                  {0, 8, 0, 7, 0, 4, 0, 0, 2}, 
	                                  {0, 0, 7, 0, 9, 14, 0, 0, 0}, 
	                                  {0, 0, 0, 9, 0, 10, 0, 0, 0}, 
	                                  {0, 0, 4, 14, 10, 0, 2, 0, 0}, 
	                                  {0, 0, 0, 0, 0, 2, 0, 1, 6}, 
	                                  {8, 11, 0, 0, 0, 0, 1, 0, 7}, 
	                                  {0, 0, 2, 0, 0, 0, 6, 7, 0} 
	                                 }; 
	        ShortestPathAlgo t = new ShortestPathAlgo(); 
	        t.dijkstra(graph, 0); 
	}
	
	private int minVetixIndex(Boolean splSet[],int dis[]) {
		int min_index = -1;
		int min = Integer.MAX_VALUE;
		for(int v=0;v<VERTICES;v++) {
			if(!splSet[v] && dis[v]<=min) {
				min= dis[v];
				min_index=v;
			}
		}
		return min_index;
	}
	
	private void dijkstra(int[][] graph, int src){
		int dis[] = new int[VERTICES];
		Boolean splSet[]= new Boolean[VERTICES];
		
		for(int i=0;i<VERTICES;i++) {
			dis[i]= Integer.MAX_VALUE;
			splSet[i]=false;
		}
		dis[src]=0;
		
		// Start iterate through all vertices
		for(int i=0;i<VERTICES;i++) {
			int u= minVetixIndex(splSet,dis); // Find minimum vertix index from current node.
			splSet[u]=true;
			// To update distance of connecting vertices from current vertex.
			for(int v=0;v<VERTICES;v++) {
				if(!splSet[v] && graph[u][v]!=0 && (dis[u]+graph[u][v])< dis[v] && dis[u]!=Integer.MAX_VALUE){
					dis[v]=dis[u]+graph[u][v];
				}
			}
		}
		printSol(dis);
	}
	
	private void printSol(int dis[]) {
		for(int i=0;i<VERTICES;i++) {
			System.out.println(i +"\t" +dis[i]);
		}
	}

}
