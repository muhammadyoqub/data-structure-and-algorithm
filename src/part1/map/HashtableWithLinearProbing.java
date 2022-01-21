package part1.map;

/**
 * Created by yaqub
 * Date: 21/01/22
 * Time: 10:22
 * Software team
 */
public class HashtableWithLinearProbing<K, V> {

	private static class Entry<K, V> {
		private final K key;
		private V value;

		public Entry(K key, V value) {
			this.key = key;
			this.value = value;
		}
	}

	private final Entry<K, V>[] entries;
	private int size;

	public HashtableWithLinearProbing(int capacity) {
		entries = new Entry[capacity];
	}

	public void put(K key, V value) {
		if (size == entries.length)
			throw new IllegalStateException();

		int hash = hash(key);
		for (int i = 0; i < entries.length; i++) {
			int index = (hash + i) % entries.length;
			Entry<K, V> entry = entries[index];
			if (entry == null || entry.key == key) {
				if (entry == null) {
					entry = new Entry<>(key, value);
					entries[index] = entry;
				} else
					entry.value = value;

				break;
			}
		}
		size++;
	}

	public V get(K key) {
		int hash = hash(key);
		for (int i = 0; i < entries.length; i++) {
			int index = (hash + i) % entries.length;
			Entry<K, V> entry = entries[index];
			if (entry != null && entry.key == key)
				return entry.value;
		}
		return null;
	}

	public V remove(K key) {
		int hash = hash(key);
		for (int i = 0; i < entries.length; i++) {
			int index = (hash + i) % entries.length;
			Entry<K, V> entry = entries[index];
			if (entry != null && entry.key == key) {
				entries[index] = null;
				size--;
				return entry.value;

			}
		}
		return null;
	}

	public int size() {
		return size;
	}


	private int hash(K key) {
		return key.hashCode() % entries.length;
	}
}
