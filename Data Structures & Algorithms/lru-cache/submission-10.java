class LRUCache {
    private class Node
    {
        int key;
        int val;
        Node prev;
        Node next;

    public Node(){}

    public Node(int key,int val)
    {
        this.val=val;
        this.key=key;
    }
    }

    private Node head=new Node();
    private Node tail=new Node();
    HashMap<Integer,Node> hash;
    private int cap;
    private int size;


    public LRUCache(int capacity) {
        this.cap=capacity;
        size=0;
        head.next=tail;
        tail.prev=head;
        hash=new HashMap<>();
    }
    
    public int get(int key) {
    if (!hash.containsKey(key))
        return -1;

    Node temp = hash.get(key);

    remove(temp);
    insertLast(temp);

    return temp.val;
}
    
    public void put(int key, int value) {
        if(hash.containsKey(key))
        {
            Node temp=hash.get(key);
            remove(temp);
            Node insert=new Node(key,value);
            hash.put(key,insert);
            insertLast(insert);
            return;
        }
        if(size==cap)
        {
            Node temp=head.next;
            hash.remove(temp.key);
            remove(temp);
            size--;
        }
        Node insert=new Node(key,value);
        insertLast(insert);
        hash.put(key,insert);
        size++;
    }

    private void remove(Node temp)
    {
        temp.prev.next=temp.next;
        temp.next.prev=temp.prev;
    }
    private void insertLast(Node temp)
    {
        tail.prev.next=temp;
        temp.prev=tail.prev;
        temp.next=tail;
        tail.prev=temp;
    }
}
