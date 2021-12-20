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
		part1.stack.Stack stack = new part1.stack.Stack();
		stack.push(10);
		stack.push(20);
		stack.push(30);
		System.out.println(stack.pop());
		System.out.println(stack.peek());
		System.out.println(stack);
		System.out.println(reverse("!tcerroC"));
		System.out.println("isValidBrackets : " + isValidBrackets("{12<>}(22[(())])[]"));
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
