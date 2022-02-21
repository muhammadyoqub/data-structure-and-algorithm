package part2.heap;

public class MinPriorityQueue {
	private MinHeap heap = new MinHeap();

	public void add(String value, int priority) {
		heap.insert(priority, value);
	}

	public String dequeue() {
		return heap.remove();
	}

	public boolean isEmpty() {
		return heap.isEmpty();
	}
}