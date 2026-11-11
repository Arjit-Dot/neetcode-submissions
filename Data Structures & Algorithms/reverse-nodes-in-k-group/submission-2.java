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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode clone=new ListNode();
        ListNode dummy=clone;
        Deque<ListNode>stack=new ArrayDeque<>();
        ListNode tail=new ListNode();
        while(head!=null){
            stack.push(head);
            head=head.next;
            if(stack.size()==k){
                tail=stack.peek().next;
                while(!stack.isEmpty()){
                    ListNode temp=stack.pop();
                    dummy.next=temp;
                    dummy=dummy.next;
                }
                dummy.next=null;
            }
        }
        if(!stack.isEmpty()) dummy.next=tail;
        return clone.next;
    }
}
