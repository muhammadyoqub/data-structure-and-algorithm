package part3.sorting;

/**
 * Created by Yaqub
 * Date: 03/12/2022
 * Time: 19:33
 * Software team
 */
public class BubbleSort {

	public void sort(int[] items) {
		for (int i = 1; i < items.length; i++) {
			boolean sorted = true;
			for (int j = 0; j < items.length - i; j++)
				if (items[j] > items[j + 1]) {
					swap(items, j, j + 1);
					sorted = false;
				}

			if (sorted)
				break;
		}
	}

	private void swap(int[] items, int index1, int index2) {
		int temp = items[index1];
		items[index1] = items[index2];
		items[index2] = temp;
	}
}
