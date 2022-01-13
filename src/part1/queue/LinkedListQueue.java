package part1.queue;

import part1.linked.LinkedList;

/**
 * Created by yaqub
 * Date: 05/01/22
 * Time: 15:03
 * Software team
 */
public class LinkedListQueue {
	private LinkedList items;

	public LinkedListQueue() {
		items = new LinkedList();
	}

	public void add(int item) {
		items.addLast(item);
	}

	public int remove() {
		int item = peek();
		items.removeFirst();
		return item;
	}

	public int peek() {
		if (isEmpty())
			throw new IllegalStateException();
		return items.getKthNodeFromTheEnd(items.size());
	}

	public int size() {
		return items.size();
	}

	public boolean isEmpty() {
		return items.size() == 0;
	}

	@Override
	public String toString() {
		return items.toString();
	}
}