package cracking.structure;

public class CustomLinkedList {

	private LinkedListNode head;
	private int size;

	public CustomLinkedList(){
		this.head = null;
	}
	public CustomLinkedList(LinkedListNode headValue) {
		this.head = headValue;
	}
	
	

	public void add(int dataValue) {
		if (head == null) {
			LinkedListNode n = new LinkedListNode(dataValue);
		}

		LinkedListNode current = head;
		while (current.getNext() != null)
			current = current.getNext();

		current.setNext(new LinkedListNode(dataValue));
		size++;

	}

	public void remove(int dataValue) {
		if (head != null) {
			LinkedListNode current = head;
			while (current.getData() != dataValue) {
				current = current.getNext();
			}
			current.setNext(current.getNext().getNext());
			size--;
		}
	}

	public LinkedListNode getHead() {
		return head;
	}

	public void setHead(LinkedListNode head) {
		this.head = head;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	


}
