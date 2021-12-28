import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yaqub
 * Date: 27/12/21
 * Time: 10:51
 * Software team
 */
public class BroTask {

	public static void main(String[] args) {
		List<Category> categories = new ArrayList<>();
		categories.add(new Category(1, 0));
		categories.add(new Category(22, 21));
		categories.add(new Category(21, 20));
		categories.add(new Category(20, 1));
		categories.add(new Category(19, 1));
		categories.add(new Category(18, 1));
		categories.add(new Category(16, 1));
		categories.add(new Category(17, 2));
		categories.add(new Category(15, 2));
		categories.add(new Category(14, 2));
		categories.add(new Category(13, 1));
		categories.add(new Category(12, 2));
		categories.add(new Category(11, 3));
		categories.add(new Category(10, 3));
		categories.add(new Category(9, 3));
		categories.add(new Category(8, 3));
		categories.add(new Category(7, 3));
		categories.add(new Category(6, 2));
		categories.add(new Category(5, 4));
		categories.add(new Category(4, 1));
		categories.add(new Category(3, 0));
		categories.add(new Category(2, 0));
		BroTask broTask = new BroTask();
		List<Category> sorted = broTask.sort(categories);
		System.out.println(sorted.toString());
	}

	public List<Category> sort(List<Category> list) {
		List<Category> sorted = new ArrayList<>();
		Map<Integer, Category> map = new HashMap<>();

		for (Category category : list) {
			map.put(category.getId(), category);
		}
		for (Category current : list) {
			if (current.getParent_id() == 0) {
				sorted.add(current);
			} else {
				Category parent = map.get(current.getParent_id());
				parent.addChild(current);
			}
		}

		return sorted;
	}

	private static class Category {
		private final int id;
		private final int parent_id;
		private List<Category> children;

		public Category(int id, int parent_id) {
			this.id = id;
			this.parent_id = parent_id;
		}

		public int getId() {
			return id;
		}

		public int getParent_id() {
			return parent_id;
		}


		public void addChild(Category child) {
			if (children == null) {
				children = new ArrayList<>();
			}
			this.children.add(child);
		}


		@Override
		public String toString() {
			return "{ID: " + id + ", ParentId: " + parent_id + ", children:" + children + "}";
		}
	}
}
