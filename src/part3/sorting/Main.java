package part3.sorting;

import java.util.Arrays;

/**
 * Created by Yaqub
 * Date: 03/12/2022
 * Time: 20:19
 * Software team
 */
public class Main {
	public static void main(String[] args) {
		BubbleSort bubbleSort = new BubbleSort();
		int[] nums = new int[]{8, 2, 4, 1, 3};
		System.out.println("Before bubble sorting: " + Arrays.toString(nums));
		bubbleSort.sort(nums);
		System.out.println("After bubble sorting: " + Arrays.toString(nums));

		SelectionSort selectionSort = new SelectionSort();
		nums = new int[]{8, 2, 4, 1, 3};
		System.out.println("\nBefore selection sorting: " + Arrays.toString(nums));
		selectionSort.sort(nums);
		System.out.println("After selection sorting: " + Arrays.toString(nums));

		nums = new int[]{8, 2, 4, 1, 3};
		InsertionSort insertionSort = new InsertionSort();
		System.out.println("\nBefore insertion sorting: " + Arrays.toString(nums));
		insertionSort.sort(nums);
		System.out.println("After insertion sorting: " + Arrays.toString(nums));

		nums = new int[]{8, 2, 4, 1, 3};
		MergeSort mergeSort = new MergeSort();
		System.out.println("\nBefore merge sorting: " + Arrays.toString(nums));
		mergeSort.sort(nums);
		System.out.println("After merge sorting: " + Arrays.toString(nums));
	}
}
