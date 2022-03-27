package part3.sorting;

/**
 * Created by Yaqub
 * Date: 03/26/2022
 * Time: 20:21
 * Software team
 */
public class CountingSort {

	public void sort(int[] items) {
		int max = max(items);
		int[] counts = new int[max + 1];
		for (int num : items)
			counts[num]++;
		int in = 0;
		for (int i = 0; i < counts.length; i++) {
			for (int j = 0; j < counts[i]; j++) {
				items[in++] = i;
			}
		}
	}

	private int max(int[] items) {
		int max = 0;
		for (int item : items) if (item > max) max = item;

		return max;
	}
}
