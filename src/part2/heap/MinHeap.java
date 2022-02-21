package part2.heap;

public class MinHeap {

	static class Node {
		private final int key;
		private final String value;

		public Node(int key, String value) {
			this.key = key;
			this.value = value;
		}

		@Override
		public String toString() {
			return String.format("{key: %d, value: %s}", key, value);
		}
	}

	private final Node[] nodes = new Node[10];
	private int size;

	public void insert(int key, String value) {
		if (isFull())
			throw new IllegalStateException();
		nodes[size++] = new Node(key, value);

		if (size == 1)
			return;

		bubbleUp(size - 1);
	}

	public String remove() {
		if (isEmpty())
			throw new IllegalStateException();

		Node removed = nodes[0];
		nodes[0] = nodes[size - 1];
		nodes[--size] = null;
		bubbleDown(0);
		return removed.value;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public boolean isFull() {
		return size == nodes.length;
	}

	private void bubbleUp(int index) {
		int parent = parent(index);
		if (parent >= 0 && nodes[index].key < nodes[parent].key) {
			swap(index, parent);
			bubbleUp(parent);
		}
	}

	private void bubbleDown(int index) {
		if (size - 1 == index)
			return;

		int smallerIndex = getSmallerIndex(index);
		if (smallerIndex == index)
			return;

		swap(index, smallerIndex);
		bubbleDown(smallerIndex);
	}

	private int getSmallerIndex(int index) {
		int smallerIndex = index;
		if (hasLeft(index) && nodes[left(index)].key < nodes[index].key)
			smallerIndex = left(index);

		if (hasRight(index) && nodes[right(index)].key < nodes[index].key)
			smallerIndex = right(index);

		return smallerIndex;
	}

	private boolean hasLeft(int index) {
		return left(index) < size;
	}

	private boolean hasRight(int index) {
		return right(index) < size;
	}

	private void swap(int first, int second) {
		Node node = nodes[first];
		nodes[first] = nodes[second];
		nodes[second] = node;
	}

	private int parent(int index) {
		return (index - 1) / 2;
	}

	private int left(int index) {
		return index * 2 + 1;
	}

	private int right(int index) {
		return index * 2 + 2;
	}
}