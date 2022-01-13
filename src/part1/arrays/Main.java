package part1.arrays;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		ArrayList arrayList = new ArrayList(3);
		arrayList.insert(10);
		arrayList.insert(20);
		arrayList.insert(20);
		arrayList.removeAt(2);
//		arrayList.insertAt(40, 2);
//		arrayList.insertAt(30, 2);
//		arrayList.insertAt(29, 2);
//		arrayList.insertAt(1, 0);
//		arrayList.insertAt(2, 1);
//		arrayList.reverse();
//		int[] intersects = arrayList.intersect(new int[]{30, 40, 11, 4, 5, 1});
//		System.out.println(Arrays.toString(intersects));
		arrayList.print();
	}
}
