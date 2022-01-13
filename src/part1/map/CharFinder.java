package part1.map;

import java.math.BigDecimal;
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
		double num = 5.6;
		double fee2 = 5.8;
		BigDecimal amount = new BigDecimal("5.6");
		BigDecimal fee = new BigDecimal("5.8");
		System.out.println(amount.add(fee));


		Hashtable<Integer, String> hashTable = new Hashtable<>(5);
		hashTable.put(1, "Ahmad");
		hashTable.put(11, "Umar");
		hashTable.put(1, "Usmon");
		hashTable.put(6, "Salmon");
		hashTable.put(42314, "ABC");
		hashTable.put(55, "OLL");
		hashTable.put(44, "ODSA");
		System.out.println(hashTable.get(1));
		System.out.println(hashTable.get(55));

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
