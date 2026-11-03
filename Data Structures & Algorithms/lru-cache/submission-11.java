class LRUCache {
    private class Node{
        int key,val;
        Node next,prev;
        public Node(){}
        public Node(int key,int val){
            this.key=key;
            this.val=val;
        }
    }
    Node head;
    Node tail;
    int cap;
    HashMap<Integer,Node>hash;

    public LRUCache(int capacity) {
        head=new Node();
        tail=new Node();
        this.cap=capacity;
        hash=new HashMap<>();
        head.next=tail;
        tail.prev=head;
    }
    
    public int get(int key) {
        if(!hash.containsKey(key)) return -1;
        Node temp=hash.get(key);
        if(temp.next!=tail){
            removeNode(temp);
            addToTail(temp);
        }
        return temp.val;
    }
    
    public void put(int key, int value) {
        Node temp;
        if(hash.containsKey(key)){
            temp=hash.get(key);
            temp.val=value;
            removeNode(temp);
        }
        else{
            temp=new Node(key,value);
            hash.put(key,temp);
        }
        addToTail(temp);
        if(hash.size()>cap){
            hash.remove(head.next.key);
            removeNode(head.next);
        }
        }
    
    private void removeNode(Node temp){
        temp.prev.next=temp.next;
        temp.next.prev=temp.prev;
    }

    private void addToTail(Node temp){
        temp.prev=tail.prev;
        tail.prev.next=temp;
        tail.prev=temp;
        temp.next=tail;
    }}

