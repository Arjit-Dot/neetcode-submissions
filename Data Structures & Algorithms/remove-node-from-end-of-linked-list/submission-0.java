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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ArrayList <ListNode>stack=new ArrayList<>();
        ListNode temp=head;
        while(temp!=null)
        {
            stack.add(temp);
            temp=temp.next;
        }
        int length=stack.size();
        temp=head;
        if(length-n==0)
        {
            head=head.next;
            return head;
        }
        ListNode remove=stack.get(length-n);
        ListNode pre=stack.get(length-n-1);
        pre.next=remove.next;
        remove=null;
        return head;
    }
}
