package part2.undirectedgraph;

/**
 * Created by muham
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
		graph.addEdge("A", "B", 4);
		graph.addEdge("A", "C", 2);
		graph.print();
	}
}
