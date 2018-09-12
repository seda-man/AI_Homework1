package search;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstFrontier implements Frontier {
	private Queue<Node> frontier;
	private int numberOfAddedNodes = 0;

	@Override
	public void addNode(Node node) {
		if (frontier == null || frontier.isEmpty()) {
			frontier = new LinkedList<>();
		}
		frontier.add(node);
		numberOfAddedNodes++;
	}

	@Override
	public void clear() {
		if (frontier != null) {
			frontier.clear();
		} else {
			frontier = new LinkedList<>();
		}
	}

	@Override
	public boolean isEmpty() {
		return frontier == null || frontier.isEmpty();
	}

	@Override
	public Node removeNode() {
		if (!isEmpty()) {
			return frontier.remove();
		} else {
			return null;
		}
	}

	@Override
	public boolean contains(Node node) {
		return frontier.contains(node);
	}

	@Override
	public int maxNumberOfNodes() {
		return numberOfAddedNodes;
	}
}
