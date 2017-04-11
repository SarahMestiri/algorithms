package cracking.structure;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

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
}
