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

	public void remove() {
		shiftUp();
		bubbleDown(0);
	}

	private void bubbleDown(int i) {
		T left = items[left(i)];
		T right = items[right(i)];
		if (right == null) {
			if (left.hashCode() > items[i].hashCode()) {
				swap(i, left(i));
				bubbleDown(left(i));
			}
		} else if (left != null) {
			if (left.hashCode() > items[i].hashCode()) {
				swap(i, left(i));
				bubbleDown(left(i));
			} else if (right.hashCode() > items[i].hashCode()) {
				swap(i, right(i));
				bubbleDown(right(i));
			}
		}
	}

	private void shiftUp() {
		items[0] = items[size - 1];
		items[size--] = null;
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