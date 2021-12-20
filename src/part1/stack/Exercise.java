package part1.stack;

import java.util.Stack;

/**
 * Created by yaqub
 * Date: 20/12/21
 * Time: 16:42
 * Software team
 */
public class Exercise {
	public static void main(String[] args) {
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
			if (isOpening(ch))
				stack.push(getPartner(ch));
			else if (isClosing(ch)) {
				if (stack.isEmpty() || stack.pop() != ch) {
					return false;
				}
			}

		}
		return stack.isEmpty();
	}

	private static boolean isOpening(char ch) {
		return ch == '(' || ch == '{' || ch == '[' || ch == '<';
	}

	private static boolean isClosing(char ch) {
		return ch == ')' || ch == '}' || ch == ']' || ch == '>';
	}

	private static char getPartner(char ch) {
		return ch == '(' ? ')' : ch == '{' ? '}' : ch == '[' ? ']' : '>';
	}
}
