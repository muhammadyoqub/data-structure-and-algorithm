package part2.undirectedgraph;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yaqub
 * Date: 03/08/2022
 * Time: 18:37
 * Software team
 */
public class Path {

	private List<String> nodes = new ArrayList<>();

	public void add(String label) {
		nodes.add(label);
	}

	@Override
	public String toString() {
		return nodes.toString();
	}
}
