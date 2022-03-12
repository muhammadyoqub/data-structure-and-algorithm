package part2.undirectedgraph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Stack;

/**
 * Created by Yaqub
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

	private static class NodeEntry {
		private final Node node;
		private final int distance;

		public NodeEntry(Node node, int distance) {
			this.node = node;
			this.distance = distance;
		}
	}

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

	public boolean hasCycle() {
		Set<Node> visited = new HashSet<>();
		for (Node node : nodes.values()) {
			if (!visited.contains(node) && hasCycle(node, null, visited))
				return true;
		}
		return false;
	}


	private boolean hasCycle(Node node, Node parent, Set<Node> visited) {
		visited.add(node);
		for (Edge edge : node.getEdges()) {
			if (edge.to == parent)
				continue;

			if (visited.contains(edge.to) || hasCycle(edge.to, node, visited))
				return true;

		}
		return false;
	}

	public Path getShortestPath(String from, String to) {
		Node fromNode = nodes.get(from);
		Node toNode = nodes.get(to);
		if (fromNode == null || toNode == null)
			throw new IllegalArgumentException();

		Map<Node, Integer> distances = new HashMap<>();
		Map<Node, Node> previousNodes = new HashMap<>();

		for (Node node : nodes.values())
			distances.put(node, Integer.MAX_VALUE);
		distances.replace(fromNode, 0);

		Set<Node> visited = new HashSet<>();
		PriorityQueue<NodeEntry> queue = new PriorityQueue<>(Comparator.comparingInt(ne -> ne.distance));
		queue.add(new NodeEntry(fromNode, 0));

		while (!queue.isEmpty()) {
			Node current = queue.remove().node;
			visited.add(current);

			for (Edge edge : current.getEdges()) {
				if (visited.contains(edge.to))
					continue;

				int newDistance = distances.get(current) + edge.weight;
				if (distances.get(edge.to) > newDistance) {
					previousNodes.put(edge.to, current);
					distances.replace(edge.to, newDistance);
					queue.add(new NodeEntry(edge.to, newDistance));
				}
			}
		}

		return buildPath(previousNodes, toNode);
	}

	private Path buildPath(Map<Node, Node> previousNodes, Node toNode) {
		Stack<String> stack = new Stack<>();
		stack.push(toNode.label);

		Node previousNode = previousNodes.get(toNode);
		while (previousNode != null) {
			stack.push(previousNode.label);
			previousNode = previousNodes.get(previousNode);
		}
		Path path = new Path();
		while (!stack.isEmpty()) {
			path.add(stack.pop());
		}
		return path;
	}


	public void print() {
		for (Node node : nodes.values()) {
			List<Edge> edges = node.getEdges();
			if (!edges.isEmpty())
				System.out.println(node + " is connected with " + edges);
		}

	}

}
