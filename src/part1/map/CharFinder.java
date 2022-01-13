package part1.map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CharFinder {

	public static void main(String[] args) {
		CharFinder charFinder = new CharFinder();
		String str = "a green apple";
		Character nonRepeated =  charFinder.nonRepeatFirstChar(str);
		Character repeatedChar = charFinder.findFirstRepeatedChar(str);
		System.out.println(nonRepeated);
		System.out.println(repeatedChar);
	}

	public Character nonRepeatFirstChar(String text) {
		Map<Character, Integer> map = new HashMap<>();
		char[] chars = text.toCharArray();
		for (Character character : chars) {
			if (map.containsKey(character)) {
				Integer integer = map.get(character);
				map.put(character, ++integer);
			} else {
				map.put(character, 1);
			}
		}

		for (Character ch : chars) {
			if (map.get(ch) == 1)
				return ch;
		}

		return Character.MIN_VALUE;
	}

	public Character findFirstRepeatedChar(String str) {
		Set<Character> set = new HashSet<>();
		for (Character character : str.toCharArray())
			if (!set.add(character)) return character;

		return Character.MIN_VALUE;
	}
}
