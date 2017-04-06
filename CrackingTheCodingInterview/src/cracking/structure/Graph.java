package cracking.structure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Graph {

	private int numVertices;
	private int numEdges;

	private HashMap<String, Vertex> verticesList;

	private List<Edge> edgesList;

	public Graph() {
		this.verticesList = new HashMap<String, Vertex>();
		this.setEdgesList(new ArrayList<Edge>());
	}

	public void addVertex(Vertex v) {
		if (!verticesList.containsKey(v.getLabel())) {
			verticesList.put(v.getLabel(), v);
			numVertices++;
		}
	}

	public void addEdge() {
		numEdges++;

	}

	public int getNumVertices() {
		return numVertices;
	}

	public void setNumVertices(int numVertices) {
		this.numVertices = numVertices;
	}

	public int getNumEdges() {
		return numEdges;
	}

	public void setNumEdges(int numEdges) {
		this.numEdges = numEdges;
	}

	/**
	 * @return the edgesList
	 */
	public List<Edge> getEdgesList() {
		return edgesList;
	}

	/**
	 * @param edgesList
	 *            the edgesList to set
	 */
	public void setEdgesList(List<Edge> edgesList) {
		this.edgesList = edgesList;
	}

}
