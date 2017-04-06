package cracking.structure;

public class Edge {
	
	private String startVertex;
	private String endVertex;
	private int weight;
	
	/**
	 * @return the weight
	 */
	public int getWeight() {
		return weight;
	}
	/**
	 * @param weigth the weight to set
	 */
	public void setWeight(int weight) {
		this.weight = weight;
	}
	/**
	 * @return the startVertex
	 */
	public String getStartVertex() {
		return startVertex;
	}
	/**
	 * @param startVertex the startVertex to set
	 */
	public void setStartVertex(String startVertex) {
		this.startVertex = startVertex;
	}
	/**
	 * @return the endVertex
	 */
	public String getEndVertex() {
		return endVertex;
	}
	/**
	 * @param endVertex the endVertex to set
	 */
	public void setEndVertex(String endVertex) {
		this.endVertex = endVertex;
	}

}
