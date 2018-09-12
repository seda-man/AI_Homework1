package search;

import java.util.Stack;

public class DepthFirstFrontier implements Frontier {
	private Stack<Node> frontier;
	private int numberOfAddedNodes = 0;

	@Override
	public void addNode(Node node) {
		if (frontier.isEmpty()) {
			frontier = new Stack<>();
		}
		frontier.add(node);
		numberOfAddedNodes++;
	}

	@Override
	public void clear() {
		if (frontier != null) {
			frontier.clear();
		} else {
			frontier = new Stack<>();
		}
	}

	@Override
	public boolean isEmpty(){
		return frontier == null || frontier.isEmpty();
	}

	@Override
	public Node removeNode() {
		if (!isEmpty()) {
			return frontier.pop();
		} else {
			return null;
		}
	}

	@Override
	public boolean contains(Node node) {
		if (!isEmpty()) {
			return frontier.contains(node);
		} else {
			return false;
		}
	}

	@Override
	public int maxNumberOfNodes() {
		return numberOfAddedNodes;
	}
}
