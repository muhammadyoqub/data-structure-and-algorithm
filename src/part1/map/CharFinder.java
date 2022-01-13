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

		Map<Integer, String> map = new HashMap<>(5);
		map.put(6, "A");
		map.put(11, "B");
		System.out.println(map);

		CharFinder characterFinder = new CharFinder();
		Character result = characterFinder.findFirstRepeatedChar("green apple ");
		System.out.println(result);
	}

	public Character findFirstRepeatedChar(String str) {
		Set<Character> set = new HashSet<>();
		for (Character character : str.toCharArray())
			if (!set.add(character)) return character;

		return null;
	}
}
