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
    public Node copyRandomList(Node head) {
        if (head==null)
        {
            return null;
        }
        Node head2=new Node(head.val);
        Node temp=head;
        Node temp2=head2;
        HashMap<Node ,Node>ret=new HashMap<>();
        ret.put(head,head2);
        temp=temp.next;
        while(temp!=null)
        {
            Node add=new Node(temp.val);
            temp2.next=add;
            ret.put(temp,add);
            temp=temp.next;
            temp2=temp2.next;
        }
        temp=head;
        temp2=head2;
        while(temp!=null)
        {
            temp2.random=ret.get(temp.random);
            temp=temp.next;
            temp2=temp2.next;
        }
        return head2;

    }
}
