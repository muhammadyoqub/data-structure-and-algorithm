package part3.sorting;

/**
 * Created by Yaqub
 * Date: 03/13/2022
 * Time: 23:04
 * Software team
 */
public class MergeSort {

	public void sort(int[] items) {
		int leftSize = items.length / 2;
		int rightSize = items.length - leftSize;

		if (items.length < 2) {

			return;
		}
		int[] left = new int[leftSize];
		int[] right = new int[rightSize];
		System.arraycopy(items, 0, left, 0, leftSize);

		for (int i = 0; i < rightSize; i++)
			right[i] = items[leftSize + i];

		sort(left);
		sort(right);
		int leftIndex = 0;
		int rightIndex = 0;
		for (int i = 0; i < items.length; i++)
			if (leftIndex < leftSize && rightIndex < right.length)
				if (left[leftIndex] > right[rightIndex])
					items[i] = right[rightIndex++];
				else
					items[i] = left[leftIndex++];

			else {
				if (leftIndex < leftSize)
					items[i] = left[leftIndex++];
				else
					items[i] = right[rightIndex++];

			}
	}

}
