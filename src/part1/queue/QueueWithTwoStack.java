package part1.queue;

import part1.stack.Stack;

import java.util.NoSuchElementException;

public class QueueWithTwoStack {
	private Stack first;
	private Stack second;
	private int count;

	public QueueWithTwoStack() {
		first = new Stack();
		second = new Stack();
	}

	public void add(int item) {
		first.push(item);
		count++;
	}

	public boolean isFull() {
		return first.size() == 5;
	}

	public int remove() {
		if (isEmpty())
			throw new NoSuchElementException();

		moveStack1ToStack2();
		count--;
		return second.pop();
	}

	public int peek() {
		if (isEmpty())
			throw new NoSuchElementException();

		moveStack1ToStack2();

		return second.peek();
	}

	public int size() {
		return count;
	}

	private void moveStack1ToStack2() {
		if (second.isEmpty())
			while (!first.isEmpty())
				second.push(first.pop());
	}

	public boolean isEmpty() {
		return first.isEmpty() && second.isEmpty();
	}

	@Override
	public String toString() {
		return first.toString();
	}
}