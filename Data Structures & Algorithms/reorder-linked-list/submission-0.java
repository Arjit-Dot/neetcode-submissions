/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public void reorderList(ListNode head) {
        Deque <ListNode> stack= new ArrayDeque<>();
        ListNode temp=head;
        while(temp!=null)
        {
            stack.push(temp);
            temp=temp.next;
        }
        temp=head;
        while(!stack.isEmpty() && temp!=stack.peek() && temp.next!=stack.peek())
        {
            ListNode add=stack.pop();
            add.next=temp.next;
            temp.next=add;
            temp=add.next;
        }
        if(temp==stack.peek())
            temp.next=null;
        else
        temp.next.next=null;
    }
}
