package part1.queue;

import java.util.Stack;

public class Main {

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

		QueueWithTwoStack queueWithTwoStack = new QueueWithTwoStack();
		queueWithTwoStack.add(10);
		queueWithTwoStack.add(20);
		queueWithTwoStack.add(30);
		queueWithTwoStack.add(40);
		queueWithTwoStack.add(50);
		System.out.println(queueWithTwoStack.remove());
		queueWithTwoStack.add(50);
		queueWithTwoStack.add(60);
		System.out.println(queueWithTwoStack);
	}

	public static void reverse(ArrayQueue queue) {
		Stack<Integer> stack = new Stack<>();
		while (!queue.isEmpty())
			stack.push(queue.remove());

		while (!stack.isEmpty())
			queue.add(stack.pop());

	}
}
