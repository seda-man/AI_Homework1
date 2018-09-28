package search;

import npuzzle.Tiles;

public class MisplacedTilesHeuristicFunction implements NodeFunction {

	@Override
	public int getNodeValue(Node n) {
		State s = n.state;
		int misplacedTilesNumber = 0;
		if (s instanceof Tiles) {
			int[] tiles = ((Tiles) s).getTiles();
			int i = 0;
			for (; i < tiles.length - 1; i++) {
				if (tiles[i] != i + 1) {
					misplacedTilesNumber++;
				}
			}
			if (tiles[i] != 0) {
				misplacedTilesNumber++;
			}
		}
		return misplacedTilesNumber;
	}
}
