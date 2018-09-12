package npuzzle;

import search.BreadthFirstFrontier;
import search.BreadthFirstTreeSearch;
import search.DepthFirstFrontier;
import search.Frontier;
import search.GoalTest;
import search.GraphSearch;
import search.Node;
import search.Search;
import search.TreeSearch;

public class BFTS_Demo {
	public static void main(String[] args) {
		System.out.println("This is a demonstration of breadth-first tree search on 8-puzzle");
		System.out.println();

//		Tiles initialConfiguration = new Tiles(new int[][] {
//				{ 7, 4, 2 },
//				{ 8, 1, 3 },
//				{ 5, 0, 6 }
//		});


		Tiles initialConfiguration = new Tiles(new int[][] {
				{ 1, 0, 2},
				{ 4, 5, 3},
				{ 7, 8, 6 }
		});

		GoalTest goalTest = new TilesGoalTest();
//		Node solution = BreadthFirstTreeSearch.findSolution(initialConfiguration, goalTest);

		Node root = new Node(null, null, initialConfiguration);

		Search s;

		NPuzzlePrinting print = new NPuzzlePrinting();

//		// graph search with breadth first frontier
//		s = new GraphSearch(new BreadthFirstFrontier());
//		Node solution = s.search(root, goalTest);
//		System.out.println("graph search with breadth first frontier");
//		print.printSolution(solution);


//		// graph search with depth first frontier
//		s = new GraphSearch(new DepthFirstFrontier());
//		Node solution = s.search(root, goalTest);
//		System.out.println("graph search with depth first frontier");
//		print.printSolution(solution);
//
//
		//tree search with breadth first frontier
//		s = new TreeSearch(new BreadthFirstFrontier());
//		Node solution = s.search(root, goalTest);
//		System.out.println("tree search with breadth first frontier");
//		print.printSolution(solution);
//		System.out.println(s.numberOfNodesFromLastSearch());
//
		// tree search with depth first frontier
		s = new TreeSearch(new DepthFirstFrontier());
		Node solution = s.search(root, goalTest);
		System.out.println("tree search with depth first frontier");
		print.printSolution(solution);

	}
}
