package part3.sorting;

/**
 * Created by Yaqub
 * Date: 03/12/2022
 * Time: 20:41
 * Software team
 */
public class SelectionSort {

	public void sort(int[] items) {
		for (int i = 0; i < items.length; i++)
			swap(items, i, findMinIndex(items, i));
	}

	public int findMinIndex(int[] items, int minIndex) {
		for (int i = minIndex; i < items.length; i++)
			if (items[minIndex] > items[i])
				minIndex = i;

		return minIndex;
	}

	private void swap(int[] items, int index1, int index2) {
		int temp = items[index1];
		items[index1] = items[index2];
		items[index2] = temp;
	}
}
