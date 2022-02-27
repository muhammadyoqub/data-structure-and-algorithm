package part2.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	private void removeEdges(Vertex vertex) {
		for (Map.Entry<Vertex, List<Vertex>> entry : edges.entrySet()) {
			if (!entry.getKey().equals(vertex)) {
				entry.getValue().remove(vertex);
			}
		}
		edges.remove(vertex);
	}
}
