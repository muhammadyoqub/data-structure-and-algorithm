package part1.queue;

import java.util.NoSuchElementException;

public class ArrayQueue {
	private final int[] items;
	private int count;
	private int front;
	private int rear;
	private final int initialSize = 5;

	public ArrayQueue() {
		items = new int[initialSize];
	}

	public boolean add(int item) {
		if (isFull())
			throw new StackOverflowError();

		items[front = ++front % initialSize] = item;
		count++;
		return true;
	}

	public int remove() {
		if (isEmpty())
			throw new NoSuchElementException();
		count--;
		return items[rear = ++rear % initialSize];
	}

	public int peek() {
		if (isEmpty())
			return 0;

		return items[rear];
	}

	public boolean isEmpty() {
		return count == 0;
	}

	public boolean isFull() {
		return count == initialSize;
	}

	@Override
	public String toString() {
		StringBuilder stringBuffer = new StringBuilder();
		stringBuffer.append("[");
		for (int i = 0; i < count; i++) {
			stringBuffer.append(items[(rear + 1 + i) % initialSize]).append(i < count - 1 ? "," : "");
		}
		stringBuffer.append("]");
		return stringBuffer.toString();
	}
}
