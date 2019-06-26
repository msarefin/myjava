package graphAlgorithm;

import java.awt.Adjustable;
import java.util.LinkedList;

public class Graph {

	int v; 
	LinkedList<Integer> adjListArray[]; 
	
	Graph (int v){
		this.v = v; 
		adjListArray = new LinkedList[v]; 
		
		for(int i = 0; i<v; i++) {
			adjListArray[i] = new  LinkedList<>();
		}
	}
	
	static void addEdge(Graph graph , int source , int destinatio ) {
		graph.adjListArray[source].add(destinatio); 
		graph.adjListArray[destinatio].add(source); 
	}
	
	static void printGraph(Graph graph) {
		for(int v = 0; v<graph.v; v++) {
			for(Integer n : graph.adjListArray[v]) {
				System.out.print("->"+n);
			}
			System.out.println("\n");
		}
	}
	
	
	
	public static void main(String[] args) {
		Graph graph = new Graph(5); 
		
		graph.addEdge(graph, 0, 1);
		graph.addEdge(graph, 0, 4);
		graph.addEdge(graph, 1, 2);
		graph.addEdge(graph, 1, 3);
		graph.addEdge(graph, 1, 4);
		graph.addEdge(graph, 3, 4);
		graph.addEdge(graph, 4, 3);
		
		graph.printGraph(graph);
		
	}
}
