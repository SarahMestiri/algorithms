import cracking.structure.Algorithm;
import cracking.structure.CustomLinkedList;
import cracking.structure.LinkedListNode;

public class Main {
	public static void main(String[] args) {	
	/*	LinkedListNode first = new LinkedListNode(0, null); //AssortedMethods.randomLinkedList(1000, 0, 2);
		LinkedListNode head = first;
		LinkedListNode second = first;
		CustomLinkedList list = new CustomLinkedList(head);
		for (int i = 1; i < 8; i++) {
			second = new LinkedListNode(i % 2, null);
			first.setNext(second);
			first = second;
		}*/
		CustomLinkedList list = new CustomLinkedList();
        list.setHead(new LinkedListNode(12));
        list.getHead().setNext(new LinkedListNode(1));
        list.getHead().getNext().setNext(new LinkedListNode(3));
        list.getHead().getNext().getNext().setNext(new LinkedListNode(12));
        list.getHead().getNext().getNext().getNext().setNext(new LinkedListNode(5));
		Algorithm algo = new Algorithm();
		algo.removeDups(list);
		for(int i=0;i<list.getSize();i++){
			
		}
}
}
