package part1.arrays;


public class ArrayList {
	private int[] items;
	private int size;

	public ArrayList(int initialSize) {
		items = new int[initialSize];
	}

	public void insert(int item) {
		if (items.length == size) {
			int[] newArray = new int[size + (size >> 1)];
			for (int i = 0; i < size; i++)
				newArray[i] = items[i];

			items = newArray;
		}
		items[size++] = item;
	}

	public void insertAt(int item, int index) {
		if (index < 0 || index > size) {
			throw new ArrayIndexOutOfBoundsException(index);
		}
		//[2,  4,  6,  8,  10]
		//[2,  4   6 7 8 ]
		if (items.length == size) {
			int[] newItems = new int[size + (size >> 1)];
			int j = 0;
			for (int i = 0; i < size; i++) {
				if (index == i)
					newItems[j++] = item;

				newItems[j++] = items[i];
			}

			items = newItems;
		} else {
			for (int i = size; i > index; i--) {
				items[i] = items[i - 1];
			}
			items[index] = item;
		}
		size++;
	}

	public void removeAt(int index) {
		if (index < 0 || index >= size)
			throw new ArrayIndexOutOfBoundsException(index);
		for (int i = index; i < size - 1; i++) {
			items[i] = items[i + 1];
		}
		size--;
	}

	public int indexOf(int item) {
		for (int i = 0; i < size; i++)
			if (items[i] == item) return i;

		return -1;
	}

	public void print() {
		for (int i = 0; i < size; i++)
			System.out.println(items[i]);
	}

	public int size() {
		return size;
	}

	public int max() {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < size; i++) {
			if (max < items[i])
				max = items[i];
		}
		return max;
	}

	public int[] intersect(int[] numbers) {
		int[] intersects = new int[numbers.length];
		int count = 0;
		for (int i = 0; i < size; i++)
			for (int number : numbers)
				if (items[i] == number)
					intersects[count++] = items[i];

		int[] result = new int[count];
		for (int i = 0; i < count; i++) {
			result[i] = intersects[i];
		}
		return result;
	}

	public void reverse() {
		for (int i = 0; i < size / 2; i++) {
			int temp = items[i];
			items[i] = items[size - i - 1];
			items[size - i - 1] = temp;
		}
	}

}
