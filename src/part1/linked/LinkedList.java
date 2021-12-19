package part1.linked;

import java.util.NoSuchElementException;

public class LinkedList {

	private Node first;
	private Node last;
	private int size;

	private static class Node {
		private final int value;
		private Node next;

		public Node(int value) {
			this.value = value;
		}
	}

	public void addLoop(int index) {
		int i = 0;
		for (Node node = first; node != null; node = node.next) {
			if (i++ == index) {
				last.next = node;
				return;
			}
		}
	}

	public void addFirst(int item) {
		Node node = new Node(item);
		if (isEmpty()) {
			first = last = node;
		} else {
			node.next = first;
			first = node;
		}
	}

	public void addLast(int item) {
		Node node = new Node(item);
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
			Node second = first.next;
			first.next = null;
			first = second;
		}
		size--;
	}

	public void removeLast() {
		if (size <= 0) {
			throw new NoSuchElementException();
		}
		if (first == last) {
			first = last = null;
		}
		last = getPrevious();
		last.next = null;
		size--;
	}

	private Node getPrevious() {
		Node node = first;
		while (node != null) {
			if (node.next == last) return node;

			node = node.next;
		}

		return null;
	}

	public boolean contains(int value) {
		return indexOf(value) != -1;
	}

	public int indexOf(int item) {
		int i = 0;
		for (Node node = first; node != null; node = node.next) {
			if (node.value == item)
				return i;
			i++;
		}
		return -1;
	}

	public int[] toArray() {
		int[] items = new int[size];
		int index = 0;
		for (Node node = first; node != null; node = node.next)
			items[index++] = node.value;

		return items;
	}

	public int getSize() {
		return size;
	}

	public void print() {
		Node node = first;
		while (node != null) {
			System.out.println(node.value);
			node = node.next;
		}
	}

	public void reverse() {
		if (first == last)
			return;
		//...
	}

	public int getKthNodeFromTheEnd(int k) {
		if (isEmpty())
			throw new IllegalArgumentException();
		Node a = first;
		Node b = first;
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

		Node a = first;
		Node b = first;
		while (true) {
			if (b.next == last) {
				System.out.printf("Middle: %d %d \n", a.value, a.next.value);
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
		Node a = first;
		Node b = first;
		while (true) {
			if (b == last || b.next == last)
				return true;
			b = b.next.next;
			a = a.next;

		}
	}

	private boolean isEmpty() {
		return first == null;
	}

}
