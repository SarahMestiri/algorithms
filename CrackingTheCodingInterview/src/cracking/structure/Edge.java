package cracking.structure;

public class Edge {
	
	private String startVertex;
	private String endVertex;
	private int weigth;
	
	/**
	 * @return the weigth
	 */
	public int getWeigth() {
		return weigth;
	}
	/**
	 * @param weigth the weigth to set
	 */
	public void setWeigth(int weigth) {
		this.weigth = weigth;
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
