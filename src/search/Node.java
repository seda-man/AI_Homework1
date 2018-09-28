package search;

public class Node {
	public final Node parent;
	public final Action action;
	public final State state;
	public int nodeValue;
	public int costFromRoot;

	public Node(Node parent, Action action, State state) {
		this.parent = parent;
		this.action = action;
		this.state = state;
		if (parent != null) {
			this.costFromRoot = parent.costFromRoot + action.actionCost(parent, this, action);
		} else {
			this.costFromRoot = 0;
		}
	}

	public int getNodeValue() {
		return nodeValue;
	}

	public void setNodeValue(int nodeValue) {
		this.nodeValue = nodeValue;
	}
}
