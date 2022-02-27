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
	private final Map<String, List<Vertex>> edges = new HashMap<>();

	public void addVertex(String label) {
		vertices.putIfAbsent(label, new Vertex(label));
		edges.putIfAbsent(label, new ArrayList<>());
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
		if (fromVertex == null)
			throw new IllegalArgumentException();

		Vertex toVertex = vertices.get(to);
		if (to == null)
			throw new IllegalArgumentException();
		edges.get(from).add(toVertex);
	}

	public boolean removeEdge(String from, String to) {
		Vertex fromVertex = vertices.get(from);
		if (fromVertex == null)
			throw new IllegalArgumentException();

		Vertex toVertex = vertices.get(to);
		if (toVertex == null)
			throw new IllegalArgumentException();

		return edges.get(from).remove(toVertex);
	}

	public void print() {
		for (Map.Entry<String, List<Vertex>> entry : edges.entrySet()) {
			if (!entry.getValue().isEmpty())
				System.out.println(entry.getKey() + " is connected with " + entry.getValue());
		}
	}

	private void removeEdges(Vertex vertex) {
		for (Map.Entry<String, List<Vertex>> entry : edges.entrySet()) {
			if (!entry.getKey().equals(vertex.label)) {
				entry.getValue().remove(vertex);
			}
		}
		edges.remove(vertex.label);
	}
}
