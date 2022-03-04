package home.ak.algo.graph.starter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author kundu
 *
 */
public class WeightedGraph {
	
	static class Node {
		int vertex;
		int weight;
		public Node(int vertex, int weight) {
			this.vertex = vertex;
			this.weight = weight;
		}
	}
	
	private Map<Integer, List<Node>> adjList;
	
	private int vertices;
	
	public WeightedGraph(int vertices) {
		this.vertices = vertices;
		adjList = new HashMap<>();
		for(int i = 0; i < vertices; i++) {
			adjList.put(i+1, new ArrayList<Node>());
		}
	}
	
	public void addDirectedEdge(int srcVertex, int destVertex, int weight) {
		adjList.get(srcVertex).add(new Node(destVertex, weight));
	}
	
	public void addUndirectedEdge(int srcVertex, int destVertex, int weight) {
		adjList.get(srcVertex).add(new Node(destVertex, weight));
		adjList.get(destVertex).add(new Node(srcVertex, weight));
	}
	
	public Map<Integer, List<Node>> getAdjacencyList(){
		return adjList;
	}
	

}
