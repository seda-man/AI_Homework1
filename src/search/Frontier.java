package search;

public interface Frontier {
	void addNode(Node node);
	void clear();
	boolean isEmpty();
	Node removeNode();
	boolean contains(Node node);
	int maxNumberOfNodes();
}
