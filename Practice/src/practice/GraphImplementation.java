package practice;

import java.util.Iterator;
import java.util.LinkedList;

public class GraphImplementation {

	int V;
	LinkedList<Integer> adjListArray[];

	void Graph(int v) {
		this.V = v;
		adjListArray = new LinkedList[V]; // Define the size of the array - the number of vertices
		for (int i = 0; i < v; i++) {
			adjListArray[i] = new LinkedList<>(); // Initialize the with a list of vertices
		}
	}

	void addEdge(GraphImplementation g, int src, int dst) { // adding edge to a undirectional graph
		g.adjListArray[src].add(dst); // adding edge from source to destination
		g.adjListArray[dst].add(src);// adding edge from destination to source
	}

	void printGraph(GraphImplementation g) {
		for (int v = 0; v < g.V; v++) {
			System.out.print("head : " + v);
			for (Integer n : g.adjListArray[v]) {
				System.out.print("->" + n);
			}
			System.out.println();
		}
	}

	void DFSUtil(int n, boolean visited[]) {
		visited[n] = true;
		System.out.print(n + " ");

		Iterator<Integer> it = adjListArray[n].iterator();
		while (it.hasNext()) {
			int n1 = it.next();
			if (!visited[n1]) {
				DFSUtil(n1, visited);
			}
		}
	}

	void DFS(int n) {
		boolean visited[] = new boolean[V];
		DFSUtil(n, visited);
	}

	public static void main(String[] args) {
		GraphImplementation g = new GraphImplementation();

		g.Graph(7);

		g.addEdge(g, 0, 1);
		g.addEdge(g, 0, 3);
		g.addEdge(g, 1, 2);
		g.addEdge(g, 1, 3);
		g.addEdge(g, 1, 5);
		g.addEdge(g, 1, 6);
		g.addEdge(g, 2, 1);
		g.addEdge(g, 2, 3);
		g.addEdge(g, 2, 4);
		g.addEdge(g, 2, 5);
		g.addEdge(g, 3, 0);
		g.addEdge(g, 3, 2);
		g.addEdge(g, 3, 4);
		g.addEdge(g, 4, 3);
		g.addEdge(g, 4, 2);
		g.addEdge(g, 5, 1);
		g.addEdge(g, 5, 2);
		g.addEdge(g, 6, 1);
		g.addEdge(g, 6, 4);
		

		g.printGraph(g);
		System.out.println("DFS");
		g.DFS(0);
	}
}
