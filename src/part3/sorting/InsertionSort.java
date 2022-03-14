package part3.sorting;

/**
 * Created by Yaqub
 * Date: 03/12/2022
 * Time: 22:09
 * Software team
 */
public class InsertionSort {

	public void sort(int[] items) {
		for (int i = 1; i < items.length; i++) {
			int current = items[i];
			items[find(items, i)] = current;
		}
	}

	private int find(int[] items, int index) {
		int current = items[index];
		for (int i = index; i > 0; i--) {
			if (items[i - 1] <= current)
				return i;
			items[i] = items[i - 1];
		}
		return 0;
	}
}
