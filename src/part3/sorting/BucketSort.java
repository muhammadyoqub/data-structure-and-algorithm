package part3.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Yaqub
 * Date: 03/26/2022
 * Time: 22:23
 * Software team
 */
public class BucketSort {

	public void sort(int[] items, int numberOfBuckets) {
		List<List<Integer>> buckets = createBuckets(items, numberOfBuckets);
		int i = 0;
		for (List<Integer> bucket : buckets) {
			Collections.sort(bucket);
			for (int integer : bucket)
				items[i++] = integer;
		}
	}

	private List<List<Integer>> createBuckets(int[] items, int numberOfBuckets) {
		List<List<Integer>> buckets = new ArrayList<>();
		for (int i = 0; i < numberOfBuckets; i++)
			buckets.add(new ArrayList<>());

		for (int item : items)
			buckets.get(item / numberOfBuckets).add(item);

		return buckets;
	}
}
