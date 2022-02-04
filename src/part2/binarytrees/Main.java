package part2.binarytrees;

public class Main {

	public static void main(String[] args) {
		Tree<Integer> tree = new Tree<>();
		tree.insert(20);
		tree.insert(10);
		tree.insert(30);
		tree.insert(6);
		tree.insert(14);
		tree.insert(24);
		tree.insert(3);
		tree.insert(8);
		tree.insert(26);
		System.out.println(tree.find(11));
		System.out.println(tree.find(1));

		System.out.println(factorial(3));
		tree.printPreOrder();
		tree.printInOrder();
		System.out.println("Height: " + tree.height());
	}

	public static int factorial(int num) {
		if (num == 0)
			return 1;
		return num * factorial(num - 1);
	}
}