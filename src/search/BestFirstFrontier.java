package search;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class BestFirstFrontier implements Frontier {
	private Queue<Node> frontier;
	private int numberOfAddedNodes = 0;
	private NodeFunction nodeFunction;

	 public BestFirstFrontier(NodeFunction nodeFunction) {
	 	frontier = new PriorityQueue<>(new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return o1.nodeValue - o2.nodeValue;
			}
		});
	 	this.nodeFunction = nodeFunction;
	 }

	@Override
	public void addNode(Node node) {
	 	int nodeValue = nodeFunction.getNodeValue(node);
	 	node.setNodeValue(nodeValue);
		if (frontier == null || frontier.isEmpty()) {
			frontier = new PriorityQueue<>(new Comparator<Node>() {
				@Override
				public int compare(Node o1, Node o2) {
					return o1.nodeValue - o2.nodeValue != 0 ? o1.nodeValue - o2.nodeValue : o1.costFromRoot - o2.costFromRoot;
				}
			});
		}
		frontier.add(node);
		numberOfAddedNodes++;
	}
	@Override
	public void clear() {
		if (frontier != null) {
			frontier.clear();
		} else {
			frontier = new PriorityQueue<>(new Comparator<Node>() {
				@Override
				public int compare(Node o1, Node o2) {
					return o1.nodeValue - o2.nodeValue;
				}
			});
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

	@Override
	public int size() {
		return frontier != null ? frontier.size() : 0;
	}
}
