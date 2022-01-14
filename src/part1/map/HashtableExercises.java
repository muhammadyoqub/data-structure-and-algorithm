package part1.map;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * Created by yaqub
 * Date: 14/01/22
 * Time: 18:00
 * Software team
 */
public class HashtableExercises {

	public static void main(String[] args) {
		HashtableExercises exercises = new HashtableExercises();
		Integer result = exercises.mostFrequent(new int[]{1, 2, 2, 3, 3, 3, 4});
		System.out.println(result);
	}


	public Integer mostFrequent(int[] nums) {
		Map<Integer, Integer> hashtable = new HashMap<>(5);

		for (int num : nums) {
			Integer value = hashtable.get(num);
			if (value == null)
				hashtable.put(num, 1);
			else {
				hashtable.put(num, ++value);
			}
		}
		Integer mostFrequent = null;
		int time = 0;
		for (Map.Entry<Integer, Integer> entry : hashtable.entrySet()) {
			if (time < entry.getValue()) {
				mostFrequent = entry.getKey();
			}
		}

		return mostFrequent;
	}
}
