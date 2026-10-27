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
        ListNode left=head;
        ListNode right=head;
        while(right.next!=null) right=right.next;
        while(left!=right){
            right.next=left.next;
            left.next=right;
            left=left.next;
            right=left;
            while(right.next!= left){
                right=right.next;
        }
        left=left.next;
        }
        right.next=null;

    }
}
