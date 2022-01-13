package part1.queue;

import java.util.EmptyStackException;

/**
 * Created by yaqub
 * Date: 05/01/22
 * Time: 15:23
 * Software team
 */
public class StackWithTwoQueues {
	private ArrayQueue first;
	private ArrayQueue second;
	private int size;

	public StackWithTwoQueues() {
		first = new ArrayQueue();
		second = new ArrayQueue();
	}

	//
	// 1, 2, 3, 4
	public void push(int item) {
		if (first.isEmpty())
			first.add(item);
		else {
			while (!first.isEmpty()) {
				second.add(first.remove());
			}
			first.add(item);

			while (!second.isEmpty()) {
				first.add(second.remove());
			}
		}
		size++;
	}

	public int pop() {
		if (isEmpty())
			throw new EmptyStackException();

		size--;
		return first.remove();

	}

	public int peek() {
		return first.peek();
	}

	public boolean isEmpty() {
		return first.isEmpty() && second.isEmpty();
	}

	@Override
	public String toString() {
		return first.toString() + second.toString();
	}

	public int size() {
		return size;
	}
}