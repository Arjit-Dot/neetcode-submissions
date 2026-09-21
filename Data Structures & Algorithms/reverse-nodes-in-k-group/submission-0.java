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
        Deque <ListNode> stack=new ArrayDeque<>();
        ListNode dummy=new ListNode();
        ListNode tail=dummy;
        ListNode temp=head;
        while(temp!=null)
        {
            while(temp!=null && stack.size()<k)
            {
                stack.push(temp);
                temp=temp.next;
            }
            if(stack.size()==k)
            {   while(!stack.isEmpty())
                {
                tail.next=stack.poll();
                tail=tail.next;
                }
                
            }
            else
                break;
            tail.next=temp;
        }
        return dummy.next;
    }
}
