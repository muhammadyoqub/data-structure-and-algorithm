package part3.searching;

/**
 * Created by Yaqub
 * Date: 03/27/2022
 * Time: 13:15
 * Software team
 */
public class Search {

	public int linearSearch(int[] items, int target) {
		for (int i = 0; i < items.length; i++) {
			if (items[i] == target)
				return i;
		}
		return -1;
	}

	public int binarySearch(int[] items, int target) {
		int left = 0;
		int right = items.length - 1;
		while (left <= right) {
			int middle = (left + right) / 2;
			if (target > items[middle])
				left = middle + 1;
			else if (target < items[middle])
				right = middle - 1;
			else
				return middle;

		}
		return -1;
	}

	public int binarySearchRec(int[] items, int target) {
		return binarySearchRec(items, target, 0, items.length - 1);
	}

	private int binarySearchRec(int[] items, int target, int left, int right) {
		if (left > right)
			return -1;

		int middle = (left + right) / 2;
		if (target > items[middle])
			return binarySearchRec(items, target, middle + 1, right);
		else if (target < items[middle])
			return binarySearchRec(items, target, left, middle - 1);
		else
			return middle;
	}

	public int ternarySearch(int[] items, int target) {
		return ternarySearch(items, target, 0, items.length - 1);
	}

	private int ternarySearch(int[] items, int target, int left, int right) {
		if (left >= right)
			return -1;

		int partitionSize = (right - left) / 3;
		int mid1 = left + partitionSize;
		int mid2 = right - partitionSize;
		if (target == items[mid1])
			return mid1;
		else if (target == items[mid2])
			return mid2;
		else if (target < items[mid1])
			return ternarySearch(items, target, left, mid1 - 1);
		else if (target > items[mid2])
			return ternarySearch(items, target, mid2 + 1, right);
		else
			return ternarySearch(items, target, mid1 + 1, mid2 - 1);

	}

	public int jumpSearch(int[] items, int target) {
		int blockSize = (int) Math.sqrt(items.length);
		int start = 0;
		int next = blockSize;

		while (start < items.length && target > items[next - 1]) {
			start = next;
			next += blockSize;
			if (next > items.length)
				next = items.length;
		}

		for (int i = start; i < next; i++)
			if (target == items[i])
				return i;

		return -1;
	}

	public int exponentialSearch(int[] items, int target) {
		int boundary = 1;
		while (boundary < items.length && target > items[boundary])
			boundary += boundary;

		int left = boundary / 2;
		int right = Math.min(boundary, items.length - 1);
		return binarySearchRec(items, target, left, right);
	}
}
