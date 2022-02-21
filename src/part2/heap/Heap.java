package part2.heap;

public class Heap<T> {
	private T[] items;
	private int size;

	public Heap(int capacity) {
		items = (T[]) new Object[capacity];
	}

	public void insert(T item) {
		items[size++] = item;
		bubbleUp(size - 1);
	}

	public T remove() {
		if (isEmpty())
			throw new IllegalStateException();

		T root = shiftUp();
		bubbleDown(0);
		return root;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public T max() {
		return items[0];
	}

	private void bubbleDown(int i) {
		if (i < size && !isValidParent(i)) {
			int largerChildIndex = largerChildIndex(i);
			swap(i, largerChildIndex);
			bubbleDown(largerChildIndex);
		}
	}

	private int largerChildIndex(int index) {
		if (!hasLeftChild(index))
			return index;

		if (right(index) >= size)
			return left(index);

		return leftChild(index).hashCode() > rightChild(index).hashCode() ? left(index) : right(index);
	}

	private boolean isValidParent(int index) {
		if (!hasLeftChild(index))
			return true;
		boolean isValid = items[index].hashCode() >= leftChild(index).hashCode();
		if (hasRightChild(index))
			isValid &= items[index].hashCode() >= rightChild(index).hashCode();

		return isValid;
	}

	private boolean hasLeftChild(int index) {
		return left(index) < size;
	}

	private boolean hasRightChild(int index) {
		return right(index) < size;
	}

	private T leftChild(int index) {
		return items[left(index)];
	}

	private T rightChild(int index) {
		return items[right(index)];
	}


	private T shiftUp() {
		T root = items[0];
		items[0] = items[size - 1];
		items[--size] = null;
		return root;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder("[");
		for (int i = 0; ; i++) {
			builder.append(items[i]);
			if (i == size - 1)
				return builder.append("]").toString();
			builder.append(", ");
		}
	}

	private void bubbleUp(int index) {
		int parentIndex = parent(index);
		if (index > 0 && items[index].hashCode() > items[parent(index)].hashCode()) {
			swap(index, parent(index));
			bubbleUp(parentIndex);
		}
	}

	private void swap(int first, int second) {
		T temp = items[first];
		items[first] = items[second];
		items[second] = temp;
	}

	private int parent(int child) {
		return (child - 1) / 2;
	}

	private int left(int index) {
		return index * 2 + 1;
	}

	private int right(int index) {
		return index * 2 + 2;
	}
}