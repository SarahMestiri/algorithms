package cracking.structure;

import java.util.ArrayList;
import java.util.List;

public class Vertex {
	
	private String label;
	
	private List<String> neighbors;
	
	public List<Integer> getNeighbors(int v){
	List<Integer> neighbors = new ArrayList<Integer>();
	return neighbors;
}

	/**
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * @param label the label to set
	 */
	public void setLabel(String label) {
		this.label = label;
	}

	/**
	 * @return the neighbors
	 */
	public List<String> getNeighbors() {
		return neighbors;
	}

	/**
	 * @param neighbors the neighbors to set
	 */
	public void setNeighbors(List<String> neighbors) {
		this.neighbors = neighbors;
	}

}
