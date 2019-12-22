package practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GraphBaeldung {

	public static void main(String[] args) {
		Graph g = new Graph().createGraph();

		System.out.println(g.getAdjVertices("Bob"));
	}
}

class vertex {
	String label;

	vertex(String label) {
		this.label = label;
	}
}

class Graph {
	private Map<vertex, List<vertex>> adjVertices;

	void addVertex(String label) {
		adjVertices.putIfAbsent(new vertex(label), new ArrayList<>());
	}

	void removeVertex(String label) {
		vertex v = new vertex(label);
		adjVertices.values().stream().forEach(e -> e.remove(v));
		adjVertices.remove(new vertex(label));
	}

	void addEdge(String label1, String label2) {
		vertex v1 = new vertex(label1);
		vertex v2 = new vertex(label2);
		adjVertices.get(v1).add(v2);
		adjVertices.get(v2).add(v1);
	}

	void removeEdge(String label1, String label2) {
		vertex v1 = new vertex(label1);
		vertex v2 = new vertex(label2);
		List<vertex> eV1 = adjVertices.get(v1);
		List<vertex> eV2 = adjVertices.get(v2);
		if (eV1 != null)
			eV1.remove(v2);
		if (eV2 != null)
			eV2.remove(v1);

	}

	Graph createGraph() {

		Graph graph = new Graph();
		graph.addVertex("Bob");
		graph.addVertex("Alice");
		graph.addVertex("Mark");
		graph.addVertex("Rob");
		graph.addVertex("Maria");

		graph.addEdge("Bob", "Alice");
		graph.addEdge("Bob", "Rob");
		graph.addEdge("Alice", "Mark");
		graph.addEdge("Rob", "Mark");
		graph.addEdge("Alice", "Maria");
		graph.addEdge("Rob", "Maria");

		return graph;

	}

	List<vertex> getAdjVertices(String label) {
		return adjVertices.get(new vertex(label));
	}

}