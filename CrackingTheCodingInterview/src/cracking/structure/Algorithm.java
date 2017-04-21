package cracking.structure;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Stack;

public class Algorithm {

	public void removeDups(CustomLinkedList list) {
		HashSet<Integer> set = new HashSet<Integer>();
		LinkedListNode current = list.getHead();
		LinkedListNode prev = null;
		while (current != null) {
			if (set.contains(current.getData())) {
				current.setNext(current.getNext());
				prev.setNext(current.getNext());
			} else {
				set.add(current.getData());
				prev = current;
			}
			current = current.getNext();
		}
	}

	public CustomLinkedList partition(CustomLinkedList list, int x) {
		CustomLinkedList beforeL = new CustomLinkedList();
		CustomLinkedList afterL = new CustomLinkedList();
		LinkedListNode current = list.getHead();
		while (current != null) {
			if (current.getData() < x) {
				addToLinkedList(beforeL, current.getData());
			} else {
				addToLinkedList(afterL, current.getData());
			}
			// increment current
			current = current.getNext();
		}
		if (beforeL.getHead() == null)
			return afterL;
		concatLinkedLists(beforeL, afterL);
		return beforeL;
	}

	public void addToLinkedList(CustomLinkedList list, int value) {
		LinkedListNode newHead = new LinkedListNode(value);
		LinkedListNode cur = list.getHead();
		if (cur == null)
			list.setHead(newHead);
		else {
			newHead.setNext(cur);
			list.setHead(newHead);
		}
	}

	public void concatLinkedLists(CustomLinkedList list1, CustomLinkedList list2) {
		LinkedListNode start = list1.getHead();
		LinkedListNode prev = null;
		while (start != null) {
			prev = start;
			start = start.getNext();
		}
		prev.setNext(list2.getHead());
	}

	public Node[] buildOrder(String[] projects, String[][] dependencies) {
		Node[] buildOrder = new Node[projects.length];
		int count = 0;
		/**** Build the graph ***/
		GraphExercice graph = buildGraph(projects, dependencies);
		/** search nodes that don't have incoming edges ***/
		int endOfList = addNonDependant(buildOrder, graph.getNodes(), 0);
		/**********
		 * For each independant (with no incoming edges) node, remove outgoing
		 * edges
		 **************/
		while (count < buildOrder.length) {
			Node currentNode = buildOrder[count];

			if (currentNode == null)
				return null;
			ArrayList<Node> children = currentNode.getChildren();
			for (Node child : children) {
				child.decrementDependencies();
			}
			endOfList = addNonDependant(buildOrder, graph.getNodes(), endOfList);
			count++;
		}
		return buildOrder;
	}

	public GraphExercice buildGraph(String[] nodes, String[][] edges) {
		GraphExercice graph = new GraphExercice();
		for (String node : nodes) {
			graph.getOrCreateNode(node);
		}
		for (String[] edge : edges) {
			graph.addEdge(edge[0], edge[1]);
		}
		return graph;
	}

	public int addNonDependant(Node[] order, List<Node> projects, int start) {
		for (Node project : projects) {
			if (project.getNumberDependencies() == 0) {
				order[start] = project;
				start++;
			}
		}
		return start;
	}

	public boolean isPalindromeList(LinkedList<Integer> list) {
		boolean isPalindrome = true;
		Stack<Integer> s = new Stack<Integer>();
		Iterator<Integer> iterator = list.iterator();
		// step1: iterate over the list and each put the element in the Stack
		while (iterator.hasNext()) {
			s.push(iterator.next());
		}
		// step2: pop elements from Stack and compare it while iterating through
		// the list
		Iterator<Integer> iterator2 = list.iterator();
		while (iterator2.hasNext()) {
			if (s.pop() != iterator2.next()) {
				return false;
			}
		}
		// for example List = {1,2,5,3}. Stack.pop()=3 do compare 3 == 1 if no
		// return false else continue
		// repeat pop() and compare with next element in the List
		return isPalindrome;
	}

	public boolean isPalindromeList(LinkedListNodeMc list) {
		boolean isPalindrome = true;
		Stack<Integer> s = new Stack<Integer>();
		LinkedListNodeMc current = list;
		// Iterator<Integer> iterator = list.iterator();
		// step1: iterate over the list and each put the element in the Stack
		while (current != null) {
			s.push(current.data);
			current = current.next;
		}
		// step2: pop elements from Stack and compare it while iterating through
		// the list
		current = list;
		while (current != null) {
			System.out.println(s.peek());
			if (s.pop() != current.data) {
				return false;
			}
			current = current.next;
		}
		// for example List = {1,2,5,3}. Stack.pop()=3 do compare 3 == 1 if no
		// return false else continue
		// repeat pop() and compare with next element in the List
		return isPalindrome;
	}

	public int sizeList(CustomLinkedList list) {
		LinkedListNode current = list.getHead();
		int s = 0;
		while (current != null) {
			current = current.getNext();
			s++;
		}
		return s;
	}

	// NOTE: not best solution, check the one of the book which considers the
	// tail of each list and return the node.
	public int intersectLinkedList(CustomLinkedList list1, CustomLinkedList list2) {
		// step 1: calculate size list 1
		int c1 = sizeList(list1);
		// step 2: calculate size list 2
		int c2 = sizeList(list2);
		// step 3: calculate the difference
		int d = Math.abs(c1 - c2);
		// step 4: traverse the bigger list until d node
		LinkedListNode startNode = null;
		int count = 0;
		if (c1 > c2) {
			LinkedListNode current = list1.getHead();
			if (current == null)
				return -1;
			while (current != null && count < d) {
				current = current.getNext();
				count++;
			}
			startNode = current;
			LinkedListNode currentS = list2.getHead();
			while (currentS != null && startNode != null) {
				if (currentS.getData() == startNode.getData())
					return currentS.getData();
				currentS = currentS.getNext();
				startNode = startNode.getNext();
			}
		} else if (c1 <= c2) {
			LinkedListNode current = list2.getHead();
			if (current == null)
				return -1;
			while (current != null && count < d) {
				current = current.getNext();
				count++;
			}
			startNode = current;

			LinkedListNode currentS = list1.getHead();
			while (currentS != null && startNode != null) {
				if (currentS.getData() == startNode.getData())
					return currentS.getData();
				currentS = currentS.getNext();
				startNode = startNode.getNext();
			}
		}
		return -1;
	}

}
