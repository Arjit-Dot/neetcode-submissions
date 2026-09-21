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
        if(lists.length==0) return null;
        for(int i=1;i<lists.length;i++)
        {
            lists[0]=merge2(lists[0],lists[i]);
        }
        return lists[0];
    }
    public ListNode merge2(ListNode left, ListNode right)
    {   
        ListNode dummy=new ListNode();
        ListNode tail=dummy;
        while(left!=null && right!=null)
        {
            if(left.val<right.val)
            {
                tail.next=left;
                tail=tail.next;
                left=left.next;
            }
            else
            {
                tail.next=right;
                tail=tail.next;
                right=right.next;
            }
        }
        tail.next=(right==null)?left:right;
        return dummy.next;
    }
}
