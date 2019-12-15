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

	public static void main(String[] args) {
		GraphImplementation g = new GraphImplementation();

		g.Graph(5);

		g.addEdge(g, 0, 1);
		g.addEdge(g, 0, 4);
		g.addEdge(g, 1, 2);
		g.addEdge(g, 1, 3);
		g.addEdge(g, 1, 4);
		g.addEdge(g, 2, 3);
		g.addEdge(g, 3, 4);

		g.printGraph(g);
	}
}
