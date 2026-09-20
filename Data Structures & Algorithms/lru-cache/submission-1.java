

class LRUCache {
    private class Node {
        int key;
        int val;
        Node prev;
        Node next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }

        Node() {}
    }

    private final int capacity;
    private final Map<Integer, Node> map;
    private final Node head;
    private final Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.head = new Node();
        this.tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        moveToTail(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value;
            moveToTail(node);
            return;
        }

        if (map.size() == capacity) {
            // Evict least recently used (head.next)
            Node lru = head.next;
            removeNode(lru);
            map.remove(lru.key);
        }

        Node newNode = new Node(key, value);
        addNodeToTail(newNode);
        map.put(key, newNode);
    }

    // Helper: remove a node from its current position
    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // Helper: add a node right before dummy tail (most recently used)
    private void addNodeToTail(Node node) {
        node.prev = tail.prev;
        node.next = tail;
        tail.prev.next = node;
        tail.prev = node;
    }

    // Helper: move an existing node to the end
    private void moveToTail(Node node) {
        removeNode(node);
        addNodeToTail(node);
    }
}