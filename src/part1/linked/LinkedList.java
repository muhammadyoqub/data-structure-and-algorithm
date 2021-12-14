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

	private boolean isEmpty() {
		return first == null;
	}

}
