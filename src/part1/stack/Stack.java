package part1.stack;

import java.util.EmptyStackException;

public class Stack {
	private int[] items = new int[10];
	private int size;

	public void push(int item) {
		if (size == items.length)
			throw new StackOverflowError();

		items[size++] = item;
	}

	public int pop() {
		if (isEmpty()) throw new EmptyStackException();
		return items[--size];
	}

	public int peek() {
		if (isEmpty()) throw new EmptyStackException();
		return items[size - 1];
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}

	@Override
	public String toString() {
		StringBuilder stringBuffer = new StringBuilder();
		stringBuffer.append("[");
		for (int i = 0; i < size; i++)
			stringBuffer.append(items[i]).append(i == size - 1 ? "" : ",");
		stringBuffer.append("]");
		return stringBuffer.toString();
	}
}
