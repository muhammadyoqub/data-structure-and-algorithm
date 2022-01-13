package part1.map;

import part1.linked.LinkedList;

/**
 * Created by yaqub
 * Date: 13/01/22
 * Time: 09:54
 * Software team
 */
public class Hashtable<K, V> {

	LinkedList<Entry<K, V>>[] list;

	public Hashtable(int capacity) {
		list = new LinkedList[capacity];
	}

	public boolean put(K key, V value) {
		Integer hash = hash(key);
		LinkedList<Entry<K, V>> entryLinkedList = list[hash];
		if (entryLinkedList == null) {
			entryLinkedList = new LinkedList<>();
			entryLinkedList.addFirst(new Entry<>(key, value));
			list[hash] = entryLinkedList;
		} else {
			Entry<K, V>[] entries = entryLinkedList.toArray();
			for (Entry<K, V> entry : entries) {
				if (entry != null && entry.key == key) {
					entry.value = value;
					return true;
				}
			}
			entryLinkedList.addLast(new Entry<>(key, value));
		}

		return true;
	}

	public V get(K key) {
		Integer hash = hash(key);
		LinkedList<Entry<K, V>> entryLinkedList = list[hash];
		if (entryLinkedList != null)
			for (Entry<K, V> entry : entryLinkedList.toArray())
				if (entry.key == key) return entry.value;


		return null;
	}

	public boolean remove(K key) {
		Integer hash = hash(key);
		LinkedList<Entry<K, V>> entryList = list[hash];
		if (entryList != null) {
			Entry<K, V>[] entries = entryList.toArray();
			for (int i = 0; i < entryList.toArray().length; i++) {
				if (entries[i] == key) {
					entryList.remove(i);
					return true;
				}
			}
		}
		return false;
	}

	public Integer hash(K key) {
		int hash = key.hashCode() % list.length;
		return hash;
	}

	private static class Entry<K, V> {
		private final K key;
		private V value;

		public Entry(K key, V value) {
			this.key = key;
			this.value = value;
		}
	}
}
