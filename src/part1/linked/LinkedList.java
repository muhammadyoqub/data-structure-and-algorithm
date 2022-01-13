package part1.linked;

import java.lang.reflect.Array;
import java.util.NoSuchElementException;

public class LinkedList<T> {

	private Node<T> first;
	private Node<T> last;
	private int size;

	private static class Node<T> {
		private final T value;
		private Node<T> next;

		public Node(T value) {
			this.value = value;
		}
	}

	public void addLoop(int index) {
		int i = 0;
		for (Node<T> node = first; node != null; node = node.next) {
			if (i++ == index) {
				last.next = node;
				return;
			}
		}
	}

	public void addFirst(T item) {
		Node<T> node = new Node<>(item);
		if (isEmpty()) {
			first = last = node;
		} else {
			node.next = first;
			first = node;
		}
	}

	public void addLast(T item) {
		Node<T> node = new Node<>(item);
		if (isEmpty()) {
			first = last = node;
		} else {
			last.next = node;
			last = last.next;
		}
		size++;
	}

	public void removeFirst() {
		if (isEmpty())
			throw new NoSuchElementException();

		if (first == last)
			first = last = null;
		else {
			Node<T> second = first.next;
			first.next = null;
			first = second;
		}
		size--;
	}

	public void remove(int index) {
		if (index >= size || index < 0)
			throw new ArrayIndexOutOfBoundsException(index);

		if (index == 0) {
			removeFirst();
		} else if (index == size - 1)
			removeLast();
		else {
			Node<T> previous = null;
			int i = 0;
			for (Node<T> node = first; node != null; node = node.next) {
				if (i++ == index) {
					previous.next = node.next;
					break;
				}
				previous = node;
			}
		}
		size--;
	}

	public void removeLast() {
		if (isEmpty())
			throw new NoSuchElementException();

		if (first == last) {
			first = last = null;
		}
		last = getPrevious();
		last.next = null;
		size--;
	}

	private Node<T> getPrevious() {
		Node<T> node = first;
		while (node != null) {
			if (node.next == last) return node;

			node = node.next;
		}

		return null;
	}

	public boolean contains(T value) {
		return indexOf(value) != -1;
	}

	public int indexOf(T item) {
		int i = 0;
		for (Node<T> node = first; node != null; node = node.next) {
			if (node.value == item)
				return i;
			i++;
		}
		return -1;
	}

	public T[] toArray() {
		T[] items = (T[]) Array.newInstance(first.value.getClass(), 5);
		int index = 0;
		for (Node<T> node = first; node != null; node = node.next)
			items[index++] = node.value;

		return items;
	}

	public int size() {
		return size;
	}

	public void print() {
		Node<T> node = first;
		while (node != null) {
			System.out.println(node.value);
			node = node.next;
		}
	}

	public void reverse() {
		if (first == last)
			return;
		last = first;
		Node<T> current = first;
		Node<T> previous = null;
		while (current != null) {
			Node<T> second = current.next;
			if (second != null) {
				Node<T> third = second.next;
				second.next = current;
				current.next = previous;
				current = third;
				previous = second;
			} else {
				current.next = previous;
				previous = current;
				break;
			}
		}
		first = previous;
	}

	public T getKthNodeFromTheEnd(int k) {
		if (isEmpty())
			throw new IllegalArgumentException();
		Node<T> a = first;
		Node<T> b = first;
		for (int i = 1; i < k; i++) {
			b = b.next;
			if (b == null)
				throw new IllegalArgumentException();
		}
		while (b != last) {
			a = a.next;
			b = b.next;
		}
		return a.value;
	}

	public void printMiddle() {
		if (isEmpty()) return;

		Node<T> a = first;
		Node<T> b = first;
		while (true) {
			if (b.next == last) {
				System.out.printf("Middle: %s %s \n", a.value, a.next.value);
				break;
			} else if (b.next == null) {
				break;
			}
			b = b.next.next;
			a = a.next;
		}
	}

	public boolean hasLoop() {
		if (first == last) return false;
		Node<T> a = first;
		Node<T> b = first;
		while (b != null && b.next != null) {
			if (b.next == a) return true;
			b = b.next.next;
			a = a.next;

		}
		return false;
	}

	private boolean isEmpty() {
		return first == null;
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("[");
		Node<T> node = first;
		while (node != null) {
			stringBuilder.append(node.value);
			node = node.next;
			if (node != null) stringBuilder.append(", ");
		}
		stringBuilder.append("]");
		return stringBuilder.toString();
	}

}
