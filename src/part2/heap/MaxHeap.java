package part2.heap;

public class MaxHeap {

	public static void heapify(int[] items) {
		int lastParentIndex = items.length / 2 - 1;
		for (int i = lastParentIndex; i >= 0; i--)
			bubbleDown(items, i);
	}

	public static int getKthLargestNumber(int[] array, int k) {
		int larger = array[0];
		Heap<Integer> heap = new Heap<>(array.length);

		for (int item : array)
			heap.insert(item);

		for (int i = 0; i < Math.min(array.length, k); i++)
			larger = heap.remove();

		return larger;
	}

	public static boolean isMaxHeap(int[] array) {
		return isMaxHeap(array, 0);
	}

	private static boolean isMaxHeap(int[] array, int index) {
		if (array.length == index)
			return true;

		return array[index] <= array[parent(index)] && isMaxHeap(array, ++index);
	}


	private static void bubbleDown(int[] items, int i) {
		int largerIndex = i;

		int leftChildIndex = left(i);
		if (leftChildIndex < items.length && items[i] < items[leftChildIndex])
			largerIndex = leftChildIndex;

		int rightChildIndex = right(i);
		if (rightChildIndex < items.length && items[largerIndex] < items[rightChildIndex])
			largerIndex = rightChildIndex;

		if (i == largerIndex)
			return;

		swap(items, i, largerIndex);
		bubbleDown(items, largerIndex);
	}

	static private void swap(int[] items, int first, int second) {
		int temp = items[first];
		items[first] = items[second];
		items[second] = temp;
	}

	private static int left(int index) {
		return index * 2 + 1;
	}

	private static int parent(int index) {
		return (index - 1) / 2;
	}

	private static int right(int index) {
		return index * 2 + 2;
	}
}