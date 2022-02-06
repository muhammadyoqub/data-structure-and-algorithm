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

		Tree<Integer> tree2 = new Tree<>();
		tree2.insert(20);
		tree2.insert(10);
		tree2.insert(30);
		tree2.insert(6);
		tree2.insert(14);
		tree2.insert(24);
		tree2.insert(3);
		tree2.insert(8);
		tree2.insert(26);
		tree2.insert(31);
		tree2.insert(29);
		tree2.insert(27);

		System.out.println(tree.find(11));
		System.out.println(tree.find(1));

		System.out.println(factorial(3));
		tree.printPreOrder();
		tree.printInOrder();
		tree.printPostOrder();
		System.out.println("Height: " + tree.height());
		System.out.println("Equals: " + tree.equals(tree2));
		System.out.println("isBinarySearchTree=" + tree.isBinarySearchTree());
		tree.printLevelOrder();
		System.out.println("Size: " + tree.size());
		System.out.println("Count Leaves: " + tree.countLeaves());
		System.out.println("Max: " + tree.max());
	}

	public static int factorial(int num) {
		if (num == 0)
			return 1;
		return num * factorial(num - 1);
	}
}