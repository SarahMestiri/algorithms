package cracking.structure;

public class LinkedListNode {
	
	private LinkedListNode next;
	
	private int data;
	
	public LinkedListNode(int dataValue, LinkedListNode nextValue){
		this.data = dataValue;
		this.next = nextValue;
	}
	public LinkedListNode(int dataValue){
		this.data = dataValue;
		this.next = null;
	}
	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}
	
	public LinkedListNode getNext(){
		return next;
	}
	
	public void setNext(LinkedListNode next){
		this.next = next;
	}

}
