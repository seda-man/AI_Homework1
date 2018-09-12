package search;

import java.util.HashSet;
import java.util.Set;

public class GraphSearch implements Search {
	private Frontier frontier;
	private Set<Node> visited = new HashSet<>();

	public GraphSearch(Frontier frontier) {
		this.frontier = frontier;
	}


	@Override
	public Node search(Node root, GoalTest test) {
		visited.clear();
		frontier.clear();
		frontier.addNode(root);
		while (!frontier.isEmpty()) {
			Node currentNode = frontier.removeNode();
			visited.add(currentNode);
			if (test.isGoal(currentNode.state)) {
				return currentNode;
			} else {
				System.out.println(frontier.maxNumberOfNodes());
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
		return visited.contains(node) || frontier.contains(node);
	}

	@Override
	public int numberOfNodesFromLastSearch() {
		return frontier.maxNumberOfNodes();
	}
}
