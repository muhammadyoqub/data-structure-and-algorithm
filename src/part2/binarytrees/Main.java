package part2.binarytrees;

public class Main {

	public static void main(String[] args) {
		Tree<Integer> tree = new Tree<>();
		tree.insert(10);
		tree.insert(5);
		tree.insert(15);
		tree.insert(6);
		tree.insert(1);
		System.out.println(tree.find(11));
		System.out.println(tree.find(1));
	}
}