
class MyHashMap<K, V> {
	int capacity = 16;
	int size = 0;
	Entry<K,V>[] buckets = new Entry[capacity];

	public boolean isEmpty() {
		return size == 0;
	}

	public void put(K key, V value) {
    	int hashKey = hash(key);
    	int index = hashKey % capacity;
    	Entry<K, V> bucket = buckets[index];

    	Entry<K, V> newEntry = new Entry(key, value);

    	if (bucket == null) {
        	// If the bucket is empty, simply insert the new entry
        	buckets[index] = newEntry;
        	size++;
    	} else {
        	// Traverse the linked list to check for an existing key
        	while (bucket != null) {
            	if (bucket.key.equals(key)) {
                	// If key exists, update the value
                	bucket.value = value;
                	return;
            	}
            	if (bucket.next == null) {
                	break;
            	}
           		bucket = bucket.next;
        	}

        	// If the key was not found, add the new entry at the end of the chain
        	bucket.next = newEntry;
        	size++;
    	}
	}

	public V get(K key) {
    	int hashKey = hash(key);
    	int index = hashKey % capacity;
    	Entry<K, V> bucket = buckets[index];

    	while (bucket != null) {
        	if (bucket.key.equals(key)) {
            	return bucket.value;
        	}
        	bucket = bucket.next;
    	}

    	return null;
	}

	public V remove(K key) {
    	int hashKey = hash(key);
    	int index = hashKey % capacity;
    	Entry<K, V> bucket = buckets[index];
    	Entry<K, V> prev = null;

    	while (bucket != null) {
        	if (bucket.key.equals(key)) {
            	// If the key matches, remove the entry
            	if (prev == null) {
                	// We're removing the first entry in the chain (bucket is the head of the list)
                	buckets[index] = bucket.next;
            	} else {
                	// We're removing an entry that's not the first one in the chain
                	prev.next = bucket.next;
            	}
            	size--; // Decrease the size after removing the entry
            	return bucket.value; // Return the value of the removed entry
        	}
        
        	// Move to the next entry in the chain
        	prev = bucket;      // `prev` should always track the previous entry
        	bucket = bucket.next; // Move to the next entry in the chain
    	}

    	return null; // Return null if key is not found
	}

	public boolean containsKey(K key) {
    	int hashKey = hash(key);
    	int index = hashKey % capacity;
    	Entry<K, V> bucket = buckets[index];

    	while (bucket != null) {
        	if (bucket.key.equals(key)) {
            	return true;
        	}
        	bucket = bucket.next;
    	}

    	return false;
	}

	public Set<K> keySet() {
    	Set<K> keys = new HashSet<>();
    	for (Entry<K, V> bucket : buckets) {
        	while (bucket != null) {
            	keys.add(bucket.key);
            	bucket = bucket.next;
        	}
    	}
    	return keys;
	}


	public Collection<V> values() {
    	List<V> values = new ArrayList<>();
    	for (Entry<K, V> bucket : buckets) {
        	while (bucket != null) {
            	values.add(bucket.value);
            	bucket = bucket.next;
        	}
    	}
    	return values;
	}

	
	private int hash(K key) {
    	if (key == null) return 0; // Special case for null keys
	    int h = key.hashCode();
	    // The use of >>> (unsigned right shift) instead of >> ensures that the leftmost bits are filled with zero, 
	    // which avoids problems that arise with negative hash codes.
    	return h ^ (h >>> 16); // Use unsigned right shift (>>>)
	}
	
	private Entry<K,V>[] entrySet() {
		return buckets;
	}


	public void print() {
		for (Entry<K,V> entry : buckets) {
			System.out.print(entry + "-");
		}
	}

	class Entry<K, V> {
		K key;
		V value;
		Entry<K, V> next;

		public Entry(K key,  V val) {
			key = key;
			value = val;
		}

		public String toString() {
			return "[" + key + ", " + value + "]";
		}
	}
}