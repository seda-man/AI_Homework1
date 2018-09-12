package search;

public interface Search {
	Node search(Node root, GoalTest test);
	int numberOfNodesFromLastSearch();
}
