package practice;

import java.util.Iterator;
import java.util.LinkedList;

public class GraphImplementation {

	private int V;
	private LinkedList<Integer> adj[];

	public GraphImplementation(int v) {
		this.V = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; i++) {
			adj[i] = new LinkedList<>();
		}
	}

	void addEdge(int v, int w) {
		adj[v].add(w);
		adj[w].add(v);
	}

	void printVertexCover() {
		boolean visited[] = new boolean[this.V];
		for (int i = 0; i < this.V; i++) {
			visited[i] = false;

		}

		Iterator<Integer> i;

		for (int u = 0; u < V; u++) {
			// An edge is only picked when both visited[u]
			// and visited[v] are false
			if (visited[u] == false) {
				// Go through all adjacents of u and pick the
				// first not yet visited vertex (We are basically
				// picking an edge (u, v) from remaining edges.
				i = adj[u].iterator();
				while (i.hasNext()) {
					int v = i.next();
					if (visited[v] == false) {
						// Add the vertices (u, v) to the result
						// set. We make the vertex u and v visited
						// so that all edges from/to them would
						// be ignored
						visited[v] = true;
						visited[u] = true;
						break;
					}
				}
			}
		}
		for (int j=0; j<V; j++) 
            if (visited[j]) 
              System.out.print(j+" "); 
	}
	
	public static void main(String[] args) {
		GraphImplementation g = new GraphImplementation(7); 
        g.addEdge(0, 1); 
        g.addEdge(0, 2); 
        g.addEdge(1, 3); 
        g.addEdge(3, 4); 
        g.addEdge(4, 5); 
        g.addEdge(5, 6); 
  
        g.printVertexCover(); 
	}

}
