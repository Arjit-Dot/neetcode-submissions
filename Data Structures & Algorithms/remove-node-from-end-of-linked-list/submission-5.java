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
        int count=0;
        ListNode counter=head;
        while(counter!=null){
            count++;
            counter=counter.next;
        }
        ListNode out=new ListNode(0,head);
        ListNode curr=head,prev=out;
        while(count!=n){
            count--;
            prev=curr;
            curr=curr.next;
        }
        prev.next=(curr==null)?null:curr.next;
        return out.next;
    }
}
