package part1.stack;

import java.util.EmptyStackException;

/**
 * Created by yaqub
 * Date: 21/12/21
 * Time: 14:24
 * Software team
 */

public class TwoStacks {
	private int[][] items = new int[5][5];
	private int count1;
	private int count2;

	public void push1(int item) {
		if (isFull1())
			throw new StackOverflowError();
		items[0][count1++] = item;
	}

	public void push2(int item) {
		if (isFull2())
			throw new StackOverflowError();
		items[1][count2++] = item;
	}

	public int pop1() {
		if (isEmpty1())
			throw new EmptyStackException();

		return items[0][--count1];
	}

	public int pop2() {
		if (isEmpty2())
			throw new EmptyStackException();

		return items[1][--count2];
	}

	public boolean isEmpty1() {
		return count1 == 0;
	}

	public boolean isEmpty2() {
		return count2 == 0;
	}

	public boolean isFull1() {
		return items[0].length == count1;
	}

	public boolean isFull2() {
		return items[1].length == count2;
	}
}
