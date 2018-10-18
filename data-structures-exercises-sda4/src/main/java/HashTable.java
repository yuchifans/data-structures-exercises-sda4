package main.java;

/**
 * Stores keys of type Object and values of type Object.
 * 
 * @author Siqi Qian
 *
 */

class Entry {
	Object key;
	Object value;
	Entry next;

	Entry(Object k, Object v, Entry n) {
		this.key = k;
		this.value = v;
		this.next = n;
	}
}

public class HashTable {
	int size = 16; // would not make a difference to use a difference
	Entry[] table = new Entry[size];

	void put(Object key, Object value) {
		int hashCode = key.hashCode();
		int index = hashCode % size;
		Entry firstEntry = table[index];
		// if hash table is empty, then firstEntry==null!!
		if (firstEntry == null) {
			Entry newEntry = new Entry(key, value, null);
			table[index] = newEntry;
		} else {
			// firstEntry!=null
			Entry current = firstEntry;
			while (current.next != null && current.key != key) {
				current = current.next;
			}
			// two cases: either current is the last entry or key in entry matches given key
			if (current.key == key) {
				current.value = value;
			} else {
				current.next = new Entry(key, value, null);
			}

		}
	}

	/**
	 * Returns the value that the key is mapped to
	 * 
	 * @param key
	 * @return the value that key maps to
	 */
	Object get(Object key) {
		int hashValue = key.hashCode();
		int index = hashValue % size;
		Entry current=table [index];
		while(current.next!=null && current.key!=key) {
			current =current.next;
		}
		if(current.key==key) {
			return current.value;
		}else {
			return null;
		}
	}

}
