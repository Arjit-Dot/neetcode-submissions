class LRUCache {
    private class Node{
        int key;
        int value;
        Node prev;
        Node next;

    public Node(){} 

    public Node(int key,int val)
    {
        this.value=val;
        this.key=key;
    }
    public Node(int val,Node prev,Node next)
    {
        this.value=val;
        this.prev=prev;
        this.next=next;
    }}

    Node head=new Node();
    Node tail=new Node();
    private int cap;
    private int size=0;
    private HashMap<Integer,Node> hash;

    public LRUCache(int capacity) {
        this.cap=capacity;
        hash=new HashMap<>();
        head.next=tail;
        tail.prev=head;
    }
    
    public int get(int key) {
    if (!hash.containsKey(key))
        return -1;

    Node temp = hash.get(key);

    remove(temp);
    insertBack(temp);

    return temp.value;
}

    
    public void put(int key, int value) {

    // Key already exists
    if (hash.containsKey(key)) {
        Node old = hash.get(key);

        remove(old);

        Node node = new Node(key, value);
        hash.put(key, node);
        insertBack(node);

        return;
    }

    // Cache is full
    if (size == cap) {
        Node lru = head.next;

        remove(lru);
        hash.remove(lru.key);

        size--;
    }

    // Add new node
    Node node = new Node(key, value);

    hash.put(key, node);
    insertBack(node);

    size++;
}

    private void insertFront(Node temp)
    {
        head.next.prev=temp;
        temp.next=head.next;
        temp.prev=head;
        head.next=temp;
    }
    private void insertBack(Node temp)
    {
        tail.prev.next=temp;
        temp.prev=tail.prev;
        tail.prev=temp;
        temp.next=tail;
    }
    private void remove(Node node) {
    node.prev.next = node.next;
    node.next.prev = node.prev;
}

}