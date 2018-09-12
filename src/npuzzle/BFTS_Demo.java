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

		// This configuration is tacking too much time try to find faster solution with other configurations
		Tiles initialConfiguration = new Tiles(new int[][] {
				{ 7, 4, 2 },
				{ 8, 1, 3 },
				{ 5, 0, 6 }
		});



		// I tried with this one and got for graph search with bff
		// size of frontier at solution time: 63
		// max size of frontier: 98

		// for graph search with dff
		// size of frontier at solution time: 6
		// max size of frontier: 9

		// for tree search with bff
		// size of frontier at solution time: 63
		// max size of frontier: 98

		// for tree search with dff
		// size of frontier at solution time: 6
		// max size of frontier: 9

		// so in this case it wasn't important what structure we are using
		// but it was important what algorithm I used and dff performed much better
//		Tiles initialConfiguration = new Tiles(new int[][] {
//				{ 1, 0, 2 },
//				{ 4, 5, 3 },
//				{ 7, 8, 6 }
//		});


		GoalTest goalTest = new TilesGoalTest();
		Node root = new Node(null, null, initialConfiguration);
		Search s;
		NPuzzlePrinting print = new NPuzzlePrinting();

		// to try the solutions uncomment the blocks of code :))

		// 1. graph search with breadth first frontier
//		s = new GraphSearch(new BreadthFirstFrontier());
//		System.out.println("graph search with breadth first frontier");
//		Node solution = s.search(root, goalTest);
//		print.printSolution(solution);
//		System.out.println("max size of bff in GraphSearch");
//		System.out.println(s.numberOfNodesFromLastSearch());
//		System.out.println("________________________________________________");


		// 2. graph search with depth first frontier
//		s = new GraphSearch(new DepthFirstFrontier());
//		System.out.println("graph search with depth first frontier");
//		Node solution1 = s.search(root, goalTest);
//		print.printSolution(solution1);
//		System.out.println("max size of dff in GraphSearch");
//		System.out.println(s.numberOfNodesFromLastSearch());
//		System.out.println("________________________________________________");


		// 3. tree search with breadth first frontier
//		s = new TreeSearch(new BreadthFirstFrontier());
//		System.out.println("tree search with breadth first frontier");
//		Node solution2 = s.search(root, goalTest);
//		print.printSolution(solution2);
//		System.out.println(s.numberOfNodesFromLastSearch());
//		System.out.println("max size of bff in TreeSearch");
//		System.out.println(s.numberOfNodesFromLastSearch());
//		System.out.println("________________________________________________");

		// 4. tree search with depth first frontier
//		s = new TreeSearch(new DepthFirstFrontier());
//		System.out.println("tree search with depth first frontier");
//		Node solution3 = s.search(root, goalTest);
//		print.printSolution(solution3);
//		System.out.println("max size of dff in GraphSearch");
//		System.out.println(s.numberOfNodesFromLastSearch());
//		System.out.println("________________________________________________");

	}
}
