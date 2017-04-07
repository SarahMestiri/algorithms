package cracking.structure;

import java.util.ArrayList;
import java.util.HashMap;

public class GraphExercice {

	private ArrayList<Node> nodes;
	private HashMap<String, Node> map;
	
	public Node getOrCreateNode(String label){
		if (!map.containsKey(label)) {
			Node node = new Node(label);
			nodes.add(node);
			map.put(label, node);
		}
		
		return map.get(label);
	}
	
	public void addEdge(String startName, String endName) {
		Node start = getOrCreateNode(startName);
		Node end = getOrCreateNode(endName);
		start.addNeighbor(end);
	}
	
	public ArrayList<Node> getNodes() {
		return nodes;
	}
}
