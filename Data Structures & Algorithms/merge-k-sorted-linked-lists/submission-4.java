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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0)return null;
        ListNode head=new ListNode();
        head.next=lists[0];
        for(int i=1;i<lists.length;i++){
            ListNode dummy=head;
            ListNode left=dummy.next;
            ListNode right=lists[i];
            while(left!=null && right!=null){
                if(left.val<=right.val){
                    dummy.next=left;
                    left=left.next;
                    dummy=dummy.next;
                }
                else{
                    dummy.next=right;
                    right=right.next;
                    dummy=dummy.next;
                }
            }
            if(left!=null)dummy.next=left;
            if(right!=null)dummy.next=right;
        }
        return head.next;
        
    }
}
