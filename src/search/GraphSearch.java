package search;

import java.util.HashSet;
import java.util.Set;

public class GraphSearch implements Search {
	private Frontier frontier;
	private Set<State> visited = new HashSet<>();

	public GraphSearch(Frontier frontier) {
		this.frontier = frontier;
	}


	@Override
	public Node search(Node root, GoalTest test) {
		visited.clear();
		frontier.clear();
		frontier.addNode(root);
		while (!frontier.isEmpty()) {
			System.out.println("Size of frontier while processing current node " + frontier.size());
			Node currentNode = frontier.removeNode();
			if (test.isGoal(currentNode.state)) {
				return currentNode;
			} else {
				visited.add(currentNode.state);
				for (Action action : currentNode.state.getApplicableActions()) {
					State newState = currentNode.state.getActionResult(action);
					Node newNode = new Node(currentNode, action, newState);
					if (!isVisitedOrPresent(newNode)) {
						frontier.addNode(newNode);
					}
				}
			}
		}
		return null;
	}

	public boolean isVisitedOrPresent(Node node) {
		return visited.contains(node.state) || frontier.contains(node);
	}

	@Override
	public int numberOfNodesFromLastSearch() {
		return frontier.maxNumberOfNodes();
	}
}
