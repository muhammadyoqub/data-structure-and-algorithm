package part2.undirectedgraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by muham
 * Date: 03/03/2022
 * Time: 22:39
 * Software team
 */
public class WeightedGraph {

	private static class Node {
		private final String label;
		private final List<Edge> edges = new ArrayList<>();

		public Node(String label) {
			this.label = label;
		}

		public void addEdge(Node to, int weight) {
			edges.add(new Edge(this, to, weight));
		}

		public List<Edge> getEdges() {
			return edges;
		}

		@Override
		public String toString() {
			return label;
		}
	}

	private static class Edge {
		private final Node from;
		private final Node to;
		private final int weight;

		public Edge(Node from, Node to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public String toString() {
			return from + "=>" + to;
		}
	}

	private final Map<String, Node> nodes = new HashMap<>();

	public void addNode(String label) {
		nodes.putIfAbsent(label, new Node(label));
	}

	public void addEdge(String from, String to, int weight) {
		Node fromNode = nodes.get(from);
		Node toNode = nodes.get(to);
		if (fromNode == null || toNode == null)
			throw new IllegalArgumentException();

		fromNode.addEdge(toNode, weight);
		toNode.addEdge(fromNode, weight);
	}

	public void print() {
		for (Node node : nodes.values()) {
			List<Edge> edges = node.getEdges();
			if (!edges.isEmpty())
				System.out.println(node + " is connected with " + edges);
		}

	}

}
