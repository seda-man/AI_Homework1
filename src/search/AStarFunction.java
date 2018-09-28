package search;

public class AStarFunction implements NodeFunction {
	private NodeFunction heuristicFunction;


	public AStarFunction(NodeFunction heuristicFunction) {
		this.heuristicFunction = heuristicFunction;
	}

	@Override
	public int getNodeValue(Node n) {
		return n.costFromRoot + heuristicFunction.getNodeValue(n);
	}
}
