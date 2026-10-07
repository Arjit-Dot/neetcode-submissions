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
    public ListNode reverseList(ListNode head) {
        ListNode dummy=new ListNode();
        Deque<ListNode> stack=new ArrayDeque<>();
        ListNode temp=dummy;
        while(head!=null)
        {
            stack.push(head);
            head=head.next;
        }
        while(!stack.isEmpty())
        {
            temp.next=stack.pop();
            temp=temp.next;
        }
        temp.next=null;
        return dummy.next;
    }
}