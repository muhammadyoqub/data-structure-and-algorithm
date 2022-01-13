package part1.queue;

import java.util.Arrays;
import java.util.Stack;

public class QueueExercise {

	public static void main(String[] args) {
		ArrayQueue queue = new ArrayQueue();
		System.out.println("isEmpty: " + queue.isEmpty());
		queue.add(10);
		queue.add(20);
		queue.add(30);
		queue.add(40);
		queue.add(50);
		queue.remove();
		queue.remove();
		queue.add(60);
		queue.add(70);
		System.out.println("queue:" + queue);
		reverse(queue);
		System.out.println("Reversed: " + queue);
		System.out.println("isFull: " + queue.isFull());
		System.out.println("remove: " + queue.remove());
		System.out.println("add: " + queue.add(80));
		System.out.println("remove: " + queue.remove());
		System.out.println("remove: " + queue.remove());
		System.out.println("remove: " + queue.remove());
		System.out.println("remove: " + queue.remove());
		System.out.println("remove: " + queue.remove());
		System.out.println(queue.isEmpty());
		System.out.println(queue);
		System.out.println("------QueueWithTwoStack---------");

		QueueWithTwoStack queueWithTwoStack = new QueueWithTwoStack(10);
		queueWithTwoStack.add(10);
		queueWithTwoStack.add(20);
		queueWithTwoStack.add(30);
		queueWithTwoStack.add(40);
		queueWithTwoStack.add(50);
		System.out.println(queueWithTwoStack.remove());
		queueWithTwoStack.add(50);
		queueWithTwoStack.add(60);
		System.out.println(queueWithTwoStack);

		System.out.println("------PriorityQueue---------");
		PriorityQueue priorityQueue = new PriorityQueue(10);
		priorityQueue.add(1);
		priorityQueue.add(5);
		priorityQueue.add(3);
		priorityQueue.add(7);
		while (!priorityQueue.isEmpty())
			System.out.println(priorityQueue.remove());
		priorityQueue.add(10);
		priorityQueue.add(8);
		priorityQueue.add(9);
		priorityQueue.add(6);
		while (!priorityQueue.isEmpty())
			System.out.println(priorityQueue.remove());
		int[] items = {1, 2, 3, 4, 5};
		System.out.println(Arrays.toString(reverse(3, items)));
		System.out.println("--------StackWithTwoQueues-----------");
		StackWithTwoQueues stack = new StackWithTwoQueues();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		System.out.println(stack.pop());
		System.out.println(stack.peek());
		System.out.println(stack.pop());
		System.out.println(stack.pop());

		System.out.println("------------LinkedListQueue--------");
		LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();
		linkedListQueue.add(10);
		linkedListQueue.add(20);
		linkedListQueue.add(30);
		linkedListQueue.add(40);
		System.out.println(linkedListQueue.remove());
		System.out.println(linkedListQueue.peek());
		System.out.println(linkedListQueue);
		System.out.println("------------StackWithTwoQueues----------");
		StackWithTwoQueues stackWithTwoQueues = new StackWithTwoQueues();
		stackWithTwoQueues.push(10);
		System.out.println(stackWithTwoQueues.pop());
		stackWithTwoQueues.push(20);
		stackWithTwoQueues.push(30);
		System.out.println(stackWithTwoQueues.pop());
		stackWithTwoQueues.push(40);
		stackWithTwoQueues.push(50);
		System.out.println(stackWithTwoQueues.peek());
		System.out.println(stackWithTwoQueues);
	}

	public static void reverse(ArrayQueue queue) {
		Stack<Integer> stack = new Stack<>();
		while (!queue.isEmpty())
			stack.push(queue.remove());

		while (!stack.isEmpty())
			queue.add(stack.pop());

	}

	public static int[] reverse(int k, int[] items) {
		if (k > items.length)
			throw new IllegalArgumentException();

		part1.stack.Stack stack = new part1.stack.Stack(k);
		for (int i = 0; i < k; i++) {
			stack.push(items[i]);
		}
		int i = 0;
		while (!stack.isEmpty()) {
			items[i++] = stack.pop();
		}
		return items;
	}

}
