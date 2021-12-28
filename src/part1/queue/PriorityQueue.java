package part1.queue;

/**
 * Created by yaqub
 * Date: 28/12/21
 * Time: 14:51
 * Software team
 */
public class PriorityQueue {

	private int[] items;
	private int count;

	public PriorityQueue(int capacity) {
		items = new int[capacity];
	}

	public void add(int item) {
		if (isFull())
			throw new IllegalStateException();

		int index = shiftItemsToInsert(item);
		items[index] = item;
		count++;
	}

	public int remove() {
		if (isEmpty())
			throw new IllegalStateException();

		return items[--count];
	}

	public boolean isEmpty() {
		return count == 0;
	}

	public boolean isFull() {
		return count == items.length;
	}

	private int shiftItemsToInsert(int item) {
		int i;
		for (i = count; i > 0; i--)
			if (items[i - 1] < item) {
				items[i] = items[i - 1];
			} else
				break;

		return i;
	}

}