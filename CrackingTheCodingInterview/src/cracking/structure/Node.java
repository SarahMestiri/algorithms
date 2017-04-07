package cracking.structure;

import java.util.ArrayList;
import java.util.HashMap;

public class Node {
	
	private ArrayList<Node> children = new ArrayList<Node>();
	private HashMap<String, Node> map = new HashMap<String, Node>();
	private String name;
	private int dependencies = 0;

	public Node(String n) {
		name = n;
	}

	public String getName() {
		return name;
	}

	public void addNeighbor(Node node) {
		if (!map.containsKey(node.getName())) {
			children.add(node);
			map.put(node.getName(), node);
			node.incrementDependencies();
		}
	}

	public void incrementDependencies() {
		dependencies++;
	}

	public ArrayList<Node> getChildren() {
		return children;
	}

	public void decrementDependencies() {
		dependencies--;
	}

	public int getNumberDependencies() {
		return dependencies;
	}
}
