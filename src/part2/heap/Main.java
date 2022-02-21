package part2.heap;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		Heap<Integer> heap = new Heap<>(100);
		heap.insert(15);
		heap.insert(10);
		heap.insert(3);
		heap.insert(8);
		heap.insert(12);
		heap.insert(9);
		heap.insert(4);
		heap.insert(1);
		heap.insert(24);
		heap.remove();
		System.out.println(heap);
		int[] items = {15, 10, 3, 8, 2, 9, 4, 1, 24};
		System.out.printf("isMaxHeap %s \n", MaxHeap.isMaxHeap(items));
		MaxHeap.heapify(items);
		System.out.println("heapified");
		System.out.printf("isMaxHeap %s \n", MaxHeap.isMaxHeap(items));
		System.out.println(Arrays.toString(items));
		System.out.println(MaxHeap.getKthLargestNumber(items, 0));

		MinHeap minHeap = new MinHeap();
		minHeap.insert(10, "");
		minHeap.insert(1, "");
		minHeap.insert(3, "");
		minHeap.insert(7, "");
		minHeap.insert(5, "");
		minHeap.insert(7, "");
		minHeap.insert(9, "");
		minHeap.insert(0, "");

		MinPriorityQueue minPriorityQueue = new MinPriorityQueue();
		minPriorityQueue.add("A", 5);
		minPriorityQueue.add("J", 3);
		minPriorityQueue.add("I", 8);
		minPriorityQueue.add("A", 1);
		minPriorityQueue.add("J", 4);
		System.out.println(minPriorityQueue.dequeue());
		System.out.println(minPriorityQueue.dequeue());
	}
}
