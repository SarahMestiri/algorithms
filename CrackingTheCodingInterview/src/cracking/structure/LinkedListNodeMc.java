package cracking.structure;

/**
 * 
 * Proposed class from Gayle
 * link https://github.com/careercup/ctci/blob/master/java/CtCILibrary/CtCILibrary/LinkedListNode.java
 *
 */
public class LinkedListNodeMc {
	
		public LinkedListNodeMc next;
		public LinkedListNodeMc prev;
		public LinkedListNodeMc last;
		public int data;
		
		public LinkedListNodeMc(int d, LinkedListNodeMc n, LinkedListNodeMc p) {
			data = d;
			setNext(n);
			setPrevious(p);
		}
		
		public LinkedListNodeMc() { }

		public void setNext(LinkedListNodeMc n) {
			next = n;
			if (this == last) {
				last = n;
			}
			if (n != null && n.prev != this) {
				n.setPrevious(this);
			}
		}
		
		public void setPrevious(LinkedListNodeMc p) {
			prev = p;
			if (p != null && p.next != this) {
				p.setNext(this);
			}
		}	
		
		public String printForward() {
			if (next != null) {
				return data + "->" + next.printForward();
			} else {
				return ((Integer) data).toString();
			}
		}
		
		public LinkedListNodeMc clone() {
			LinkedListNodeMc next2 = null;
			if (next != null) {
				next2 = next.clone();
			}
			LinkedListNodeMc head2 = new LinkedListNodeMc(data, next2, null);
			return head2;
		}
}
