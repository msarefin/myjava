package practice;

import java.awt.Adjustable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GraphBaeldung {

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
		adjVertices.values().stream().forEach(e-> e.remove(v));
		adjVertices.remove(new vertex(label)); 
	}
	

	void addEdge(String label1, String label2) {
		vertex v1= new vertex(label1); 
		vertex v2 = new vertex(label2); 
		adjVertices.get(v1).add(v2); 
		adjVertices.get(v2).add(v1);
	}
	
	void removeEdge(String label1, String label2) {
		vertex v1 = new vertex(label1);
		vertex v2 = new vertex(label2);
		
		
	}
	
}