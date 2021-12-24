package part1.stack;

import java.util.EmptyStackException;

/**
 * Created by yaqub
 * Date: 21/12/21
 * Time: 17:31
 * Software team
 */
public class MinStack {
	private int[] items = new int[10];
	private int size;
	private int min;
	private final int num = 2;

	public void push(int item) {
		if (size == items.length)
			throw new StackOverflowError();

		if (isEmpty()) {
			min = item;
			items[size++] = item;
		} else {
			if (min > item) {
				items[size++] = item * num - min;
				min = item;
			} else
				items[size++] = item;
		}
	}

	public int top() {
		int item = items[size - 1];
		return Math.max(item, min);
	}

	public int pop() {
		if (isEmpty()) throw new EmptyStackException();

		int item = items[--size];
		if (item < min) {
			int temp = min;
			min = num * min - item;
			return temp;
		} else return item;
	}

	public int min() {
		return min;
	}

	public boolean isEmpty() {
		return size == 0;
	}

}
