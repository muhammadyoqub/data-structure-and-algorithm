package part2.undirectedgraph;

/**
 * Created by Yaqub
 * Date: 03/03/2022
 * Time: 22:53
 * Software team
 */
public class Main {

	public static void main(String[] args) {
		WeightedGraph graph = new WeightedGraph();
		graph.addNode("A");
		graph.addNode("B");
		graph.addNode("C");
		graph.addEdge("A", "B", 2);
		graph.addEdge("B", "C", 2);
		graph.addEdge("A", "C", 3);
		graph.print();
		System.out.println(graph.getShortestPath("A", "C"));
	}
}
