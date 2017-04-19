package cracking.structure;

public class DoublyLinkedList<T>{
	
	// sentinel before first item
	private NodeDoublyLinked<T> head;
	// sentinel after last item
	private NodeDoublyLinked<T> tail;
	//number of elements
	private int size;
	
	public NodeDoublyLinked<T> getHead() {
		return head;
	}
	public void setHead(NodeDoublyLinked<T> head) {
		this.head = head;
	}
	public NodeDoublyLinked<T> getTail() {
		return tail;
	}
	public void setTail(NodeDoublyLinked<T> tail) {
		this.tail = tail;
	}
	
	public boolean isEmpty(){
		return size==0;
	}
	
	public void addNode(T data){
		
		NodeDoublyLinked<T> prev = tail.getPrev();
		NodeDoublyLinked<T> node = new NodeDoublyLinked<T>(data, prev, tail);
		tail.setPrev(node);
		size++;
		
	}
	
	
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
}
