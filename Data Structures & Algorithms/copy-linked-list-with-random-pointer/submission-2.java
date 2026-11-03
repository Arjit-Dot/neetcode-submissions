/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
class Solution {
    HashMap<Node, Node> hash = new HashMap<>();

    public Node copyRandomList(Node head) {
        if (head == null) return null;
        
        Node curr = head;
        
        while (curr != null) {
            // 1. Secure the clone of the current node (creates it if missing)
            Node clone = hash.computeIfAbsent(curr, k -> new Node(k.val));
            
            // 2. Secure the next node and wire it
            if (curr.next != null) {
                clone.next = hash.computeIfAbsent(curr.next, k -> new Node(k.val));
            }
            
            // 3. Secure the random node and wire it
            if (curr.random != null) {
                clone.random = hash.computeIfAbsent(curr.random, k -> new Node(k.val));
            }
            
            // 4. Move forward in the ORIGINAL list
            curr = curr.next;
        }
        
        // The head was cloned in step 1, so the map has it ready
        return hash.get(head);
    }
}