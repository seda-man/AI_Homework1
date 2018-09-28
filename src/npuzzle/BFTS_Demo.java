package npuzzle;

import search.AStarFunction;
import search.BestFirstFrontier;
import search.BreadthFirstFrontier;
import search.DepthFirstFrontier;
import search.GoalTest;
import search.GraphSearch;
import search.MisplacedTilesHeuristicFunction;
import search.Node;
import search.Search;
import search.TreeSearch;

public class BFTS_Demo {


	public static void main(String[] args) {
		System.out.println("This is a demonstration of breadth-first tree search on 8-puzzle");
		System.out.println();

		// This configuration is taking too much time try to find faster solution with other configurations
		Tiles initialConfiguration = new Tiles(new int[][] {
				{ 7, 4, 2 },
				{ 8, 1, 3 },
				{ 5, 0, 6 }
		});

		uninformedSearch(initialConfiguration);


		informedSearch(initialConfiguration);

//		after comparing results of informed and uninformed searches
//		it is clear that during my tests (the comparision is made after
//		observing results run on the configuration I proposed for
//		uninformed searches) informed searches performed much better
//		than the uniformed searches

	}


//	the initial configuration that we pass works fine for A* algorithms
//	both on tree and graph searches, but the best-first search is taking
//	too much time to solve the problem (haven't checked how much, but the
//	size of frontier was over 1000000 at the stop time
//	I suggest you to try it with different initial configuration
//	So far with the initial configuration both tree and graph searches
//	gave the same result: 13 steps to the goal state,
//  847 nodes stored at the frontier and 1347 created nodes

	public static void informedSearch(Tiles initialConfiguration) {
		GoalTest goalTest = new TilesGoalTest();
		Node root = new Node(null, null, initialConfiguration);
		Search s;
		NPuzzlePrinting print = new NPuzzlePrinting();

//		1. graph search with best first frontier
		s = new GraphSearch(new BestFirstFrontier(new MisplacedTilesHeuristicFunction()));
		System.out.println("graph search with best first frontier");
		Node solution = s.search(root, goalTest);
		print.printSolution(solution);
		System.out.println("max size of best-first f in GraphSearch");
		System.out.println(s.numberOfNodesFromLastSearch());
		System.out.println("________________________________________________");

//		2. tree search with best first frontier
		s = new TreeSearch(new BestFirstFrontier(new MisplacedTilesHeuristicFunction()));
		System.out.println("tree search with best first frontier");
		Node solution1 = s.search(root, goalTest);
		print.printSolution(solution1);
		System.out.println("max size of best-first f in TreeSearch");
		System.out.println(s.numberOfNodesFromLastSearch());
		System.out.println("________________________________________________");


//		3. graph search with A* search
		s = new GraphSearch(new BestFirstFrontier(new AStarFunction(new MisplacedTilesHeuristicFunction())));
		System.out.println("graph search with A*");
		Node solution2 = s.search(root, goalTest);
		print.printSolution(solution2);
		System.out.println("max size of A* in GraphSearch");
		System.out.println(s.numberOfNodesFromLastSearch());
		System.out.println("________________________________________________");

//		4. tree search with A* search
		s = new TreeSearch(new BestFirstFrontier(new AStarFunction(new MisplacedTilesHeuristicFunction())));
		System.out.println("tree search with A*");
		Node solution3 = s.search(root, goalTest);
		print.printSolution(solution3);
		System.out.println("max size of A* in TreeSearch");
		System.out.println(s.numberOfNodesFromLastSearch());
		System.out.println("________________________________________________");


	}

//	  I tried with this
//	  { 1, 0, 2 },
//	  { 4, 5, 3 },
//	  { 7, 8, 6 }
//	  configuration and got for graph search with bff
//	  size of frontier at solution time: 63
//	  max size of frontier: 98
//
//	  for graph search with dff
//	  size of frontier at solution time: 6
//	  max size of frontier: 9
//
//	  for tree search with bff
//	  size of frontier at solution time: 63
//	  max size of frontier: 98
//
//	  for tree search with dff
//	  size of frontier at solution time: 6
//	  max size of frontier: 9
//
//	  so in this case it wasn't important what structure we are using
//	  but it was important what algorithm I used and dff performed much better

	public static void uninformedSearch(Tiles initialConfiguration) {
		GoalTest goalTest = new TilesGoalTest();
		Node root = new Node(null, null, initialConfiguration);
		Search s;
		NPuzzlePrinting print = new NPuzzlePrinting();

//		 to try the solutions uncomment the blocks of code :))

//		 1. graph search with breadth first frontier
		s = new GraphSearch(new BreadthFirstFrontier());
		System.out.println("graph search with breadth first frontier");
		Node solution = s.search(root, goalTest);
		print.printSolution(solution);
		System.out.println("max size of bff in GraphSearch");
		System.out.println(s.numberOfNodesFromLastSearch());
		System.out.println("________________________________________________");


//		 2. graph search with depth first frontier
		s = new GraphSearch(new DepthFirstFrontier());
		System.out.println("graph search with depth first frontier");
		Node solution1 = s.search(root, goalTest);
		print.printSolution(solution1);
		System.out.println("max size of dff in GraphSearch");
		System.out.println(s.numberOfNodesFromLastSearch());
		System.out.println("________________________________________________");


//		 3. tree search with breadth first frontier
		s = new TreeSearch(new BreadthFirstFrontier());
		System.out.println("tree search with breadth first frontier");
		Node solution2 = s.search(root, goalTest);
		print.printSolution(solution2);
		System.out.println(s.numberOfNodesFromLastSearch());
		System.out.println("max size of bff in TreeSearch");
		System.out.println(s.numberOfNodesFromLastSearch());
		System.out.println("________________________________________________");

//		 4. tree search with depth first frontier
		s = new TreeSearch(new DepthFirstFrontier());
		System.out.println("tree search with depth first frontier");
		Node solution3 = s.search(root, goalTest);
		print.printSolution(solution3);
		System.out.println("max size of dff in GraphSearch");
		System.out.println(s.numberOfNodesFromLastSearch());
		System.out.println("________________________________________________");

	}
}
