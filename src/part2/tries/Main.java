package part2.tries;

import java.util.List;

public class Main {
	public static void main(String[] args) {
		Trie tries = new Trie();
		tries.insert("can");
		tries.insert("canada");
		tries.insert("boy");
		tries.insert("book");
		tries.insert("border");
		tries.insert("cat");
		tries.insert("doctor");
		tries.insert("dog");
		tries.printWords();
		System.out.println(tries.contains("book"));
		System.out.println(tries.containsRecursive("book"));
		System.out.println(tries.countOfWords());
		tries.remove("can");
		List<String> words = tries.findWords("bo");
		System.out.println(words);
		System.out.println(Trie.longestCommonPrefix(new String[]{"car"}));
	}
}
