package practice;

import java.util.LinkedList;

public class WorkingWithGraph {

	int v;
	LinkedList<Integer> adjListArray[];

	public WorkingWithGraph(int v) {

		this.v = v;

		adjListArray = new LinkedList[v];

		for (int i = 0; i < v; i++) {
			adjListArray[i] = new LinkedList<>();
		}

	}

	static void addEdge(WorkingWithGraph graph, int src, int dst) {
		graph.adjListArray[src].add(dst);
		graph.adjListArray[dst].add(src);
	}

	static void printGraph(WorkingWithGraph graph) {

		for (int v = 0; v < graph.v; v++) {

			System.out.print("Adjacency list of vertex " + v);
			System.out.print(" head");

			for (Integer pCrawl : graph.adjListArray[v]) {
				System.out.print("-> " + pCrawl);
			}

			System.out.println("\n");
		}
	}

	public static void main(String[] args) {
		int v = 5;

		WorkingWithGraph graph = new WorkingWithGraph(v);

		graph.addEdge(graph, 0, 1);
		graph.addEdge(graph, 0, 4);
		graph.addEdge(graph, 1, 2);
		graph.addEdge(graph, 1, 3);
		graph.addEdge(graph, 1, 4);
		graph.addEdge(graph, 2, 3);
		graph.addEdge(graph, 3, 4);
		
		printGraph(graph);

	}

}
