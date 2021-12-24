package part1.stack;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Created by yaqub
 * Date: 20/12/21
 * Time: 16:42
 * Software team
 */
public class Exercise {

	private final static List<Character> leftBrackets = Arrays.asList('(', '{', '[', '<');
	private final static List<Character> rightBrackets = Arrays.asList(')', '}', ']', '>');

	public static void main(String[] args) {
//		part1.stack.Stack stack = new part1.stack.Stack();
//		Stack stack1 = new Stack();
//		stack1.push(10);
//		stack.push(10);
//		stack.push(20);
//		stack.push(30);
//		System.out.println(stack.pop());
//		System.out.println(stack.peek());
//		System.out.println(stack);
//		System.out.println(reverse("!tcerroC"));
//		System.out.println("isValidBrackets : " + isValidBrackets("{12<>}(22[(())])[]"));

		MinStack minStack = new MinStack();
		minStack.push(5);
		minStack.push(4);
		minStack.push(3);
		minStack.push(2);
		minStack.push(1);
		System.out.println("min: " + minStack.min());
		System.out.println("pop: " + minStack.pop());
		System.out.println("min: " + minStack.min());
		System.out.println("pop: " + minStack.pop());
		System.out.println("min: " + minStack.min());
		System.out.println("pop: " + minStack.pop());
		System.out.println("min: " + minStack.min());
		System.out.println("pop: " + minStack.pop());
		System.out.println("top: " + minStack.top());
		System.out.println("min: " + minStack.min());

		TwoStacks twoStacks = new TwoStacks();
		System.out.println("isEmpty1" + twoStacks.isEmpty1());
		System.out.println("isEmpty2" + twoStacks.isEmpty2());
		System.out.println("isFull1" + twoStacks.isFull1());
		System.out.println("isFull1" + twoStacks.isFull2());
		twoStacks.push1(10);
		twoStacks.push1(20);
		twoStacks.push1(30);
		twoStacks.push1(40);
		twoStacks.push1(50);
		twoStacks.push2(60);
		twoStacks.push2(70);
		twoStacks.push2(80);
		twoStacks.push2(90);
		twoStacks.push2(100);
		System.out.println("isEmpty1" + twoStacks.isEmpty1());
		System.out.println("isEmpty2" + twoStacks.isEmpty2());
		System.out.println("isFull1" + twoStacks.isFull1());
		System.out.println("isFull1" + twoStacks.isFull2());
	}

	public static String reverse(String str) {
		if (str == null)
			throw new IllegalArgumentException();

		Stack<Character> characters = new Stack<>();
		StringBuilder reversed = new StringBuilder();
		for (Character character : str.toCharArray())
			characters.push(character);

		for (int i = 0; i < str.length(); i++)
			reversed.append(characters.pop());

		return reversed.toString();
	}

	public static boolean isValidBrackets(String input) {
		if (input == null)
			throw new IllegalArgumentException();

		Stack<Character> stack = new Stack<>();
		for (char ch : input.toCharArray()) {
			if (isLeftBracket(ch))
				stack.push(getPartner(ch));
			else if (isRightBracket(ch)) {
				if (stack.isEmpty() || stack.pop() != ch) {
					return false;
				}
			}

		}
		return stack.isEmpty();
	}

	private static boolean isLeftBracket(char ch) {
		return leftBrackets.contains(ch);
	}

	private static boolean isRightBracket(char ch) {
		return rightBrackets.contains(ch);
	}

	private static char getPartner(char ch) {
		return rightBrackets.get(leftBrackets.indexOf(ch));
	}
}
