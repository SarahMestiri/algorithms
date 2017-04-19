package cracking.structure;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class NodeDoublyLinked<T> implements Iterable<T> {

	private T data;
	private NodeDoublyLinked<T> prev;
	private NodeDoublyLinked<T> next;

	public NodeDoublyLinked(){
		
	}
	public NodeDoublyLinked(T value, NodeDoublyLinked<T> previousN, NodeDoublyLinked<T> nextN) {
		this.data = value;
		this.prev = previousN;
		this.next = nextN;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public NodeDoublyLinked<T> getPrev() {
		return prev;
	}

	public void setPrev(NodeDoublyLinked<T> prev) {
		this.prev = prev;
	}

	public NodeDoublyLinked<T> getNext() {
		return next;
	}

	public void setNext(NodeDoublyLinked<T> next) {
		this.next = next;
	}

	@Override
	public Iterator<T> iterator() {
		return new NodeDoublyLinkedIterator();
	}

	private class NodeDoublyLinkedIterator implements Iterator<T> {
		// the current node returned by next()
		NodeDoublyLinked<T> current = prev.next;

		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public T next() {
			if (!hasNext())
				throw new NoSuchElementException();
			T item = current.data;
			current = current.next;
			return item;

		}
		
		public void remove(){
			NodeDoublyLinked<T> lastAccessed = current;
			NodeDoublyLinked<T> previousElmt = lastAccessed.prev;
			NodeDoublyLinked<T> nextElement = lastAccessed.next;
			
			previousElmt.next = nextElement;
			nextElement.prev = previousElmt;
			current = nextElement;
			
		}

	}

}
