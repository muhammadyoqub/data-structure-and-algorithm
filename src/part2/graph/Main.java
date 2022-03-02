package part2.graph;

public class Main {

	public static void main(String[] args) {
		Graph graph = new Graph();
		graph.addVertex("Bob");
		graph.addVertex("Alice");
		graph.addVertex("Mark");
		graph.addVertex("Rob");
		graph.addVertex("Maria");
		graph.addEdge("Bob", "Alice");
		graph.addEdge("Bob", "Rob");

		graph.addEdge("Alice", "Bob");
		graph.addEdge("Alice", "Mark");
		graph.addEdge("Alice", "Maria");

		graph.addEdge("Mark", "Alice");
		graph.addEdge("Mark", "Rob");

		graph.addEdge("Rob", "Bob");
		graph.addEdge("Rob", "Mark");
		graph.addEdge("Rob", "Maria");
		graph.addEdge("Rob", "Maria");

		graph.addEdge("Maria", "Alice");
		graph.addEdge("Maria", "Rob");
		graph.removeEdge("Maria", "Alice");
		graph.removeVertex("Mark");
		graph.print();
		graph.traverseDepthFirst("Rob");
		graph.iterateDepthFirst("Rob");
		graph.traverseBreadthFirst("Rob");
	}
}
