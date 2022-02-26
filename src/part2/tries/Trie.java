package part2.tries;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Trie {
	private static final int ALPHABET_SIZE = 26;

	private static class Node {
		char value;
		HashMap<Character, Node> children = new HashMap<>(ALPHABET_SIZE);
		boolean isEndOfWord;

		public Node(char character) {
			value = character;
		}

		public boolean hasChild(char ch) {
			return children.containsKey(ch);
		}

		public boolean hasChildren() {
			return !children.isEmpty();
		}

		public void addChild(char ch) {
			children.put(ch, new Node(ch));
		}

		public Node getChild(char ch) {
			return children.get(ch);
		}

		public Node[] getChildren() {
			return children.values().toArray(new Node[0]);
		}

		public Node removeChildren(char ch) {
			return children.remove(ch);
		}

		@Override
		public String toString() {
			return "value=" + value;
		}
	}

	private final Node root = new Node(' ');

	public void insert(String word) {
		if (word == null)
			throw new IllegalArgumentException();

		Node node = root;
		for (Character character : word.toCharArray()) {
			if (!node.hasChild(character))
				node.addChild(character);
			node = node.getChild(character);
		}
		node.isEndOfWord = true;
	}

	public boolean contains(String word) {
		if (word == null)
			return false;
		Node node = root;
		for (Character character : word.toCharArray()) {
			if (!node.hasChild(character))
				return false;
			node = node.getChild(character);
		}
		return node.isEndOfWord;
	}

	public boolean containsRecursive(String word) {
		if (word == null)
			return false;

		return containsRecursive(root, word, 0);
	}

	public int countOfWords() {
		return countOfWords(root);
	}

	public void printWords() {
		printWords(root, "");
	}

	private void printWords(Node root, String word) {
		if (root.isEndOfWord)
			System.out.println(word);

		for (Node child : root.getChildren()) {
			printWords(child, word + child.value);
		}
	}

	public static String longestCommonPrefix(String[] words) {
		Trie trie = new Trie();
		for (String word : words)
			trie.insert(word);

		Node current = trie.root;
		StringBuilder prefix = new StringBuilder();
		while (true) {
			if (current.getChildren().length == 1) {
				current = current.getChildren()[0];
				prefix.append(current.value);
			} else {
				break;
			}

		}

		return prefix.toString();
	}

	private int countOfWords(Node root) {
		int count = 0;
		if (root.isEndOfWord)
			count++;

		for (Node child : root.getChildren())
			count += countOfWords(child);

		return count;
	}

	private boolean containsRecursive(Node root, String word, int index) {
		if (word.length() == index)
			return root.isEndOfWord;

		Node child = root.getChild(word.charAt(index));
		return child != null && containsRecursive(child, word, index + 1);
	}

	public void traverse() {
		traverse(root);
	}

	public void remove(String word) {
		if (word == null)
			return;

		remove(root, word, 0);
	}

	private void remove(Node node, String word, int index) {
		if (word.length() == index) {
			node.isEndOfWord = false;
			return;
		}
		char currentChar = word.charAt(index);
		Node child = node.getChild(currentChar);
		if (child == null)
			return;

		remove(child, word, ++index);
		if (!child.hasChildren() && !child.isEndOfWord)
			node.removeChildren(currentChar);
	}

	public List<String> findWords(String prefix) {
		Node lastNode = findLastNodeOf(prefix);
		List<String> words = new ArrayList<>();
		findWords(lastNode, prefix, words);
		return words;
	}

	private void findWords(Node root, String prefix, List<String> words) {
		if (root == null)
			return;

		if (root.isEndOfWord)
			words.add(prefix);

		for (Node child : root.getChildren())
			findWords(child, prefix + child.value, words);

	}

	private Node findLastNodeOf(String prefix) {
		if (prefix == null)
			return null;

		Node node = root;
		for (char ch : prefix.toCharArray()) {
			node = node.getChild(ch);
			if (node == null)
				return null;
		}
		return node;
	}


	private void traverse(Node node) {
		System.out.println(node.value);
		for (Node child : node.getChildren()) {
			traverse(child);
		}
	}
}
