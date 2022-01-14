package part1.map;

import part1.linked.LinkedList;

/**
 * Created by yaqub
 * Date: 13/01/22
 * Time: 09:54
 * Software team
 */
public class Hashtable<K, V> {

	LinkedList<Entry<K, V>>[] entries;

	public Hashtable(int capacity) {
		entries = (LinkedList<Entry<K, V>>[]) new LinkedList[capacity];
	}

	public void put(K key, V value) {
		Entry<K, V> entry = getEntry(key);
		if (entry != null) {
			entry.value = value;
			return;
		}

		getOrCreateBucket(key).addLast(new Entry<>(key, value));
	}

	public V get(K key) {
		Entry<K, V> entry = getEntry(key);
		return entry == null ? null : entry.value;
	}

	public boolean remove(K key) {
		Entry<K, V> entry = getEntry(key);
		if (entry != null)
			getBucket(key).remove(entry);

		return false;
	}

	private Entry<K, V> getEntry(K key) {
		LinkedList<Entry<K, V>> bucket = getBucket(key);
		if (bucket != null)
			for (Entry<K, V> entry : bucket.toArray())
				if (entry.key == key)
					return entry;

		return null;
	}

	private LinkedList<Entry<K, V>> getBucket(K key) {
		return entries[hash(key)];
	}

	private LinkedList<Entry<K, V>> getOrCreateBucket(K key) {
		Integer index = hash(key);
		if (entries[index] == null)
			entries[index] = new LinkedList<>();
		return entries[index];
	}

	public Integer hash(K key) {
		return key.hashCode() % entries.length;
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
