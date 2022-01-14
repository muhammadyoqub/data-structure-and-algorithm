package part1.map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by yaqub
 * Date: 12/01/22
 * Time: 16:19
 * Software team
 */
public class CharFinder {

	public static void main(String[] args) {

		Hashtable<Integer, String> hashTable = new Hashtable<>(5);
		hashTable.put(1, "A");
		hashTable.put(3, "B");
		hashTable.put(11, "C");
		hashTable.put(6, "Salmon");
		hashTable.put(42314, "ABC");
		hashTable.put(55, "OLL");
		hashTable.put(44, "ODSA");
		System.out.println(hashTable.get(1));
		System.out.println(hashTable.get(55));

		CharFinder charFinder = new CharFinder();
		String str = "a green apple";
		Character nonRepeated = charFinder.nonRepeatFirstChar(str);
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
