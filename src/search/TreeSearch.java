package search;

public class TreeSearch implements Search {
	private Frontier frontier;

	public TreeSearch(Frontier frontier) {
		this.frontier = frontier;
	}

	@Override
	public Node search(Node root, GoalTest test) {
		frontier.clear();
		frontier.addNode(root);
		while (!frontier.isEmpty()) {
			Node currentNode = frontier.removeNode();
			if (test.isGoal(currentNode.state)) {
				return currentNode;
			} else {
				for (Action action : currentNode.state.getApplicableActions()) {
					State newState = currentNode.state.getActionResult(action);
					frontier.addNode(new Node(currentNode, action, newState));
				}
			}
		}
		return null;
	}

	@Override
	public int numberOfNodesFromLastSearch() {
		return frontier.maxNumberOfNodes();
	}
}
