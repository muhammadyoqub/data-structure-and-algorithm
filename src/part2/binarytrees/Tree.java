package part2.binarytrees;

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
			return "Node=" + value;
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

	public int height() {
		return height(root);
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

	private int height(Node<T> root) {
		if (root == null)
			return -1;
		if (isLeaf(root))
			return 0;

		int left = height(root.left);
		int right = height(root.right);
		return 1 + (Math.max(left, right));
	}

	private boolean isLeaf(Node<T> root) {
		return root.left == null && root.right == null;
	}
}