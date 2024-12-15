import java.util.Map;
import java.util.HashMap;

class LRUCache2 {
    // Default cache capacity
    public static final int CAPACITY = 16;
    
    private Map<Integer, Node> map;  // Store key-node mapping
    private int capacity;  // Max capacity of the cache
    private int size;  // Current size of the cache
    private Node head;  // Sentinel node at the head of the doubly linked list
    private Node tail;  // Sentinel node at the tail of the doubly linked list

    // Constructor with a custom capacity
    public LRUCache2(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
        this.size = 0;

        // Initialize the doubly linked list with dummy head and tail nodes
        head = new Node();
        tail = new Node();
        head.post = tail;
        tail.pre = head;
    }

    // Default constructor using the default capacity
    public LRUCache2() {
        this(CAPACITY);
    }

    // Put a new key-value pair into the cache
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            // Update the existing node and move it to the head
            Node node = map.get(key);
            node.value = value;
            moveToHead(node);
        } else {
            // Create a new node and add it to the cache
            Node node = new Node(key, value);
            map.put(key, node);
            addFirst(node);
            size++;

            // If the cache exceeds capacity, remove the least recently used (LRU) node
            if (size > capacity) {
                Node removed = removeLast();
                map.remove(removed.key);
                size--;
            }
        }
    }

    // Get the value of a key in the cache
    public int get(int key) {
        Node node = map.get(key);
        if (node != null) {
            moveToHead(node);  // Move the accessed node to the head
            return node.value;
        }
        return -1;  // Return -1 if the key doesn't exist
    }

    // Helper method to move a node to the head (most recently used)
    private void moveToHead(Node node) {
        removeNode(node);
        addFirst(node);
    }

    // Helper method to add a node to the head of the list
    private void addFirst(Node node) {
        node.pre = head;
        node.post = head.post;

        head.post.pre = node;
        head.post = node;
    }

    // Helper method to remove a node from the list
    private void removeNode(Node node) {
        Node prev = node.pre;
        Node next = node.post;

        prev.post = next;
        next.pre = prev;
    }

    // Helper method to remove the last node (least recently used)
    private Node removeLast() {
        Node res = tail.pre;
        removeNode(res);
        return res;
    }

    // Get the current size of the cache
    public int size() {
        return this.size;
    }

    // Get the current capacity of the cache
    public int capacity() {
        return this.capacity;
    }

    // Print the current state of the cache (for debugging)
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cache [size=").append(size)
          .append(", capacity=").append(capacity)
          .append("]\n");

        Node curr = head.post;
        while (curr != tail) {
            sb.append(curr).append(" -> ");
            curr = curr.post;
        }
        sb.append("null");
        return sb.toString();
    }

    // Static inner Node class representing a cache entry
    static class Node {
        int key;
        int value;
        Node pre;
        Node post;

        // Constructor
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "[" + key + "=" + value + "]";
        }
    }
}