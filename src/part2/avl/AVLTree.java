package part2.avl;

public class AVLTree<T> {

	private Node<T> root;

	private static class Node<T> {
		private Node<T> left;
		private final T value;
		private Node<T> right;
		private int height;

		public Node(T item) {
			value = item;
		}

		@Override
		public String toString() {
			return "Node: " + value;
		}
	}

	public void insert(T item) {
		if (item == null)
			throw new IllegalArgumentException();
		root = insert(root, item);
	}

	private Node<T> insert(Node<T> root, T item) {
		if (root == null)
			return new Node<>(item);

		if (item.hashCode() < root.value.hashCode())
			root.left = insert(root.left, item);
		else
			root.right = insert(root.right, item);

		setHeight(root);
		return balance(root);
	}

	private Node<T> balance(Node<T> root) {
		if (isLeftHeavy(root)) {
			if (balanceFactor(root.left) < 0)
				root.left = leftRotate(root.left);
			return rightRotate(root);
		} else if (isRightHeavy(root)) {
			if (balanceFactor(root.right) > 0)
				root.right = rightRotate(root.right);
			return leftRotate(root);
		}
		return root;
	}

	private Node<T> leftRotate(Node<T> root) {
		Node<T> newRoot = root.right;
		root.right = newRoot.left;
		newRoot.left = root;
		setHeight(root);
		setHeight(newRoot);
		return newRoot;
	}

	private Node<T> rightRotate(Node<T> root) {
		Node<T> newRoot = root.left;
		root.left = newRoot.right;
		newRoot.right = root;
		setHeight(root);
		setHeight(newRoot);
		return newRoot;
	}

	private void setHeight(Node<T> node) {
		node.height = Math.max(height(node.left), height(node.right)) + 1;
	}

	private int height(Node<T> node) {
		return node == null ? -1 : node.height;
	}

	private boolean isLeftHeavy(Node<T> node) {
		return balanceFactor(node) > 1;
	}

	private boolean isRightHeavy(Node<T> node) {
		return balanceFactor(node) < -1;
	}

	private int balanceFactor(Node<T> node) {
		return node == null ? 0 : height(node.left) - height(node.right);
	}
}