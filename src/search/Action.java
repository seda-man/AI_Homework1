package search;

public interface Action {
	int actionCost(Node parent, Node child, Action action);
}
