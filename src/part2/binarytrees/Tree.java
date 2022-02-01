package part2.binarytrees;

/**
 * Created by yaqub
 * Date: 28/01/22
 * Time: 16:51
 * Software team
 */
public class Tree<T> {
	private Node<T> root;
	private int size;

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
		size++;
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


	public int size() {
		return size;
	}

}