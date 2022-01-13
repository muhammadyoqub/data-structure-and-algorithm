package part1.linked;

public class Main {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.print();
		System.out.println(list.size());
		list.addLast(10);
		list.addLast(20);
		list.addLast(30);
		list.addLast(40);
		list.addLast(50);
//		list.addLoop(2);
//		list.addLast(20);
//		list.addLast(30);
//		list.addLast(40);
//		list.addLast(50);
//		list.addLoop(3);
//		System.out.println("consists: " + list.contains(30));
//		System.out.println("indexOf: " + list.indexOf(30));
//		System.out.println("K :" + list.getKthNodeFromTheEnd(1));
//		System.out.println("hasLoop :" + list.hasLoop());
		list.printMiddle();
//		list.print();
	}
}
