package part3.sorting;

/**
 * Created by Yaqub
 * Date: 03/26/2022
 * Time: 18:27
 * Software team
 */
public class QuickSort {

	public void sort(int[] items) {
		sort(items, 0, items.length - 1);
	}

	private void sort(int[] items, int start, int end) {
		if (start >= end)
			return;

		int boundary = partition(items, start, end);
		sort(items, start, boundary - 1);
		sort(items, boundary + 1, end);
	}

	private int partition(int[] items, int start, int end) {
		int pivot = items[end];
		int boundary = start - 1;
		for (int i = start; i <= end; i++)
			if (items[i] <= pivot)
				swap(items, ++boundary, i);
		return boundary;
	}

	private void swap(int[] items, int a, int b) {
		int temp = items[a];
		items[a] = items[b];
		items[b] = temp;
	}
}
