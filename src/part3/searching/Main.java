package part3.searching;

/**
 * Created by Yaqub
 * Date: 03/27/2022
 * Time: 13:17
 * Software team
 */
public class Main {

	public static void main(String[] args) {

		Search search = new Search();
		int[] items = new int[]{1, 2, 3, 4, 5, 6};
		System.out.println(search.linearSearch(items, 88));
		System.out.println(search.binarySearchRec(items, 4));
		System.out.println(search.binarySearch(items, 4));
		System.out.println(search.ternarySearch(items, 5));
		System.out.println(search.jumpSearch(items, 0));
		System.out.println(search.exponentialSearch(items, 6));
		System.out.println();
	}
}
