package part2.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class Graph {

	private static class Vertex {
		private final String label;

		public Vertex(String label) {
			this.label = label;
		}

		@Override
		public String toString() {
			return label;
		}
	}

	private final Map<String, Vertex> vertices = new HashMap<>();
	private final Map<Vertex, List<Vertex>> edges = new HashMap<>();

	public void addVertex(String label) {
		Vertex vertex = new Vertex(label);
		vertices.putIfAbsent(label, vertex);
		edges.putIfAbsent(vertex, new ArrayList<>());
	}

	public boolean removeVertex(String label) {
		Vertex vertex = vertices.get(label);
		if (vertex == null)
			return false;

		removeEdges(vertex);
		return vertices.remove(label, vertex);
	}

	public void addEdge(String from, String to) {
		Vertex fromVertex = vertices.get(from);
		Vertex toVertex = vertices.get(to);
		if (fromVertex == null || toVertex == null)
			throw new IllegalArgumentException();

		if (!edges.get(fromVertex).contains(toVertex))
			edges.get(fromVertex).add(toVertex);
	}

	public boolean removeEdge(String from, String to) {
		Vertex fromVertex = vertices.get(from);
		Vertex toVertex = vertices.get(to);
		if (fromVertex == null || toVertex == null)
			throw new IllegalArgumentException();

		return edges.get(fromVertex).remove(toVertex);
	}

	public void print() {
		for (Map.Entry<Vertex, List<Vertex>> entry : edges.entrySet()) {
			if (!entry.getValue().isEmpty())
				System.out.println(entry.getKey() + " is connected with " + entry.getValue());
		}
	}

	public void traverseDepthFirst(String root) {
		Vertex vertex = vertices.get(root);
		if (vertex != null)
			traverseDepthFirst(vertex, new HashSet<>());

	}

	public void iterateDepthFirst(String root) {
		Vertex vertex = vertices.get(root);
		if (vertex == null)
			return;

		Set<Vertex> visited = new HashSet<>();

		Stack<Vertex> stack = new Stack<>();
		stack.push(vertex);

		while (!stack.isEmpty()) {
			Vertex current = stack.pop();

			if (visited.contains(current))
				continue;

			System.out.println(current);
			visited.add(current);

			for (Vertex neighbour : edges.get(current))
				if (!visited.contains(neighbour))
					stack.push(neighbour);

		}
	}

	public void traverseBreadthFirst(String root) {
		Vertex vertex = vertices.get(root);
		if (vertex == null)
			return;
		Set<Vertex> visited = new HashSet<>();

		Queue<Vertex> queue = new ArrayDeque<>(vertices.size());
		queue.add(vertex);
		while (!queue.isEmpty()) {
			Vertex current = queue.remove();

			if (visited.contains(current))
				continue;

			visited.add(current);
			System.out.println(current);

			for (Vertex neighbour : edges.get(current))
				if (!visited.contains(neighbour))
					queue.add(neighbour);
		}
	}

	private void traverseDepthFirst(Vertex vertex, Set<Vertex> visited) {
		System.out.println(vertex);
		visited.add(vertex);

		for (Vertex adjacent : edges.get(vertex))
			if (!visited.contains(adjacent))
				traverseDepthFirst(adjacent, visited);
	}

	private void removeEdges(Vertex vertex) {
		for (Map.Entry<Vertex, List<Vertex>> entry : edges.entrySet()) {
			if (!entry.getKey().equals(vertex)) {
				entry.getValue().remove(vertex);
			}
		}
		edges.remove(vertex);
	}
}
