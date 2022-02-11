package part2.binarytrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by yaqub
 * Date: 28/01/22
 * Time: 16:51
 * Software team
 */
public class Tree<T> {
	private Node<T> root;

	public static class Node<T> {
		private Node<T> right;
		private final T value;
		private Node<T> left;

		public Node(T item) {
			value = item;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Node=").append(value);
			if (left != null)
				builder.append(", left=").append(left.value);

			if (right != null)
				builder.append(", right=").append(right.value);

			return builder.toString();
		}
	}

	public void insert(T item) {
		Node<T> newItem = new Node<>(item);
		if (root == null) {
			root = newItem;
		} else {
			Node<T> node = root;

			while (true) {
				if (item.hashCode() < node.value.hashCode()) {
					if (node.left == null) {
						node.left = newItem;
						break;
					}
					node = node.left;
				} else {
					if (node.right == null) {
						node.right = newItem;
						break;
					}
					node = node.right;
				}
			}
		}
	}

	public boolean find(T item) {
		Node<T> current = root;

		while (current != null) {
			if (item.hashCode() < current.value.hashCode())
				current = current.left;
			else if (item.hashCode() > current.value.hashCode())
				current = current.right;
			else
				return true;
		}

		return false;
	}

	public void printLevelOrder() {
		System.out.println("Print Level Order");
		for (int i = 0; i <= height(); i++) {
			for (T item : getNodesAtDistance(i))
				System.out.println(item);
		}
	}

	public void printPreOrder() {
		System.out.println("---Depth first Pre order BEGIN");
		traversePreOrder(root);
		System.out.println("---Depth first Pre order END");
	}

	public void printInOrder() {
		System.out.println("---Depth first In order BEGIN");
		traverseInOrder(root);
		System.out.println("---Depth first In order END");
	}

	public void printPostOrder() {
		System.out.println("---Depth first Post order BEGIN");
		traversePostOrder(root);
		System.out.println("---Depth first Post order END");
	}

	public int height() {
		return height(root);
	}

	public boolean equals(Tree<T> tree) {
		if (tree == null)
			return false;
		return equals(root, tree.root);
	}

	public boolean isBinarySearchTree() {
		return isBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	public List<T> getNodesAtDistance(int distance) {
		List<T> list = new ArrayList<>();
		getNodesAtDistance(root, distance, list);
		return list;
	}

	public int size() {
		return size(root, 1);
	}

	public int countLeaves() {
		return countLeaves(root, 0);
	}

	public boolean areSibling(T a, T b) {
		return areSibling(root, a.hashCode() + b.hashCode());
	}

	private boolean areSibling(Node<T> root, int hashcode) {
		if (root != null) {
			if (root.left != null && root.right != null
					&& root.right.value.hashCode() + root.left.value.hashCode() == hashcode)
				return true;
			else return areSibling(root.left, hashcode) || areSibling(root.right, hashcode);
		}
		return false;
	}

	public List<T> getAncestors(T item) {
		LinkedList<T> ancestors = new LinkedList<>();
		getAncestors(root, item, ancestors);
		return ancestors;
	}

	private boolean getAncestors(Node<T> root, T item, List<T> ancestors) {
		if (root == null)
			return false;
		if (root.value == item)
			return true;
		if (getAncestors(root.left, item, ancestors) || getAncestors(root.right, item, ancestors)) {
			ancestors.add(root.value);
			return true;
		}
		return false;
	}

	private int countLeaves(Node<T> root, int count) {
		if (root == null)
			return count;

		if (isLeaf(root))
			return count + 1;

		count = countLeaves(root.left, count);
		count = countLeaves(root.right, count);
		return count;
	}

	private int size(Node<T> root, int size) {
		if (root == null)
			return size - 1;

		size = size(root.left, size + 1);
		size = size(root.right, size + 1);
		return size;
	}

	public T max() {
		return max(root, root.value);
	}

	public boolean contains(T item) {
		return contains(root, item);
	}

	private boolean contains(Node<T> root, T item) {
		if (root != null) {
			if (root.value.hashCode() > item.hashCode())
				return contains(root.left, item);
			else if (root.value.hashCode() < item.hashCode())
				return contains(root.right, item);
			else return true;
		}
		return false;
	}

	private T max(Node<T> root, T max) {
		if (root == null || root.right == null)
			return max;

		return max(root.right, root.right.value);
	}

	private boolean isBinarySearchTree(Node<T> root, int min, int max) {
		if (root == null)
			return true;

		return root.value.hashCode() > min && root.value.hashCode() < max
				&& isBinarySearchTree(root.left, min, root.value.hashCode() - 1)
				&& isBinarySearchTree(root.right, root.value.hashCode(), max);
	}

	private void getNodesAtDistance(Node<T> root, int distance, List<T> list) {
		if (root == null)
			return;

		if (distance == 0) {
			list.add(root.value);
			return;
		}

		distance--;
		getNodesAtDistance(root.left, distance, list);
		getNodesAtDistance(root.right, distance, list);
	}

	private boolean equals(Node<T> a, Node<T> b) {
		if (a == null && b == null)
			return true;

		if (a != null && b != null)
			return a.value == b.value
					&& equals(a.left, b.left)
					&& equals(a.right, b.right);

		return false;
	}

	private void traversePreOrder(Node<T> root) {
		if (root == null)
			return;
		System.out.println(root.value);
		traversePreOrder(root.left);
		traversePreOrder(root.right);
	}

	private void traverseInOrder(Node<T> root) {
		if (root == null)
			return;
		traverseInOrder(root.left);
		System.out.println(root.value);
		traverseInOrder(root.right);
	}

	private void traversePostOrder(Node<T> root) {
		if (root == null)
			return;
		traversePostOrder(root.left);
		traversePostOrder(root.right);
		System.out.println(root.value);
	}

	private int height(Node<T> root) {
		if (root == null)
			return -1;
		if (isLeaf(root))
			return 0;

		int left = height(root.left);
		int right = height(root.right);
		return 1 + Math.max(left, right);
	}

	private boolean isLeaf(Node<T> root) {
		return root.left == null && root.right == null;
	}

	private boolean hasBothSubTree(Node<T> root) {
		return root.left != null && root.right != null;
	}


}